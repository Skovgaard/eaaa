package ex2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Ex2Test {

    private Ex2 ex2;

    @Before
    public void setUp() {
        ex2 = new Ex2();
    }

    @Test
    public void testTotalPayment() {
        //TC:1
        int small = 0;
        int big = 0;
        assertEquals(0, ex2.totalPayment(small, big));

        //TC:2
        small = 1;
        big = 0;
        assertEquals(2000, ex2.totalPayment(small, big));

        //TC:3
        small = 0;
        big = 1;
        assertEquals(1000, ex2.totalPayment(small, big));

        //TC:4
        small = 1;
        big = 1;
        assertEquals(2750, ex2.totalPayment(small, big));

        //TC:5
        small = 2;
        big = 1;
        assertEquals(4250, ex2.totalPayment(small, big));

        //TC:6
        small = 1;
        big = 2;
        assertEquals(3500, ex2.totalPayment(small, big));

        //TC:7
        small = 2;
        big = 2;
        assertEquals(4500, ex2.totalPayment(small, big));

        //TC:8
        small = 3;
        big = 2;
        assertEquals(5500, ex2.totalPayment(small, big));

        //TC:9
        small = 2;
        big = 3;
        assertEquals(4500, ex2.totalPayment(small, big));

        //TC:10
        small = 3;
        big = 3;
        assertEquals(5500, ex2.totalPayment(small, big));
    }

}
