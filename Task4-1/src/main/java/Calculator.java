import java.util.Scanner;
import java.util.Stack;

public class Calculator extends Arithmetic {

    public static void main(String[] args) {
        System.out.print("Type the expression: ");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(calculate(str));
        in.close();
    }

    /**
     * @param s parsed substring
     * @return true, if substring contains digit
     * @throws NumberFormatException otherwise
     */
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * @param str User's input
     * @return the result of expression
     */
    public static double calculate(String str) {
        String[] input = str.split(" ");

        Stack<Double> stack = new Stack<>();

        for (int i = input.length - 1; i >= 0; i--) {
            double a;
            double b;
            if (isDigit(input[i])) {
                stack.push(Double.parseDouble(input[i]));
            } else {
                switch (input[i]) {
                    case "+" -> {
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(Arithmetic.addition(b, a));
                    }
                    case "-" -> {
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(Arithmetic.subtraction(a, b));
                    }
                    case "*" -> {
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(Arithmetic.multiplication(a, b));
                    }
                    case "/" -> {
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(Arithmetic.division(a, b));
                    }
                    case "log" -> {
                        a = stack.pop();
                        stack.push(Arithmetic.log(a));
                    }
                    case "sqrt" -> {
                        a = stack.pop();
                        stack.push(Arithmetic.sqrt(a));
                    }
                    case "pow" -> {
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(Arithmetic.pow(a, b));
                    }
                    case "fact" -> {
                        a = stack.pop();
                        stack.push(Arithmetic.factorial(a));
                    }
                    case "sin" -> {
                        a = stack.pop();
                        stack.push(Arithmetic.sin(a));
                    }
                    case "cos" -> {
                        a = stack.pop();
                        stack.push(Arithmetic.cos(a));
                    }
                    default -> System.out.println("Error");
                }
            }

        }
        return stack.pop();
    }
}
