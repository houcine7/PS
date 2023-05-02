import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * a<b<c
 * a<c<b
 * b<a<c
 * 
 */
public class Cl3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int j2 = j + 1; j2 < nums.length; j2++) {
                    if (nums[i] + nums[j] + nums[j2] == 0) {
                        List<Integer> ls2 = new ArrayList<>();
                        /*
                         * Math.min(i,j,j2)=numj
                         */

                        if (nums[i] <= nums[j] && nums[i] <= nums[j2]) {
                            ls2.add(0, nums[i]);
                            if (nums[j] <= nums[j2]) {
                                ls2.add(1, nums[j]);
                                ls2.add(2, nums[j2]);
                            } else {
                                ls2.add(1, nums[j2]);
                                ls2.add(2, nums[j]);
                            }
                        } else if (nums[j] <= nums[i] && nums[j] <= nums[j2]) {
                            ls2.add(0, nums[j]);
                            if (nums[i] <= nums[j2]) {
                                ls2.add(1, nums[i]);
                                ls2.add(2, nums[j2]);
                            } else {
                                ls2.add(1, nums[j2]);
                                ls2.add(2, nums[i]);
                            }
                        } else {
                            ls2.add(0, nums[j2]);
                            if (nums[i] <= nums[j]) {
                                ls2.add(1, nums[i]);
                                ls2.add(2, nums[j]);
                            } else {
                                ls2.add(1, nums[j]);
                                ls2.add(2, nums[i]);
                            }
                        }

                        if (!ls.contains(ls2)) {
                            ls.add(ls2);
                        }

                    }
                }
            }

        }

        System.out.println(ls.toString());
        return null;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        //

        HashMap<Integer, Integer> mp = new HashMap<>();
        List<List<Integer>> st = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(nums[i])) {
                mp.put(nums[i], mp.get(nums[i]) + 1);
            } else {
                mp.put(nums[i], 1);
            }
        }
        System.out.println(mp.toString());
        //
        for (int i = 0; i < nums.length; i++) {

            mp.put(nums[i], mp.get(nums[i]) - 1);

            for (int j = i + 1; j < nums.length; j++) {

                mp.put(nums[j], mp.get(nums[j]) - 1);

                if (mp.containsKey(-(nums[i] + nums[j])) && mp.get(-(nums[i] + nums[j])) != 0) {
                    //
                    List<Integer> ls2 = new ArrayList<>();
                    ls2.add(nums[i]);
                    ls2.add(nums[j]);
                    ls2.add(-(nums[i] + nums[j]));
                    Collections.sort(ls2);

                    if (!st.contains(ls2))
                        st.add(ls2);
                }
                mp.put(nums[j], mp.get(nums[j]) + 1);
            }
            mp.put(nums[i], mp.get(nums[i]) + 1);
        }
        System.out.println(st.toString());
        return st;
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        //
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i == 0 || nums[i - 1] != nums[i]) {

                int low = i + 1;
                int high = nums.length - 1;
                while (low < high) {
                    if ((nums[low] + nums[high]) > -nums[i]) {
                        high--;
                    } else if ((nums[low] + nums[high]) < -nums[i]) {
                        low++;
                    } else {
                        List<Integer> ls = List.of(nums[i], nums[high], nums[low]);
                        result.add(ls);

                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }

                        low++;
                        high--;

                    }
                }
            }

        }

        System.out.println(result);
        return null;
    }

    public static void main(String[] args) {

        threeSum3(new int[] { -1, 0, 1, 2, -1, -4 }); // -4,-1,-1,0,1,2
    }
}
