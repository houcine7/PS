import java.util.Arrays;

public class KokoEatingBananas {

    public static int minSpeed(int[] piles, int h) {
        // brute force

        int start = 1;
        int max_speed = 1;

        for (int i : piles) {
            max_speed = Math.max(max_speed, i);
        }
        // => brute force
        /*
         * for (int i = 1; i <= max_speed; i++) {
         * int hours = 0;
         * for (int j = 0; j < piles.length; j++) {
         * if (piles[j] % i == 0) {
         * hours += piles[j] / i;
         * } else {
         * hours += piles[j] / i + 1;
         * }
         * }
         * if (hours < h)
         * minSpeed = Math.min(minSpeed, hours);
         * }
         */

        while (start < max_speed) {
            int mid = start + (max_speed - start) / 2;
            int hours = 0;
            for (int i = 0; i < piles.length; i++) {
                if (piles[i] % mid == 0)
                    hours += piles[i] / mid;
                else
                    hours += (piles[i] / mid) + 1;
            }
            if (hours > h)
                start = mid + 1;
            else {
                max_speed = mid;
            }

        }

        return max_speed;
    }

    public static void main(String[] args) {
        int[] pl = new int[] { 3, 6, 7, 11 };
        int result = minSpeed(pl, 8);
        System.out.println(result);

    }
}
