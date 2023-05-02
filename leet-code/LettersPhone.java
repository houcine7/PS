import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LettersPhone {

    public static List<String> mapDigits(String digits) {

        Map<Character, String> mp = Map.of('1', "1", '2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7',
                "pqrs", '8', "tuv", '9', "wxyz");

        List<String> list = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();

        queue.add("");

        while (!queue.isEmpty()) {

            // System.out.println(queue.toString());
            //
            String s = queue.remove();

            if (s.length() == digits.length()) {
                list.add(s);

            } else {

                String value = mp.get(digits.charAt(s.length()));
                for (char c : value.toCharArray()) {
                    queue.add(s + c);
                }

            }
        }

        // System.out.println(list.toString());

        return list;

    }

    public static void main(String[] args) {
        mapDigits("23");
    }
}
