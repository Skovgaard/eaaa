package ex2;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        //ex2
        System.out.println("Ex2:");
        Customer c1 = new Customer(1, "Kasper");
        Customer c2 = new Customer(2, "Mathias");
        Customer c3 = new Customer(3, "Alexander");

        List<Customer> customerList = new LinkedList<>();
        customerList.add(c1);
        customerList.add(c2);
        customerList.add(c3);

        System.out.println("Sorting by number: ");
        Customer.setComparator(new CustomerCompareNumber());
        Collections.sort(customerList);
        for (Customer c : customerList) {
            System.out.println(c);
        }

        System.out.println("Sorting by name: ");
        Customer.setComparator(new CustomerCompareName());
        Collections.sort(customerList);
        for (Customer c : customerList) {
            System.out.println(c);
        }

        //Uden strategy pattern, bruger bare lambda
        customerList.sort((c4, c5) -> Integer.compare(c4.getNumber(), c5.getNumber()));
        customerList.sort(Comparator.comparingInt(Customer::getNumber));

        customerList.sort((c4, c5) -> c4.getName().compareTo(c5.getName()));
        customerList.sort(Comparator.comparing(Customer::getName));

    }

}
