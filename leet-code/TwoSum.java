import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {

    // working but we could do better
    public static int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] + nums[j] == target) {
                return new int[] { i + 1, j + 1 };
            } else if (nums[i] + nums[j] > target) {
                i++;
                j = i + 1;
            } else {
                System.out.println(nums[i]);
                j++;
                if (j == nums.length) {
                    i++;
                    j = i + 1;
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {

        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                return new int[] { i + 1, j + 1 };
            }
        }

        return null;

    }

    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {

                int left = i, right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] > -nums[i]) {
                        right--;
                    } else if (nums[left] + nums[right] < -nums[i]) {
                        left++;
                    } else {
                        ls.add(List.of(nums[i], nums[right], nums[left]));

                        while (left < right && nums[right - 1] == nums[right])
                            right--;
                        right--;
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        left++;
                    }
                }

            }
        }

        return ls;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2(new int[] { 5, 25, 75 }, 100)));

    }

}
