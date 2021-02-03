using System;

/*
Generate a list of random numbers. Print them to the console. Information about random numbers can be found here:

https://docs.microsoft.com/en-us/dotnet/api/system.random?view=netframework-4.7.2 (Links til en ekstern webside.)

Often a simple guide can be found on stackoverflow.com. I usually get there from a Google search.
If there is a solution from stackoverflow it is often good and simple.

https://stackoverflow.com/questions/2706500/how-do-i-generate-a-random-int-number-in-c (Links til en ekstern webside.)

You need the method Next NextDouble on your Random object. What is the difference??
s*/

namespace Øvelse5
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Random random = new Random();
            string intList = "";
            string doubleList = "";

            for (int i = 0; i < 7; i++)
            {
                int intNumber = random.Next(100);
                intList += $"{intNumber}, ";
                double doubleNumber = random.NextDouble();
                doubleList += $"{doubleNumber}, ";
            }
            Console.WriteLine($"Next: {intList}");
            Console.WriteLine($"NextDouble: {doubleList}");
        }
    }
}
