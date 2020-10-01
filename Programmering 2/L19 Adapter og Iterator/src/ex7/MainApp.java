package ex7;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Opg 7");
        // Tror ikke jeg har forstået den korrekt, generelt uklart skrevet?

        ObservableBag observableBag = new ObservableBag();

        ObserveableBagAdapter observeableBagAdapter = new ObserveableBagAdapter(observableBag);

        BagObserver bagObserver = new BagObserver();

        observableBag.addObserver(bagObserver);

        observableBag.add("Bog");
        observableBag.add("Vandflaske");
        observableBag.add("Bærbar");
        observableBag.add("Bog");

        observableBag.remove("Bog");
        observableBag.remove("Bog");

        for (String s : observableBag) {
            System.out.println(s);
        }

    }
}
