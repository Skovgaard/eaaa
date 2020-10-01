package ex3;

public class Person<T extends Comparable<T>> implements Comparable<Person<T>> {

    private T navn;

    public Person(T navn) {
        this.navn = navn;
    }

    @Override
    public int compareTo(Person<T> o) {
        return navn.compareTo(o.navn);
    }

    @Override
    public String toString() {
        return navn.toString();
    }
}
