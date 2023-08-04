public class MyPower {

    public static double myPow(double x, int n) {

        if (n == 0)
            return 1;
        if (n < 0)
            return 1 / myPow(x, -n);
        if (n % 2 == 0)
            return myPow(x * x, (Math.abs(n)) / 2);
        else
            return x * myPow(x * x, (Math.abs(n) - 1) / 2);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00, 10));
    }

}
