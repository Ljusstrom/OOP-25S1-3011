import java.util.ArrayList;

public class PersonExample {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();

        persons.add(new Person("Matti", 123));
        persons.add(new Person("Ahmed", 19));

        for (Person person : persons)
            System.out.println(person.getName() + ", age: " + person.getAge());
    }
}
