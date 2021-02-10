using System;

/*
 * Opret en MyClass klasse, som skal kunne bruges således:
 * var mc = new MyClass(56);
 * mc.Arg = 65;
 * Console.WriteLine(mc);
 * Output skal minde om dette
 * MyArg set to 65
 * Klassen MyClass skal have en property som kan tilgå den interne variabel, som bliver initialiseret i constructor'en.
 */

namespace Øvelse7
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            var mc = new MyClass(56);
            mc.Arg = 65;
            Console.WriteLine(mc);
        }
    }

    class MyClass
    {
        public int Arg { get; set;}

        public MyClass(int i)
        {
            Arg = i;
        }

        public override string ToString()
        {
            return "MyArg set to " + Arg.ToString();
        }
    }
}
