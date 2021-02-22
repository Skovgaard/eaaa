/*
 * Find all names that occur in both data1.csv and data2.csv (both data1.csv and data2.csv are available on Canvas)
 */

using System;
using System.Collections.Generic;
using System.Linq;
using Øvelse1;

namespace Øvelse14
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            string filename1 = "../../../Øvelse1/data1.csv";
            string filename2 = "../../data2.csv";
            List<Person> people1 = Person.ReadCSVFile(filename1);
            List<Person> people2 = Person.ReadCSVFile(filename2);

            var linq = from person1 in people1
                where (from person2 in people2
                    select person2.Name).Contains(person1.Name)
                select person1.Name;

            foreach (var p in linq)
            {
                Console.WriteLine(p);
            }

        }
    }
}