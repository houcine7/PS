import java.util.*;

public class CoinChange {

    public int totalCombination(int[] coins, int amount) {
        int[] counts = new int[amount + 1];

        counts[0] = 1;

        for (int i = 0; i < coins.length; i++) {

            for (int j = 0; j < counts.length; j++) {
                if (j >= coins[i]) {
                    counts[j] = counts[j - coins[i]] + counts[j];
                }
                System.out.println(Arrays.toString(counts));
            }
        }
        return counts[amount];
    }

    public int changeCoins(int[] coins, int amount) {
        int[] counts = new int[amount + 1];
        Arrays.fill(counts, amount + 1);
        counts[0] = 0;

        for (int i = 1; i < counts.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    counts[i] = Math.min(counts[i], counts[i - coin] + 1);
                }
                System.out.println(Arrays.toString(counts));
            }
        }
        return counts[amount] > amount ? -1 : counts[amount];
    }

    // here we do it recursive way
    public int changeCoinsBase(int[] coins, int amount) {

        int dp[] = new int[amount + 1];
        Arrays.fill(dp, -1);

        int result = minCoinsRec(coins, amount, dp);

        return result != Integer.MAX_VALUE ? result : -1;
    }

    private int minCoinsRec(int[] coins, int amount, int[] dp) {

        if (amount == 0)
            return 0; // 0 coins to sum upp to 0
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int subResult = 0;
                if (dp[amount - coins[i]] != -1) {
                    subResult = dp[amount - coins[i]];
                } else {
                    subResult = minCoinsRec(coins, amount - coins[i], dp);
                }

                if (subResult != Integer.MAX_VALUE && subResult + 1 < result)
                    result = subResult + 1;
            }
        }
        return dp[amount] = result;
    }

    public static void main(String[] args) {
        CoinChange ch = new CoinChange();

        System.out.println(ch.changeCoinsBase(new int[] { 186, 419, 83, 408 }, 6249));

    }

}