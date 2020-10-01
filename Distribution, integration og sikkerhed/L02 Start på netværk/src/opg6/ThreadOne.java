package opg6;

import java.util.Scanner;

public class ThreadOne extends Thread {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        while (true) {
            Common.setString(scanner.nextLine());
        }
    }

}
