public class KnapSack {

    // RECURSION APPROACH
    public static int knapSackRec(int w, int[] values, int[] weights, int n) {

        // Base test case theres is no weight to be filled || there is no items
        if (n == 0 || w == 0) {
            return 0;
        }

        if (weights[n - 1] > w)
            return knapSackRec(w, values, weights, n - 1);

        else
            return Math.max(
                    values[n - 1] + knapSackRec(w - weights[n - 1], values, weights, n - 1),
                    knapSackRec(w, values, weights, n - 1));

    }

    public static void main(String[] args) {

        int[] weights = new int[] { 10, 20, 30 };

        int[] values = new int[] { 60, 100, 120 };

        System.out.println(knapSackRec(50, values, weights, 3));

    }
}
