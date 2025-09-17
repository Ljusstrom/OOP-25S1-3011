import java.util.Scanner;

public class Main {
    private static String askValue(Scanner scanner) {
        System.out.print("Give a temperature (x to exit)? ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        Estimator estimator = new Estimator();
        Scanner   scanner   = new Scanner(System.in);
        String s;

        s = askValue(scanner);
        while (!s.equals("x")) {
            estimator.storeMeasurement(Double.valueOf(s), System.currentTimeMillis());
            s = askValue(scanner);
        }

        System.out.printf("Trend is %.1f C/h\n", estimator.getTrend(5));
    }
}