using System;

/*
 * Give your Person object a constructor that takes a string in this format as input:
 * string s = "Saul;60;63";
 * This means that you can create new Person objects by writing:
 * string s = "Saul;60;63";
 * var person = new Person(s);
 * Console.WriteLine(person);
 * Console.ReadKey();
 * And get output to console that looks like this: Saul : 60 years, 63 kg
 * To implement this you can use data.Split(';') If data is a string. If you want to know more, the Split method is described here:
 * https://docs.microsoft.com/en-us/dotnet/api/system.string.split?view=netframework-4.7.2 (https://docs.microsoft.com/en-us/dotnet/api/system.string.split?view=netframework-4.7.2)
 */

namespace Øvelse9
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            string s = "Saul;60;63";
            var person = new Person(s);
            Console.WriteLine(person);
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
    }
}
