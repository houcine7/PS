import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {

    //
    public static int[] getNextPermutation(int[] nums) {
        if (nums == null || nums.length <= 0)
            return nums;

        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 & nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
        return null;
    }

    // generate all possible permutaions :

    private static void reverse(int[] nums, int i, int j) {

        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public static void generatePossiblePermutations(int[] elements, int n) {
        //
        if (n == 1) {
            printArray(elements);
        } else {
            for (int i = 0; i < n - 1; i++) {
                //
                generatePossiblePermutations(elements, n - 1);

                if (n % 2 == 0) {
                    swap(elements, i, n - 1);
                } else {
                    swap(elements, 0, n - 1);
                }
            }

            generatePossiblePermutations(elements, n - 1);
        }
    }

    private static void swap(int[] elements, int i, int j) {
        //
        int holder = elements[i];
        elements[i] = elements[j];
        elements[j] = holder;
    }

    private static void printArray(int[] elements) {

        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " ,");
        }
        System.out.print('\n');
    }

    private static void iterartiveGenerator(int[] elements) {
        //
        int[] indexes = new int[elements.length];

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < elements.length; i++) {
            //
            indexes[i] = 0;
        }
        result.add(elements);
        int i = 0;
        while (i < elements.length) {
            if (indexes[i] < i) {
                swap(elements, i % 2 == 0 ? 0 : indexes[i], i);
                result.add(elements);
                indexes[i]++;
                i = 0;
            } else {
                indexes[i] = 0;
                i++;
            }
        }

        // printArray(elements);
    }

    private static void singlePassApproach(int[] nums) {

        //
        if (nums.length <= 1)
            System.out.println(nums);

        int i = nums.length - 1;

        while (i >= 1 && nums[i] <= nums[i - 1]) {
            i--;
        }

        System.out.println(i);

        if (i == 0) {
            Arrays.sort(nums);
            printArray(nums);

        } else {
            int holder = Integer.MAX_VALUE;
            int index = 0;
            for (int j = i; j < nums.length; j++) {
                //
                if (nums[j] > nums[i - 1] && nums[j] < holder) {
                    index = j;
                    holder = nums[j];
                }
            }
            swap(nums, i - 1, index);
            Arrays.sort(nums, i, nums.length);
            printArray(nums);
        }
    }

    private static void nextPermSPA2(int[] nums) {
        //

        int i = nums.length - 1;

        while (i >= 1 && nums[i] <= nums[i - 1]) {
            i--;
        }
        System.out.println(i - 1);
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i - 1]) {
                j--;
            }
            swap(nums, i - 1, j);
        }
        reRange(nums, i);

    }

    private static void reRange(int[] nums, int start) {

        int i = start, j = nums.length - 1;
        System.out.println(i + "----" + j);
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 1 };

        nextPermSPA2(nums);
    }

}
