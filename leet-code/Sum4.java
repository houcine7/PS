import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 *  nums[a] + nums[b] + nums[c] + nums[d] ==target
 * [1,2,5,3,7,-1,0]
 * 
 */
public class Sum4 {

    public static List<List<Integer>> fourSum(int[] arr, int target) {

        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            if (i == 0 || arr[i - 1] != arr[i]) {
                for (int j = i + 1; j < arr.length - 2; j++) {

                    if (j == i + 1 || arr[j] != arr[j - 1]) {
                        int low = j + 1;
                        int high = arr.length - 1;

                        while (low < high) {

                            Long sum = (long) arr[low] + (long) arr[high] + (long) arr[i] + (long) arr[j];

                            if (sum > target) {
                                //
                                high--;
                            } else if (sum < target) {
                                //
                                low++;
                            } else {
                                //
                                List<Integer> ls = List.of(arr[low], arr[high], arr[i], arr[j]);
                                result.add(ls);

                                while (low < high && arr[low + 1] == arr[low]) {
                                    low++;

                                }
                                while (low < high && arr[high - 1] == arr[high]) {
                                    high--;

                                }
                                low++;
                                high--;
                            }

                        }
                    }
                }
            }
        }

        // System.out.println(result);

        return result;
    }

    public static void main(String[] args) {
        fourSum(new int[] { -2, -1, -1, 1, 1, 1, 2, 2 }, 0);

        /*
         * -2,-1,-1,1,1,2,2
         */

        System.out.println(1000000000L + 1000000000L + 1000000000L + 1000000000L);
        System.out.println(1000000000 + 1000000000 + 1000000000 + 1000000000 > Integer.MAX_VALUE);
    }

}
