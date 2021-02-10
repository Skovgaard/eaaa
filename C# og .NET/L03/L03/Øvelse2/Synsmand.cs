using System;
namespace Øvelse2
{
    public class Synsmand : Mekaniker
    {
        public int SynPerUge { get; set; }

        public int UgeLøn
        {
            get { return SynPerUge * 290; }
        }

        public Synsmand(string navn, string adresse, int svennePrøveÅr, int timeløn, int synPerUge) : base(navn, adresse, svennePrøveÅr, timeløn)
        {
            SynPerUge = synPerUge;
        }
    }
}
