package ex2;

public class Ex2 {

    private static final int SMALLPRICE = 2000;
    private static final int BIGPRICE = 1000;

    /*
     * Returns the total payment for a family minus discount
     * Pre: small >= 0, big >= 0
     * (small is the number of pre-school children
     * and big is the number of children attending school) */
    public int totalPayment(int small, int big) {
        if (small + big > 3) {
            int sum = 0;
            if (small > 0 && big < 3) {
                sum += SMALLPRICE;
                small--;
            } else {
                sum += BIGPRICE;
                big--;
            }
            for (int i = 0; i < 2; i++) {
                if (big > 0) {
                    sum += BIGPRICE * 0.75;
                    big--;
                } else {
                    sum += SMALLPRICE * 0.75;
                    small--;
                }
            }
            return (int) (sum + (big * BIGPRICE * 0.5) + (small * SMALLPRICE * 0.5));
        } else if (small + big > 1) {
            int sum = 0;
            if (small > 0) {
                sum += SMALLPRICE;
                small--;
            } else {
                sum += BIGPRICE;
                big--;
            }
            return (int) (sum + (big * BIGPRICE * 0.75) + (small * SMALLPRICE * 0.75));
        } else if (small + big == 1) {
            return small > big ? SMALLPRICE : BIGPRICE;
        } else
            return 0;
    }
    /*
    public int totalPayment(int small, int big) {
        int smallPrice = 2000, bigPrice = 1000;
        int totalPrice = 0, totalChildren = 0;
        if (small-- >= 1) {
            totalPrice += smallPrice;
            totalChildren++;
        }
        while (true) {
            float discountMod = 1f;
            if (totalChildren >= 3) discountMod = 0.5f;
            else if (totalChildren >= 1) discountMod = 0.75f;
            if (big-- > 0) {
                totalPrice += (int) (bigPrice * discountMod);
            } else if (small-- > 0) {
                totalPrice += (int) (smallPrice * discountMod);
            } else break;
            totalChildren++;
        }
        return totalPrice;
    }
     */

}
