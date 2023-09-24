public class DivideCon {

    /*
     * find the maximum number in an array
     * using divide and conquer approach
     */
    public static int DAC_MAX(int[] arr, int index, int len) {

        //
        if (len - 1 == 0)
            return arr[index];
        if (index >= len - 2) {
            if (arr[index] > arr[index + 1])
                return arr[index];
            else
                return arr[index + 1];
        }

        int max = DAC_MAX(arr, index + 1, len);
        if (arr[index] > max)
            return arr[index];
        else
            return max;
    }

    public static int DAC_MIN(int[] arr, int index, int len) {

        if (len - 1 == 0)
            return arr[index];
        if (index >= len - 2)
            if (arr[index] < arr[index + 1])
                return arr[index];
            else
                return arr[index + 1];

        int min = DAC_MIN(arr, index + 1, len);
        if (min < arr[index])
            return min;
        else
            return arr[index];

    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 22, 55, 0, 7, 3, 55, 303, 4, 5, 6, 7, 9, 8, 304, 215, 555 };
        System.out.println(DAC_MIN(arr, 0, arr.length));
    }

}
