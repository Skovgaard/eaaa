/*
 * Skriv en klasse som indeholder et array af tilfældige heltal:
 * int[] intArray = { 5, 67, 45, 23, 99, 44, 56, 12, 3, 44 }
 * Implementér nu på denne klasse en metode Sort, som sorterer tallene. Din sort metode skal anvende følgende delegate signatur:
 * // vi skal bruge Comparator til at vælge mellem stigende og faldende orden
 * public delegate bool Comparator(int e1, int e2);
 * // sorter array ved hjælp af Comparator delegate
 * public static void SortArray(int[] array, Comparator Compare)
 * {
 * ... }
 * Vælg sorteringsalgoritme efter eget valg, men bubble-sort er f.eks. fint. Skriv sorteringsmetoden selv for at øve C#.
 */

using System;

namespace Øvelse4
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            var randomNumbers = new RandomNumbers();

            randomNumbers.PrintArray();

            // randomNumbers.Sort(new Comparator(BiggerThan)); // Redundant explicit
            // randomNumbers.Sort((e1, e2) => e1 > e2); // With lambda
            randomNumbers.Sort(BiggerThan);

            randomNumbers.PrintArray();

            randomNumbers.Sort(LessThan);

            randomNumbers.PrintArray();
        }

        private static bool BiggerThan(int e1, int e2)
        {
            return e1 > e2;
        }

        private static bool LessThan(int e1, int e2)
        {
            return e1 < e2;
        }
    }

    public class RandomNumbers
    {
        private readonly int[] _intArray = {5, 67, 45, 23, 99, 44, 56, 12, 3, 44};

        public void Sort(Comparator comparator)
        {
            SortArray(_intArray, comparator);
        }

        public delegate bool Comparator(int e1, int e2);

        public static void SortArray(int[] array, Comparator compare)
        {
            while (true)
            {
                bool swapped = false;
                for (int i = 0; i < array.Length - 1; i++)
                {
                    if (compare(array[i], array[i + 1]))
                    {
                        SwapWithNext(array, i);
                        swapped = true;
                    }
                }

                if (!swapped) break;
            }
        }

        private static void SwapWithNext(int[] array, int i)
        {
            int temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
        }

        public void PrintArray()
        {
            // Array.ForEach(_intArray, Console.WriteLine);
            Console.WriteLine("[{0}]", string.Join(", ", _intArray));
        }
    }
}