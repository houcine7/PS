import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Temperature {

    public int[] dailyTemperatures1(int[] temp) {
        int[] answer = new int[temp.length];
        Stack<Integer> indexes = new Stack<>();

        for (int i = 0; i < answer.length; i++) {
            while (!indexes.isEmpty() && temp[i] > temp[indexes.peek()]) {
                int firstTempIndex = indexes.pop();
                answer[firstTempIndex] = i - firstTempIndex;
            }

            indexes.add(i); // adding the current index
        }
        return answer;
    }

    public static void main(String[] args) {
        Temperature tp = new Temperature();
    }

}
