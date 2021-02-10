using System;

/*
 * Opret en solution som en konsolapplikation (File, New, Project, Visual C#, Console Application). Giv den et fornuftigt navn og omdøb også Program.cs (højreklik på filen i Solution Explorer).
 * Programmér de fire klasser og deres indbyrdes sammenhæng. For hver klasse: Opret en ny klasse i projektet (Project, Add Class og giv den navn).
 * Test, at der kan oprettes instanser af klasserne og indsættes og læses oplysninger.
 */

namespace Øvelse2
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Person person = new Person("navn", "adresse");

            Console.WriteLine($"{person.Navn} {person.Adresse}");

            person.Navn = "Navn1";
            person.Adresse = "Adresse1";

            Console.WriteLine($"{person.Navn} {person.Adresse}");

            Synsmand synsmand = new Synsmand("synsmandnavn", "synsmandadresse", 2020, 150, 7);

            Console.WriteLine($"{synsmand.Navn} {synsmand.Adresse} {synsmand.UgeLøn}");

            synsmand.Navn = "Navn1";
            synsmand.Adresse = "Adresse1";
            synsmand.SynPerUge = 14;

            Console.WriteLine($"{synsmand.Navn} {synsmand.Adresse} {synsmand.UgeLøn}");
        }
    }
}
