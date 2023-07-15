import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinitaionSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        // perform backtracking
        backTracking1(result, new ArrayList<Integer>(), 0, target, candidates);

        System.out.println(result);
        return result;

    }

    private void backTracking1(List<List<Integer>> result, ArrayList<Integer> temp, int start, int target,
            int[] candidates) {

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                //
                if (i > start && candidates[i] == candidates[i - 1])
                    continue;

                if (target - candidates[i] < 0)
                    break;
                temp.add(candidates[i]);
                backTracking1(result, temp, i + 1, target - candidates[i], candidates);
                temp.remove(temp.size() - 1);
            }
        }

    }

    private void backtracking(List<List<Integer>> result, ArrayList<Integer> temp, int start, int target,
            int[] candidates) {

        if (start == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        if (candidates[start] <= target) {
            temp.add(candidates[start]);
            backtracking(result, temp, start + 1, target - candidates[start], candidates);
            temp.remove(temp.size() - 1);
        }

        backtracking(result, temp, start + 1, target, candidates);
    }

    public static void main(String[] args) {

        CombinitaionSum2 cs = new CombinitaionSum2();
        cs.combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5);

    }// 1 1 2 5 6 7 10
}
