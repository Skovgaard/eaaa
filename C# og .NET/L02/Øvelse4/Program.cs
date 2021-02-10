using System;

/*
Lav en funktion til beregning af en persons alder. Funktionen skal også virke de efterfølgende år, når årstal har skiftet.
Brug derfor DateTime.Now.Year til at finde nuværende gældende årstal.

Funktionen defineres med to parametre:

Input parameter: Fødselsår
Output parameter: Alder
Garantér vha. af parameterdefinitionen at de to parametre udelukkende kan anvendes som hhv. input og output parametre.

Skriv et lille konsol test program til funktionen.
*/

namespace Øvelse4
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Person alder beregning");
            while (true)
            {
                Console.WriteLine("Indtast fødselsår (-1 for at afslutte)");
                int birthYear = Int32.Parse(Console.ReadLine());
                if (birthYear == -1)
                {
                    Console.WriteLine("Stopper");
                    break;
                }
                int age;
                calcAge(in birthYear, out age);
                Console.WriteLine($"Alder: {age}");
            }
            
        }

        public static void calcAge(in int birthYear, out int age)
        {
            age = DateTime.Now.Year - birthYear;
        }
    }
}
