import java.util.ArrayList;
import java.util.List;

public class Permutation2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), nums, new ArrayList<>());
        return result;
    }

    public void backtracking(List<List<Integer>> result, List<Integer> curr, int[] nums,
            ArrayList<Integer> visitedIndexs) {

        if (curr.size() == nums.length) {
            if (result.contains(new ArrayList<>(curr)))
                return;
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i);
            if (!visitedIndexs.contains(i)) {
                System.out.println("i: " + i);
                curr.add(nums[i]);
                visitedIndexs.add(i);
                backtracking(result, curr, nums, visitedIndexs);
                visitedIndexs.remove(visitedIndexs.size() - 1);
                curr.remove(curr.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        Permutation2 p2 = new Permutation2();
        System.out.println(p2.permuteUnique(new int[] { 1, 4, 2 }));
    }

}
