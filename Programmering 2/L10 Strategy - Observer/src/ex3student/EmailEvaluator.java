package ex3student;

import java.util.Arrays;

public class EmailEvaluator implements Evaluator {
    /**
     * Returns true, if s contains a valid email address.
     */
    @Override
    public boolean isValid(String s) {
        if (!s.contains("@") || s.charAt(0) == '.' || s.charAt(s.length() - 1) == '.') return false;
        String[] subs = s.replaceFirst("@", ".").split("[.]");
        System.out.println(Arrays.toString(subs));
        for (String ss : subs) {
            if (!isWord(ss)) return false;
        }
        return true;
    }

    /**
     * Returns true, if s is an acceptable word.
     * That is, s is not empty, and
     * all letters are in 'A'..'Z', 'a'..'z' or '0'..'9'.
     */
    public boolean isWord(String s) {
        return !s.isEmpty() && s.matches("[\\w]+");
    }
}
