import java.util.Scanner;

class CalculatorApp {

    public static void main(String []arg) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first number ");
        int num1 = scanner.nextInt();

        System.out.println("Enter your second number ");
        int num2 = scanner.nextInt();

        System.out.println("select operation (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        int result =0;

        switch (operator) {
            case '+':
                result = calculator.divide(num1, num2);
                break;
            case '-':
                result = calculator.subtract(num1, num2);
                break;
            case '*':
                result = calculator.multiply(num1, num2);
                break;
            case '/':
                result = calculator.divide(num1, num2);
                break;
            default:
                System.out.println("invalid operator");
                return;
        }
        System.out.println("results " + result);
        scanner.close();
        
    }
}
public class  Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide (int a, int b) {
        if(b == 0){
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a/b;
    }
}
