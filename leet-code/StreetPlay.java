import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreetPlay {

    public static int solve(int n, int m, int[][] lights) {
        String[] tracker = new String[n];
        Arrays.fill(tracker, "");
        for (int i = 0; i < m; i++) {
            Character color = null;
            switch (lights[i][0]) {
                case 1:
                    color = 'r';
                    break;
                case 2:
                    color = 'b';
                    break;
                case 3:
                    color = 'g';
                    break;
                default:
                    break;
            }

            for (int j = lights[i][1] - 1; j < lights[i][2]; j++) {
                tracker[j] += color;
            }
        }

        int counter = 0;

        for (String s : tracker) {
            if (s != null && s.length() == 3) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {

        System.out.println(solve(5, 7, new int[][] {
                { 1, 1, 2 },
                { 2, 1, 2 },
                { 3, 1, 2 },
                { 1, 2, 3 },
                { 3, 3, 5 },
                { 1, 4, 5 },
                { 2, 4, 5 },

        }));

    }
}