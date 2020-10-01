package ex3;

public class Navn implements Comparable<Navn> {

    private String fornavn;
    private String efternavn;

    public Navn(String fornavn, String efternavn) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
    }

    @Override
    public int compareTo(Navn o) {
        if (fornavn.compareTo(o.fornavn) == 0)
            return efternavn.compareTo(o.efternavn);
        else
            return fornavn.compareTo(o.fornavn);
    }

    @Override
    public String toString() {
        return fornavn + (efternavn.isEmpty() ? "" : " " + efternavn);
    }
}
