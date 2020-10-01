package ex7;

public class BagObserver implements Observer {

    @Override
    public void update(String s, int amount) {
        System.out.println("Navn: " + s + " antal: " + amount);
    }
}
