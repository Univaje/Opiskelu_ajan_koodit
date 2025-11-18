using Microsoft.EntityFrameworkCore;
using RazorPhones.Data;
using Savonia.xUnit.Helpers;
using Savonia.xUnit.Helpers.Infrastructure;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using Xunit;
using Xunit.Abstractions;

namespace tests;

public class UnitTest : AppTestBase, IClassFixture<WebApplicationFactoryFixture<Program>>
{
    private readonly HttpClient _client;
    private readonly PhonesContext _db;

    public UnitTest(ITestOutputHelper testOutputHelper, WebApplicationFactoryFixture<Program> fixture) : base(new string[] { "Phones.db" }, testOutputHelper)
    {
        _client = fixture.CreateClient();
        WriteLine(fixture.HostUrl);

        string connectionstring = "Data Source=Phones.db";

        var optionsBuilder = new DbContextOptionsBuilder<PhonesContext>();
        optionsBuilder.UseSqlite(connectionstring);

        _db = new PhonesContext(optionsBuilder.Options);
    }

    [Fact]
    public async void Checkpoint04_CheckFields()
    {
        // Arrange
        var requiredInputs = new List<string?>()
        {
            "Phone.Id",
            "Phone.Make",
            "Phone.Model",
            "Phone.RAM",
            "Phone.PublishDate",
            "Phone.Created",
            "Phone.Modified"
        };
        var readonlyInputs = new List<string?>()
        {
            "Phone.Id",
            "Phone.Created",
            "Phone.Modified"
        };
        Random r = new Random();
        int skip = r.Next(0, _db.Phones.Count());
        Phone phone = await _db.Phones.Skip(skip).Take(1).FirstAsync();

        // Act
        var response = await _client.GetAsync($"/phones/edit/{phone.Id}");
        var content = await HtmlHelpers.GetDocumentAsync(response);
        var allInputs = content.QuerySelectorAll("input");
        var dataInputs = allInputs.Where(i => i.GetAttribute("type")?.ToLower() != "submit" && i.GetAttribute("name") != "__RequestVerificationToken");
        var form = content.GetForm();
        var submit = form.GetElement("button");

        // Assert
        Assert.True(response.IsSuccessStatusCode);
        Assert.Equal(requiredInputs.Count, dataInputs.Count());
        var dataInputNames = dataInputs.Select(i => i.GetAttribute("name")).OrderBy(i => i).ToList();
        Assert.Equal(requiredInputs.OrderBy(i => i), dataInputNames);
        var readonlyInputNames = content.QuerySelectorAll("[readonly]").Select(i => i.GetAttribute("name")).OrderBy(i => i).ToList();
        Assert.Equal(readonlyInputs.OrderBy(i => i), readonlyInputNames);
    }

    [Fact]
    public async void Checkpoint04_Post()
    {
        // Arrange
        Random r = new Random();
        int skip = r.Next(0, _db.Phones.Count());
        Phone phone = await _db.Phones.Skip(skip).Take(1).FirstAsync();

        // Act
        var responseGet = await _client.GetAsync($"/phones/edit/{phone.Id}");
        var content = await HtmlHelpers.GetDocumentAsync(responseGet);

        phone.Make += r.Next().ToString();
        phone.Model += r.Next().ToString();

        var form = content.GetForm();
        var submit = form.GetSubmitButton();

        var responsePost = await _client.SendAsync(
                form,
                submit,
                new Dictionary<string, string>
                {
                    {"Phone.Make", phone.Make},
                    {"Phone.Model", phone.Model},
                    {"Phone.RAM", phone.RAM.ToString()},
                    {"Phone.PublishDate", phone.PublishDate.ToString("O")}
                });
        var phonesPage = await responsePost.Content.ReadAsStringAsync();

        // Assert
        Assert.True(responseGet.IsSuccessStatusCode);
        Assert.True(responsePost.IsSuccessStatusCode);
        Assert.Contains(phone.Make, phonesPage);
        Assert.Contains(phone.Model, phonesPage);
    }

    [Fact]
    public void CheckProjectType()
    {
        // Arrange
        string path = "../../../../../src/RazorPhones/Program.cs";

        // Act
        var result = GetFileContent(path);

        // Assert
        Assert.True(result.fileExists);
        Assert.NotNull(result.content);
        string content = result.content.FilterComments().Condense();
        Assert.Contains(".MapRazorPages(", content);
        Assert.DoesNotContain(".MapControllerRoute(", content);
    }
}