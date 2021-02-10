using System;

/*
 * Implementer en struct kaldet Time, som repræsenterer et tidspunkt 00:00:00-23:59:59. Internt gemmes tidspunktet som et antal sekunder i et privat felt. 
 * F.eks. svarer 01:23:20 til 5000 sekunder i det private felt.
 * I de foregående opgaver blev det foreslået at oprette en fil pr. klasse. Her kan I nøjes med at skrive det hele i en cs-fil.
 * Erklær en int, der indeholder antal sekunder siden midnat.
 * Erklær tre properties, som sætter og returnerer henholdsvis timer, minutter og sekunder (i det følgende antages det, at de hedder Hour, Min og Sek).
 * Skriv en constructor, der kan tage tidspunktet som en string på formatet ”hh:mm:ss” (f.eks. ”01:23:20”). Altså altid 3 gange to cifre adskilt af kolon.
 * Brug SubString() i string klassen til at trække de enkelte værdier ud. Omform til tal med Int32.Parse(). 
 * Skriv en anden constructor, der tager 3 int som parametre, nemlig timer, minutter og sekunder.
 * Lav desuden en ToString(), der returnerer tidspunktet på førnævnte format. Bemærk at signaturen skal indeholde ”override”, dvs. den skal være
 * public override string ToString()
 * Test din struct, og prøv f.eks. følgende kode i main:
 * Time t1, t2;
 * t1=new Time("08:30:00");
 * t2=t1;
 * t2.Hour=t2.Hour+2;
 * textBox1.Text=t1.ToString();
 * textBox2.Text=t2.ToString();
 * Test også fejl i input ved oprettelse og ændring.
 */

namespace Øvelse4
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Time t1, t2;
            t1 = new Time("08:30:00");
            t2 = t1;
            t2.Hour = t2.Hour + 2;
            Console.WriteLine(t1.ToString());
            Console.WriteLine(t2.ToString());

            Time t3, t4;
            t3 = t1;
            t3.Min = t3.Min + 2;
            t4 = t1;
            t4.Sek = t4.Sek + 2;
            Console.WriteLine(t3.ToString());
            Console.WriteLine(t4.ToString());

            // Time t5;
            // t5 = new Time("25:0:0");
            // Console.WriteLine(t5.ToString());
        }
    }

    struct Time
    {
        private int _secondsSinceMidnight;

        public int Hour
        {
            get => _secondsSinceMidnight / 3600;
            set => _secondsSinceMidnight += (value - Hour) * 3600;
        }
        public int Min
        {
            get => _secondsSinceMidnight % 3600 / 60;
            set => _secondsSinceMidnight += (value - Min) * 60;
        }
        public int Sek
        {
            get => _secondsSinceMidnight % 60;
            set => _secondsSinceMidnight += value - Sek;
        }

        public Time(string time)
        {
            int h = Int32.Parse(time.Substring(0, 2));
            int m = Int32.Parse(time.Substring(3, 2));
            int s = Int32.Parse(time.Substring(6, 2));
            _secondsSinceMidnight = h * 3600 + m * 60 + s;
        }

        public Time(int h, int m, int s)
        {
            _secondsSinceMidnight = h * 3600 + m * 60 + s;
        }

        public override string ToString()
        {
            return $"{Hour}:{Min}:{Sek}";
        }
    }
}
