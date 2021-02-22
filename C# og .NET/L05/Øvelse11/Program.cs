/*
 * Write an extension method on the List<Person> class so you can make this call:
 * people.Reset();
 * The call must set person.Accepted = false for all people on the list.
 */

using System;
using System.Collections.Generic;
using Øvelse4;

namespace Øvelse11
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            string filename = "../../../Øvelse1/data1.csv";
            List<Person> people = Person.ReadCSVFile(filename);

            people.Reset();

            people.ForEach(Console.WriteLine);
        }
    }

    public static class Extension
    {
        public static void Reset(this List<Person> people)
        {
            people.ForEach(p => p.Accepted = false);
        }
    }
}