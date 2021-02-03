using System;

/*
Create a new project with the method:

private void MyMethodWithError(int num = 0)
MyMethodWithError must throw an exception.

Call MyMethodWithError from another method:

public void MyNormalMethod(int num = 0)
MyNormalMethod must catch the exception from MyMethodWithError and contain a “finally” statement.

Make sure you write a lot to stdout (This is the normal output to the console), so you see what is going on.

A simple and fast reference for exceptions is found here

https://docs.microsoft.com/en-us/dotnet/csharp/language-reference/keywords/try-catch-finally (Links til en ekstern webside.)

or here https://www.tutorialspoint.com/Try-Catch-Finally-in-Chash
*/

namespace Øvelse6
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            MyNormalMethod();
        }

        private static void MyMethodWithError(int num = 0)
        {
            Console.WriteLine("Throwing exception!");
            throw new Exception("MyMethodWithError");
        }


        public static void MyNormalMethod(int num = 0)
        {
            try
            {
                MyMethodWithError();
            }
            catch (Exception e)
            {
                Console.WriteLine("Exception message: " + e.Message);
            }

            finally
            {
                Console.WriteLine("Finally?");
            }
        }
    }
}
