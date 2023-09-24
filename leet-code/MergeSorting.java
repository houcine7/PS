import java.util.Arrays;

public class MergeSorting {

    public static void merge(int[] arr, int left, int right, int mid) {

        int len1 = mid - left + 1;
        int len2 = right - mid;

        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2]; //

        // fill arrays
        for (int i = 0; i < len1; i++) {
            leftArr[i] = arr[left + i]; // (mid-left +left) =mid
        }

        for (int j = 0; j < len2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < len1 && j < len2) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
            System.out.println("heere");
        }

        while (i < len1) {
            arr[k++] = leftArr[i++];
        }

        while (j < len2) {
            arr[k++] = rightArr[j++];
        }

    }

    static void sort(int[] arr, int left, int right) {
        //
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            merge(arr, left, right, mid);

        }
    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

}

/*
 * 
 * left + (right - left)/2 = (2left+ (right-left))/2 = (left-right)/2
 * 
 */