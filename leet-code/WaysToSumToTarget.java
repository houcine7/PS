import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class WaysToSumToTarget {

    public static class Pair {

        int index, sum;

        Pair(int i, int currSum) {
            this.index = i;
            this.sum = currSum;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Pair)) {
                return false;
            }
            Pair other = (Pair) obj;
            return this.index == other.index && this.sum == other.sum;
        }

        @Override
        public int hashCode() {
            return 31 * index + sum;
        }

    }

    public static int waysToSumToTarget(int[] nums, int target) {

        Map<Pair, Integer> mp = new HashMap<>();

        return dpApproach(nums, target, 0, 0, mp);
    }

    public static void waysToSumToTarget(int[] nums, int target, int index, StringBuilder curr,
            List<StringBuilder> all) {

        if (index >= nums.length) {
            System.out.println(curr);
            if (isStringEqualTarget(curr.toString(), target)) {
                all.add(curr);
            }
            return;
        }

        // if (nums[index] <= target)
        waysToSumToTarget(nums, target, index + 1, new StringBuilder(curr + "+" + nums[index]), all);

        // if (nums[index] >= target)
        waysToSumToTarget(nums, target, index + 1, new StringBuilder(curr + "-" + nums[index]), all);

    }

    public static boolean isStringEqualTarget(String str, int target) {

        int sum = 0;
        int sign = 1;
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (str.charAt(i) == '+') {
                sign = +1;
                i++;
            } else {
                StringBuilder temp = new StringBuilder();
                while (i < str.length() && str.charAt(i) != '-' && str.charAt(i) != '+') {
                    temp.append(str.charAt(i));
                    i++;
                }
                if (sign == 1)
                    sum += Integer.parseInt(temp.toString());
                else
                    sum -= Integer.parseInt(temp.toString());
            }
        }
        return sum == target;
    }

    static public int dpApproach(int[] nums, int target, int currSum, int index, Map<Pair, Integer> dp) {

        Pair key = new Pair(index, currSum);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        List ls = new ArrayList<>();

        if (index >= nums.length) {
            if (currSum == target) {
                return 1;
            }
            return 0;
        }

        int positive = dpApproach(nums, target, currSum + nums[index], index + 1, dp);
        int negative = dpApproach(nums, target, currSum - nums[index], index + 1, dp);

        dp.put(key, positive + negative);
        return positive + negative;
    }

    // write a fibonacci function with with iterative and memoization
    public static int fib(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0; // base case
        dp[1] = 1; // base case
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // recurrence relation
        }
        return dp[n];
    }

    // what is this function time complexity?

    // write power function with recursion without memoization
    public static int power(int n, int p) {
        if (p == 0)
            return 1;
        return n * power(n, p - 1);
    }
    // what is this function time complexity? O(p)

    public static void main(String[] args) {

        Map<Pair, Integer> mp = new HashMap<>();
        mp.put(new WaysToSumToTarget.Pair(1, 2), 3);

        if (mp.containsKey(new WaysToSumToTarget.Pair(1, 2)))
            System.out.println("yeeeq");
        System.out.println(isStringEqualTarget("-1+1+1+1+1", 3));
        System.out.println(waysToSumToTarget(new int[] { 1, 1, 1, 1, 1 }, 3));
    }

}
