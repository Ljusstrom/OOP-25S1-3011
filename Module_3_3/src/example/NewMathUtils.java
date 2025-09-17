package example;

public class NewMathUtils extends MathUtils {
    // @Override - cannot be overriden
    public static int add(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        MathUtils m = new MathUtils();
        int result = m.add(5, 3); // Calling static method directly using class name
        System.out.println("Result: " + result);

        MathUtils n = new NewMathUtils();
        result = n.add(5, 3); // Calling through example.MathUtils calls example.MathUtils.add()
        System.out.println("Result: " + result);
    }
}
