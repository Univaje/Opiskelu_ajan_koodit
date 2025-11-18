using Xunit;
using ConsoleApp;
using Xunit.Abstractions;
using Savonia.xUnit.Helpers;
using System;

namespace tests;

public class UnitTest : AppTestBase
{
    public UnitTest(ITestOutputHelper output) : base(output)
    {
    }

    [Theory]
    [JsonFileData("testdata.json", typeof(Tuple<int, int>), typeof(int?))]    
    public void Checkpoint03(Tuple<int, int> data, int? expected)
    {
        Calculator calculator = new Calculator();
        int? actual = calculator.CalculateAreaCircumference(data.Item1, data.Item2);
        Assert.Equal(expected, actual);
    }
}