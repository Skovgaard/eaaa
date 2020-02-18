
import java.io.File;

public class Exercises {

    public static void main(String[] args) {

        //ex1
        System.out.println(factorial(5));

        //ex2
        System.out.println(power(2, 2));

        System.out.println(power2(2, 8));

        //ex3
        System.out.println(prod(2, 5));

        System.out.println(prodRus(3, 7));

        //ex4
        System.out.println(reverse("RANSLIRPA"));

        System.out.println(reverse2("RANSLIRPA"));

        //ex5
//        scanDir("/Users/skov/Dropbox/eaaa/1 Semester/Programmering 1/Eclipse");

        //ex6
        System.out.println(gcd(1071, 462));

        //ex7
        System.out.println(domino(1));
        System.out.println(domino(2));
        System.out.println(domino(3));
        System.out.println(domino(4));
        System.out.println(domino(5));
        System.out.println(domino(6));
        System.out.println(domino(7));

    }


    //ex1
    private static int factorial(int n) {
        int sum;
        if (n <= 0)
            sum = 1;
        else {
            sum = n * factorial(n - 1);
        }
        return sum;
    }

    //ex2
    private static int power(int n, int p) {
        int sum;
        if (p <= 0)
            sum = 1;
        else {
            sum = power(n, p - 1) * n;
        }
        return sum;
    }

    private static int power2(int n, int p) {
        int sum;
        if (p <= 0)
            sum = 1;
        else if (p % 2 != 0) {
            sum = power2(n, p - 1) * n;
        } else {
            sum = power2(n * n, p / 2);
        }
        return sum;
    }

    //ex3
    private static int prod(int a, int b) {
        int sum;
        if (a == 1)
            sum = b;
        else if (a == 0)
            sum = 0;
        else
            sum = prod(a - 1, b) + b;
        return sum;
    }

    private static int prodRus(int a, int b) {
        int sum;
        if (a % 2 == 0 && a >= 2)
            sum = prodRus(a / 2, 2 * b);
        else if (a % 2 != 0 && a >= 1)
            sum = prodRus(a - 1, b) + b;
        else
            sum = 0;
        return sum;
    }

    //ex4
    private static String reverse(String s) {
        String result;
        if (s.length() > 0)
            result = s.substring(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
        else
            result = "";
        return result;
    }

    private static String reverse2(String s) {
        String result;
        if (s.length() > 0)
            result = s.substring(s.length() - 1) + reverse(s.substring(1, s.length() - 1)) + s.charAt(0);
        else
            result = "";
        return result;
    }


    //ex5
    private static void scanDir(String path) {
        try {
            File file = new File(path);
            if (file.isDirectory() && file.getName().charAt(0) == '.') {
                // if hidden do nothing
            } else if (file.isDirectory()) {
                // -7 to remove start level of path
                System.out.println(fill(dirLevel(path, 0) - 7) + file.getName());
                for (String s : file.list()) {
                    scanDir(path + "/" + s);
                }
            }
        } catch (Exception e) {
            System.out.println("Can't find file");
        }

    }

    private static int dirLevel(String path, int index) {
        if (index + 1 > path.length())
            return 0;

        int count = path.substring(index, index + 1).equals("/") ? 1 : 0;
        return count + dirLevel(path, index + 1);
    }

    private static String fill(int level) {
        String s = "";
        for (int i = 0; i < level; i++) {
            s += "  ";
        }
        return s;
    }

    //ex6
    private static int gcd(int a, int b) {
        int result;
        if (b <= a && a % b == 0)
            result = b;
        else if (a < b)
            result = gcd(b, a);
        else
            result = gcd(b, a % b);
        return result;
    }

    //ex7
    /*
        dom(n) = 1      if n = 1
        dom(n) = 2      if n = 2

        dom(n) = 0      if n < 1

        dom(n) = 1      if n <= 1
        dom(n) = dom(n-1) + dom(n-2)

        if n = 1, result = 1
        if n = 2, result = 2
        if n = 3, result = 3
        if n = 4, result = 5
        if n = 5, result = 8

          f(n) = f(n-1) + f(n-2)    for n >= 3
          f(2) = 2
          f(1) = 1

     */
    private static int domino(int n) {
        int result;
        if (n <= 1)
            result = 1;
        else
            result = domino(n - 1) + domino(n - 2);
        return result;
    }
}
