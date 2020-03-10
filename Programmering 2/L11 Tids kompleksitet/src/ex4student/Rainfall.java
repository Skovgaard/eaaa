package ex4student;

public class Rainfall {

    public static void main(String[] args) {

        System.out.println("Ex4:");
        System.out.println("minRainfall3: " + minRainfall3());
        System.out.println("Time complexity = O(n)");
        System.out.println();
        System.out.println("minRainfallN (with n = 5): " + minRainfallN(5));
        System.out.println("Time complexity = O(n)");
        System.out.println();
        System.out.println("sameRainfall: " + sameRainfall());
        System.out.println("Time complexity = O(n)"); // Kan laves O(n)
    }

    private static int[] weekly = {
            20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13, 15, 10,
            9, 6, 8, 12, 22, 14, 16, 16, 18, 23, 12, 0, 2,
            0, 0, 18, 0, 0, 0, 34, 12, 34, 23, 23, 12, 44,
            23, 12, 34, 22, 22, 22, 22, 18, 19, 21, 32, 24, 13};

    /**
     * Returns the week number of the week that starts
     * a period of 3 weeks with the least rainfall.
     */
    public static int minRainfall3() {
        int week = 0;
        int min = weekly[0] + weekly[1] + weekly[2];
        for (int i = 1; i <= weekly.length - 3; i++) {
            int period = weekly[i] + weekly[i + 1] + weekly[i + 2];
            if (period < min) {
                min = period;
                week = i + 1;
            }
        }
        return week;
    }

    /**
     * Returns the week number of the week that starts
     * a period of n weeks with the least rainfall.
     * Requires: 0 < n < 52.
     */
    public static int minRainfallN(int n) {
        int week = 0;
        int rainfall = 0;
        int currentRainfall = 0;
        for (int i = 1; i <= weekly.length - n; i++) {
            if (i < n)
                rainfall += weekly[i];
            if (i > 0) {
                currentRainfall = currentRainfall - weekly[i - 1] + weekly[i + n - 1];
                if (currentRainfall < rainfall) {
                    rainfall = currentRainfall;
                    week = i + 1;
                }
            }
        }
        return week;
    }

    // Same but with O(n^2)
    public static int minRainfallNn2(int n) {
        int week = -1;
        int min = 0;
        for (int i = 0; i <= weekly.length - n; i++) {
            int period = 0;
            for (int j = 0; j < n; j++) {
                period += weekly[i + j];
            }
            if (period < min || week == -1) {
                min = period;
                week = i + 1;
            }
        }
        return week;
    }

    /**
     * Returns the week number of the week that starts
     * the longest period, where the rainfall has been exactly the same.
     */
    public static int sameRainfall() {
        int week = 0;
        int weeks = 1;

        int count = 1;
        int currentRainfall = weekly[0];
        int currentStart = 0;

        for (int i = 1; i < weekly.length - weeks; i++) {
            if (weekly[i] == currentRainfall) {
                count++;
            } else {
                currentStart = i;
                currentRainfall = weekly[i];
                count = 1;
            }
            if (count > weeks) {
                week = currentStart;
                weeks = count;
            }
        }
        return week;
    }

    // Same but with O(n^2)
    public static int sameRainfalln2() {
        int week = 0;
        int weeks = 0;
        for (int i = 0; i < weekly.length - weeks; i++) {
            int count = 1;
            for (int j = 1; j < weekly.length - i; j++) {
                if (weekly[i + j] == weekly[i]) {
                    count++;
                } else
                    break;
            }
            if (count > weeks) {
                week = i;
                weeks = count;
            }
        }
        return week;
    }
}
