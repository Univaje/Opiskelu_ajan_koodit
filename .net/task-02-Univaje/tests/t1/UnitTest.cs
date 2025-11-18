using Savonia.xUnit.Helpers;
using ShapesLibrary;
using System.IO;
using Xunit;
using Xunit.Abstractions;

namespace tests;

public class UnitTest : AppTestBase
{
    public UnitTest(ITestOutputHelper output) : base(output)
    {
    }

    [Fact]
    public async void Checkpoint01_1()
    {
        // proper class file name
        string path = "../../../../../src/ShapesLibrary/IShape.cs";
        var result = GetFileContent(path);
        Assert.True(result.fileExists);
        Assert.NotNull(result.content);
        FileInfo fi = new FileInfo(path);
        Assert.NotNull(fi);
        Assert.Equal("IShape.cs", fi.Name, false);
        Assert.Contains("IShape", result.content.FilterComments().Condense());
    }

    [Fact]
    public async void Checkpoint01_2()
    {
        var type = typeof(IShape);
        var method = type.GetMethod("Area");
        Assert.NotNull(method);
        method = type.GetMethod("Circumference");
        Assert.NotNull(method);
        // check return type
        Assert.Equal(typeof(double), method.ReturnType);
    }
}