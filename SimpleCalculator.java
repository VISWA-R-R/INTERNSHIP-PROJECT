import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get the first number from the user.
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            // Get the arithmetic operator.
            System.out.print("Enter operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            // Get the second number from the user.
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            double result;

            // Perform the selected arithmetic operation.
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    // Prevent division by zero.
                    if (num2 == 0) {
                        throw new ArithmeticException("Cannot divide by zero.");
                    }
                    result = num1 / num2;
                    break;

                default:
                    throw new IllegalArgumentException("Invalid operator.");
            }

            // Display the result clearly.
            System.out.println("\n----- Calculator Result -----");
            System.out.println("Expression: " + num1 + " " + operator + " " + num2);
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            // Handle division-by-zero errors.
            System.out.println("Error: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            // Handle invalid operators.
            System.out.println("Error: " + e.getMessage());

        } catch (java.util.InputMismatchException e) {
            // Handle non-numeric input.
            System.out.println("Error: Please enter valid numbers.");

        } finally {
            // Close the Scanner.
            scanner.close();
        }
    }
}
