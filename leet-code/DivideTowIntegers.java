/**
 * DivideTowIntegers
 */
public class DivideTowIntegers {

    // this is can take a long time with large numbers : so it's a bad solution
    public static int divideTwoNumers(int dividend, int divisor) {

        int sign = ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) ? -1 : 1;

        dividend = dividend < 0 ? dividend * -1 : dividend;
        divisor = divisor < 0 ? divisor * -1 : divisor;

        int sum = 0;
        int counter = 0;

        while (sum < dividend) {
            sum += divisor;
            // System.out.println(sum);
            if (sum > dividend) {
                return counter;
            }

            counter++;

        }

        return sign * counter;

    }

    //

    public static int divideTwoNumbers2(int dividend, int divisor) {

        int sign = dividend < 0 ^ divisor < 0 ? -1 : 1;

        int quotient = 0;
        int subQuot = 0;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while (dividend - divisor >= 0) {

            for (subQuot = 0; dividend - (divisor << subQuot << 1) >= 0; subQuot++)
                ;

            quotient += 1 << subQuot;
            dividend -= divisor << subQuot; // => divisor * 2^subQuotient

        }
        return sign * quotient;
    }

    public static void main(String[] args) {

        System.out.println("result:" + divideTwoNumbers2(555, -1));

    }
}