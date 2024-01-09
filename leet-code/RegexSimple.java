public class RegexSimple {

    public static boolean match(String text, String pattern) {
        int tIndex = 0, pIndex = 0;
        int wildCardIndex = -1;
        int tBacktrackIndex = -1;

        while (tIndex < text.length()) {
            if (pIndex < pattern.length() &&
                    pattern.charAt(pIndex) == text.charAt(tIndex)) {
                tIndex++;
                pIndex++;
            } else if (pIndex < pattern.length() && pattern.charAt(pIndex) == '*') {
                wildCardIndex = pIndex;
                tBacktrackIndex = tIndex;
                pIndex++;
            } else if (wildCardIndex == -1) {
                return false;
            } else {
                pIndex = wildCardIndex + 1;
                tIndex = ++tBacktrackIndex;
            }
        }

        if (pIndex != pattern.length()) {
            return false;
        }

        return true;
    }

    public static boolean match2(String str, String pattern) {
        int wildCardIndex = pattern.indexOf('*');

        System.out.println(wildCardIndex);
        int j = 0;
        for (int i = 0; i < wildCardIndex; i++) {
            if (j < str.length() && str.charAt(j) != pattern.charAt(i))
                return false;
            j++;
        }

        System.out.println("passed to here ");
        j = str.length() - 1;
        for (int i = pattern.length() - 1; i > wildCardIndex; i--) {
            System.out.println(pattern.charAt(i));
            if (j < str.length() && str.charAt(j) != pattern.charAt(i))
                return false;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(match2("baaabab", "ba*ab"));

    }
}
