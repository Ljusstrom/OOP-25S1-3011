import java.util.function.Supplier;


/**
 * Calculator class that supports addition, subtraction, multiplication and division.
 */
public class Calculator {
    private int result;

    /**
     * Internal function that checks for Integer overflow.
     *
     * @param oper Operation that is being checked whether it produces and exception.
     * @throws IntegerOverflowException
     */
    private void checkForOverflow(Supplier<Long> oper) throws IntegerOverflowException {
        if (oper.get() > Integer.MAX_VALUE ||
            oper.get() < Integer.MIN_VALUE) throw new IntegerOverflowException("Integer would've overflowed.");
    }

    public void clear() {
        result = 0;
    }
    public void add(int n) {
        checkForOverflow(() -> (long)result + n);
        result += n;
    }
    public void sub(int n) {
        checkForOverflow(() -> (long)result - n);
        result -= n;
    }
    public void mul(int n) {
        checkForOverflow(() -> (long)result * n);
        result *= n;
    }
    public void div(int n) {
        if (n == 0) {
            System.out.println("Cannot divide by zero.");
            return;
        }
        result /= n;
    }
    public int giveResult() {
        return result;
    }
}