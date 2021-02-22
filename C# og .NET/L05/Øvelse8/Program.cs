/*
 * Brug LINQ til at sortere listen af personer efter Score og Age. Sortér efter både stigende og faldende orden.
 */

using System;
using System.Collections.Generic;
using System.Linq;
using Øvelse1;

namespace Øvelse8
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            string filename = "../../../Øvelse1/data1.csv";
            List<Person> people = Person.ReadCSVFile(filename);

            var linq = from person in people
                orderby person.Score
                select person;
            // var linq = from person in people
            //     orderby person.Score descending
            //     select person;

            var linqf = people.OrderBy(p => p.Score);
            // var linqf = people.OrderByDescending(p => p.Score);

            foreach (var person in linq)
            {
                Console.WriteLine(person);
            }

            Console.WriteLine();

            foreach (var person in linqf)
            {
                Console.WriteLine(person);
            }

            Console.WriteLine();

            var linqA = from person in people
                orderby person.Age
                select person;
            // var linq = from person in people
            //     orderby person.Score descending
            //     select person;

            var linqfA = people.OrderBy(p => p.Age);
            // var linqf = people.OrderByDescending(p => p.Score);

            foreach (var person in linqA)
            {
                Console.WriteLine(person);
            }

            Console.WriteLine();

            foreach (var person in linqfA)
            {
                Console.WriteLine(person);
            }

        }
    }
}