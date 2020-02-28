package ex2;

import java.util.Comparator;

public class CustomerCompareNumber implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return Integer.compare(o1.getNumber(), o2.getNumber());
    }
}
