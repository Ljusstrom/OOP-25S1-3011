import java.util.Scanner;

public class DivideByTwo  {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int intValue = Integer.parseInt(scanner.nextLine());

        System.out.println("The result is " + (double)intValue / 2);

        final String xSTring = "ssdf";

        scanner.close();
    }
}