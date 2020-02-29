package ex3student;

public class NumberEvaluator implements Evaluator {
    /**
     * Returns true, if s contains valid integer or decimal number.
     */
    @Override
    public boolean isValid(String s) {
        // Metode 1 med at prøve ved at parse til typer:
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

        // Metode 2 med regex (ikke færdig, mangler at tjekke for en del 0. og E, osv):
//        return s.matches("[+-.]?\\d+(\\.\\d+)?");

    }
}
