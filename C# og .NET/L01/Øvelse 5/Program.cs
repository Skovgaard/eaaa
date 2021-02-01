using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Øvelse_5
{
    class Program
    {
        public static double Max(params double[] numbers)
        {
            double max = 0;
            for (int i = 0; i < numbers.Length; i++)
            {
                if (numbers[i] > max)
                    max = numbers[i];
            }
            return max;

        }

        static void Main(string[] args)
        {
            double m1 = Max(28.5, 17.2);
            double m2 = Max(4.0, 10.8, 34.25, 2.0, 23.6);

            Console.WriteLine(m1 + " " + m2);
            Console.ReadLine();
        }
    }
}
