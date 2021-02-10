using System;

namespace Øvelse3
{
    public class Værkfører : Mekaniker
    {
        public int UdnævnelsesÅr { get; set; }
        public int TillægPerUge { get; set; }

        public override int UgeLøn
        {
            get { return base.UgeLøn + TillægPerUge; }
        }

        public Værkfører(string navn, string adresse, int svennePrøveÅr, int timeløn, int udnævnelsesÅr, int tillægPerUge) : base(navn, adresse, svennePrøveÅr, timeløn)
        {
            UdnævnelsesÅr = udnævnelsesÅr;
            TillægPerUge = tillægPerUge;
        }

    }
}
