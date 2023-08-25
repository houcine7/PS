import java.util.Arrays;

public class KnapSack {

    // RECURSION APPROACH
    public static int knapSackRec(int w, int[] values, int[] weights, int n) {

        // Base test case theres is no weight to be filled || there is no items
        if (n == 0 || w == 0) {
            return 0;
        }

        // if n-1 th weight is greater then w then we can't include it in the bag
        if (weights[n - 1] > w)
            return knapSackRec(w, values, weights, n - 1);

        // The max if value if we include or not the n-1 th weight to the bag
        else
            return Math.max(
                    values[n - 1] + knapSackRec(w - weights[n - 1], values, weights, n - 1),
                    knapSackRec(w, values, weights, n - 1));

    }

    // WITH DP APPROACH
    /*
     * Because sub problems can be repeated if we choose between the two(include
     * exclude ) we end up calculating a sub problem many times
     * we are introducing an array dp[][] that holds the result of a subproblem(n,w)
     * so we store the result of a problem and we do not
     * calculate it again
     */

    static int knapSack(int w, int[] values, int[] weights, int n) {

        int[][] dp = new int[n + 1][w + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(Arrays.deepToString(dp));
        return knapSacKDp(w, values, weights, n, dp);

    }

    static int knapSacKDp(int w, int[] values, int[] weights, int n, int[][] dp) {

        if (w == 0 || n == 0)
            return 0;

        if (dp[n][w] != -1)
            return dp[n][w];

        if (weights[n - 1] > w)
            return dp[n][w] = knapSacKDp(w, values, weights, n - 1, dp);
        else
            return dp[n][w] = Math.max(
                    values[n - 1] + knapSacKDp(w - weights[n - 1], values, weights, n - 1, dp),
                    knapSacKDp(w, values, weights, n - 1, dp));
    }

    // bottom up approach

    static int knapSack2(int w, int n, int[] values, int[] weights) {

        int[][] k = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {

                if (i == 0 || j == 0)
                    k[i][j] = 0;
                else if (weights[i - 1] <= j)
                    k[i][j] = Math.max(values[i - 1] + k[i - 1][j - weights[i - 1]], k[i - 1][j]);
                else
                    k[i][j] = k[i - 1][j];
            }
        }

        return k[n][w];

    }

    public static void main(String[] args) {

        int[] weights = new int[] { 10, 20, 30 };

        int[] values = new int[] { 60, 100, 120 };

        System.out.println(knapSack2(50, 3, values, weights));

    }
}
