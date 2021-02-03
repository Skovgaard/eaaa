using System;

/* 
 * Kør og omprogrammér eksemplet  "ValAndRefTypeExample", så det kommer til at anvende C#-nøgleordet 'ref'
 * til at demonstrere 'call by value' vs 'call by reference'.
 */

namespace Øvelse7
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = 7;
            IncrementValue(a);
            Console.WriteLine("IncrementValue: " + a);

            IncrementValueWithRef(ref a);
            Console.WriteLine("IncrementValueWithRef: " + a);
            
            Integer A = new Integer(7);
            IncrementValue(A);
            Console.WriteLine(A.value);

            // Console.ReadLine();
        }

        private static void IncrementValue(Integer A)
        {
            A.value = A.value + 1;
        }

        private static void IncrementValue(int a)
        {
            a = a + 1;
        }

        private static void IncrementValueWithRef(ref int a)
        {
            a = a + 1;
        }

    }

    class Integer
    {
        public int value;

        public Integer(int val)
        {
            value = val;
        }
    }
}
