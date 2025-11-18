// To use a class library: 
// 1. add a reference to the class library to *.csproj file
// 2. Add using clause to the class library's namespace
using ConsoleApp;

Console.WriteLine("Hello, .NET 6!");
List<int> list = new List<int>();
int height = 0 , width = 0;
if (null != args){
     System.Console.WriteLine("Arguments: {0} ",string.Join(" ",args));    
    foreach (var arg in args)
    {
        System.Console.WriteLine(arg); 
        if (int.TryParse(arg, out int result))
            list.Add(result);
        else
            list.Add(0);
        
    }
    if (args.Length > 1)
    {
        System.Console.WriteLine("Arguments: {0} ",string.Join(" ",args));
        System.Console.WriteLine("Args.Length: {0}",args.Length);
        height = list[1];
        width = list[0];
    }
    else if (args.Length == 1)
    {
        
        width = list[0];
    }
   
}
// 3. use classes and methods from the class library
Calculator calc = new Calculator();

int? sum = calc.CalculateAreaCircumference(width, height);
Console.WriteLine($"Circumference of area of {width} and {height} is {sum}");

/* double division = calc.Divide(height, width);
Console.WriteLine($"Division of {height} and {width} is {division}");

// call async method from the class library
int c = 5;
int result = await calc.IOIntensiveSample(c); // the method simulates execution with Task.Delay()
Console.WriteLine($"Result of I/O intensive sample with parameter value {c} is {result}"); */