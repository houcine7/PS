import javax.print.attribute.standard.Media;

public class Median {

    public double medianArrays(int[] arr1, int[] arr2) {

        //
        int n = arr1.length;
        int m = arr2.length;

        int[] combinedTable = new int[n + m];

        /**
         * [5,8,10] [2,4]
         * 
         */

        int i = 0, j = 0, k = 0;

        while ((i < n && j < m)) {
            if (arr1[i] < arr2[j]) {
                System.out.println(arr1[i] + "::::" + arr2[j]);
                combinedTable[k++] = arr1[i++];

            } else {
                // System.out.println(arr2[j]);
                combinedTable[k++] = arr2[j++];

            }
        }

        while (i < n) {
            combinedTable[k++] = arr1[i++];
        }
        while (j < m) {
            combinedTable[k++] = arr2[j++];
        }

        double median = 0;

        if ((n + m) % 2 == 0) {
            median = Math.floor(combinedTable[(n + m) / 2] + combinedTable[((n + m) / 2) - 1]) / Math.floor(2);
        } else {
            median = combinedTable[(n + m) / 2];
        }

        System.out.println(median);

        return median;
    }

    public static void main(String[] args) {
        Median md = new Median();

        System.out.println(md.medianArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
    }

}
