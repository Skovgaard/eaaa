package ex6student;

import java.util.LinkedHashSet;
import java.util.Set;

public class Salesman implements BookObserver {
    private String name;

    public Salesman(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Book book) {
        Set<Book> booksBought = new LinkedHashSet<>();
        book.getCustomers().forEach(customer -> booksBought.addAll(customer.getBooks()));
        booksBought.remove(book);
        System.out.println(booksBought);
    }
}
