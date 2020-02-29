package ex3student;

public class EmailEvaluator implements Evaluator {
    /**
     * Returns true, if s contains a valid email address.
     */
    @Override
    public boolean isValid(String s) {
        // Metode 1 med hjælpe metoden isWord:
//        if (!s.contains("@") || s.charAt(0) == '.' || s.charAt(s.length() - 1) == '.') return false;
//        String[] subs = s.replaceFirst("@", ".").split("[.]");
//        System.out.println(Arrays.toString(subs));
//        for (String ss : subs) {
//            if (!isWord(ss)) return false;
//        }
//        return true;

        // Metode 2 med en regex:
        return s.matches("(\\w+((\\.\\w+)+)?)@(\\w+((\\.\\w+)+)?)");
    }

    /**
     * Returns true, if s is an acceptable word.
     * That is, s is not empty, and
     * all letters are in 'A'..'Z', 'a'..'z' or '0'..'9'.
     */
    public boolean isWord(String s) {
        return !s.isEmpty() && s.matches("\\w+");
    }
}
