import java.util.function.Consumer;

public class ClosureDemo {
    public static void main(String[] args) {
        int externalValue = 10;

        // Creating a closure using a lambda expression
        Consumer<Integer> closure = (x) -> {
            int result = x + externalValue; // Accessing externalValue from the enclosing scope
            System.out.println("Result: " + result);
        };

        // Calling the closure
        closure.accept(5); // Prints: Result: 15

        // Modifying externalValue will not affect the closure
        //externalValue = 20; // Uncommenting this line will cause a compilation error
    }
}