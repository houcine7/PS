import java.util.HashMap;
import java.util.Map;

public class Permutation {

    public boolean permutation(String s1, String s2) {
        int n = s1.length();

        if (n > s2.length())
            return false;

        Map<Character, Integer> countMp = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();
        for (char c : "azertyuiopqsdfghjklmwxcvbn".toCharArray()) {
            countMp.put(c, 0);
            count2.put(c, 0);
        }

        for (char c : s1.toCharArray()) {
            countMp.put(c, countMp.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            count2.put(s2.charAt(i), count2.getOrDefault(s2.charAt(i), 0) + 1);
            if (i >= n) {
                count2.put(s2.charAt(i - n), count2.get(s2.charAt(i - n)) - 1);
            }
            if (countMp.equals(count2)) {
                return true;
            }

        }

        return false;
    }

}
