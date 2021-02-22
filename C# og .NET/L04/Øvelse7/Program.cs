/*
 * Implement three classes:
 * public class SortByAge : IComparer<Person>
 * public class SortByWeight : IComparer<Person>
 * public class SortByName : IComparer<Person>
 * This way you can sort your list of Persons by Age, Weight, and Name.
 * Now you must be able to write
 * people.Sort(new SortByWeight());
 * and people are sorted by weight.
 */

using System;
using System.Collections.Generic;
using System.IO;

namespace Øvelse7
{
    class Program
    {
        static void Main(string[] args)
        {
            string filename = "../../data.csv";
            var people = Person.ReadCSVFile(filename);

            // people.Sort(new SortByAge());
            people.Sort(new SortByWeight());
            // people.Sort(new SortByName());

            people.ForEach(Console.WriteLine);
        }
    }

    public class SortByAge : IComparer<Person>
    {
        public int Compare(Person x, Person y)
        {
            return x.Age > y.Age ? 1 : x.Age < y.Age ? -1 : 0;
        }
    }

    public class SortByWeight : IComparer<Person>
    {
        public int Compare(Person x, Person y)
        {
            return x.Weight > y.Weight ? 1 : x.Weight < y.Weight ? -1 : 0;
        }
    }

    public class SortByName : IComparer<Person>
    {
        public int Compare(Person x, Person y)
        {
            return String.CompareOrdinal(x.Name, y.Name);
        }
    }

    public class Person
    {
        public String Name { get; set; }
        public int Age { get; set; }
        public double Weight { get; set; }

        public Person(string s)
        {
            string[] split = s.Split(';');
            Name = split[0];
            Age = Int32.Parse(split[1]);
            Weight = Double.Parse(split[2]);
        }

        public override string ToString()
        {
            return String.Format("{0} : {1} years, {2} kg", Name, Age, Weight);
        }

        public static List<Person> ReadCSVFile(string filename)
        {
            List<Person> persons = new List<Person>();
            string line;

            // Read the file and display it line by line.
            using (StreamReader file = new StreamReader(filename))
            {
                while ((line = file.ReadLine()) != null)
                {
                    // Console.WriteLine(line);
                    persons.Add(new Person(line));
                }
            }

            return persons;
        }
    }
}