import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

public class ArrNotEqualNeighbors {

    public static int[] rearrangeArray2(int[] nums) {

        Arrays.sort(nums);
        int result[] = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result[i] = nums[j++];
        }

        for (int i = 1; i < nums.length; i += 2)
            result[i] = nums[j++];

        return result;
    }

    public static int[] rearrangeArray1(int[] nums) {
        final int n = nums.length;

        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] + nums[i + 1] == nums[i] * 2) {
                swap(nums, i, i + 1);
            }
            System.out.println(Arrays.toString(nums));
        }

        for (int i = n - 2; i >= 1; i--) {
            if (nums[i + 1] + nums[i - 1] == 2 * nums[i]) {
                swap(nums, i, i - 1);
            }
        }

        return nums;

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] test_arr = new int[] { 6, 2, 0, 9, 7 };

        System.out.println(Arrays.toString(rearrangeArray1(test_arr)));
    }

}

/*
 * 6+0=6/2=3
 * 9+2=11/
 * 
 */