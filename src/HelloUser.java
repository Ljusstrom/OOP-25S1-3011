import java.util.Scanner;

public class HelloUser {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = reader.nextLine();

        System.out.print("How old are you? ");
        int age = Integer.parseInt(reader.nextLine());
        //age+=2;

        System.out.println("Hello " + name + ", you are " + age + " years old!");
        System.out.println(age);

        double f = 1.23;
        f++; // Why are we incrementing!
        System.out.println("Floating point: " + f);
    }
}