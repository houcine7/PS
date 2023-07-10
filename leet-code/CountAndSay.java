import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CountAndSay {

    // not working
    public String countAndSay(int n) {

        if (n == 1)
            return "1";

        String str = "1";
        for (int i = 0; i < n - 1; i++) {

            int left = 0, right = 0;
            String holder = "";
            while (right < str.length()) {
                int counter = 0;
                while (right < str.length() && str.charAt(left) == str.charAt(right)) {
                    counter++;
                    right++;
                }

                holder += counter + "" + str.charAt(left);
                left = right;
            }

            str = holder;
            // System.out.println("HOLDER: " + holder);

        }
        // System.out.println(str);
        return str;
    }

    // recursion

    public String countSay(int n) {
        if (n == 1)
            return "1";
        String res = countSay(n - 1);
        StringBuilder str = new StringBuilder();

        int left = 0, right = 0;

        while (right < res.length()) {
            int counter = 0;

            while (right < res.length() && res.charAt(right) == res.charAt(left)) {
                counter++;
                right++;
            }

            str.append(counter);
            str.append(res.charAt(left));
            left = right;
        }

        return str.toString();

    }

    public static void main(String[] args) {
        CountAndSay cs = new CountAndSay();
        System.out.println(cs.countAndSay(6)); // 111221

    }

}
