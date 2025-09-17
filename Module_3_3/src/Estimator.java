/**
 * Linear regression for a first order equation y = bx + a
 * <p>
 * It needs the Storage class to hold the values the estimation to be done.
 *
 * @author Jarkko Vuori
 * @see    <a href="https://pub.towardsai.net/calculating-simple-linear-regression-and-linear-best-fit-an-in-depth-tutorial-with-math-and-python-804a0cb23660">Linear regression</a>
 */

public class Estimator extends Storage {
    private static final int INMILLIS = 1000;

    /** calculate linear regression of the given temperature channel
     * @param N how many samples are used in regression analysis
     * @return  coefficient b (time scaled to hours)
     */
    public double getTrend(int N) {
        double sumxx = 0, sumyy = 0;
        double sumxy = 0;
        double sumx = 0, sumy = 0;
        double Sxx, Sxy, Syy;
        double a, b;    	                        // regression coefficients y = bx + a
        int    n = 0, i = measurements.size()-1;

        // collect N (or less if there are not enough entries in the buffer) (x,y) values
        long  t = 0;
        while (n < N && n < measurements.size()) {
            double x, y;
            // take the time of the first temperature measurement as a reference
            if (t == 0)
                t = measurements.get(i).measurementTime;

            // calculate the current sample value, time is referenced to the first measurement sample
            y = measurements.get(i).value;
            x = (double)(measurements.get(i).measurementTime - t) / (3600.0 * INMILLIS); // x-scale is 1 C/h

            // then accumulate partial products
            sumx  += x;
            sumy  += y;
            sumxx += x*x;
            sumyy += y*y;
            sumxy += x*y;

            n++; i--;
        }

        // calculate coefficients (bx + a) by the linear regression
        Sxx = sumxx-sumx*sumx/n;
        Sxy = sumxy-sumx*sumy/n;
        b   = Sxy/Sxx;
        a   = (sumy-b*sumx)/n;

        return (b);
    }
}