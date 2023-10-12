import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class MostKElements {

    // using min HEAP ds
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        for (int l : nums) {
            freq.put(l, freq.getOrDefault(l, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (ele1, ele2) -> freq.get(ele1) - freq.get(ele2));

        int m = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (m != k) {
                pq.add(entry.getKey());
                m++;
                System.out.println(pq);
            } else {
                if (freq.get(pq.peek()) < entry.getValue()) {
                    pq.poll();
                    pq.add(entry.getKey());
                }
            }
        }

        int[] result = new int[k];
        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = pq.poll();
        }
        return result;

    }

    // using quick sort approach
    public int[] topKFrequent2(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        for (int l : nums) {
            freq.put(l, freq.getOrDefault(l, 0) + 1);
        }

        int[] uniques = new int[freq.size()];
        int i = 0;
        for (int key : freq.keySet()) {
            uniques[i++] = key;
        }

        int N = uniques.length;

        quickSelect(0, N - 1, N - k, uniques, freq);

        return Arrays.copyOfRange(uniques, N - k, N);
    }

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int partition(int left, int right, int index_pivot, int[] arr, Map<Integer, Integer> freq) {
        int pivot_freq = freq.get(arr[index_pivot]);
        swap(index_pivot, right, arr);

        int storeIndex = left;
        for (int i = left; i <= right; i++) {
            if (pivot_freq > freq.get(arr[i])) {
                swap(storeIndex, i, arr);
                storeIndex++;
            }
        }

        swap(right, storeIndex, arr);

        return storeIndex;
    }

    public void quickSelect(int left, int right, int k_smallest, int[] arr, Map<Integer, Integer> freq) {

        if (left == right)
            return;

        Random rd = new Random();
        int pivot_index = left + rd.nextInt(right - left);

        pivot_index = partition(left, right, pivot_index, arr, freq);

        if (k_smallest == pivot_index)
            return;
        else if (k_smallest < pivot_index) {
            quickSelect(left, pivot_index - 1, k_smallest, arr, freq);
        } else {
            quickSelect(pivot_index + 1, right, k_smallest, arr, freq);
        }

    }

    public static void main(String[] args) {
        MostKElements ms = new MostKElements();
        System.out.println(Arrays.toString(ms.topKFrequent2(new int[] { 4, 1, -1, 2, -1, 2, 3 }, 2)));
    }
}
