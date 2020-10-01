package ex5;

public interface LispList {

    LispList NIL = new EmptyList();

    boolean empty();

    Object head();

    LispList tail();

    default LispList cons(Object object) {
        return new NonEmptyList(object, this);
    }
}
