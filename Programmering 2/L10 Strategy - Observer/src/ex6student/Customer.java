package ex6student;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;

    private List<Book> books = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
            book.addCustomer(this);
        }
    }

    @Override
    public String toString() {
        return name;
    }

}
