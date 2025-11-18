

// Use the class library on a console app. The console app needs a reference to the class library project. 
//In console app instantiate both classes with values 6 and 8 for rectangle and value 5 for 
//circle and write the ToString() methods outputs to console.
using ShapesLibrary;
namespace ConsoleApp;

public class Program
{
    public static void Main(string[] args)
    {
        Rectangle rectangle = new Rectangle(6, 8);
        Circle circle = new Circle(5);

        Console.WriteLine(rectangle.ToString());
        Console.WriteLine(circle.ToString());
    }
}