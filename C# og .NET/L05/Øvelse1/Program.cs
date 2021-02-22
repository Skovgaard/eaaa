/*
 * Load all the people from data1.csv into a List: List<Person>
 * You can get inspiration to most of the solution from Dag 4 - Løsning øvelse 6 PersonsDatafile.
 * The method call could look like this:
 * List<Person> people = GetPeople();
 * Use the FindAll method on List<T> to find
 * 1. All persons with a score below 2
 * 2. All persons with even score
 * 3. All persons with even score and weight above 60
 * 4. All persons with a weight divisible by 3
 */

using System;
using System.Collections.Generic;
using System.IO;

namespace Øvelse1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string filename = "../../data1.csv";
            List<Person> people = Person.ReadCSVFile(filename);

            people.FindAll(p => p.Score < 2).ForEach(Console.WriteLine);

            Console.WriteLine();

            people.FindAll(p => p.Score % 2 == 0).ForEach(Console.WriteLine);

            Console.WriteLine();

            people.FindAll(p => p.Score % 2 == 0 && p.Weight > 60).ForEach(Console.WriteLine);

            Console.WriteLine();

            people.FindAll(p => p.Weight % 3 == 0).ForEach(Console.WriteLine);

            Console.WriteLine();
        }
    }

    public class Person
    {
        public String Name { get; set; }
        public int Age { get; set; }
        public int Weight { get; set; }
        public int Score { get; set; }

        public Person(string s)
        {
            string[] split = s.Split(';');
            Name = split[0];
            Age = int.Parse(split[1]);
            Weight = int.Parse(split[2]);
            Score = int.Parse(split[3]);
        }

        public override string ToString()
        {
            return String.Format("{0} : {1} years, {2} kg, {3} score", Name, Age, Weight, Score);
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