package ex1;

import java.time.LocalDate;

public class Ex1 {

    /*
    Returns the amount of the fine according to the table above.
    Pre: calculatedDate and actualDate contains valid dates and
         calculatedDate < actualDate
         (calculatedDate is the expected return-date and
          actualDate is the day you actually return the book;
          adult is true if the borrower is an adult, false else)
     */
    public int calculateFine(LocalDate calculatedDate, LocalDate actualDate, boolean adult) {
        int daysLate = calculatedDate.until(actualDate).getDays();
        if (daysLate >= 15 || calculatedDate.until(actualDate).getMonths() > 0)
            return adult ? 90 : 45;
        else if (daysLate >= 8)
            return adult ? 60 : 30;
        else if (daysLate >= 1)
            return adult ? 20 : 10;
        else return 0;
    }

}
