package bageri;

/**
 * File			: Kunder.java
 * Author		: S�ren Madsen
 * Beskrivelse	: Her simuleres en kunde i bageriudsalget
 * I Constructor modtages instans af nummerdimsen
 * Kunden ankommer til butikken og tr�kker et nummer fra nummerdimsen
 * sleep metoden simulerer vente- og betjeningstiden for kunden
 */

public class Kunder extends Thread {

    private static int nummer = 10000;      // Initial ID nummer
    private int id;
    private TagEtNummer tagEtNummer;

    /**
     * Kunder() constructor
     */
    public Kunder(TagEtNummer dims) {
        id = ++nummer;
        tagEtNummer = dims;
    }

    /**
     * run() metode
     */
    public void run() {
        try {
            sleep((int) (Math.random() * 16000));
            tagEtNummer.naesteNummer(id);
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    } // run()
} // Kunder
