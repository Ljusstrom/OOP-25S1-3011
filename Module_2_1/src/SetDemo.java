import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class SetDemo {
    private int something = 0;
    private Person p0 = new Person("name", 12);

    public SetDemo() {
        something = 0;
    }

    public static void main(String[] args) {
        // Creating a TreeSet of Strings
        TreeSet<String> treeSetStr = new TreeSet<>();

        // Adding elements
        treeSetStr.add("Volvo");
        treeSetStr.add("BMW");
        treeSetStr.add("Ford");
        treeSetStr.add("BMW");
        treeSetStr.add("Mazda");

        // Printing the sorted elements
        System.out.println("Sorted Set: " + treeSetStr);
        for (String car : treeSetStr) {
            System.out.println(car);
        }

        // Creating a HashSet of Strings
        HashSet<String> hashSetStr = new HashSet<>();

        // Adding elements
        hashSetStr.add("Volvo");
        hashSetStr.add("BMW");
        hashSetStr.add("Ford");
        hashSetStr.add("BMW");
        hashSetStr.add("Mazda");

        // Printing unsorted elements
        System.out.println("Unsorted Set: " + hashSetStr);
        for (String car : hashSetStr) {
            System.out.println(car);
        }
    }
}