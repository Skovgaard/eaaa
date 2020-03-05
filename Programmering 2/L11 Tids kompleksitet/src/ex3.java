import java.text.DecimalFormat;
import java.util.Arrays;

public class ex3 {

    public static void main(String[] args) {
        System.out.println("Ex3:");
        int[] input = {5, 10, 5, 6, 4, 9, 8};
        double[] output = prefixAverage(input);
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Output: " + Arrays.toString(output));
    }

    // Solution 1: O(n)
    private static double[] prefixAverage(int[] input) {
        double[] output = new double[input.length];
        double sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            DecimalFormat df = new DecimalFormat("#.###");
            output[i] = Double.parseDouble(df.format(sum / (i + 1)));
        }
        return output;
    }

    // Solution 2: O(n^2)
    private static double[] prefixAverage1(int[] input) {
        double[] output = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            double sum = 0;
            for (int j = 0; j < i + 1; j++) {
                sum += input[j];
            }
            DecimalFormat df = new DecimalFormat("#.###");
            output[i] = Double.parseDouble(df.format(sum / (i + 1)));

        }
        return output;
    }

}
