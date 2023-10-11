import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsackPrb {
    public static int maximizing_total_value(int[][] arr, int w) { // arr[values][weights]

        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                double temp1 = (double) o1[0] / (double) o1[1];
                double temp2 = (double) o2[0] / (double) o1[1];

                if (temp1 > temp2)
                    return 1;
                else if (temp1 < temp2)
                    return -1;
                else
                    return 0;
            }
        });

        double result = 0;
        for (int[] item : arr) {
            if (item[1] <= w) {
                result += item[0];
                w -= item[1];
            } else {
                double fraction = (double) w / (double) item[1];
                w *= fraction;
                result += item[0] * fraction;
                break;
            }
        }

        System.out.println(Arrays.deepToString(arr));
        System.out.println(result);
        return (int) result;
    }

    public static double[] maximizing_total_values_w_queries(int[][] arr, int[] queries) { // arr[weights][values]
        double[] result = new double[queries.length];

        // sort the array
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                double fr1 = (double) o1[1] / (double) o1[0];
                double fr2 = (double) o2[1] / (double) o2[0];

                if (fr1 < fr2)
                    return 1;
                else if (fr1 > fr2)
                    return -1;
                else
                    return 0;
            }
        });

        int k = 0;
        for (int w : queries) {
            double subResult = 0;

            for (int[] item : arr) {

                if (w == 0)
                    break;

                if (item[0] <= w) {
                    subResult += item[1];
                    w -= item[0];
                } else {
                    double fr = (double) item[0] / (double) w;
                    subResult += fr * item[1];
                    break;
                }
            }
            result[k++] = subResult;

        }

        System.out.println(Arrays.toString(result));

        return result;
    }

    public static void main(String[] args) {
        // maximizing_total_value(new int[][] { { 100, 20 }, { 120, 30 }, { 60, 10 } },
        // 50);
        maximizing_total_values_w_queries(new int[][] { { 1, 2 }, { 1, 3 }, { 3, 7 } }, new int[] { 1, 2, 3, 4, 5 });

    }
}
