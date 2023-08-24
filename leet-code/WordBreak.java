import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordBreak {

    static boolean breakWord(String s, List<String> wordDict) {

        Set<String> words = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[s.length()];

        queue.add(0);

        while (!queue.isEmpty()) {
            //
            int start = queue.poll();
            for (int end = start + 1; end < s.length(); end++) {
                if (seen[end]) {
                    continue;
                }

                if (words.contains(s.substring(start, end))) {
                    //
                    queue.add(end);
                    seen[end] = true;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        List<String> ls = new ArrayList<>();

        ls.add("car");
        ls.add("ca");
        ls.add("rs");

        System.out.println(breakWord("cars", ls));
    }

}
