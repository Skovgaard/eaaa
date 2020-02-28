package ex2;

import java.util.Comparator;

public class Customer implements Comparable<Customer> {

    private int number;
    private String name;

    private static Comparator<Customer> comparator;

    public Customer(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Comparator<Customer> getComparator() {
        return comparator;
    }

    public static void setComparator(Comparator<Customer> comparator) {
        Customer.comparator = comparator;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Customer c) {
        return comparator.compare(this, c);
    }
}
