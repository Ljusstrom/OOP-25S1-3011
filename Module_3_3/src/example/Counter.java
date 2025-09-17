package example;

public class Counter {
    private static int count = 0; // static variable

    public Counter() {
        count++; // Increment count each time a new instance is created
    }

    public static void main(String[] args) {
        System.out.println("Count: " + Counter.count);

        Counter c1 = new Counter();
        System.out.println("Count: " + Counter.count); // Accessing static variable using class name

        Counter c2 = new Counter();
        System.out.println("Count: " + Counter.count);

        task1.TestClass.testMethod();
    }
}