import java.util.Arrays;

public class ex5 {

    public static void main(String[] args) {

        System.out.println("Ex5:");
        char[] input = {'W', 'R', 'G', 'W', 'W', 'R', 'G', 'R', 'W', 'W', 'R', 'G', 'W'};
        System.out.println("Input: " + Arrays.toString(input));
        order(input);
        System.out.println("Output: " + Arrays.toString(input));
        System.out.println("Time complextity: O(n)");
    }

    // O(n) - Lav med while loop for at undgå while inde i for - stadig O(n)
    public static void order(char[] letters) {
        int firstIndex = 0;
        int lastIndex = letters.length - 1;
        for (int i = 0; i < lastIndex; i++) {
            if (letters[i] == 'R') {
                while (letters[lastIndex] == 'R')
                    lastIndex--;
                char temp = letters[i];
                letters[i] = letters[lastIndex];
                letters[lastIndex] = temp;
                lastIndex--;
            }
            if (letters[i] == 'G') {
                char temp = letters[i];
                letters[i] = letters[firstIndex];
                letters[firstIndex] = temp;
                firstIndex++;
            }
        }
    }

    // O(n^2)
    public static void order1(char[] letters) {
        int gCount = 0;
        int wCount = 0;
        for (char letter : letters) {
            if (letter == 'G')
                gCount++;
            else if (letter == 'W')
                wCount++;
        }
        for (int i = 0; i < letters.length; i++) {
            if (i < gCount)
                letters[i] = 'G';
            else if (i < gCount + wCount)
                letters[i] = 'W';
            else
                letters[i] = 'R';
        }
    }
}
