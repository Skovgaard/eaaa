using System;
using System.Collections.Generic;

/*
 * Explain the behavior of this call
 * people.Sort((p1,p2) => p1.Age.CompareTo(p2.Age));
 * (Sort method can take a lambda as argument) 
 * 
 * Explain why
 * people.Sort(new SortByAge());
 * Is or is not a better way to do it. Find pros and cons.
 * 
 * Write examples of sorting using Lambdas. Find the 10 oldest people, and the 10 youngest. 
 * There is a Reverse method on the array class.
 */

namespace Øvelse10
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            List<Person> people = new List<Person>();
            people.Add(new Person("Saul;60;63"));
            people.Add(new Person("Saul;66;63"));
            people.Add(new Person("Saul;84;63"));
            people.Add(new Person("Saul;16;63"));

            people.ForEach(Console.WriteLine);

            Console.WriteLine();

            people.Sort((p1, p2) => p1.Age.CompareTo(p2.Age));

            people.ForEach(Console.WriteLine);

            Console.WriteLine();

            people.Reverse();

            people.ForEach(Console.WriteLine);
        }
    }

    // Kopi fra opg. 9
    class Person
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
    }
}
