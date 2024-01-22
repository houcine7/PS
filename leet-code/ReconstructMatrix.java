import java.util.*;

public class ReconstructMatrix {
    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        /*
         * m[0][j] + m[1][j] == col[j];
         */

        List<List<Integer>> res = new ArrayList<>();

        initList(res, colsum.length);

        int sumUpper = 0;
        int sumLower = 0;

        for (int i = 0; i < colsum.length; i++) {
            switch (colsum[i]) {
                case 0:
                    res.get(0).set(i, 0);
                    res.get(1).set(i, 0);
                    break;
                case 2:
                    res.get(0).set(i, 1);
                    res.get(1).set(i, 1);
                    sumUpper++;
                    sumLower++;
                    if (sumUpper > upper || sumLower > lower) {
                        res.clear();
                        return res;
                    }
                    break;
            }
        }

        for (int i = 0; i < colsum.length; i++) {
            switch (colsum[i]) {
                case 1:
                    if (sumUpper < upper) {
                        sumUpper++;
                        res.get(0).set(i, 1);
                    } else if (sumLower < lower) {
                        res.get(1).set(i, 1);
                        sumLower++;
                    } else {
                        res.clear();
                        return res;
                    }
                    break;
            }
        }

        if (sumLower != lower || sumUpper != upper)
            res.clear();

        return res;
    }

    public static void initList(List<List<Integer>> res, int n) {
        for (int i = 0; i < 2; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            res.add(row);
        }

    }

    public static void main(String[] args) {
        int lower = 2;
        int upper = 2;
        int[] colsum = new int[] { 1, 1, 1 };

        System.out.println(reconstructMatrix(upper, lower, colsum));

    }
}
