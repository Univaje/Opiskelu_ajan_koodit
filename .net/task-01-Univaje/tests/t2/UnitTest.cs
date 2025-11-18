using Xunit;
using ConsoleApp;
using System.IO;
using Xunit.Abstractions;
using Savonia.xUnit.Helpers;

namespace tests;

public class UnitTest : AppTestBase
{
    public UnitTest(ITestOutputHelper output) : base(output)
    {
    }

    [Fact]
    public void Checkpoint02_1()
    {
        // proper class file name and content
        var path = "../../../../../src/ConsoleApp/Calculator.cs";
        var result = GetFileContent(path);
        Assert.True(result.fileExists);
        Assert.NotNull(result.content);
        FileInfo fi = new FileInfo(path);
        Assert.NotNull(fi);
        Assert.Equal("Calculator.cs", fi.Name, false);
        Assert.Contains("Calculator", result.content.FilterComments().Condense());
    }

    [Fact]
    public void Checkpoint02_2()
    {
        var type = typeof(Calculator);
        var method = type.GetMethod("CalculateAreaCircumference");
        Assert.NotNull(method);
        // check return type
        Assert.Equal(typeof(int?), method.ReturnType);
    }
}