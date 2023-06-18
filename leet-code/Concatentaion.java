import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Concatentaion {

    public static List<Integer> findSubString(String s, String[] words) {

        int index = 0;
        int n = words[0].length() * words.length;
        List<Integer> result = new ArrayList<>();

        while (s.length() - index >= n) {
            if (isConcatentaion(s.substring(index, index + n), words)) {
                result.add(index);
            }

            index += 1;
            System.out.println(index);

        }

        System.out.println(result.toString());
        return result;
    }

    public static boolean isConcatentaion(String str, String[] words) {

        int n = words[0].length();

        if (str.length() != n * words.length) {
            return false;
        }

        for (String word : words) {
            if (!str.contains(word)) {
                return false;
            } else {
                System.out.println(word);
                str = str.replaceFirst(word, " ");
                System.out.println(str);
            }
        }

        return true;
    }

    public static List<Integer> findSubString2(String s, String[] words) {

        final Map<String, Integer> counts = new HashMap<>();

        for (final String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        final List<Integer> indexes = new ArrayList<>();

        final int n = s.length(), num = words.length, len = words[0].length();

        for (int i = 0; i < n - num * len + 1; i++) {

            final Map<String, Integer> seen = new HashMap<>();

            int j = 0;

            while (j < num) {

                final String word = s.substring(i + j * len, i + (j + 1) * len);

                if (counts.containsKey(word)) {

                    seen.put(word, seen.getOrDefault(word, 0) + 1);

                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }

                } else {
                    break;
                }

                j++;
            }

            if (j == num) {
                indexes.add(i);
            }
        }
        return indexes;

    }

    public static List<Integer> findstrBugFix(String s, String[] words) {
        //
        final List<Integer> result = new ArrayList<>();
        final Map<String, Integer> count = new HashMap<>();
        // map each word to occurence number in words array
        for (String w : words) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }
        final int n = s.length(), num = words.length, len = words[0].length();

        for (int i = 0; i < n - num * len + 1; i++) {
            //
            final Map<String, Integer> current = new HashMap<>();
            int j = 0;
            while (j < num) {

                final String word = s.substring(i + j * len, i + (j + 1) * len);

                if (count.containsKey(word)) {

                    current.put(word, current.getOrDefault(word, 0) + 1);

                    if (current.get(word) > count.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                result.add(i);
            }
        }
        return result;

    }

    public static void main(String[] args) {

        System.out
                .println(findstrBugFix("barfoothefoobarman", new String[] { "foo", "bar" }));

        // System.out.println(findSubString("foobarthekdjfdkjbarfoothefoobar", new
        // String[] { "the", "foo", "bar" }));

    }

}
