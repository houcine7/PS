public class ReversInteger {

    public static int reverse(int x) {

        StringBuilder str = new StringBuilder(x + "");

        str.reverse();

        int result = Integer.parseInt(str.toString().replace("-", ""));

        if (x < 0)
            result = -1 * result;

        return Math.pow(-2, 31) < result && result < Math.pow(2, 31) - 1 ? result : 0;

    }

    public static int revers2(int x) {

        long result = 0;

        while (x != 0) {
            int lastDig = x % 10;
            result += lastDig;
            result *= 10;
            x = x / 10;
        }
        result = result / 10;

        System.out.println(result);
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;

        else
            return x < 0 ? (int) (-1 * result) : (int) result;

    }

    public static void main(String[] args) {
        System.out.println(ReversInteger.revers2(-321));
    }
}
