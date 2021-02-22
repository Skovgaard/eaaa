/*
 * Write an extension method on the List<Person> class so you can make this call:
 * List<Person> people = GetPeople();
 * people.UpdatePeople(p => p.Score >= 6 && p.Age <= 40, (p) => { p.Accepted = true; });
 * Hint: Use a Predicate delegate and an Action delegate to solve this problem.
 */

using System;
using System.Collections.Generic;
using System.IO;

namespace Øvelse4
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            string filename = "../../../Øvelse1/data1.csv";
            List<Person> people = Person.ReadCSVFile(filename);

            people.UpdatePeople(p => p.Score >= 6 && p.Age <= 40, (p) => { p.Accepted = true; });

            people.ForEach(Console.WriteLine);
        }
    }

    public static class Extension
    {

        // public delegate bool Predicate<in T>(T obj);

        // public delegate void Action<in T>(T obj);

        public static void UpdatePeople<T>(this List<T> people, Predicate<T> predicate, Action<T> action)
        {
            people.FindAll(predicate).ForEach(action);
        }
    }

    public class Person
    {
        public String Name { get; set; }
        public int Age { get; set; }
        public int Weight { get; set; }
        public int Score { get; set; }
        public bool Accepted { get; set; }

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
            return String.Format("{0} : {1} years, {2} kg, {3} score, isAccepted {4}", Name, Age, Weight, Score, Accepted);
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