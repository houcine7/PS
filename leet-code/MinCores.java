import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinCores {

    /*
     * public static int getMinCores(int[] start, int[] end) {
     * int n = start.length;
     * 
     * if (n == 0)
     * return 0;
     * 
     * Arrays.sort(start);
     * Arrays.sort(end);
     * 
     * int i = 0;
     * int counter = 1;
     * 
     * while (i < n) {
     * boolean isCoreEmpty = false;
     * for (int j = 0; j < i; j++) {
     * if (end[j] < start[i]) {
     * isCoreEmpty = true;
     * }
     * }
     * 
     * if (isCoreEmpty) {
     * counter++;
     * }
     * i++;
     * }
     * 
     * return counter;
     * }
     */

    public static int getMinCores(List<Integer> start, List<Integer> end) {

        Collections.sort(start);
        Collections.sort(end);

        int counter = 0;
        int activeCount = 0;

        for (int i = 0, j = 0; i < start.size();) {
            if (start.get(i) < end.get(j)) {
                activeCount++;
                counter = Math.max(activeCount, counter);
                i++;
            } else {
                activeCount--;
                j++;
            }
        }

        return counter;

    }

    public static int[] minimizeArray(int[] arr) {
        Arrays.sort(arr); // Sort the array in ascending order
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            boolean paired = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (2 * arr[i] <= arr[j]) {
                    paired = true;
                    break;
                }
            }

            if (!paired) {
                result.add(arr[i]);
            }
        }

        // Convert the result list to an array
        int[] minimizedArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            minimizedArray[i] = result.get(i);
        }

        return minimizedArray;
    }

    // Collections.sort(arr);
    // int count = 0;
    // int i = 0, j = arr.size() - 1;
    // while (i <= j) {
    // if (j == i || 2 * arr.get(i) <= arr.get(j)) {
    // j -= 1;
    // i++;
    // count++;
    // } else {
    // i++;
    // }
    // }

    public static int minArrSize(List<Integer> arr) {
        Collections.sort(arr);
        Set<Integer> set = new HashSet<>();
        int i = 0;
        int count = 0;
        while (i < arr.size()) {
            for (int j = i; j < arr.size(); j++) {
                if (!set.contains(arr.get(j)) && !set.contains(i) && 2 * arr.get(i) <= arr.get(j)) {
                    set.add(j);
                    set.add(i);
                    count++;
                    break;
                }
            }
            i++;
        }

        return count;

    }

    public static void main(String[] args) {

        List<Integer> ls = new ArrayList<>();
        List<Integer> ls1 = new ArrayList<>();

        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);

        ls.add(16);
        ls.add(32);
        ls.add(64);

        System.out.println(minArrSize(ls));
    }

}
