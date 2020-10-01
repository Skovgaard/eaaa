package ex2;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Exercise 2");
        Food food = new Food(100, "Bolle");
        ElApp elApp = new ElApp(150, "TV");
        AlcoBev alcoBev = new AlcoBev(75, "Alcohol");
        AlcoBevAdapter alcoBevAdapter = new AlcoBevAdapter(alcoBev);

        List<Item> list = new LinkedList<>();
        list.add(food);
        list.add(elApp);
        list.add(alcoBevAdapter);

        for (Item item : list) {
            System.out.println("Name: " + item.getName() + " netprice: " + item.getNetprice() + " vat: " + item.calcVAT());
        }
    }
}
