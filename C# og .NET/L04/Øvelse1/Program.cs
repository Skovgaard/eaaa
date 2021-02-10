/*
 * a)
 * Skriv en rekursiv metode public static int factorial(int n) der beregner n!, n>=0. Den rekursive definition er givet ved.
 * Termineringsregel: 0! = 1
 * Rekurrensregel: n! = n * (n -1)!, n > 0
 * b)
 * Brug din factorial metode til at lave en extension metode, så man kan skrive 4.Factorial() og få resultatet 24.
 */

using System;

namespace Øvelse1
{
    internal static class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine(Factorial(5));

            Console.WriteLine(4.Factorial());
        }

        public static int Factorial(int n)
        {
            if (n == 0) return 1;
            else return n * Factorial(n - 1);
        }
    }

    public static class Extension
    {
        public static int Factorial(this int n)
        {
            if (n == 0) return 1;
            else return n * Factorial(n - 1);
        }
    }
}