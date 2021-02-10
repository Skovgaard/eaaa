using System;

/*
 * Lav en klasse ”MyClass” som tager et integer argument i constructoren og bruger dette argument i sin ToString() metode. Det er nødvendigt at override ToString()
 * ( Keyword override er nødvendigt. Se evt. her: https://docs.microsoft.com/en- us/dotnet/csharp/language-reference/keywords/override (https://docs.microsoft.com/en- us/dotnet/csharp/language-reference/keywords/override) )
 * Du kan kalde din klasse hvad som helst men min hedder ”MyClass” ....
*/

namespace Øvelse6
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            MyClass myClass = new MyClass(10);
            Console.WriteLine(myClass.ToString());
        }
    }

    class MyClass
    {
        private int integer;

        public MyClass(int integer)
        {
            this.integer = integer;
        }

        public override string ToString()
        {
            return $"{integer}";
        }
    }
}
