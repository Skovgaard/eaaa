package ex5;

public class MainApp {

    public static void main(String[] args) {

        LispList list = new NonEmptyList("A", new NonEmptyList("B", new NonEmptyList("C", new EmptyList())));

        LispList list1 = LispList.NIL.cons("C").cons("B").cons("A");

        System.out.println(list.toString());

        System.out.println(list1.toString());

    }

}
