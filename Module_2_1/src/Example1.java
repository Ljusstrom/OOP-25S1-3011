public class Example1 {
    /* Sqrt() calculation using Newton-Raphson method to demonstrate the while-loop
     * See https://en.wikipedia.org/wiki/Newton%27s_method or https://math.mit.edu/~stevenj/18.335/newton-sqrt.pdf
     */


    public static void main(String[] args) {
        Point p0 = new Point();
        Point p1 = new Point(11, 12, 13);
        Point p2 = new Point(23, 24, 25);

        System.out.println("The distance between points is " + p1.distance(p2));
        System.out.println("The distance between point 1 and origin is " + p1.distance(p0));
    }
}