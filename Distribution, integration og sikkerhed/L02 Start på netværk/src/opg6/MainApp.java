package opg6;

public class MainApp {

    public static void main(String[] args) {

        ThreadOne threadOne = new ThreadOne();
        threadOne.start();

        ThreadTwo threadTwo = new ThreadTwo();
        threadTwo.start();

    }

}
