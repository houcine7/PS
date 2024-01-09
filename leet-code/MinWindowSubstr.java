import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstr {

    /*
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: "BANC" includes 'A', 'B', and 'C'
     * from string t.
     */

    public static String minWindow(String s, String t) {

        Map<Character, Integer> counter = new HashMap<>();
        for (char c : t.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        int left = 0, matched = 0;
        int min = s.length() + 1;
        int subStr = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // System.out.println(s.charAt(left));
            if (counter.containsKey(c)) {
                counter.put(c, counter.get(c) - 1);
                // System.out.println("THE counter map after susbstructing :" + counter);
                if (counter.get(c) == 0)
                    matched++;
            }

            while (matched == counter.size()) {
                if (min > right - left + 1) {
                    min = right - left + 1;
                    subStr = left;
                }
                char deleted = s.charAt(left++);
                System.out.println(deleted);
                if (counter.containsKey(deleted)) {
                    if (counter.get(deleted) == 0)
                        matched--;
                    counter.put(deleted, counter.get(deleted) + 1);
                }
                // System.out.println("counter after deleting :" + counter);

            }
        }

        if (min > s.length())
            return "";
        return s.substring(subStr, subStr + min);

    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        System.out.println(minWindow(s, t));

    }
}
