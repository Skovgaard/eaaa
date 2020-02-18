package andebybank.ex6;

public class Transaktion {

    private int regNr;
    private long ktoNr;
    private String dato;
    private String tekst;
    private double beløb;

    public Transaktion(int regNr, long ktoNr, String dato, String tekst, double beløb) {
        this.regNr = regNr;
        this.ktoNr = ktoNr;
        this.dato = dato;
        this.tekst = tekst;
        this.beløb = beløb;
    }

    @Override
    public String toString() {
        return regNr + "    " + ktoNr + "    " + dato + "    " + tekst + "    " + beløb;
    }
}
