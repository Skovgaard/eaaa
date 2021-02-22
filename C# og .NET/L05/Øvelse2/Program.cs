/*
 * 5. Use the FindIndex method on the List<T> class to find the index of the first person with a Score of 3.
 * 6. Use FindIndex to find the index of the first person under 10 years, with a score of 3.
 * 7. How many people are there under 10 years, with a score of 3?
 * 8. Use FindIndex to find the index of the first person under 8 years, with a score of 3.
 * 9. What does the return value mean?
 */

using System;
using System.Collections.Generic;

using Øvelse1;

namespace Øvelse2
{
    internal class Program
    {
        public static void Main(string[] args)
        {

            string filename = "../../../Øvelse1/data1.csv";
            List<Person> people = Person.ReadCSVFile(filename);

            Console.WriteLine(people.FindIndex(p => p.Score == 3));

            Console.WriteLine(people.FindIndex(p => p.Age < 10 && p.Score == 3));

            Console.WriteLine(people.FindAll(p => p.Age < 10 && p.Score == 3).Count);

            Console.WriteLine(people.FindIndex(p => p.Age < 8 && p.Score == 3));

            Console.WriteLine("-1 Means result was empty = noone found");
        }
    }
}