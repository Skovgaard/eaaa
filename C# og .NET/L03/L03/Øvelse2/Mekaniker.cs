using System;

namespace Øvelse2
{
    public class Mekaniker : Person
    {
        public int SvennePrøveÅr { get; set; }
        public int Timeløn { get; set; }

        public Mekaniker(string navn, string adresse, int svennePrøveÅr, int timeløn) : base(navn, adresse)
        {
            SvennePrøveÅr = svennePrøveÅr;
            Timeløn = timeløn;
        }
    }
}
