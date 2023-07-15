import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    // bad apporach alot: not working
    public List<List<Integer>> possibleCombinationLists(int[] candidate, int target) {

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < candidate.length; i++) {
            //
            int j = i == 0 ? i : i + 1;
            int holder = j;
            int counter = candidate[i];
            List<Integer> ls = new ArrayList<>();
            System.out.println("counter: " + counter);

            if (candidate[i] == target) {
                ls.add(target);
                if (!result.containsAll(ls)) {
                    result.add(ls);
                    continue;
                }
            }

            ls.add(candidate[i]);

            while (j < candidate.length) {

                counter += candidate[j];
                System.out.println(counter);
                if (counter < target) {
                    ls.add(candidate[j]);
                } else if (counter > target) {
                    counter -= candidate[j];
                    j++;

                } else {
                    ls.add(candidate[j]);
                    System.out.println(ls);
                    if (!result.containsAll(ls)) {
                        result.add(ls);
                        if (holder < candidate.length) {
                            j = holder + 1;
                            holder++;
                        } else {
                            break;
                        }
                        ls = new ArrayList<>();
                        counter = candidate[i];
                        ls.add(candidate[i]);
                    }
                }
            }
        }

        System.out.println(result);
        return result;
    }

    // backtracking
    public List<List<Integer>> combinitionSum(int[] candidates, int target) {
        //
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<Integer>(), candidates, target, 0);
        System.out.println(result);
        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain,
            int start) {
        //
        if (remain < 0 || start >= candidates.length)
            return;
        else if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backtracking(result, tempList, candidates, remain - candidates[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // backtracking 27
    private void backtracking2(List<List<Integer>> result, List<Integer> temp, int start, int target, int[] candidate) {

        if (start == candidate.length) {
            if (target == 0) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        if (candidate[start] <= target) {
            temp.add(candidate[start]);
            backtracking2(result, temp, start, target - candidate[start], candidate);
            temp.remove(temp.size() - 1);
        }

        backtracking2(result, temp, start + 1, target, candidate);

    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        cs.combinitionSum(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
    }

}
