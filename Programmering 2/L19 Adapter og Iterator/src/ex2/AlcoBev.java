package ex2;

public class AlcoBev {

    private double theNetprice;
    private String theDescription;

    public AlcoBev(double theNetprice, String theDescription) {
        this.theNetprice = theNetprice;
        this.theDescription = theDescription;
    }

    public double getTheNetprice() {
        return theNetprice;
    }

    public void setTheNetprice(double theNetprice) {
        this.theNetprice = theNetprice;
    }

    public String getTheDescription() {
        return theDescription;
    }

    public void setTheDescription(String theDescription) {
        this.theDescription = theDescription;
    }

    public double getVat() {
        return getTheNetprice() > 150 ? getTheNetprice() * 0.8 : getTheNetprice() * 1.2;
    }
}
