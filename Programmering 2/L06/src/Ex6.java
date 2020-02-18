import java.io.FileReader;
import java.util.*;

public class Ex6 {

    public static void main(String[] args) {

        //ex6
        System.out.println("Ex6:");
        String path = "L06/res/movieRatings.txt";
        readFileWithMovieRatings(path);

    }

    private static void readFileWithMovieRatings(String path) {
        Map<String, List<Integer>> map = new LinkedHashMap<>();

        try (FileReader fileReader = new FileReader(path); Scanner scanner = new Scanner(fileReader)) {

            //skip first line
            scanner.nextLine();
//            int ratings = Integer.valueOf(scanner.nextLine());

            while (scanner.hasNextLine()) {
                String name = scanner.nextLine();
                int rating = Integer.valueOf(scanner.nextLine());
                if (!map.containsKey(name)) {
                    List<Integer> list = new LinkedList<>();
                    list.add(rating);
                    map.put(name, list);
                } else
                    map.get(name).add(rating);
            }

            printRatings(map);

        } catch (Exception e) {
            System.out.println("File not found or error reading");
        }
    }

    private static void printRatings(Map<String, List<Integer>> map) {
        for (String s : map.keySet()) {
            double avg = averageFromIntList(map.get(s));
            System.out.printf("%-30s %d %-11s gennemsnit %.1f%n", s + ":", map.get(s).size(), map.get(s).size() > 1 ? "karakterer," : "karakter,", avg);
        }
    }

    private static double averageFromIntList(List<Integer> list) {
        double sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum / list.size();
    }

}
