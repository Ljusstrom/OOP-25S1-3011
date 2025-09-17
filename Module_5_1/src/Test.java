public class Test {
    public static void main(String[] args) {
        int x = 12;
        doSomething();
        System.out.println("The End");
    }

    public static void doSomething() {
        int a = 23; // load contents of 'a' to register EAX
        int x = 2;  // load contents of 'x' to register EBX
        int c = a + x; // ADD EAX, EBX
    }
}
