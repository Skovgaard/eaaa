using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Øvelse_8
{
    class Program
    {
        static void Main(string[] args)
        {
            double number1, number2 = 0;
            string operator1 = ""; // operator saved namespace?

            Console.WriteLine("Lommeregner");
            Console.WriteLine("Skriv operation med 2 tal (2 + 2)");

            string input = Console.ReadLine();
            string[] split = input.Split(' ');

            number1 = Convert.ToDouble(split[0]);
            number2 = Convert.ToDouble(split[2]);
            operator1 = split[1];

            switch (operator1)
            {
                case "+":
                    Console.WriteLine($"Resultat af {input} = {number1 + number2}");
                    break;
                case "-":
                    Console.WriteLine($"Resultat af {input} = {number1 - number2}");
                    break;
                case "*":
                    Console.WriteLine($"Resultat af {input} = {number1 * number2}");
                    break;
                case "/":
                    Console.WriteLine($"Resultat af {input} = {number1 / number2}");
                    break;
            }

            Console.Write("Tryk vilkårlig tast for at afslutte...");
            Console.ReadKey();

        }
    }
}
