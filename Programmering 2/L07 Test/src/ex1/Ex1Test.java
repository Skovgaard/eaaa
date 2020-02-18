package ex1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class Ex1Test {

    private Ex1 ex1;
    private LocalDate calculatedDate;

    @Before
    public void setUp() {
        ex1 = new Ex1();
        calculatedDate = LocalDate.of(2020, 2, 17);
    }

    @Test
    public void testCalculateFine() {
        //TC1
        LocalDate actualDate = calculatedDate.plusDays(1);
        assertEquals(10, ex1.calculateFine(calculatedDate, actualDate, false));

        //TC2
        actualDate = calculatedDate.plusDays(4);
        assertEquals(20, ex1.calculateFine(calculatedDate, actualDate, true));

        //TC3
        actualDate = calculatedDate.plusDays(9);
        assertEquals(60, ex1.calculateFine(calculatedDate, actualDate, true));

        //TC4
        actualDate = calculatedDate.plusDays(16);
        assertEquals(90, ex1.calculateFine(calculatedDate, actualDate, true));

        //TC5
        actualDate = calculatedDate.plusDays(31);
        assertEquals(90, ex1.calculateFine(calculatedDate, actualDate, true));

        //TC6
        actualDate = calculatedDate.plusDays(7);
        assertEquals(10, ex1.calculateFine(calculatedDate, actualDate, false));

        //TC6
        actualDate = calculatedDate.plusDays(8);
        assertEquals(30, ex1.calculateFine(calculatedDate, actualDate, false));

        //TC7
        actualDate = calculatedDate.plusDays(8);
        assertEquals(30, ex1.calculateFine(calculatedDate, actualDate, false));

        //TC8
        actualDate = calculatedDate.plusDays(10);
        assertEquals(30, ex1.calculateFine(calculatedDate, actualDate, false));

        //TC9
        actualDate = calculatedDate.plusDays(14);
        assertEquals(30, ex1.calculateFine(calculatedDate, actualDate, false));

        //TC10
        actualDate = calculatedDate.plusDays(15);
        assertEquals(45, ex1.calculateFine(calculatedDate, actualDate, false));

        //TC11
        actualDate = calculatedDate.plusDays(23);
        assertEquals(45, ex1.calculateFine(calculatedDate, actualDate, false));

        //TC12
        actualDate = calculatedDate.plusDays(30);
        assertEquals(45, ex1.calculateFine(calculatedDate, actualDate, false));

        //TC13
        actualDate = calculatedDate.plusDays(31);
        assertEquals(45, ex1.calculateFine(calculatedDate, actualDate, false));

        //TC14
        actualDate = calculatedDate.plusDays(90);
        assertEquals(45, ex1.calculateFine(calculatedDate, actualDate, false));

        //TC15
        actualDate = calculatedDate.plusDays(0);
        assertEquals(0, ex1.calculateFine(calculatedDate, actualDate, false));

        //TC16
        actualDate = calculatedDate.plusDays(-1);
        assertEquals(0, ex1.calculateFine(calculatedDate, actualDate, false));
    }
}
