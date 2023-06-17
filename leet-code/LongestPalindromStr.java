import java.util.Arrays;

public class LongestPalindromStr {

    public String longestPalindrom(String s) {

        String longestString = "";
        for (int i = 0; i < s.length(); i++) {
            //
            for (int j = i + 1; j < s.length(); j++) {
                //
                if (s.charAt(i) == s.charAt(j)) {
                    StringBuilder subStr = new StringBuilder(s.substring(i, j + 1));
                    if (subStr.toString().equals(subStr.reverse().toString())) {
                        if (subStr.length() > longestString.length()) {
                            longestString = subStr.toString();
                        }
                    }
                }
            }
        }
        // System.out.println(longestString);
        return longestString;
    }

    public String longestPalindrom2(String s, int begin, int curr) {

        String longestString = "";

        while (begin >= 0 && curr < s.length() && s.charAt(curr) == s.charAt(begin)) {
            //
            begin--;
            curr++;

        }

        System.out.println(longestString);
        return longestString;

    }

    public String longestPalindrome(String s) {
        int n = s.length();

        if (n < 2)
            return s;

        int maxLength = 1, start = 0;
        int low, high;

        for (int i = 0; i < n; i++) {
            //

            high = i + 1;
            low = i - 1;

            while (low >= 0 && s.charAt(i) == s.charAt(low)) {
                //
                low--;
            }

            while (high < n && s.charAt(i) == s.charAt(high)) {
                high++;
            }

            while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }

            int length = high - low - 1;
            if (maxLength < length) {
                maxLength = length;
                start = low + 1;
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {

        LongestPalindromStr lp = new LongestPalindromStr();

        int[] arr = new int[] { 1, 3, 5 };

        Arrays.asList(arr);

        System.out.println(lp.longestPalindrome("babadac"));
    }

}
