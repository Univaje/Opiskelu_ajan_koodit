using Xunit;
using ShapesLibrary;
using System;
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
    public void Checkpoint03_1()
    {
        // proper class file name
        string path = "../../../../../src/ShapesLibrary/Circle.cs";
        var result = GetFileContent(path);
        Assert.True(result.fileExists);
        Assert.NotNull(result.content);
        FileInfo fi = new FileInfo(path);
        Assert.NotNull(fi);
        Assert.Equal("Circle.cs", fi.Name, false);
        Assert.Contains("Circle", result.content.FilterComments().Condense());
    }

    [Fact]
    public void Checkpoint03_2()
    {
        var type = typeof(Circle);
        var method = type.GetMethod("Area");
        Assert.NotNull(method);
        method = type.GetMethod("Circumference");
        Assert.NotNull(method);
        // check return type
        Assert.Equal(typeof(double), method.ReturnType);
    }

    [Fact]
    public void Checkpoint03_3()
    {
        Circle c1 = new Circle();
        Assert.NotNull(c1);
        Assert.Equal(0.0, c1.Area(), 1);
        Assert.Equal(0.0, c1.Circumference(), 1);
    }
    
    [Theory]
    [JsonFileData("testdata.json", typeof(double), typeof(Tuple<double, double>))]    
    public void Checkpoint03_4(double data, Tuple<double, double> expected)
    {
        Circle c2 = new Circle(data);
        Assert.NotNull(c2);
        Assert.Equal(expected.Item1, c2.Area(), 4);
        Assert.Equal(expected.Item2, c2.Circumference(), 4);
    }
}