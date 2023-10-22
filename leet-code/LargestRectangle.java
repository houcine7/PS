import java.lang.reflect.Array;
import java.util.Stack;

public class LargestRectangle {
    public int largestRectangle(int[] heights) {

        int maxArea = 0;
        Stack<int[]> st = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            int start_idx = i;
            while (!st.isEmpty() && st.peek()[1] > heights[i]) {
                int[] prev = st.pop();
                maxArea = Math.max(maxArea, (i - prev[0]) * prev[1]);
                start_idx = prev[0];
            }
            st.add(new int[] { start_idx, heights[i] });
        }

        while (!st.isEmpty()) {

            int[] temp = st.pop();
            maxArea = Math.max(maxArea, (heights.length - temp[0]) * temp[1]);
        }

        return maxArea;

    }

}
