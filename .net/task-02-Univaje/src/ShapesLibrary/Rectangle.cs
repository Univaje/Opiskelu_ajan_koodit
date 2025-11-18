//Create a class Rectangle which implements the IShape interface. 
//Rectangle has two constructors; one that does not take parameters and one that takes parameters width and height (double). 
//Implement the interface methods. The class must be in the class library project.

namespace ShapesLibrary
{
    public class Rectangle : IShape
    {
        public double Width { get; set; }
        public double Height { get; set; }

        public Rectangle()
        {
            Width = 0;
            Height = 0;
        }

        public Rectangle(double width, double height)
        {
            Width = width;
            Height = height;
        }

        public double Area()
        {
            return Width * Height;
        }

        public double Circumference()
        {
            return 2 * (Width + Height);
        }

        public override string ToString()
        {
            return $"Rectangle with width {Width:F2} and height {Height:F2} has area {Area():F2} and circumference {Circumference():F2}";
        }
    }
}