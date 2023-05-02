import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.lang.Character;
import java.util.concurrent.atomic.AtomicReference;

public class Solution {

    public int lengthOfLongestSubstring(String s) {

        Map<String, Integer> mp = new HashMap<>();

        int maxLength = -1;
        for (int i = 1; i < s.length(); i++) {

            int counter = 1;
            String subStr = s.substring(0, i);

            String lefteString = s.substring(i);

            // System.out.println(lefteString);

            while (lefteString.length() != 0) {
                if (lefteString.contains(subStr)) {
                    counter++;
                    int indexElemetn = lefteString.indexOf(subStr);

                    lefteString = lefteString.substring(0, indexElemetn) + lefteString.substring(indexElemetn + i);
                    if (lefteString == "")
                        mp.put(subStr, counter);
                    maxLength = Math.max(maxLength, counter);
                } else {
                    mp.put(subStr, counter);
                    maxLength = Math.max(maxLength, counter);
                    break;
                }
                ;
            }
        }

        final int max = maxLength;
        mp.put(s, 1);
        AtomicReference<String> longestSubString = new AtomicReference<>("");
        mp.forEach((key, val) -> {
            if (val == max && longestSubString.get().length() < key.length()) {
                longestSubString.set(key);
                ;
            }
        });
        ;

        System.out.println(mp);

        return longestSubString.get().length();

    }

    public int longestSubStringNore(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int rigth = 0; rigth < s.length(); rigth++) {
            //
            if (!set.contains(s.charAt(rigth))) {
                set.add(s.charAt(rigth));
                maxLength = Math.max(maxLength, rigth - left + 1);
            } else {
                while (s.charAt(rigth) != s.charAt(left)) {

                    set.remove(s.charAt(left));
                    left++;
                }

                set.remove(s.charAt(left));
                left++;
                set.add(s.charAt(rigth));
            }

        }
        return maxLength;

    }

    public static void main(String[] args) {

        Solution s = new Solution();

        System.out.println(s.longestSubStringNore("abcabcdfhd"));

    }

}
