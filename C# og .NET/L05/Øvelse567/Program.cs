/*
 * Øvelse 5
 * Create a new class EventClass.
 * Give this class a StringToInt delegate that takes a string argument and returns an integer.
 * Implement a method CountChars, that count chars in a string argument and returns the integer result.
 *
 * Øvelse 6
 * In class EventClass: Create a StringToInt delegate from your CountChars method.
 * Use the delegate to count the chars in 3 different strings.
 *
 * Øvelse 7
 * In class EventClass: Create a method DelegateUser that takes two arguments: a StringToInt delegate and a string argument.
 * DelegateUser must call the delegate with the string argument and return the result.
 * Demonstrate that you can use your DelegateUser on a string.
 */

using System;

namespace Øvelse567
{
    internal class Program
    {
        public static void Main(string[] args)
        {

            string s1 = "abc";
            string s2 = "abcwdawd";
            string s3 = "abf213y4123awdawdc";

            Console.WriteLine(EventClass.CountChars(s1));
        }
    }

    internal class EventClass
    {
        internal delegate int StringToInt(string s);

        public StringToInt stringToInt = CountChars;

        public static int CountChars(string s)
        {
            return s.Length;
        }

    }
}