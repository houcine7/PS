import java.util.ArrayDeque;
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

    // Using quicksort
    static int[] maxSlidingWindow2(int[] nums, int k) {

        int i = 0;
        List<Integer> ls = new ArrayList<>();
        while (i <= nums.length - k) {
            int[] tep = nums.clone();
            quickSort(tep, i, i + k - 1);
            ls.add(tep[i + k - 1]);
            i++;
        }

        int[] r = new int[ls.size()];
        int m = 0;
        for (int max : ls) {
            r[m++] = max;
        }

        return r;
    }

    static void sortFromTo(int[] nums, int start, int end) {

    }

    static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pi = partition(nums, start, end);
            quickSort(nums, start, pi - 1);
            quickSort(nums, pi + 1, end);
        }
        ;
    }

    static int partition(int[] nums, int start, int end) {

        // the pivot
        int pivot = nums[end];
        int indexMin = start - 1;

        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                indexMin++;
                swap(nums, indexMin, i);
            }

        }

        swap(nums, indexMin + 1, end);

        return indexMin + 1;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // using deque

    static int[] maxSlidingWindow0(int[] nums, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int m = 0;
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.removeLast();
            }

            dq.offer(i);
        }

        result[m++] = nums[dq.peekFirst()];
        for (int j = k; j < nums.length; j++) {

            // element OUT OF THE WINDOW
            if (dq.peekFirst() == j - k) {
                dq.pollFirst();
            }
            System.out.println(j);

            while (!dq.isEmpty() && nums[j] >= nums[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.offer(j);

            result[m++] = nums[dq.peekFirst()];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };

        quickSort(nums, 0, 2);
        System.out.println(Arrays.toString(maxSlidingWindow0(nums, 3)));
    }

}
