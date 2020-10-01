package bageri;

/**
 * File			: Ekspedient.java
 * Author		: S�ren Madsen
 * Beskrivelse	: Defintion af ekspedienten p� basis af Thread klassen
 * Constructor modtager instans af nummerdimsen, s�ledes at den n�ste kunde der skal betjenes kan udv�lges
 * sleep metoden simulerer den tid det tager at ekspedere en kunde
 */
public class Ekspedient extends Thread {
    private TagEtNummer tagEtNummer;

    /**
     * Ekspedient() constructor
     */
    public Ekspedient(TagEtNummer dims) {
        tagEtNummer = dims;
    }

    /**
     * run() metode
     */
    public void run() {
        while (true) {
            try {
                sleep((int) (Math.random() * 4000));
                tagEtNummer.naesteKunde();
            } catch (InterruptedException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        } // while
    } // run()
} // Ekspedient
