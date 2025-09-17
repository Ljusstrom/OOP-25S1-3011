import java.util.Scanner;

public class SumOfSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double firstNumber = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter second number: ");
        double secondNumber = Double.parseDouble(scanner.nextLine());

        double sumOfSquares = Math.pow(firstNumber, 2) + Math.pow(secondNumber, 2);

        System.out.println("\n");
        System.out.printf("The first number is:   %6.2f\n", firstNumber);
        System.out.printf("The second number is:  %6.2f\n", secondNumber);
        System.out.printf("The sum of squares is: %6.2f\n", sumOfSquares);

        scanner.close();
    }
}