/*
 * Din opgave er at erstatte de fire metoder med én enkelt metode, så vi undgår duplikeret kode.
 * 1. Start med at lave en delegate i Person klassen.
 * Formålet med denne delegate er at den skal bruges til at give en metode med som parameter til vores nye Print metode.
 * Således at man kan kalde vores nye metode med forskellige metoder, der formaterer navnet på forskellige måder.
 * 2. Lav på Person klassen nu en ny metode, der tager den nyoprettede delegate som parameter.
 * Metoden udskriver til konsollen resultatet af et kald til parameteren.
 * 3. Gå nu tilbage Program.cs og tilføj fire metoder, der hver især formaterer en persons navn til et af de kendte formater.
 * 4. Endelig skal du nu erstatte kaldene til PrintFullNameLastNameFirst(), PrintFullNameAllCaps(),
 * PrintFullNameLowerCase() og PrintShortName() med kald til din nye metode med passende parameter.
 * 5. Ekstra: Prøv nu også at slippe af med de gentagne kald til ForEach for hver formatering af personnavnene.
 * Dette kan du f.eks. gøre ved at lave en PrintPeople metode som tager din delegate som parameter og bruger den under gennemløb af alle personer.
 */

using System;
using System.Collections.Generic;
// ReSharper disable InconsistentNaming

namespace Øvelse8
{
    public class Person
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }

        public delegate string Formatter(string F, string L);

        public void CallDelegate(Formatter formatter)
        {
            Console.WriteLine(formatter(FirstName, LastName));
        }

        // public void PrintFullNameLastNameFirst()
        // {
        //     Console.WriteLine($"{LastName}, {FirstName}");
        // }
        //
        // public void PrintFullNameAllCaps()
        // {
        //     Console.WriteLine($"{LastName.ToUpper()}, {FirstName.ToUpper()}");
        // }
        //
        // public void PrintFullNameLowerCase()
        // {
        //     Console.WriteLine($"{LastName.ToLower()}, {FirstName.ToLower()}");
        // }
        //
        // public void PrintShortName()
        // {
        //     Console.WriteLine($"{FirstName.Substring(0, 1)}. {LastName}");
        // }

        public static List<Person> CreateListOfPeople()
        {
            return new List<Person>()
            {
                new Person() {FirstName = "Stephen", LastName = "King"},
                new Person() {FirstName = "George", LastName = "Martin"},
                new Person() {FirstName = "Ernest", LastName = "Hemingway"},
                new Person() {FirstName = "William", LastName = "Shakespeare"}
            };
        }
    }

    public class PersonUserClass
    {
        public static void Main(string[] args)
        {
            var people = Person.CreateListOfPeople();

            ////////////////////////////////
            // Start here            
            ////////////////////////////////
            // Hint:
            // This piece of code
            // foreach (var p in people)
                // p.PrintFullNameLastNameFirst();
            // can be translated to
            // people.ForEach(p => p.PrintFullNameLastNameFirst());
            // using the ForEach method on List<>. ForEach takes a Lambda as input

            //
            // Problem 1
            // Use this to simplify the foreach statements in the while loop below
            // so they take up only one line each, instead of two
            //
            // Problem 2 (Answer in less than 30 seconds)
            // Did Problem 1 simplify or just make your code harder to read?
            //
            // Problem 3 (May be a hard problem)
            // Give the PersonUserClass class a method PrintFullNameLastNameFirst (copy from Person class)
            // And add a delegate called Formatter to your Person class
            // and a method that takes a this type of delegate as input
            // so this call becomes possible on a person:
            //
            // p.CallDelegate((F, L) => PrintFullNameLastNameFirst(F, L))
            // Use this to translate all your ForEach lines in the while loop to something like
            // people.ForEach(p => p.CallDelegate((F, L) => PrintFullNameLastNameFirst(F, L)));
            //

            while (true)
            {
                Console.WriteLine("----------------------------------------------------");
                Console.WriteLine("Hvordan vil du have udskrevet navnene?");
                Console.WriteLine("1: Efternavn efterfulgt af fornavn");
                Console.WriteLine("2: Efternavn efterfulgt af fornavn, store bogstaver");
                Console.WriteLine("3: Efternavn efterfulgt af fornavn, små bogstaver");
                Console.WriteLine("4: Kun forbogstav af fornavn efterfulgt af efternavn");
                Console.WriteLine();
                Console.WriteLine("q: For at afslutte!");
                Console.Write("> ");
                var input = Console.ReadLine();
                switch (input.ToUpper())
                {
                    case "1":
                        people.ForEach(p => p.CallDelegate((F, L) => PrintFullNameLastNameFirst(F, L)));
                        break;
                    case "2":
                        people.ForEach(p => p.CallDelegate((F, L) => PrintFullNameAllCaps(F, L)));
                        break;
                    case "3":
                        people.ForEach(p => p.CallDelegate((F, L) => PrintFullNameLowerCase(F, L)));
                        break;
                    case "4":
                        people.ForEach(p => p.CallDelegate((F, L) => PrintShortName(F, L)));
                        break;
                    case "Q": return;
                    default:
                        Console.WriteLine("Ukendt valg, prøv igen");
                        break;
                }
            }
        }

        public static string PrintFullNameLastNameFirst(string F, string L)
        {
            return $"{L}, {F}";
        }

        public static string PrintFullNameAllCaps(string F, string L)
        {
            return $"{L.ToUpper()}, {F.ToUpper()}";
        }

        public static string PrintFullNameLowerCase(string F, string L)
        {
            return $"{L.ToLower()}, {F.ToLower()}";
        }

        public static string PrintShortName(string F, string L)
        {
            return $"{F.Substring(0, 1)}. {L}";
        }
    }
}