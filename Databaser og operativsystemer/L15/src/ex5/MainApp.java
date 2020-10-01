package ex5;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MainApp {

    public static void main(String[] args) {

        int[] array1 = {1, 2, 3};
        int[] array2 = {5, 4, 1};
        int[] array3 = {6, 4, 3};
        int[] array4 = {8, 6, 4};
        int[] array5 = {9, 6, 3};

        new ArraySortThread(array1).start();
        new ArraySortThread(array2).start();
        new ArraySortThread(array3).start();
        new ArraySortThread(array4).start();
        new ArraySortThread(array5).start();

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));

        int[] mergedArray = ArrayMergeThread.mergeAll(array1, array2, array3, array4, array5);

        System.out.println(Arrays.toString(mergedArray));

//        Arrays.sort(mergedArray);
//        System.out.println(Arrays.toString(mergedArray));


    }

    private static class ArraySortThread extends Thread {

        private int[] array;

        public ArraySortThread(int[] array) {
            this.array = array;
        }

        public void run() {
            Arrays.sort(array);
        }

    }

    private static class ArrayMergeThread extends Thread {

        public static int[] mergeAll(int[]... elements) {

            int[] mergedArray = new int[0];

            for (int[] element : elements) {
                mergedArray = IntStream.concat(Arrays.stream(mergedArray), Arrays.stream(element))
                        .toArray();
            }
            Arrays.sort(mergedArray);
            return mergedArray;
        }

    }

}
