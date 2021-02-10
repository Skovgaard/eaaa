/*
 * a)
 * Skriv en rekursiv metode public static int Power(int n, int p) der beregner n opløftet i p hvor p >=0.
 * b)
 * Lav en extension metode, så man for eksempel kan skrive 2.Power(4) og få resultatet 16
 */

using System;

namespace Øvelse2
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine(Power(7, 2));
            Console.WriteLine(Power(2, 8));

            Console.WriteLine(2.Power(4));
        }

        public static int Power(int n, int p)
        {
            if (p > 0)
                return Power(n, p - 1) * n;
            else
                return 1;
        }
    }

    public static class Extension
    {
        public static int Power(this int n, int p)
        {
            if (p > 0)
                return Power(n, p - 1) * n;
            else
                return 1;
        }
    }
}