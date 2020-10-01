package ex3;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        ArrayList<Person<Navn>> list = new ArrayList<>();

        list.add(new Person<>(new Navn("Rap", "")));
        list.add(new Person<>(new Navn("Joakim", "von And")));
        list.add(new Person<>(new Navn("Anders", "Gås")));
        list.add(new Person<>(new Navn("Anders", "And")));
        list.add(new Person<>(new Navn("Rup", "")));
        list.add(new Person<>(new Navn("Rip", "")));
        list.add(new Person<>(new Navn("Andersine", "And")));
        list.add(new Person<>(new Navn("Anders", "Ikke And")));

        System.out.println(list.toString());

        Collections.sort(list);

        System.out.println(list.toString());
    }

}
