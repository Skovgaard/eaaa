package ex4;

public class MainApp {

    public static void main(String[] args) {
        ArrayedListStudent<Integer> arrayedListStudent = new ArrayedListStudent<>();
        arrayedListStudent.add(1);
        arrayedListStudent.add(2);
        arrayedListStudent.add(3);

        for (Integer integer : arrayedListStudent) {
            System.out.println(integer);
        }
    }
}
