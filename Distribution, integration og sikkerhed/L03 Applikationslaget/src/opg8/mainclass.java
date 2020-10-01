package opg8;

// Note: Ikke helt korrekt, lave en extra klasse og split arrayet op istedet for at kopiere dele

public class mainclass {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // laver 10 millioner lottorækker
        lottoraek[] spillede = new lottoraek[10000000];
        for (int j = 0; j < spillede.length; j++)
            spillede[j] = new lottoraek();
        // laver den rigtige lottorække
        lottoraek rigtig = new lottoraek();
        // laver array til optælling
        int[] antalgev = new int[8];
        // checker de 10 millioner lottorækker
        long l1, l2;
        lottoraek[] spillede1 = new lottoraek[5000000], spillede2 = new lottoraek[5000000];
        int[] antalgev1 = new int[8], antalgev2 = new int[8];
        // arraycopy er ender med at gøre køretiden næsten 2x - lidt forkert at sætte tælleren uden for
        System.arraycopy(spillede, 0, spillede1, 0, spillede.length / 2);
        System.arraycopy(spillede, spillede.length / 2, spillede2, 0, spillede.length / 2);
        l1 = System.nanoTime();
        CheckGevinster checkGevinster1 = new CheckGevinster(spillede1, antalgev1, rigtig);
        CheckGevinster checkGevinster2 = new CheckGevinster(spillede2, antalgev2, rigtig);
        checkGevinster1.start();
        checkGevinster2.start();
        try {
            checkGevinster1.join();
            checkGevinster2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        l2 = System.nanoTime();
        for (int i = 0; i < antalgev.length; i++) {
            antalgev[i] = antalgev1[i] + antalgev2[i];
        }
        // udskriver resultat
        System.out.println("Kæretiden var " + (l2 - l1) / 1000000 + " millisekunder");
        int total = 0;
        for (int i = 0; i < 8; i++) {
            System.out.println("Der var " + antalgev[i] + " rækker med " + i + " rigtige");
            total = total + antalgev[i];
        }
        System.out.println("Der var totalt " + total + " rækker");
    }
}	
