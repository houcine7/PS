import java.util.Arrays;

public class Sum3Closest {

    /*
     * 
     * [-4,-1,1,2]
     * -4
     * -4-1+2=-3<target : => -4+1+2=>-1<target
     */

    public static int sum3Closest(int[] nums, int target) {

        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        boolean isNegative = false;

        for (int i = 0; i < nums.length; i++) { // n
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) { // n-2
                int sum = nums[i] + nums[high] + nums[low];

                int before = minDiff;

                minDiff = Math.min(Math.abs(sum - target), minDiff);
                if (sum - target < 0 && before != minDiff) {
                    isNegative = true;
                } else if (sum - target > 0 && before != minDiff) {
                    isNegative = false;

                }
                if (sum > target || nums[high] == nums[high - 1]) {
                    //
                    high--;
                } else if (sum < target || nums[low] == nums[low + 1]) {

                    low++;
                } else {
                    return target;
                }
            }
        }

        return !isNegative ? minDiff + target : target - minDiff;
    }

    public static void main(String[] args) {
        System.out.println(sum3Closest(new int[] { -1, 2, 1, -4 }, 3));
    }

}
