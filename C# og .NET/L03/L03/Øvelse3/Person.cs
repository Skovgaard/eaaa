using System;

namespace Øvelse3
{
    public class Person
    {
        public string Navn { get; set; }
        public string Adresse { get; set; }

        public Person(string navn, string adresse)
        {
            Navn = navn;
            Adresse = adresse;
        }
    }
}
