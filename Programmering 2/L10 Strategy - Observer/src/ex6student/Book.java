package ex6student;

import java.util.*;

public class Book {
    private String title;
    private int count;


    private List<Customer> customers = new ArrayList<>();

    private Set<BookObserver> bookObservers = new LinkedHashSet<>();

    public Book(String title) {
        this.title = title;
        this.count = 0;
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addObserver(BookObserver bookObserver) {
        bookObservers.add(bookObserver);
    }

    public void incCount(int amount) {
        count += amount;
    }

    public void decCount(int amount) {
        count -= amount;
        bookObservers.forEach(bookObserver -> bookObserver.update(this));
    }

    public void addCustomer(Customer customer) {
        if (!customers.contains(customer)) {
            customers.add(customer);
            customer.addBook(this);
        }
    }

    @Override
    public String toString() {
        return title + "(" + count + ")";
    }
}
