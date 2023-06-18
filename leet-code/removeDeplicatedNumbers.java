import java.util.Arrays;

public class removeDeplicatedNumbers {

    public static void printArray(int[] array) {

        String str = "";

        for (int i = 0; i < array.length; i++) {
            str += array[i] + "";
        }

        System.out.println(str);
    }

    public static int towPointer(int[] nums) {

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int removeValueInArray(int[] nums, int val) {
        //

        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                System.out.println(index);
                index++;
                nums[index] = nums[i];
            }
        }
        printArray(nums);
        return index + 2;
    }

    public static void main(String[] args) {

        int[] arr = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
        System.out.println(removeValueInArray(arr, 2));
        printArray(arr);
    }
}
