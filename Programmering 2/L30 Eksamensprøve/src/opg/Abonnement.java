package opg;

public class Abonnement {

    private double mndPris;
    private double minutPris;

    public Abonnement(double mndPris, double minutPris) {
        this.mndPris = mndPris;
        this.minutPris = minutPris;
    }

    public double getMndPris() {
        return mndPris;
    }

    public double abonnementsPris(){
        return mndPris;
    }
}
