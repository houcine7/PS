import java.util.Stack;

import javax.security.auth.Subject;

public class LogestValideParntheses {

    // brute force implementation
    private static int longestValideParnthesesBR(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isValidParanteheses(s.substring(i, j + 1))) {
                    maxLen = Math.max(maxLen, j + 1 - i);
                }
            }
        }
        return maxLen;
    }

    //

    public static boolean isValidParanteheses(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    // dynamic approach
    private static int longestValideParnthesesDP(String s) {

        int[] arr = new int[s.length()];
        int maxLen = 0;
        //
        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    arr[i] = (i >= 2 ? arr[i - 2] : 0) + 2;

                } else if (i - arr[i - 1] - 1 >= 0) {
                    int expectedOpeningIndex = i - arr[i - 1] - 1;
                    if (s.charAt(expectedOpeningIndex) == '(') {
                        arr[i] = arr[i - 1] + (i - arr[i - 1] - 2 >= 0 ? arr[i - arr[i - 1] - 2] : 0) + 2;
                    }
                }
                maxLen = Math.max(maxLen, arr[i]);
            }
        }
        return maxLen;
    }

    private static int longestValideParnthesesStack(String s) {

        int maxLen = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - st.peek());
                }

            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestValideParnthesesStack("()(()())"));
    }

}

/*
 * (()
 * 
 * 
 */
