package ex5;

public class EmptyList implements LispList {

    @Override
    public boolean empty() {
        return true;
    }

    @Override
    public Object head() {
        throw new UnsupportedOperationException();
    }

    @Override
    public LispList tail() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "";
    }
}
