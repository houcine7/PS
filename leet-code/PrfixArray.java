import java.util.List;

public class PrfixArray {
    public long manipulateArray(List<List<Integer>> queries, int n) {

        int[] arr = new int[n + 1];

        for (List<Integer> q : queries) {
            int start = q.get(0) - 1;
            int end = q.get(1);
            int val = q.get(2);

            arr[start] += val;
            arr[end] -= val;
        }

        long max = Integer.MIN_VALUE;
        long holder = 0;

        for (int num : arr) {
            holder += num;
            max = Math.max(max, holder);
        }

        return max;
    }

}
