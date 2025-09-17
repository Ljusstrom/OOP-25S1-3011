public class Point {
    private int x, y, z;

    public Point() {
        x = 0;
        y = 0;
        z = 0;
    }

    public Point(int cx, int cy, int cz) {
        x = cx;
        y = cy;
        z = cz;
    }

    private static double sqrt(double a) {
        double x = a / 2;                       // Initial quess for the square root
        double eps = 4 * Math.ulp(a);           // Check the accuracy of number representation

        while (Math.abs(x * x - a) >= eps) {    // Iterative algorithm until we have enough accuracy
            x = (a / x + x) / 2;                  // Improve the estimate x for the square root
        }

        return (x);
    }

    public double distance(Point p) {
        return (sqrt((x-p.x)*(x-p.x) + (y-p.y)*(y-p.y) + (z-p.z)*(z-p.z)));
    }

    public void setX(int cx) { x = cx; }
    public int getX() { return x; }
    public void setY(int cy) { y = cy; }
    public int getY() { return y; }
    public void setZ(int cz) { z = cz; }
    public int getZ() { return z; }
}