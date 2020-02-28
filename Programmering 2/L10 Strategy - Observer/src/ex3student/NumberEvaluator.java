package ex3student;

public class NumberEvaluator implements Evaluator {
    /**
     * Returns true, if s contains valid integer or decimal number.
     */
    @Override
    public boolean isValid(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ignored) {

        }
        try {
            Double.parseDouble(s);
            char c = s.toLowerCase().charAt(s.length() - 1);
            return c != 'd' && c != 'f';
        } catch (NumberFormatException ignored) {

        }
        return false;
    }
}
