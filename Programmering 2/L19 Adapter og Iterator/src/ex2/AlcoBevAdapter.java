package ex2;

public class AlcoBevAdapter extends Item {

    private AlcoBev alcoBev;

    public AlcoBevAdapter(AlcoBev alcoBev) {
        super(alcoBev.getTheNetprice(), alcoBev.getTheDescription()); // name = description
        this.alcoBev = alcoBev;
    }

    public double getNetprice() {
        return alcoBev.getTheNetprice();
    }

    public void setNetprice(double netprice) {
        alcoBev.setTheNetprice(netprice);
    }

    public String getTheDescription() {
        return alcoBev.getTheDescription();
    }

    public void setTheDescription(String theDescription) {
        alcoBev.setTheDescription(theDescription);
    }

    @Override
    public double calcVAT() {
        return alcoBev.getVat();
    }
}
