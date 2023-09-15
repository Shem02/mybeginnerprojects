import java.util.Scanner;

class CalculatorApp {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int num1 = getNumberInput(scanner, "Enter your first number: ");
            int num2 = getNumberInput(scanner, "Enter your second number: ");
            char operator = getOperatorInput(scanner);
            int result = performOperation(num1, num2, operator);
            if (result != Interger.MIN_VALUE) {
                System.out.println("result: " + result);
            }
            scanner.close();
        }
         public static int getNumberInput(Scanner scanner, String message) {
            System.out.println(message);
            return scanner.nextInt();
        }
public static char getOperatorInput(Scanner scanner) {
    System.out.println("select operator (+, -, *, /): ");
    return scanner.next().charAt(0);
}

            public static int performOperation(int num1, int num2, char operator) {
        int result;
    }

        switch (operator)
    private final Object result;

    private final Object num1;

    private final Object num2;

    {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result num1 * num2;
            case '/' -> {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Cannot divide by zero.");
                    return Integer.MIN_VALUE;
                }
            }
            default -> {
                System.out.println("Invalid operator selected.");
                return Integer.MIN_VALUE;
            }
        }
        return result;
    }
}
