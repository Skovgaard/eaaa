import java.util.ArrayList;

public class Exercises {

    public static void main(String[] argd) {

        //ex0
        System.out.println("Ex0:");
        int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(evenNumbers(list));

        //ex1
        System.out.println("\nex1:");
        System.out.println(binomial(6, 1));
        System.out.println(binomial(6, 2));
        System.out.println(binomial(6, 3));

        //ex2
        System.out.println("\nEx2:");
        System.out.println(isPalindrome("TestNoteKode.test"));
        System.out.println(isPalindrome("otto"));
        System.out.println(isPalindrome("oadw"));

        //ex3
        System.out.println("\nEx3:");
        System.out.println(calcNo(3));
        System.out.println(calcNo(4));
        System.out.println(calcNo(5));
        System.out.println(calcNo(6));

        //ex4
        System.out.println("\nEx4:");
        printAnagrams("cat");
        System.out.println();
        printAnagrams("", "cat");

        //ex5
        System.out.println("\nEx5:");
        int disks = 4;
        printMovesNeeded(disks);
        move(disks, 1, 3);

    }

    //ex0
    public static int evenNumbers(int[] list) {
        return evenNumbers(list, 0);
    }

    public static int evenNumbers(int[] list, int index) {
        if (list.length - 1 == index)
            return list[index] % 2 == 0 ? 1 : 0;
        else
            return (list[index] % 2 == 0 ? 1 : 0) + evenNumbers(list, index + 1);
    }

    //ex1
    public static int binomial(int n, int m) {
        if (m == 0 || n == m)
            return 1;
        else
            return binomial(n - 1, m) + binomial(n - 1, m - 1);
    }

    //ex2
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1)
            return true;
        else
            return s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1, s.length() - 1));
    }

    //ex3
    //Returns the n’th number in the sequence defined above.
    // Requires: n >= 0
    //3.2
    public static int calcNo(int n) {

        if (n == 0)
            return 2;
        else if (n == 1)
            return 1;
        else if (n == 2)
            return 5;
        else if (n > 2 && n % 2 == 0)
            return 2 * calcNo(n - 3) - calcNo(n - 1);
        else
            return calcNo(n - 1) + calcNo(n - 2) + 3 * calcNo(n - 3);

    }

    //3.3
    public static int calcNoIterative(int n) {

        //husk max 3 tal og opdater løbende

        return 0;
    }

    //ex4
    public static void printAnagrams(String prefix, String word) {
        if (word.length() <= 1)
            System.out.println(prefix + word);
        else {
            for (int i = 0; i < word.length(); i++) {
                String p = prefix + word.charAt(i);
                String s = word.substring(0, i) + word.substring(i + 1);
                printAnagrams(p, s);
            }
        }
    }

    public static void printAnagrams(String word) {
        for (String s : permutations(word)) {
            System.out.println(s);
        }
    }

    //Er i bogen, 13.4
    private static ArrayList<String> permutations(String word) {
        ArrayList<String> result = new ArrayList<>();

        // The empty string has a single permutation: itself
        if (word.length() == 0) {
            result.add(word);
            return result;
        } else {
            // Loop through all character positions
            for (int i = 0; i < word.length(); i++) {
                // Form a shorter word by removing the ith character
                String shorter = word.substring(0, i) + word.substring(i + 1);

                // Generate all permutations of the simpler word
                ArrayList<String> shorterPermutations = permutations(shorter);

                // Add the removed character to the front of
                // each permutation of the simpler word
                for (String s : shorterPermutations) {
                    result.add(word.charAt(i) + s);
                }
            }
            // Return all permutations
            return result;
        }
    }

    public static void printMovesNeeded(int disks) {
        System.out.printf("%s%.0f%n", "Moves needed: ", (Math.pow(2, disks) - 1));
    }


    public static void move(int disks, int from, int to) {
        int other = 6 - from - to;
        if (disks == 1) {
            System.out.println("Move: " + from + " -> " + to);
        } else {
            move(disks - 1, from, other);
            System.out.println("Move: " + from + " -> " + to);
            move(disks - 1, other, to);
        }
    }
}
