public class SearchRoatatedArray {

    /*
     * this method has a time complexity of O(n) =O(n) O(log(n)) : so we need to
     * improve it
     */
    public int searchInRotatedArray1(int[] nums, int target) {

        if (nums.length == 1) {
            if (nums[0] == target)
                return 0;
            return -1;
        }

        int pivot_index = 0;
        for (int i = 1; i < nums.length; i++) { // [1,2,3,4,5,6,7] (n-1)
            if (nums[i] < nums[0]) {
                pivot_index = i;
                break;
            }
        }

        System.out.println(pivot_index);

        if (nums[pivot_index] == target)
            return pivot_index;
        int rightSearch = this.binarySearch(nums, target, pivot_index, nums.length - 1); // log(n)
        int lefSearch = this.binarySearch(nums, target, 0, pivot_index - 1); // log(n)

        if (rightSearch != -1)
            return rightSearch;
        if (lefSearch != -1)
            return lefSearch;
        return -1;
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        //
        int right = end;
        int left = start;

        while (left <= right) {
            // calculate median
            int median = left + (right - left) / 2;
            if (nums[median] == target) {
                return median;
            } else if (nums[median] < target) {
                left = median + 1;
            } else {
                right = median - 1;
            }

        }
        return -1;
    }

    public int findPivot(int[] nums, int start, int end) {
        //
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            // if()
        }

        return -1;
    }

    public static void main(String[] args) {

        // System.out.println(binarySearch(new int[] { 0, 2, 3, 5, 6, 7, 11, 14 }, 2, 3,
        // 5));

        SearchRoatatedArray sr = new SearchRoatatedArray();

        System.out.println(sr.searchInRotatedArray1(new int[] { 4, 5, 6, 7, 0, 2, 3 }, 5));

    }

}
