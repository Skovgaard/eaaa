/*
 * Brug nu LINQ til:
 * 1. Sort the people by distance to the average Age
 * 2. Sort the people by size of their ? Dwa = Sqr(Weight^2 + Age^2)
 */

using System;
using System.Collections.Generic;
using System.Linq;
using Øvelse1;

namespace Øvelse9
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            string filename = "../../../Øvelse1/data1.csv";
            List<Person> people = Person.ReadCSVFile(filename);

            var query1 = from person in people
                let averageAge = (from p in people select p.Age).Average() // Muligt uden at gøre det?
                orderby Math.Abs(person.Age - averageAge)
                select person;

            var query2 = from person in people
                let dwa = Math.Sqrt(Math.Pow(person.Weight, 2) + Math.Pow(person.Age, 2))
                orderby dwa
                select person;

            foreach (var person in query1)
            {
                Console.WriteLine(person);
            }

            Console.WriteLine();

            foreach (var person in query2)
            {
                Console.WriteLine(person);
            }
        }
    }
}