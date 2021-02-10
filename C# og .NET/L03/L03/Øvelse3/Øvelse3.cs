using System;

/*
 * Udvid klasserne fra opgave 1 og 2, så det nu bliver muligt at beregne ugeløn for alle. 
 * Det kan antages, at alle har en arbejdsuge på 37 timer.
 * Test den nye funktionalitet.
 */

namespace Øvelse3
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Mekaniker mekaniker = new Mekaniker("m", "a", 2020, 200);

            Console.WriteLine(mekaniker.UgeLøn);

            Værkfører værkfører = new Værkfører("v", "a", 2020, 200, 2020, 1000);

            Console.WriteLine(værkfører.UgeLøn);

            Synsmand synsmand = new Synsmand("s", "a", 2020, 200, 35);

            Console.WriteLine(synsmand.UgeLøn);
        }
    }
}
