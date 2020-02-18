import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Exercises {

    public static void main(String[] args) {

        //ex1
        System.out.println("ex1:");
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("List:" + list);
        System.out.println("Total of all elements in list: " + totalRecursive(list));
        list.add(5);
        System.out.println("List:" + list);
        System.out.println("Total of all elements in list: " + totalRecursive(list));

        //ex2
        System.out.println("\nEx2:");
        list.add(0);
        list.add(0);
        System.out.println("List:" + list);
        int number = 0;
        System.out.println("Total count of " + number + " in list: " + countNumber(list, number));

        //ex3
        System.out.println("\nEx3:");
        list.clear();
        list.addAll(Arrays.asList(8, 56, 45, 34, 15, 12, 34, 44));
        System.out.printf("%-18s%s%n", "List:", list);
        mergesort(list);
        System.out.printf("%-18s%s%n", "Mergesorted list:", list);

        //ex4
        System.out.println("\nEx4:");
        Collections.shuffle(list);
        System.out.printf("%-18s%s%n", "List:", list);
        quicksort(list);
        System.out.printf("%-18s%s%n", "Quicksorted list:", list);


        System.out.println("\nEx4a:");
        System.out.printf("              [13, 7, 48, 17, 24, 8, 5, 33]%n");
        System.out.printf("       [13, 7, 48, 17]             [24, 8, 5, 33]%n");
        System.out.printf("     [7, 13]       [17, 48]    [8, 24 ]       [5, 33]%n");
        System.out.printf("       [7, 13, 17, 48]            [5, 8, 24, 33]%n");
        System.out.printf("            [5, 7, 8, 13, 17, 24, 33, 48]%n");

        System.out.println("\nEx4b:");
        System.out.printf("                    [13, 7, 48, 17, 24, 8, 5, 33]%n");
        System.out.printf("                [8, 7, 5]     [13]     [33, 24, 17, 48]%n");
        System.out.printf("         [5, 7]     [8]     [13]    [17, 24]    [33]    [48]%n");
        System.out.printf("    [5]    [7]     [8]     [13]    [17]     [24]    [33]    [48]%n");
    }

    //ex1
    public static int totalRecursive(ArrayList<Integer> list) {
        return totalRecursive(list, 0, list.size() - 1);
    }


    private static int totalRecursive(ArrayList<Integer> list, int l, int h) {
        if (l == h)
            return list.get(l);
        else {
            int m = (l + h) / 2;
            int t1 = totalRecursive(list, l, m);
            int t2 = totalRecursive(list, m + 1, h);
            return t1 + t2;
        }
    }

    //ex2
    public static int countNumber(ArrayList<Integer> list, int n) {
        return countNumber(list, n, 0, list.size() - 1);
    }

    private static int countNumber(ArrayList<Integer> list, int n, int l, int h) {
        if (l == h)
            return list.get(l) == n ? 1 : 0;
        else {
            int m = (l + h) / 2;
            int c1 = countNumber(list, n, l, m);
            int c2 = countNumber(list, n, m + 1, h);
            return c1 + c2;
        }
    }

    //ex3
    public static void mergesort(ArrayList<Integer> list) {
        mergesort(list, 0, list.size() - 1);
    }

    private static void mergesort(ArrayList<Integer> list, int l, int h) {
        if (l < h) {
            int m = (l + h) / 2;
            mergesort(list, l, m);
            mergesort(list, m + 1, h);
            merge(list, l, m, h);
        }
    }

    private static void merge(ArrayList<Integer> list, int l, int m, int h) {
        ArrayList<Integer> temp = new ArrayList<>();

        int i1 = l;
        int i2 = m + 1;

        while (i1 <= m && i2 <= h) {
            if (list.get(i1) < list.get(i2)) {
                temp.add(list.get(i1));
                i1++;
            } else {
                temp.add(list.get(i2));
                i2++;
            }
        }
        while (i1 <= m) {
            temp.add(list.get(i1));
            i1++;
        }
        while (i2 <= h) {
            temp.add(list.get(i2));
            i2++;
        }

        for (int i = 0; i < temp.size(); i++) {
            list.set(l + i, temp.get(i));
        }

    }

    //ex 4 (quicksort)
    public static void quicksort(ArrayList<Integer> list) {
        quicksort(list, 0, list.size() - 1);
    }


    private static void quicksort(ArrayList<Integer> list, int low, int high) {
        if (low < high) {
            int p = partition(list, low, high);
            quicksort(list, low, p - 1);
            quicksort(list, p + 1, high);
        }
    }

    private static int partition(ArrayList<Integer> list, int low, int high) {
        int e = list.get(low);
        int i = low + 1;
        int j = high;
        while (i <= j) {
            if (list.get(i) <= e) {
                i++;
            } else if (list.get(j) > e) {
                j--;
            } else {
                swap(list, i, j);
                i++;
                j--;
            }
        }
        swap(list, low, j);
        return j;
    }

    private static void swap(ArrayList<Integer> list, int k, int l) {
        Integer e = list.get(k);
        list.set(k, list.get(l));
        list.set(l, e);
    }

}
