/*
 * Se tilbage på tidligere øvelse, hvor du indlæste en csv-fil. Arbejd nu videre med den løsning. Implement a static method on your Person class
 * public static List<Person> ReadCSVFile(string filename)
 * that reads a file containing lines of persons in the format "Saul;60;63" shown above. This method returns a list of Person objects from a CSV file.
 * (I gave you a file called data.csv, you should use)
 * Now you must be able to write code that looks like this:
 * string filename = @"C:\somewhere\else\or\whereever\data.csv";
 * var people = Person.ReadCSVFile(filename);
 * Console.WriteLine("Number of people in data file : " + people.Count);
 */

using System;
using System.Collections.Generic;
using System.IO;

namespace Øvelse6
{
    class Program
    {
        static void Main(string[] args)
        {
            string filename = "../../data.csv";
            var people = Person.ReadCSVFile(filename);
            Console.WriteLine("Number of people in data file : " + people.Count);
        }
    }

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