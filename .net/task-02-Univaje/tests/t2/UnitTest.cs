using Savonia.xUnit.Helpers;
using ShapesLibrary;
using System;
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
    public void Checkpoint02_1()
    {
        // proper class file name
        string path = "../../../../../src/ShapesLibrary/Rectangle.cs";
        var result = GetFileContent(path);
        Assert.True(result.fileExists);
        Assert.NotNull(result.content);
        FileInfo fi = new FileInfo(path);
        Assert.NotNull(fi);
        Assert.Equal("Rectangle.cs", fi.Name, false);
        Assert.Contains("Rectangle", result.content.FilterComments().Condense());
    }

    [Fact]
    public void Checkpoint02_2()
    {
        var type = typeof(Rectangle);
        var method = type.GetMethod("Area");
        Assert.NotNull(method);
        method = type.GetMethod("Circumference");
        Assert.NotNull(method);
        // check return type
        Assert.Equal(typeof(double), method.ReturnType);
    }

    [Fact]
    public void Checkpoint02_3()
    {
        Rectangle r1 = new Rectangle();
        Assert.NotNull(r1);
        Assert.Equal(0.0, r1.Area(), 1);
        Assert.Equal(0.0, r1.Circumference(), 1);
    }

    [Theory]
    [JsonFileData("testdata.json", typeof(Tuple<double, double>), typeof(Tuple<double, double>))]    
    public void Checkpoint02_4(Tuple<double, double> data, Tuple<double, double> expected)
    {
        Rectangle r2 = new Rectangle(data.Item1, data.Item2);
        Assert.NotNull(r2);
        Assert.Equal(expected.Item1, r2.Area(), 4);
        Assert.Equal(expected.Item2, r2.Circumference(), 4);
    }
}