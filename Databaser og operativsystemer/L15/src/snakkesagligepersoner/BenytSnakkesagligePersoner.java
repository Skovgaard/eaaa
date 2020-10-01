package snakkesagligepersoner;

public class BenytSnakkesagligePersoner {
    public static void main(String[] arg) {
        SnakkesagligPerson p = new SnakkesagligPerson("Jacob", 150); // opret Jacob
        Thread t = new Thread(p); // Ny tr�d, klar til at udf�re p.run()
        t.start(); // .. Nu starter personen med at snakke...

        p = new SnakkesagligPerson("Troels", 400);                   // opret Troels
        t = new Thread(p);
        t.start();

        // Det kan ogs� g�res meget kompakt:
        new Thread(new SnakkesagligPerson("Henrik", 200)).start();   // opret Henrik
    }
}