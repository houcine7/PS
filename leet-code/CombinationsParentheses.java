import java.util.ArrayList;
import java.util.List;

/*
 *  ((())) => (()()) => (())()=> ()()() => ()(()) ... 
 *  (((()))) =>( () ( () ) ) 
 * 
 */

public class CombinationsParentheses {

    public static List<String> getPossibleCombiniations(int n) {
        List<String> result = new ArrayList<>();

        generateAll(new char[2 * n], 0, result);

        return result;
    }

    //
    public static void generateAll(char[] current, int pos, List<String> result) {
        //

        if (pos == current.length) {
            // check if the string new String(current) is valid or not =>
            if (isValid(new String(current))) {
                result.add(new String(current));
            }

        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public static boolean isValid(String s) {
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                balance++;
            else {
                balance--;

                if (balance < 0)
                    return false;
            }
        }

        return balance == 0;
    }

    public static List<String> possibleCombinations(int n) {

        List<String> result = new ArrayList<>();
        backtracker(result, new StringBuilder(), 0, 0, n);

        //
        return result;
    }

    private static void backtracker(List<String> result, StringBuilder curr, int open, int close, int max) {

        if (curr.length() == max * 2) {
            result.add(curr.toString());
            return;
        }

        if (open < max) {
            //
            curr.append('(');
            backtracker(result, curr, open + 1, close, max);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (close < open) {
            //
            curr.append(')');
            backtracker(result, curr, open, close + 1, max);
            curr.deleteCharAt(curr.length() - 1);
        }

    }

    public static void main(String[] args) {

        System.out.println(possibleCombinations(3));

    }

}
