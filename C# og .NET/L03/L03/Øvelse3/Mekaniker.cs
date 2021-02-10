using System;

namespace Øvelse3
{
    public class Mekaniker : Person
    {
        public int SvennePrøveÅr { get; set; }
        public int Timeløn { get; set; }

        public virtual int UgeLøn
        {
            get { return Timeløn * 37; }
        }

        public Mekaniker(string navn, string adresse, int svennePrøveÅr, int timeløn) : base(navn, adresse)
        {
            SvennePrøveÅr = svennePrøveÅr;
            Timeløn = timeløn;
        }
    }
}
