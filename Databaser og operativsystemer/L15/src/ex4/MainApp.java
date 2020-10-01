package ex4;

public class MainApp {

    public static void main(String[] args) {

        new Factorial(5).run();

        new Sum(5).start();

        new Both(7).start();

    }

    private static class Factorial implements Runnable {

        private int n;

        public Factorial(int n) {
            this.n = n;
        }

        public void run() {
            int result = n;
            for (int i = 1; i < n; i++) {
                result *= (n - i);
            }
            System.out.println(result);
        }
    }

    private static class Sum extends Thread {

        private int n;

        public Sum(int n) {
            this.n = n;
        }

        public void run() {
            int result = 0;
            for (int i = 0; i <= n; i++) {
                result += i;
            }
            System.out.println(result);
        }
    }

    private static class Both extends Thread {

        private int n;

        public Both(int n) {
            this.n = n;
        }

        public void run() {
            new Factorial(n).run();
            new Sum(n).start();
        }

    }

}
