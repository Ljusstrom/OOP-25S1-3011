import java.util.Arrays;
import java.util.stream.Stream;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Lotto class to generate random lotto numbers and count matching numbers against given lotto vector using functional programming
 */
public class Lotto {
    private int[] numbers;
    private int size;
    private int range;

    public Lotto(int size, int range) {
        this.numbers = new int[size];
        this.size = size;
        this.range = range;
    }

    // generate size random numbers between 1 and range
    public void generateLottoNumbers() {
        numbers = Stream.iterate(1, n -> n + 1)
                .limit(range)
                .sorted((a, b) -> ThreadLocalRandom.current().nextInt(-1, 2))   // randomize the order
                 .distinct()
                .limit(size)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // count matching numbers between the generated numbers and the given numbers
    public int countMatchingNumbers(int[] givenNumbers) {
        return (int) Arrays.stream(numbers)
                .filter(num -> Arrays.stream(givenNumbers).anyMatch(givenNum -> givenNum == num))
                .count();
    }

    // get the numbers from the stream
    public int[] getNumbers() {
        return numbers;
    }
}