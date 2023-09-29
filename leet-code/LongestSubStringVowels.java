import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestSubStringVowels {

    public static boolean vowelsInEvenCount(String str) {
        //
        Map<Character, Integer> mp = new HashMap<>();

        mp.put('a', 0);
        mp.put('e', 0);
        mp.put('i', 0);
        mp.put('o', 0);
        mp.put('u', 0);

        for (char c : str.toCharArray()) {
            if (mp.containsKey(c)) {
                mp.put(c, mp.get(c) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            if (entry.getValue() % 2 != 0)
                return false;
        }

        return true;
    }

    public static int findTheLongestSubstring(String s) {

        Set<String> result = new HashSet<>();
        // for (int i = 0; i < s.length(); i++) {
        backTracking(s, 0, s.length(), result);
        // }

        System.out.println(result.size());
        int max = Integer.MIN_VALUE;
        for (String st : result) {
            if (vowelsInEvenCount(st)) {
                max = Math.max(max, st.length());
            }
        }

        return max;

    }

    private static void backTracking(String s, int start, int end, Set<String> possibleSubString) {

        // System.out.println(curr);
        if (start >= end) {
            return;
        }
        possibleSubString.add(s.substring(start, end));
        backTracking(s, start, end - 1, possibleSubString);

        backTracking(s, start + 1, end, possibleSubString);

    }

    private static int findLongestSubstring(String s) {
        HashMap<String, Integer> indexes = new HashMap<>();
        Map<Character, Integer> vowels = new HashMap<>() {
            {
                put('a', 0);
                put('e', 1);
                put('i', 2);
                put('o', 3);
                put('u', 4);
            }
        };

        String evenOdd = "00000";
        indexes.put(evenOdd, -1);

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            boolean it = vowels.containsKey(currChar);
            System.out.println(currChar);
            if (it != false) {
                if (evenOdd.charAt(vowels.get(currChar)) == '0') {
                    evenOdd = evenOdd.substring(0, vowels.get(currChar)) + '1'
                            + evenOdd.substring(vowels.get(currChar) + 1);
                } else {
                    evenOdd = evenOdd.substring(0, vowels.get(currChar)) + '0'
                            + evenOdd.substring(vowels.get(currChar) + 1);
                }
            }

            System.out.println(indexes);
            if (!indexes.containsKey(evenOdd)) {
                indexes.put(evenOdd, i);
            } else {
                System.out.println(evenOdd);
                max = Math.max(max, i - indexes.get(evenOdd));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLongestSubstring("eleetminicoworoep"));
    }

}
