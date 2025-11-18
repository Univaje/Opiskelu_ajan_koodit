namespace ConsoleApp;

public class Calculator
{
/*
    public int CalculateAreaCircumference(int length, int width)
    {
        return length * width;
    }*/


// The app must handle arguments passed to the app. Convert arguments to `int` and pass to CalculateAreaCircumference method. Must not error. 
// Use int default value if no argument is given. If arguments are given to the app, write them to console with text `Arguments: x y` where x and y are replaced with argument values. 
// Write this to a new line. Note! if one argument is missing then it won't be printed. If both are missing then nothing is printed on this line.
// The app must write to console: `Circumference of area of x and y is z` where x, y and z are replaced with actual values. Write to new line.
    public int? CalculateAreaCircumference(int length, int width)
    {
        //The method must return `null` if a parameter is negative, must not error in any case (will return null instead of exception). 
        //Must not overflow (returns null instead).
        if (length < 0 || width < 0)
        {
            return null;
        }
        else if (length == 0 || width == 0)
        {
            return 0;
        }
        try
        {

            return checked(length *2 + 2* width);
        }
        catch (OverflowException)
        {
            return null;
        }
    }
}
