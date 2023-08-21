import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BuySellS {

    // TIME COMPLEXITY IS HIGHER :
    public static int highestProfit(int[] prices) {

        // if the array is sorted descendent
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                break;
            }
            if (i == prices.length - 2) {
                return 0;
            }
        }

        int maxPrice = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i])
                    maxPrice = Math.max(maxPrice, prices[j] - prices[i]);
            }
        }

        return maxPrice;
    }

    // REDUCE N**2
    public static int highestProfit2(int[] prices) {

        // if the array is sorted descendent
        int total = 0;
        int minFoundedTillNow = Integer.MAX_VALUE;
        int profitIfSold = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < minFoundedTillNow) {
                minFoundedTillNow = prices[i];
            }

            profitIfSold = prices[i] - minFoundedTillNow;

            if (profitIfSold > total) {
                total = profitIfSold;
            }
        }
        return total;
    }

    public static void main(String[] args) {

        System.out.println(highestProfit2(new int[] { 7, 1, 5, 3, 6, 4 }));
    }

}
