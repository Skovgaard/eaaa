package ex2;

public class Ex2 {

    private static final int SMALL_PRICE = 2000;
    private static final int BIG_PRICE = 1000;

    //For use in totalPaymentCompact
    private static final int SP = 2000;
    private static final int BP = 1000;

    /*
     * Returns the total payment for a family minus discount
     * Pre: small >= 0, big >= 0
     * (small is the number of pre-school children
     * and big is the number of children attending school) */
    public int totalPayment(int small, int big) {
        if (small + big > 3) {
            int sum = 0;
            if (small > 0 && big < 3) {
                sum += SMALL_PRICE;
                small--;
            } else {
                sum += BIG_PRICE;
                big--;
            }
            for (int i = 0; i < 2; i++) {
                if (big > 0) {
                    sum += BIG_PRICE * 0.75;
                    big--;
                } else {
                    sum += SMALL_PRICE * 0.75;
                    small--;
                }
            }
            return (int) (sum + (big * BIG_PRICE * 0.5) + (small * SMALL_PRICE * 0.5));
        } else if (small + big > 1) {
            int sum = 0;
            if (small > 0) {
                sum += SMALL_PRICE;
                small--;
            } else {
                sum += BIG_PRICE;
                big--;
            }
            return (int) (sum + (big * BIG_PRICE * 0.75) + (small * SMALL_PRICE * 0.75));
        } else if (small + big == 1) {
            return small > big ? SMALL_PRICE : BIG_PRICE;
        } else
            return 0;
    }

    //Compact
    public int totalPaymentCompact(int s, int b) {
        if (s + b <= 1) return s + b == 1 ? s > b ? SP : BP : 0;
        else if (s + b < 4)
            return (int) (b > 0 ? (BP * 0.75) + totalPaymentCompact(s, --b) : (SP * 0.75) + totalPaymentCompact(--s, b));
        else return (int) (s > 0 ? (SP * 0.5) + totalPaymentCompact(--s, b) : (BP * 0.5) + totalPaymentCompact(s, --b));
    }

    /*
    // @formatter:off
    //Minifier
    public int totalPaymentMinified(int s, int b) {
        if(s+b<=1)return s+b==1?s>b?SP:BP:0;else if(s+b<4)return(int)(b>0?(BP*0.75)+ totalPaymentCompact(s,--b):(SP*0.75)+ totalPaymentCompact(--s,b));else return(int)(s>0?(SP*0.5)+ totalPaymentCompact(--s,b):(BP*0.5)+ totalPaymentCompact(s,--b));
    }
    // @formatter:on
     */
}
