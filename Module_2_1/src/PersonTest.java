import java.util.ArrayList;
import java.util.Scanner;

public class PersonTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstname, lastname;
        ArrayList<Person2> persons = new ArrayList<>();

        do {
            System.out.print("Give firstname: ");
            firstname = scanner.nextLine();
            if (firstname.length() > 0) {
                System.out.print("Give lastname: ");
                lastname = scanner.nextLine();
                persons.add(new Person2(firstname, lastname));
            }
        } while (firstname.length() > 0);

        System.out.println("Added " + persons.size() + " persons.");
        persons.add(0, new Person2("Vilhelm", "The First"));
        System.out.print("Give the index of the person searched for 0.." + (persons.size()-1) +": ");
        System.out.println(persons.get(scanner.nextInt()));

        System.out.println("All persons:");
        for (Person2 person : persons)
            System.out.println(person); // calls Person.toString()
    }
}