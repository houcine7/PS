import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Temperature {

    public class Nam<T extends Naj> {

    }

    public class Naj {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty()
                    && temperatures[i] > temperatures[st.peek()]) {
                int prev = st.pop();
                ans[prev] = i - prev;
            }
            st.add(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Temperature tp = new Temperature();
    }

}
