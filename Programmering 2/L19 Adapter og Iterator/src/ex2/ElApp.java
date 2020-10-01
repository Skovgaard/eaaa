package ex2;

public class ElApp extends Item {

    public ElApp(double netprice, String name) {
        super(netprice, name);
    }

    public double calcVAT() {
        return getNetprice() * 0.3 > 3 ? getNetprice() * 0.3 : 3;
    }
}
