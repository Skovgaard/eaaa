package ex2;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Ex2: (Check paranthesis)");

        String string1 = "(3+{5{99{*}}[23[{67}67]]})";
        String string2 = "(}){";
        String string3 = "()";
        String string4 = "(()";
        String string5 = ")";

        System.out.printf("%-6b %s%n", ArrayStack.checkParentheses(string1), string1);
        System.out.printf("%-6b %s%n", ArrayStack.checkParentheses(string2), string2);
        System.out.printf("%-6b %s%n", ArrayStack.checkParentheses(string3), string3);
        System.out.printf("%-6b %s%n", ArrayStack.checkParentheses(string4), string4);
        System.out.printf("%-6b %s%n", ArrayStack.checkParentheses(string5), string5);

    }

}
