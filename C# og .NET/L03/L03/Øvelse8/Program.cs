using System;

/*
 * Create small console projekt for writing small bits of code. 
 * Write a class Person with Name, Age and Weight properties.
 * Override the ToString method so you can print person objects to console. Output must take up only one line in the console!
 * Tabulator is the traditional way to do this but you can also use String.Format
 */

namespace Øvelse8
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Person person = new Person();
            person.Name = "Navn";
            person.Age = 111;
            person.Weight = 2222;
            Person person2 = new Person();
            person2.Name = "Navndwda";
            person2.Age = 664;
            person2.Weight = 623;
            Console.WriteLine(person);
            Console.WriteLine(person2);
        }
    }

    class Person
    {
        public string Name { get; set;}
        public int Age { get; set; }
        public double Weight { get; set; }

        public override string ToString()
        {
            return String.Format("Name: {0, -10} Age: {1, -5} Weight: {2, -5}", Name, Age, Weight);
        }
    }
}
