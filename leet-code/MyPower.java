public class MyPower {

    // public static double myPow(double x, int n) {

    // if (n == 0)
    // return 1;
    // if (n < 0)
    // return 1 / myPow(x, -n);
    // if (n % 2 == 0)
    // return myPow(x * x, (Math.abs(n)) / 2);
    // else
    // return x * myPow(x * x, (Math.abs(n) - 1) / 2);
    // }

    public static double myPow2(double x, int n) {
        //

        if (n == 0)
            return 1;
        if (n < 0) {
            n = -1 * n;
            x = 1 / x;
        }
        double result = 1;
        while (n != 0) {
            if (n % 2 == 1) {

                result = result * x;
                n -= 1;
            }

            x = x * x;
            n = n / 2;
        }

        System.out.println(result);
        return result;
    }

    public double solve(double x, long n) {
        double ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }

    public double myPow(double x, int n) {
        if (x == 1)
            return 1;
        long longN = n;
        double ans = solve(x, Math.abs(longN));
        if (longN < 0)
            return 1 / ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow2(2.00, -2));
    }

}
