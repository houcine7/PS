import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FirstLastPosSortedArray {

    public int[] firstLastPosition(int[] nums, int target) {

        //

        if (nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int start = 0;
        int end = nums.length - 1;
        List<Integer> result = findRec(nums, start, end, target, new ArrayList<>());

        if (result.size() == 0) {
            return new int[] { -1, -1 };
        }

        Collections.sort(result);

        return new int[] { result.get(0), result.get(result.size() - 1) };
    }

    public List<Integer> findRec(int[] nums, int start, int end, int target, ArrayList<Integer> result) {

        while (start <= end) {

            int mid = (end - start) / 2 + start;

            if (nums[mid] == target) {
                result.add(mid);
                // System.out.println("here");
                if (mid < end && nums[mid + 1] == target) {
                    System.out.println("nums[mid+1]");
                    findRec(nums, mid + 1, end, target, result);
                }

                if (mid > start && nums[mid - 1] == target) {
                    System.out.println("nums[mid-1]");
                    findRec(nums, start, mid - 1, target, result);
                }

                break;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            }

            else if (nums[mid] < target) {
                start = mid + 1;
            }

        }
        System.out.println(result.toString());
        return result;
    }

    public static void main(String[] args) {
        FirstLastPosSortedArray fst = new FirstLastPosSortedArray();

        // System.out.println(fst.firstLastPosition(new int[] { 5, 7, 7, 8, 8, 10 },
        // 8));

        System.out.println(fst.findRec(new int[] { 5, 5, 5, 5 }, 0, 3, 5, new ArrayList<>()));
    }

}
