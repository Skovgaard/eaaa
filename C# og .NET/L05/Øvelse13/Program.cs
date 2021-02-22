/*
 * Use LINQ to group people by the first letter in their names.
 */

using System;
using System.Collections.Generic;
using System.Linq;
using Øvelse1;

namespace Øvelse13
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            string filename = "../../../Øvelse1/data1.csv";
            List<Person> people = Person.ReadCSVFile(filename);

            var linq = from person in people
                group person by person.Name[0]
                into newGroup
                orderby newGroup.Key
                select newGroup;

            foreach (var group in linq)
            {
                Console.WriteLine(group.Key);
                foreach (var person in group)
                {
                    Console.WriteLine(" " + person.Name);
                }
            }
        }
    }
}