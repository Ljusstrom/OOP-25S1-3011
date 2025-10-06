import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ImperativeDemo {
    public static void main(String[] args) {
        List<Integer> numbers
                = Arrays.asList(11, 22, 33, 44,
                55, 66, 77, 88,
                99, 100);

        // Imperative way:
        int largest = Integer.MIN_VALUE;
        for (Integer n : numbers) {
            if (n % 2 != 0) {   // Filtering
                int temp = n/2; // mapping

                if (temp > largest)
                    largest = temp;
            }
        }
        System.out.println(largest);

        // Functional way:
        int value = numbers.stream()
                .filter(x -> x%2!=0)
                .map(x -> x/2)
                .max(Integer::compare).orElse(0);
        System.out.println(value);
    }
}