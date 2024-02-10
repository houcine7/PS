import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Candles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            long n = scanner.nextLong();
            long[] candlesCount = new long[10];

            if (n < 10) {
                for (int digit = 0; digit <= n; digit++) {
                    candlesCount[digit] = 1;
                }
            } else {

                long number = 1;
                while (n > 0) {
                    long digit = n % 10;
                    System.out.println(digit);
                    for (int d = 0; d < 10; d++) {
                        candlesCount[d] += (digit == d) ? 1 : 0;
                    }
                    n /= 10;
                    number *= 10;
                }

            }
            StringBuilder sb = new StringBuilder();
            for (int digit = 0; digit < 10; digit++) {
                sb.append(candlesCount[digit]).append(" ");
                ;
            }
            System.out.println(sb.toString().trim());
        }

        scanner.close();

    }
}
