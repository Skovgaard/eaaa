/*
 * Generate a list of 100 random integers. Then use LINQ to
 * 1. a) Find the number of odd numbers in the list.
 * 2. b) Find the number of distinct numbers in the list.
 * 3. c) Find the first three odd numbers.
 * 4. d) Find all distinct odd numbers.
 */

using System;
using System.Linq;

namespace Øvelse12
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            int[] numbers = new int[100];

            for (int i = 0; i < numbers.Length; i++)
            {
                numbers[i] = new Random().Next(100);
            }

            // foreach (var n in numbers)
            // {
            //     Console.Write(n + " ");
            // }

            var linq1 = (from n in numbers
                where n % 2 != 0
                select n).Count();

            var linq2 = (from n in numbers select n).Distinct().Count();

            var linq3 = (from n in numbers
                where n % 2 != 0
                select n).Take(3);

            var linq4 = (from n in numbers
                where n % 2 != 0
                select n).Distinct();

            Console.WriteLine(linq1);

            Console.WriteLine(linq2);

            foreach (var n in linq3)
            {
                Console.Write(n + " ");
            }

            Console.WriteLine();

            foreach (var n in linq4)
            {
                Console.Write(n + " ");
            }
        }
    }
}