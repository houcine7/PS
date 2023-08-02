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

    public static void sol2(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            int j = 0;
            int k = n - 1;

            while (j < k) {
                int holder = matrix[j][i];

                // System.out.println("holder :" + holder);
                matrix[j][i] = matrix[k][i];
                matrix[k][i] = holder;
                // printArray(matrix[j]);
                j++;
                k--;
            }
        }
        printArray(matrix[0]);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

                // System.out.println(matrix[i][j]);
            }
        }

        // printArray(matrix[0]);
    }

    static void printArray(int[] arr) {
        String str = "";
        for (int i : arr) {
            str += i + ",";
        }
        System.out.println(str);
    }

    public static void main(String[] args) {

        sol2(new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } });

    }
}

/*
 * 5 2 13 15
 * 1 4 3 14
 * 9 8 6 12
 * 11 10 7 16
 * 
 * 
 * 5 1 9 11
 * 2 4 8 10
 * 13 3 6 7
 * 15 14 12 16
 * 
 * 
 * 15 14 12 16
 * 13 3 6 7
 * 2 4 8 10
 * 5 1 9 11
 * 
 * 
 */
