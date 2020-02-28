package ex6student;

public class TestApp {

    public static void main(String[] args) {
        //Create a salesman and a purchaser
        Salesman salesman = new Salesman("Sælger 1");
        Purchaser purchaser = new Purchaser("Indkøber 1");

        Book b1 = new Book("Donald Duck");
        //Add observers
        b1.addObserver(salesman);
        b1.addObserver(purchaser);

        //Make purchaser buy 6 copies of b1
        purchaser.purchaseBook(b1, 6);
        System.out.println();

        Book b2 = new Book("Java");
        //Add observers
        b2.addObserver(salesman);
        b2.addObserver(purchaser);

        //Make purchaser buy 8 copies of b2
        purchaser.purchaseBook(b2, 8);
        System.out.println();

        Book b3 = new Book("Design Patterns");
        //Add observers
        b3.addObserver(salesman);
        b3.addObserver(purchaser);

        //Make purchaser buy 10 copies of b3
        purchaser.purchaseBook(b3, 10);
        System.out.println();

        Customer c1 = new Customer("Bob");
        Customer c2 = new Customer("Alice");
        Customer c3 = new Customer("Harry");

        //---------------------------------------------------------------------

        TestApp.makeSale(b1, c1);
        System.out.println();
        TestApp.makeSale(b1, c2);
        System.out.println();
        TestApp.makeSale(b1, c3);
        System.out.println();

        TestApp.makeSale(b2, c1);
        System.out.println();
        TestApp.makeSale(b2, c2);
        System.out.println();
        TestApp.makeSale(b2, c3);
        System.out.println();

        TestApp.makeSale(b3, c1);
        System.out.println();

        //Print each customer and his/her books
        System.out.println(c1.getName() + "'s books: " + c1.getBooks());
        System.out.println(c2.getName() + "'s books: " + c2.getBooks());
        System.out.println(c2.getName() + "'s books: " + c2.getBooks());
    }

    public static void makeSale(Book b, Customer c) {
        System.out.println("Sale: " + b + " sold to " + c.getName());
        //Link customer and book
        b.addCustomer(c);
        b.decCount(1);
    }

}
