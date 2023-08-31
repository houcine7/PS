import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

class KthLargestNumber {

    static int KthLargestNumber1(int[] nums, int k) {

        int counter = 0;
        int kth = Integer.MIN_VALUE;
        boolean[] seen = new boolean[nums.length];

        while (counter < k) {
            int max = Integer.MIN_VALUE;
            int indexMax = -1;
            for (int i = 0; i < nums.length; i++) {
                if (seen[i])
                    continue;
                if (nums[i] > max) {
                    max = nums[i];
                    indexMax = i;
                }
            }
            seen[indexMax] = true;
            counter++;
            kth = max;
        }

        return kth;
    }

    static int KthLargestNumber0(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
        }

        while (nums.length - k != 0) {
            minHeap.poll();
            k++;
        }

        return minHeap.poll();

    }

    static int KthLargestNumber2(int[] nums, int k) {

        List<Integer> ls = new ArrayList<>();
        for (int num : nums) {
            ls.add(num);
        }
        return quickSelect(ls, k);
    }

    static int quickSelect(List<Integer> ls, int k) {

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();

        int pivotI = new Random().nextInt(ls.size());
        int pivot = ls.get(pivotI);

        for (Integer num : ls) {
            if (num > pivot)
                left.add(num);
            else if (num < pivot)
                right.add(num);
            else
                mid.add(num);
        }

        if (left.size() >= k)
            return quickSelect(left, k);
        else if ((left.size() + mid.size()) < k)
            return quickSelect(right, k - left.size() - mid.size());
        else
            return pivot;

    }

    public static void main(String[] args) {

        int[] a = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        System.out.println(KthLargestNumber2(a, 4));

    }
}