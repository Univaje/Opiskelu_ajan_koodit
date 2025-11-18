// Create a class Circle which implements the IShape interface. Circle has two constructors; 
//one that does not take parameters and one that takes one parameter radius (double). Implement the interface methods. 
//*Hint use System.Math.PI*. The class must be in the class library project.

// Override ToString() methods on both classes: Rectangle will return a string like "Rectangle with width X and height Y has area A and circumference C". 
//Circle will return a string like "Circle with radius X has area A and circumference C". 
//In samples X, Y, A and C are placeholders for the actual values from the class instance. 
//Format the strings so that values are written with two decimals like 3.14 or 5.00. Notice the decimal separator. 
//Use the decimal separator that your computer's locale defines (i.e. comma (,) for Finnish, dot (.) for English locales)
//and use proper string format methods to produce the desired output.
namespace ShapesLibrary
{
    public class Circle : IShape
    {
        public double Radius { get; set; }

        public Circle()
        {
            Radius = 0;
        }

        public Circle(double radius)
        {
            Radius = radius;
        }

        public double Area()
        {
            return Math.PI * Radius * Radius;
        }

        public double Circumference()
        {
            return 2 * Math.PI * Radius;
        }

        public override string ToString()
        {
            return $"Circle with radius {Radius:F2} has area {Area():F2} and circumference {Circumference():F2}";
        }
    }
}