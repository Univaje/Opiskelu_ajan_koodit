using Savonia.xUnit.Helpers;
using System.Diagnostics;
using Xunit;
using Xunit.Abstractions;

namespace tests;

public class UnitTest : AppTestBase
{
    string path = "../../../../../src/ConsoleApp/ConsoleApp.csproj";

    public UnitTest(ITestOutputHelper output) : base(output)
    {
    }

    [Fact]
    public async void Checkpoint05_1()
    {
        var result = GetFileContent(path);
        Assert.True(result.fileExists);
        Assert.NotNull(result.content);
        Assert.Contains("<ProjectReference Include=\"..\\ShapesLibrary\\ShapesLibrary.csproj\" />", result.content);
    }

    [Fact]
    public async void Checkpoint05_2()
    {
        ProcessStartInfo psi = new ProcessStartInfo("dotnet", $"run --project {path}");
        psi.CreateNoWindow = true;
        psi.RedirectStandardOutput = true;
        Process? p = Process.Start(psi);
        Assert.NotNull(p);
        await p.WaitForExitAsync();
        string pout = await p.StandardOutput.ReadToEndAsync();
        Assert.Contains("Rectangle with width 6.00 and height 8.00 has area 48.00 and circumference 28.00".SetDecimalSeparator(), pout);
        Assert.Contains("Circle with radius 5.00 has area 78.54 and circumference 31.42".SetDecimalSeparator(), pout);
        WriteLine(pout);
    }
}