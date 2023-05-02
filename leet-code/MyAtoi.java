import java.util.HashSet;
import java.util.Set;

public class MyAtoi {

    public static int atoi(String s) {
        //

        s = s.replace(" ", "");
        int i = 0;
        Set<Character> numbers = new HashSet<>();

        for (char c : "0123456789".toCharArray()) {
            numbers.add(c);
        }

        boolean isNegativ = s.charAt(0) == '-' ? true : false;
        boolean containsPuls = s.charAt(0) == '+' ? true : false;

        if (isNegativ || containsPuls)
            s = s.substring(1, s.length());

        if (!numbers.contains(s.charAt(0)))
            return 0;

        while (i < s.length()) {

            if (!numbers.contains(s.charAt(i))) {
                s = s.replace("" + s.charAt(i), "");
                continue;
            }
            i++;
        }

        System.out.println(s);

        if (Long.parseLong(s) > Integer.MAX_VALUE || Long.parseLong(s) < Integer.MIN_VALUE)
            return 0;

        return isNegativ ? -1 * Integer.parseInt(s) : Integer.parseInt(s);
    }

    public static int atoi2(String s) {

        String numbers = "0123456789";

        String result = "";
        int i = 0;
        boolean isNegative = false;
        s = s.trim();

        if (s.length() == 0)
            return 0;

        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            i++;
            if (s.charAt(0) == '-') {
                result = "-";
                isNegative = true;
            }
        }

        while (i < s.length()) {
            if (numbers.contains("" + s.charAt(i))) {
                result += s.charAt(i);
                i++;
            } else {
                break;
            }
        }

        if (result == "" || result == "-" || result == "+")
            return 0;

        try {
            return Integer.parseInt(result);
        } catch (Exception e) {
            // TODO: handle exception
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

    }

    public static void main(String[] args) {
        System.out.println(MyAtoi.atoi2("1a"));
    }

}
