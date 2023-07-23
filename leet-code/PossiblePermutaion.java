import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossiblePermutaion {

    public List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTracking(nums, new ArrayList<>(), result);
        return result;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void backTracking(int[] nums, List<Integer> curr, List<List<Integer>> result) {

        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!curr.contains(nums[i])) {
                curr.add(nums[i]);
                backTracking(nums, curr, result);
                curr.remove(curr.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        PossiblePermutaion pp = new PossiblePermutaion();
        System.out.println(pp.permutation(new int[] { 1, 2, 3 }));
    }

}
