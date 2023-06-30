public class SearchRoatatedArray {

    /*
     * this method has a time complexity of O(n) =O(n) O(log(n)) : so we need to
     * improve it
     */
    public int searchInRotatedArray1(int[] nums, int target) {

        int pivot_index = this.findPivot(nums, 0, nums.length);

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
        while (start < end) {
            int mid = (end - start) / 2 + start;
            System.out.println(mid);
            if (mid < end && nums[mid + 1] < nums[mid]) {
                return mid + 1;
            }

            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid;
            }
            if (nums[mid] < nums[start]) {
                return findPivot(nums, start, mid - 1);
            }

            return findPivot(nums, mid + 1, end);
        }

        return 0;
    }

    public static void main(String[] args) {

        // System.out.println(binarySearch(new int[] { 0, 2, 3, 5, 6, 7, 11, 14 }, 2, 3,
        // 5));

        SearchRoatatedArray sr = new SearchRoatatedArray();

        // System.out.println(sr.searchInRotatedArray1(new int[] { 4, 5, 6, 7, 0, 2, 3
        // }, 5));

        System.out.println(sr.findPivot(new int[] { 1 }, 0, 1));

    }

}
