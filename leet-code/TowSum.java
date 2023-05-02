import java.util.HashMap;

import javax.print.attribute.HashDocAttributeSet;

public class TowSum {

    public int[] towSume(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target) {
                    return new int[] { i, j };
                }
            }

        }
        return null;
    }

    // optimized implementation

    public int[] towSumeOpt(int[] nums, int target) {

        //
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                //
                return new int[] { map.get(target - nums[i]), i };

            }
            map.put(target - nums[i], i);
        }

        return null;
    }

    //
    public static void main(String[] ar) {

        TowSum tsm = new TowSum();
        System.out.println(
                tsm.towSume(new int[] { 3, 2, 4 }, 6)[0] + "----" + tsm.towSume(new int[] { 3, 2, 4 }, 6)[1]);
    }
}