package ex4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class Exercise4 {

    public static void main(String[] args) {

        //ex4a
        System.out.println("Ex4a:");

        String path = "L04 Java Collections Framework/res/";
        String inputFileName = "Gjoengehoevdingen.txt";
        String outputFileName = "Words.txt";

        readWordsFromFileToTreeSet(path + inputFileName, path + "TreeSet" + outputFileName);

        //ex4b
        System.out.println("\nEx4b:");

        readWordsFromFileToTreeMap(path + inputFileName, path + "TreeMap" + outputFileName);

        //ex4c
        System.out.println("\nEx4c:");

        readWordsFromFileToLinkedHashMap(path + inputFileName, path + "LinkedHashMap" + outputFileName);

    }

    private static void readWordsFromFileToTreeSet(String inputPath, String outputPath) {

        Set<String> set = new TreeSet<>();
        int wordCount = 0;

        try (Scanner scanner = new Scanner(new FileReader(inputPath)); PrintWriter printWriter = new PrintWriter(outputPath)) {
            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("[^\\wæøåÆØÅ]", "").toLowerCase();
                if (!word.isEmpty()) {
                    printWriter.println(word);
                    wordCount++;
                    set.add(word);
                }
            }

            System.out.println("Word list printed in: " + outputPath);
            System.out.println("Word count: " + wordCount);
            System.out.println("Different word count: " + set.size());

        } catch (FileNotFoundException e) {
            System.out.println("File(s) not found");
        }
    }

    private static void readWordsFromFileToTreeMap(String inputPath, String outputPath) {

        Map<String, Integer> map = new TreeMap<>();

        try (Scanner scanner = new Scanner(new FileReader(inputPath)); PrintWriter printWriter = new PrintWriter(outputPath)) {
            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("[^\\wæøåÆØÅ]", "").toLowerCase();
                if (word.isEmpty())
                    continue;
                if (!map.containsKey(word))
                    map.put(word, 1);
                else
                    map.put(word, map.get(word) + 1);
            }

            int wordCount = 0;

            for (String s : map.keySet()) {
                if (map.get(s) >= 100)
                    printWriter.printf("%-12s %d%n", s, map.get(s));
                wordCount += map.get(s);
            }

            System.out.println("Word list (with count >= 100) printed in: " + outputPath);
            System.out.println("Word count: " + wordCount);
            System.out.println("Different word count: " + map.size());

        } catch (FileNotFoundException e) {
            System.out.println("File(s) not found");
        }
    }

    private static void readWordsFromFileToLinkedHashMap(String inputPath, String outputPath) {

        Map<Integer, Set<String>> map = new LinkedHashMap<>();

        try (Scanner scanner = new Scanner(new FileReader(inputPath)); PrintWriter printWriter = new PrintWriter(outputPath)) {
            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("[^\\wæøåÆØÅ]", "").toLowerCase();
                int hash = word.hashCode();
                if (!map.containsKey(hash)) {
                    Set<String> set = new LinkedHashSet<>();
                    set.add(word);
                    map.put(hash, set);
                } else {
                    map.get(hash).add(word);
                }
            }

            for (Integer hash : map.keySet()) {
                if (map.get(hash).size() > 1)
                    printWriter.printf("%-12d %s%n", hash, map.get(hash));
            }

            System.out.println("Hash code list (with count > 1) printed in: " + outputPath);

        } catch (FileNotFoundException e) {
            System.out.println("File(s) not found");
        }
    }
}
