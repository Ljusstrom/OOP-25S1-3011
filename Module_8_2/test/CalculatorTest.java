import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator c;

    @BeforeAll
    static void setUpEnvironment() {
        System.out.println("Creating Calculator object.");
        c = new Calculator();
    }

    @BeforeEach
    void setUp() {
        c.clear(); // set up same state for every test
    }

    @Test
    void clear() {
        c.clear();
        assertEquals(0, c.giveResult());
        c.add(12);
        assertEquals(12, c.giveResult());
        c.clear();
        assertEquals(0, c.giveResult());
    }

    @Test
    void add() {
        c.add(3);
        assertEquals(3, c.giveResult());
        c.add(7);
        assertEquals(10, c.giveResult());
        c.add(0);
        assertEquals(10, c.giveResult());
        c.add(-100);
        assertEquals(-90, c.giveResult());
        c.add(100_000_000);
        assertEquals(100_000_000-90, c.giveResult());
        c.add(100_000_000_0);
        assertEquals(100_000_000_0+100_000_000-90, c.giveResult());
    }

    @Test
    void addOverflow() {
        c.add(Integer.MAX_VALUE); // 2147483647
        assertEquals(Integer.MAX_VALUE, c.giveResult());
        // next add() would overflow the integer
        assertThrows(IntegerOverflowException.class, () -> c.add(1));
    }

    @Test
    void addOverflowUnder() {
        c.add(Integer.MIN_VALUE); // -2147483648
        assertEquals(Integer.MIN_VALUE, c.giveResult());
        // next add() would overflow the integer
        assertThrows(IntegerOverflowException.class, () -> c.add(-1));
    }

    @Test
    void sub() {
        c.sub(2);
        assertEquals(-2, c.giveResult());
        c.sub(2);
        assertEquals(-4, c.giveResult());
        c.sub(0);
        assertEquals(-4, c.giveResult());
        c.sub(-4);
        assertEquals(0, c.giveResult());
        c.sub(-100);
        assertEquals(100, c.giveResult());
    }

    @Test
    void subOverflowUnder() {
        c.sub(Integer.MAX_VALUE); // 2147483647
        assertEquals(Integer.MIN_VALUE+1, c.giveResult());
        // next sub() would overflow the integer
        assertThrows(IntegerOverflowException.class, () -> c.sub(2));
    }

    @Test
    void subOverflow() {
        // sub() would overflow the integer
        assertThrows(IntegerOverflowException.class, () -> c.sub(Integer.MIN_VALUE));
    }

    @Test
    void mul() {
        c.mul(2);
        assertEquals(0, c.giveResult());
        c.add(1);
        c.mul(2);
        assertEquals(2, c.giveResult());
        c.mul(-10);
        assertEquals(-20, c.giveResult());
        c.mul(0);
        assertEquals(0, c.giveResult());
    }

    @Test
    void mulOverflowUnder() {
        c.add(1);
        c.mul(Integer.MAX_VALUE); // 2147483647
        // next mul() would overflow the integer
        assertThrows(IntegerOverflowException.class, () -> c.mul(2));
    }

    @Test
    void mulOverflow() {
        c.add(1);
        c.mul(Integer.MIN_VALUE); // -2147483648
        // next mul() would overflow the integer
        assertThrows(IntegerOverflowException.class, () -> c.mul(2));
    }

    @Test
    void div() {
        c.add(100);
        c.div(2);
        assertEquals(50, c.giveResult());
        c.div(0);
        assertEquals(50, c.giveResult());
    }

    @Test
    void testGiveResult() {
        assertEquals(0, c.giveResult());
        c.add(123);
        assertEquals(123, c.giveResult());
    }
}