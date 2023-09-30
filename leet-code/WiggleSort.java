import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WiggleSort {

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        int k = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result[i] = nums[k++];
        }

        for (int i = 1; i < result.length; i += 2) {
            result[i] = nums[k++];
        }

        nums = result.clone();
        System.out.println(Arrays.toString(nums));

    }

    public static int[] wiggleSort1(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (i % 2 == 0 && arr[i] > arr[i + 1]) {
                //
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
            if (i % 2 != 0 && arr[i] < arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        return arr;

    }

    public static void wiggleSortII(int nums[]) {

        Arrays.sort(nums);
        int i = 1;
        int j = nums.length - 1;

        int[] ans = new int[nums.length];

        while (j >= 0) {
            ans[i] = nums[j];
            j--;
            i += 2;
            if (i >= nums.length) {
                i = 0;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            nums[k] = ans[k];
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        wiggleSortII(new int[] { 1, 3, 2, 2, 3, 1 });
    }

}
