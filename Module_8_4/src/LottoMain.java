public class LottoMain {
    public static void main(String[] args) {
        // Create a Lotto object with size 7 and range 40
        // The number of combinations is C(40, 7) = 18.643.560
        Lotto lotto = new Lotto(7, 40);

        // Generate random lotto numbers
        lotto.generateLottoNumbers();
        int[] generatedNumbers = lotto.getNumbers();

        // Print the generated numbers
        System.out.println("Generated Lotto Numbers: " + java.util.Arrays.toString(generatedNumbers));

        // Given numbers to compare with
        int[] givenNumbers = {1, 2, 3, 4, 5, 6, 7};

        // Count matching numbers
        int matchingCount = lotto.countMatchingNumbers(givenNumbers);

        // Print the count of matching numbers
        System.out.println("Count of Matching Numbers: " + matchingCount);
    }
}