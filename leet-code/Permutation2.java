import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<List<Integer>> permutationUnique2(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> occurences = new HashMap<>();

        for (int num : nums) {
            occurences.put(num, occurences.getOrDefault(num, 0) + 1);
        }

        backTracking(result, occurences, new ArrayList<>(), nums);

        return result;

    }

    private void backTracking(List<List<Integer>> result, Map<Integer, Integer> occurences, ArrayList<Integer> current,
            int[] nums) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));

            return;
        }

        for (Map.Entry<Integer, Integer> entry : occurences.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value != 0) {
                current.add(key);
                occurences.put(key, value - 1);
                backTracking(result, occurences, current, nums);
                occurences.put(key, value);
                current.remove(current.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        Permutation2 p2 = new Permutation2();
        System.out.println(p2.permutationUnique2(new int[] { 1, 1, 2 }));
    }

}
