import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSlidingWindow {

    // Time complexity pb
    static int[] maxSlidingWindow(int[] nums, int k) {

        int i = 0;
        List<Integer> ls = new ArrayList<>();
        while (i <= nums.length - k) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            ls.add(max);
            i++;

        }

        int[] r = new int[ls.size()];
        int m = 0;
        for (int max : ls) {
            r[m++] = max;
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
    }

}
