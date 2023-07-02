public class InsertElement {

    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        if (nums.length >= 0) {
            if (target < nums[0])
                return 0;
        }

        while (start <= end) {
            mid = (end - start) / 2 + start;
            // System.out.println("Miduim: " + mid);
            if (nums[mid] == target)
                return mid;
            if (mid < end && nums[mid] < target && nums[mid + 1] > target)
                return mid + 1;
            if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;

        }

        return mid + 1;

    }

    public static void main(String[] args) {

        InsertElement ins = new InsertElement();
        System.out.println(ins.searchInsert(new int[] { 1, 3, 5, 6 }, 8));

    }

}
