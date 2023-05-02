public class MarchngStr {

    public static boolean matchRegex(String s, String p) {

        if (s.length() != p.length() && !p.contains("*")) {
            return false;
        }

        String str = "";
        for (int i = 0; i < p.length(); i++) {
            //

            System.out.println(i + "--------" + str);
            if (p.charAt(i) == '*') {

                if (s.charAt(i % s.length()) == str.charAt(i - 1) || p.charAt(i - 1) == '.') {
                    // System.out.println("heere");
                    str += s.charAt(i % s.length());
                } else if (p.length() > s.length() && str.charAt(i - 1) != s.charAt(i - 1)) {
                    if (i - 1 > 0) {
                        str = str.substring(0, i - 1) + " " + str.substring(i + 1, str.length());
                    } else {
                        str = "";
                    }

                }

                else {
                    return false;
                }
            } else if (p.charAt(i) == '.') {
                str += s.charAt(i % s.length());
            }

            else {
                str += p.charAt(i);
            }

        }

        System.out.println(str);
        return false;
    }

    public static boolean isMatch(String s, String p) {

        if (p.length() == 0)
            return s.length() == 0;

        boolean match = (s.length() == 0) ? false : ((p.charAt(0) == '.') || s.charAt(0) == p.charAt(0));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            //
            return isMatch(s, p.substring(2)) || (match && isMatch(s.substring(1), p));
        } else {
            return match && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(MarchngStr.isMatch("aa", "a*"));
    }
}
