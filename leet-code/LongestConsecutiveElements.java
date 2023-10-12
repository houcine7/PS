import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LongestConsecutiveElements {

    public int longestConsecutive(int[] nums) {

        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }

        int max = Integer.MIN_VALUE;
        int prev = pq.poll();
        int counter = 1;
        while (!pq.isEmpty()) {
            if (pq.peek() == prev + 1) {
                counter++;
                prev = pq.poll();

            } else if (pq.peek() == prev) {
                prev = pq.poll();
            } else {
                counter = 1;
                prev = pq.poll();
            }
            max = Math.max(max, counter);

        }

        return max;
    }

    public static void main(String[] args) {

        LongestConsecutiveElements lc = new LongestConsecutiveElements();
        System.out.println(lc.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
    }

}
