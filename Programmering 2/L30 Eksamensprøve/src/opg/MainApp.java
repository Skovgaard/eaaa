package opg;

import java.util.LinkedList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        Abonnement abonnement = new Abonnement(100, 0.2);

        TimePakke timePakke = new TimePakke(80, 0.3, 10);

        Udvidelsespakke udvidelsespakke = new Udvidelsespakke(50, 0d, 5, 25);

        List<Abonnement> abonnementList = new LinkedList<>();
        abonnementList.add(abonnement);
        abonnementList.add(timePakke);
        abonnementList.add(udvidelsespakke);

        for (Abonnement abonnement1 : abonnementList) {
            System.out.println("Abonnement pris: " + abonnement1.abonnementsPris());
        }

        System.out.println("Sum: " + sumAfAbonnementer(abonnementList));

    }

    public static double sumAfAbonnementer(List<Abonnement> list) {
        double sum = 0;
        for (Abonnement abonnement : list) {
            sum += abonnement.abonnementsPris();
        }
        return sum;
    }

}
