import java.util.HashMap;
import java.util.Map;

public class IsVPalindrom {

    static boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isAlphabet(s.charAt(i))) {
                System.out.println(s.charAt(i));
                if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                    sb.append((char) (s.charAt(i) + 32));
                } else
                    sb.append(s.charAt(i));
            }
        }

        String stClean = sb.toString();
        return stClean.equals(sb.reverse().toString());

    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
            counter.put(t.charAt(i), counter.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (int val : counter.values()) {
            if (val != 0)
                return false;
        }

        return true;
    }

    static boolean isAlphabet(char c) {
        // System.out.println(c);
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        Map<Integer, Integer> mp = new HashMap<>();
        System.out.println(isPalindrome("0P"));
    }

}
