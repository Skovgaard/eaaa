/*
 * Create an array of numbers:
 * int[] numbers = { 34, 8, 56, 31, 79, 150, 88, 7, 200, 47, 88, 20 };
 * Write LINQ statements to
 * 1. Return all two-digit integers sorted in ascending order.
 * 2. Return all two-digit integers sorted in descending order.
 * 3. As in a. but instead of integers you must return strings ”20”, ”31”, ”34”, etc.
 * 4. As in c. but returning “20 even”, “31 uneven”, ...
 *
 * 1. Write a query returning an anonymous type with two values: the integer and true/false indicating if the number is even.
 * Name the object attributes ”Number” and ”Even”.
 * (The ambitious student may want to write two versions: One for method style and one for query style.)
 */

using System;
using System.Linq;

namespace Øvelse10
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            int[] numbers = {34, 8, 56, 31, 79, 150, 88, 7, 200, 47, 88, 20};

            var linq1 = from number in numbers
                orderby number
                where number >= 10 && number <= 99
                select number;

            var linq2 = from number in numbers
                orderby number descending
                where number >= 10 && number <= 99
                select number;

            var linq3 = from number in numbers
                orderby number
                where number >= 10 && number <= 99
                select number.ToString();

            var linq4 = from number in numbers
                orderby number
                where number >= 10 && number <= 99
                select number + (number % 2 == 0 ? " even" : " uneven");

            var linq5 = from number in numbers
                orderby number
                where number >= 10 && number <= 99
                let even = number % 2 == 0
                select new {Number = number, Even = even};

            var linq5Method = numbers.Where(n => n >= 10 && n <= 99).OrderBy(n => n).Select(n => new {Number = n, Even = n % 2 == 0});

            foreach (var n in linq1)
            {
                Console.Write(n + " ");
            }

            Console.WriteLine();

            foreach (var n in linq2)
            {
                Console.Write(n + " ");
            }

            Console.WriteLine();

            foreach (var n in linq3)
            {
                Console.Write("\"" + n + "\" ");
            }

            Console.WriteLine();

            foreach (var n in linq4)
            {
                Console.Write(n + " ");
            }

            Console.WriteLine();

            foreach (var n in linq5)
            {
                Console.Write(n + " ");
            }

            Console.WriteLine();

            foreach (var n in linq5Method)
            {
                Console.Write(n + " ");
            }

            Console.WriteLine();
        }
    }
}