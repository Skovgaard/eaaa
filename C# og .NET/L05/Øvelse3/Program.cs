/*
 * Sorting with List<T>.Sort()
 * Sort persons after both Score and Age, (both ascending and descending)
 */

using System;
using System.Collections.Generic;

using Øvelse1;

namespace Øvelse3
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            string filename = "../../../Øvelse1/data1.csv";
            List<Person> people = Person.ReadCSVFile(filename);

            people.Sort((p1, p2) => p1.Age.CompareTo(p2.Age)); // Ascending
            // people.Sort((p1, p2) => -p1.Age.CompareTo(p2.Age)); // Descending

            people.ForEach(Console.WriteLine);

            Console.WriteLine();

            people.Sort((p1, p2) => p1.Score.CompareTo(p2.Score)); // Ascending
            // people.Sort((p1, p2) => -p1.Score.CompareTo(p2.Score)); // Descending

            people.ForEach(Console.WriteLine);
        }
    }
}