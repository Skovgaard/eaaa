package bageri;

/*
 * File			: Bageri.java
 * Author		: S�ren Madsen
 * Beskrivelse	: Simulerer et bageriudsalg
 * 					Opretter en nummerdims, en ekspedient og et antal kunder.
 * 					Starter derefter simulering af bageriudsalget
 */

public class Bageri {
    public static void main(String[] args) {
        System.out.println("Starter Ekspedient og Kunde tr�dene");
        TagEtNummer nummerDims = new TagEtNummer();
        Ekspedient ekspedient = new Ekspedient(nummerDims);
        ekspedient.start();
        for (int k = 0; k < 10; k++) {
            Kunder kunder = new Kunder(nummerDims);
            kunder.start();
        }
    } // main()
} // Bageri

