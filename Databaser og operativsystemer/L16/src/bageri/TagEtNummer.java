package bageri;

/**
 * File			: TagEtNummer.java
 * Author		: S�ren Madsen
 * Beskrivelse	: Simulerer nummerdimsen i bageriudsalget
 * Klassen har to lokale variable
 * naeste		: angiver det n�ste nummer som en ny kunde vil tr�kke fra nummerdimsen
 * betjening	: angiver hvilken kunde der n�ste gang skal betjenes af ekspedienten
 */

public class TagEtNummer {

    private int naeste = 0;
    private int betjening = 0;

    /**
     * Kaldes fra klassen Kunder og giver en nyankommen kunde det n�ste nummer fra nummerdimsen
     * Der sendes en notify() som v�kker ekspedienten, hvis denne er i wait() fordi der ikke var flere kunder i butikken
     */
    public synchronized int naesteNummer(int kundeId) {
        naeste = naeste + 1;
        System.out.println("Kunde " + kundeId + " tager nummer " + naeste);
        notify();
        return naeste;
    } // naesteNummer()+++


    /**
     * Kaldes fra klassen Ekspedient og fort�ller hvilken kunde der skal ekspederes nu
     * Hvis der ikke er flere kunder i k�en kaldes metoden wait() og tr�den afventer en notify fra kundetr�den. Denne sendes, n�r en
     * ny kunde kommer ind i butikker og tr�kker et nummer
     */

    public synchronized int naesteKunde() {
        try {
            while (naeste <= betjening) {
                System.out.println("  Ekspedient venter ");
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Exception " + e.getMessage());
        } finally {
            ++betjening;
            System.out.println("  Ekspedient ekspederer nummer " + betjening);
        }
        return betjening;
    } // naesteKunde()
} // TagEtNummer
