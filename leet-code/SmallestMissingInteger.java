import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestMissingInteger {

    public int firstMissingPositive(int[] nums) {

        int missingInteger = 1;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                if (nums[i] <= missingInteger) {
                    missingInteger++;
                    continue;
                }
                return missingInteger;
            }
        }

        return missingInteger;

    }

    public int firstMissingPositive2(int[] nums) {

        int[] tracker = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            //
            if (nums[i] <= 0 || nums[i] > nums.length)
                continue;
            tracker[nums[i] - 1] = nums[i];
        }

        for (int i = 0; i < tracker.length; i++) {
            if (tracker[i] == 0) {
                return i + 1;
            }
        }

        return nums.length + 1;

    }

    public static void main(String[] args) {

        SmallestMissingInteger smi = new SmallestMissingInteger();

        System.out.println(smi.firstMissingPositive2(new int[] { 7, 8, 9, 11, 12 }));

    }

}
