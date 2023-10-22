import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;
        int[][] pairs = new int[n][n];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0])
                    return -1;
                else if (o1[0] > o2[0])
                    return 1;
                else
                    return 0;
            }
        });

        Stack<Double> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            double currTime = (double) (target - pairs[i][0]) / (double) pairs[i][1]; // time to reach target
            if (!st.isEmpty() && currTime <= st.peek()) {
                continue;
            }
            st.add(currTime);
        }

        return st.size();

    }
}
