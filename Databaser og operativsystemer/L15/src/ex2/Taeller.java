package ex2;

/*
 * Klasse : Taeller.java
 * Programmør : Søren Madsen
 * Beskrivelse: Mainprogram der opretter 5 tråde og starter udførelsen af dem */
public class Taeller {
    public static void main(String args[]) {
        Thread tal1, tal2, tal3, tal4, tal5; // 5 tråde
        tal1 = new Thread(new TaellerThread(1));
        tal1.start(); // Opretter og starter udførelsen af tråd
        tal2 = new Thread(new TaellerThread(2));
        tal2.start();
        tal3 = new Thread(new TaellerThread(3));
        tal3.start();
        tal4 = new Thread(new TaellerThread(4));
        tal4.start();
        tal5 = new Thread(new TaellerThread(5));
        tal5.start();
    } // main()
} // Taeller
