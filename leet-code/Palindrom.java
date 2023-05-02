import java.util.HashSet;
import java.util.Set;

public class Palindrom {

    public static boolean isPalindrom(int x) {

        if (x < 0)
            return false;
        int y = x;
        long revers = 0;

        while (y != 0) {
            int lastDig = y % 10;
            System.out.println(lastDig);
            revers += lastDig;
            revers *= 10;
            System.out.println("------ revers" + revers);
            y = y / 10;
        }

        revers = revers / 10;

        System.out.println(revers);

        //
        return revers == x;

    }

    public static void main(String[] args) {
        System.out.println(Palindrom.isPalindrom(1000000001));
    }

}
