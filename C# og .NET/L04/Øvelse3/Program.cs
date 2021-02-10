/*
 * a)
 * Et palindrom er en tekststreng der læses ens forfra og bagfra som fx ”ABBA” og ”radar”.
 * Skriv en statisk rekursiv metode public static bool IsPalindrom(String tekst), der returnerer true hvis teksten er et palindrom, og false ellers.
 * I løsningen kan du anvende hjælpemetoder, så der ikke skal laves substrings af String undervejs.
 * b)
 * Lav en extension metode så man for eksempel kan skrive ”ABBA”.IsPalindrome() og få true tilbage.
 */

using System;

namespace Øvelse3
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine(IsPalindrom("ABBA"));
            Console.WriteLine(IsPalindrom("radar"));
            Console.WriteLine(IsPalindrom("test"));
            Console.WriteLine(IsPalindrom("a"));
            Console.WriteLine(IsPalindrom("aba"));
            Console.WriteLine(IsPalindrom("ababa"));
            Console.WriteLine(IsPalindrom("aba1ba"));

            Console.WriteLine();

            Console.WriteLine("ABBA".IsPalindrome());
            Console.WriteLine("AB1A".IsPalindrome());
        }

        public static bool IsPalindrom(string tekst)
        {
            if (tekst.Length <= 1)
                return true;
            else if (tekst[0] == tekst[tekst.Length - 1])
                return IsPalindrom(tekst.Substring(1, tekst.Length - 2));
            else
                return false;
        }
    }

    public static class Extension
    {
        public static bool IsPalindrome(this string tekst)
        {
            if (tekst.Length <= 1)
                return true;
            else if (tekst[0] == tekst[tekst.Length - 1])
                return IsPalindrome(tekst.Substring(1, tekst.Length - 2));
            else
                return false;
        }
    }
}