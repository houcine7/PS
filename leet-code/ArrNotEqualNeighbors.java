import java.util.Arrays;

public class ArrNotEqualNeighbors {

    public static int[] rearrangeArray(int[] nums) {

        /*
         * [0,1,2,3,4]
         * let's pick the index 2 for example the average
         * can equal the element in the index if only one neighbor is smaller then the
         * element
         * and the other is greater
         * 1 2 3 4 5 3
         * 1 4 2 5 3
         */

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

    public static void main(String[] args) {
        int[] test_arr = new int[] { 1, 3, 2 };

        System.out.println(Arrays.toString(rearrangeArray(test_arr)));
    }

}

/*
 * 6+0=6/2=3
 * 9+2=11/
 * 
 */