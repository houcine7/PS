import java.lang.reflect.Array;
import java.util.Arrays;

public class RotateImage {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];
        int counter = 0;

        while (counter < n) {
            int j = 0;
            int[] temp = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                temp[j++] = (matrix[i][counter]);
            }
            result[counter++] = temp;
            printArray(temp);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = result[i][j];
            }
        }

    }

    static void printArray(int[] arr) {
        String str = "";
        for (int i : arr) {
            str += i + ",";
        }
        System.out.println(str);
    }

    public static void main(String[] args) {

        rotate(new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } });

    }
}

/*
 * 5 2 13 15
 * 1 4 3 14
 * 9 8 6 12
 * 11 10 7 16
 * 
 * 
 * 
 */
