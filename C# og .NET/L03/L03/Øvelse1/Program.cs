using System;

/*
 * Skitser fire klasser i en generaliseringsstruktur, der repræsenterer begreberne person, mekaniker, værkfører og synsmand (på et mekanikerværksted).
 * For personer registreres navn og adresse. Det skal være muligt både at opdatere og hente navn og adresse.
 * For mekanikere registreres endvidere år for svendeprøve samt en timeløn. Igen skal det være muligt at hente og opdatere begge attributter.
 * For værkførere (der også er mekanikere) registreres år for udnævnelse til værkfører samt størrelsen af det tillæg pr. uge, som værkføreren gives ud over den almindelige timeløn.
 * En synsmand er også ansat på et værksted og er mekaniker. For hver Synsmand holdes rede på, hvor mange syn han har lavet på en uge. Hans ugeløn beregnes som antal syn i den pågældende uge * 290.
 */

namespace Øvelse1
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
        }
    }

    class Person
    {
        public string Navn { get; set; }
        public string Adresse { get; set; }

        public Person(string navn, string adresse)
        {
            Navn = navn;
            Adresse = adresse;
        }
    }

    class Mekaniker : Person
    {
        public int SvennePrøveÅr { get; set; }
        public int Timeløn { get; set; }

        public Mekaniker(string navn, string adresse, int svennePrøveÅr, int timeløn) : base(navn, adresse)
        {
            SvennePrøveÅr = svennePrøveÅr;
            Timeløn = timeløn;
        }
    }

    class Værkfører : Mekaniker
    {
        public int UdnævnelsesÅr { get; set; }
        public int TillægPerUge { get; set; }

        public Værkfører(string navn, string adresse, int svennePrøveÅr, int timeløn, int udnævnelsesÅr, int tillægPerUge) : base(navn, adresse, svennePrøveÅr, timeløn)
        {
            UdnævnelsesÅr = udnævnelsesÅr;
            TillægPerUge = tillægPerUge;
        }

    }

    class Synsmand : Mekaniker
    {
        public int SynPerUge { get; set; }

        public int UgeLøn {
            get { return SynPerUge * 290; }
        }

        public Synsmand(string navn, string adresse, int svennePrøveÅr, int timeløn, int synPerUge) : base(navn, adresse, svennePrøveÅr, timeløn)
        {
            SynPerUge = synPerUge;
        }
    }
}
    