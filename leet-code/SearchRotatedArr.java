public class SearchRotatedArr {

    // THIS IS MUCH Complicated
    static boolean containsTarget(int[] nums, int target) {
        //
        int i = 0;

        while (i + 1 < nums.length) {
            if (nums[i + 1] >= nums[i]) {
                i++;
            } else {
                break;
            }
        }
        int k = i + 1 == nums.length ? 0 : i + 1;

        int start;
        int end;
        if (nums[k] > target) {
            start = 0;
            end = k - 1;
        } else if (nums[k] < target) {
            start = k + 1;
            end = nums.length - 1;
        } else {
            return true;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    static boolean searchTarget(int[] nums, int target) {
        //
        int n = nums.length;
        if (n == 0)
            return false;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return true;
            if (!isBinarySearchHelpFul(nums, start, nums[mid])) {
                start++;
                continue;
            }

            // which arr does pivot belong to
            boolean pivotArr = existsInFirst(nums, start, nums[mid]); // true if it is in sorted first arr

            // which arr does target belong to
            boolean targetArr = existsInFirst(nums, start, target); // true if it is in first sorted arr

            if (pivotArr ^ targetArr) {
                if (pivotArr) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }

        return false;
    }

    // is target present in the first sorted array
    static boolean existsInFirst(int[] arr, int start, int target) {
        return target >= arr[start];
    }

    static boolean isBinarySearchHelpFul(int[] arr, int left, int element) {
        return arr[left] != element;
    }

    public static void main(String[] args) {
        System.out.println(containsTarget(new int[] { 2, 2, 2, 3, 2, 2, 2 }, 3));
    }

}
