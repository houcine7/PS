import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvalPRN {

    public static int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();
        Set<String> oper = new HashSet<>();
        oper.add("+");
        oper.add("-");
        oper.add("*");
        oper.add("/");

        for (int i = 0; i < tokens.length; i++) {
            if (!oper.contains(tokens[i])) {
                st.add(Integer.parseInt(tokens[i]));
            } else {
                System.out.println(st);
                int total = 0;
                int val1 = st.pop();
                int val2 = st.pop();
                switch (tokens[i]) {
                    case "+":
                        total = val2 + val1;
                        break;
                    case "-":
                        total = val2 - val1;
                        break;
                    case "*":
                        total = val2 * val1;
                        break;
                    case "/":
                        total = val2 / val1;
                    default:
                        break;
                }
                st.add(total);
            }
        }

        return st.pop();

    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] { "2", "1", "+", "3", "*" }));
    }
}
