import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class validParntheses {

    public static boolean isVlaid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> mp = Map.of('{', '}', '[', ']', '(', ')');
        List<String> subStrings = new ArrayList<>();
        int prev = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (!mp.containsKey(s.charAt(i)) && mp.containsKey(s.charAt(i + 1))) {
                //
                System.out.println(i);
                subStrings.add(s.substring(prev, i + 1));
                prev = i + 1;
            }
        }

        subStrings.add(s.substring(prev, s.length()));

        System.out.println(subStrings);

        for (String str : subStrings) {

            for (int i = 0; i < str.length() / 2; i++) {
                if (!mp.containsKey(str.charAt(i))) {
                    return false;
                } else if (mp.get(str.charAt(i)) != str.charAt(str.length() - 1 - i)) {
                    System.out.println("......");
                    return false;
                }
            }

        }
        return true;
    }

    public static boolean isParnthesesValid(String s) {
        //

        Map<Character, Character> mp = Map.of('{', '}', '[', ']', '(', ')');
	/*{
	 * '{':'}',
	 * '[':']'
	 * '(':')'
	 * }*/
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!mp.containsKey(c)) {
                if (st.isEmpty() || mp.get(st.pop()) != c) {
                    return false;
                }
            } else {
                st.add(c);
            }

        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isParnthesesValid("{}()[()]"));

        /***
         * {} () [()]
         */
    }

}
