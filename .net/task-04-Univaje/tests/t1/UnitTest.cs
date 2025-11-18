using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using Xunit;
using Xunit.Abstractions;
using Savonia.xUnit.Helpers;
using Savonia.xUnit.Helpers.Infrastructure;

namespace tests;

public class UnitTest : AppTestBase, IClassFixture<WebApplicationFactoryFixture<Program>>

{
    private readonly HttpClient _client;

    public UnitTest(ITestOutputHelper testOutputHelper, WebApplicationFactoryFixture<Program> fixture) : base(new string[] { "Phones.db" }, testOutputHelper)
    {
        _client = fixture.CreateClient();
        WriteLine(fixture.HostUrl);
    }

    [Fact]
    public async void Checkpoint01_H1()
    {
        // Arrange

        // Act
        var response = await _client.GetAsync("/");
        var content = await HtmlHelpers.GetDocumentAsync(response);

        var h1 = content.QuerySelector("h1");

        // Assert
        Assert.True(response.IsSuccessStatusCode);
        Assert.NotNull(h1);
        Assert.Contains("Welcome to the Modern Phone database in Razor Pages", h1.TextContent);
    }

    [Theory]
    [JsonFileData("testdata.json", typeof(string), typeof(IEnumerable<string>))]
    public async void Checkpoint01_Top3(string data, IEnumerable<string> expected)
    {
        // Arrange

        // Act
        var response = await _client.GetAsync("/");
        var content = await HtmlHelpers.GetDocumentAsync(response);
        var tableRows = content.QuerySelectorAll(data);

        // Assert
        Assert.True(response.IsSuccessStatusCode);
        Assert.Equal(4, tableRows.Count());
        Assert.Equal(expected, tableRows.TakeLast(3).Select(t => t.FirstElementChild?.TextContent));
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