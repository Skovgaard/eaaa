package ex5;

public class NonEmptyList implements LispList {

    private Object head;
    private LispList tail;

    public NonEmptyList(Object head, LispList tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public Object head() {
        return head;
    }

    @Override
    public LispList tail() {
        return tail;
    }

    public String toString() {
        return head() + " " + tail().toString();
    }
}
