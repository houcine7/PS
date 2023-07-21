public class WildCardMatching {
    public boolean isMatch(String s, String p) {

        int curr_pattern = 0;
        for (int i = 0; i < s.length(); i++) {
            if (curr_pattern >= p.length())
                return false;
            if (p.charAt(curr_pattern) == s.charAt(i))
                curr_pattern++;
            else if (p.charAt(curr_pattern) == '?')
                curr_pattern++;
            else if (p.charAt(curr_pattern) == '*') {
                System.out.println(i);
                if (s.length() - i > p.length() - curr_pattern) {
                    continue;
                }
                curr_pattern++;
            } else
                return false;
        }

        // }

        return true;
    }

    public boolean isMatch2(String s, String p) {
        int p_pointer = 0, s_pointer = 0;
        int match = 0;
        int starIndex = -1;

        while (s_pointer < s.length()) {
            if (p_pointer < p.length() && (s.charAt(s_pointer) == p.charAt(p_pointer) || p.charAt(p_pointer) == '?')) {
                s_pointer++;
                p_pointer++;
            } else if (p_pointer < p.length() && p.charAt(p_pointer) == '*') {
                starIndex = p_pointer;
                match = s_pointer;
                p_pointer++;

            } else if (starIndex != -1) {
                p_pointer = starIndex + 1;
                match++;
                s_pointer = match;
            } else
                return false;
        }

        while (p_pointer < p.length() && p.charAt(p_pointer) == '*') {
            p_pointer++;
        }

        return p_pointer == p.length();
    }

    public static void main(String[] args) {

        WildCardMatching m = new WildCardMatching();

        System.out.println(m.isMatch2("ab", "**a*"));

    }

}
