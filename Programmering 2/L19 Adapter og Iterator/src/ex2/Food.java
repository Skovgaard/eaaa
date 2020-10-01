package ex2;

public class Food extends Item {

    public Food(double netprice, String name) {
        super(netprice, name);
    }

    public double calcVAT() {
        return getNetprice() * 0.05;
    }
}
