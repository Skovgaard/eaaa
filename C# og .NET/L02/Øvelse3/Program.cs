using System;

/*
Programmér nu en ny Visual Studio applikation, der kan udskrive Fibonacci-talrække https://da.wikipedia.org/wiki/Fibonacci-tal (Links til en ekstern webside.)

Som input modtager applikationen et heltal, som angiver grænseværdien for det maksimale tal, der skal udskrives. Herefter udskrives talrækken 1, 1, 2, 3, ... , Grænseværdi
Herefter vender applikationen tilbage og spørger om ny grænseværdi for udskrift af endnu en talrække osv.
Når brugeren indtaster grænseværdien 0, så standses applikationen.
*/

namespace Øvelse3
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Fibonacci");
            while (true)
            {
                Console.WriteLine("Indtast grænseværdi:");         
                int gv = Int32.Parse(Console.ReadLine());
                if (gv == 0)
                {
                    Console.WriteLine("Stopper");
                    break;
                }
                Fibonacci(gv);
            }
        }

        private static void Fibonacci(int max)
        {
            int previous = 0;
            int current = 1;
            string result = "0, 1";
            while (current < max)
            {
                int next = previous + current;
                if (next <= max)
                    result += $", {next}";
                previous = current;
                current = next;
            }
            Console.WriteLine(result);
        }
    }
}