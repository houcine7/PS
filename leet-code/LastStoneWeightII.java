import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeightII {

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

    public int lastStoneWeightII(int stones[]) {
        Queue<Integer> ls = new PriorityQueue<>();
        int curr = 0, index = 0;
        Map<Pair, Integer> mem = new HashMap<>();

        dp(stones, curr, ls, index, mem);
        System.out.println(ls);
        return ls.poll();
    }

    private int dp(int[] stones, int curr, Queue<Integer> ls, int index, Map<Pair, Integer> mem) {
        if (mem.containsKey(new Pair(index, curr))) {
            if (curr > 0)
                ls.add(curr);
            return curr;
        }
        if (index >= stones.length) {
            if (curr > 0)
                ls.add(curr);
            return curr;
        }
        int negative = 0, positive = 0;

        negative = dp(stones, curr - stones[index], ls, index + 1, mem);
        positive = dp(stones, curr + stones[index], ls, index + 1, mem);
        mem.put(new Pair(index, curr), positive + negative);
        return positive + negative;
    }

    public int lastStoneWeight(int stones[]) {

        // S= S1+S2 (two sub arrays)
        // diff = S1-S2 ==> diff = S-2*S2;
        int n = stones.length;
        int S = 0, S2 = 0;
        for (int stone : stones)
            S += stone;

        boolean[][] dp = new boolean[S / 2 + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true; // indexes from 1st to the jth has a subset that can sum-up to 0
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= S / 2; j++) {
                if (dp[j][i - 1] || (j >= stones[i - 1] && dp[j - stones[i - 1]][i - 1])) {
                    dp[j][i] = true;
                    S2 = Math.max(S2, j);
                }
            }
        }
        return S - 2 * S2;

    }

    public static void main(String[] args) {
        LastStoneWeightII ls = new LastStoneWeightII();
        System.out.println(ls.lastStoneWeightII(new int[] { 31, 26, 33, 21, 40 }));
    }
}
