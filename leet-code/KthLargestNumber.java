import java.util.Arrays;

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

    public static void main(String[] args) {

        int[] a = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        System.out.println(KthLargestNumber1(a, 4));

    }
}