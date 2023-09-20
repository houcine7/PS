import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordBreak {

    static boolean breakWord(String s, List<String> wordDict) {

        // This has a complexity of (n*3)
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

        return seen[s.length()];
    }

    // with dp approach
    public static boolean breakWord2(String s, List<String> wordDir) {
        //
        int[] mem = new int[s.length()];
        Arrays.fill(mem, -1);
        return dp(s, wordDir, mem, s.length() - 1);
    }

    private static boolean dp(String s, List<String> wordDir, int[] mem, int i) {
        if (i < 0)
            return true;
        if (mem[i] != -1)
            return mem[i] == 1;

        for (String word : wordDir) {

            if (i - word.length() + 1 < 0) {
                continue;
            }

            System.out.println("WORD:" + word);
            System.out.println(s.substring(i - word.length() + 1, i + 1));

            if (s.substring(i - word.length() + 1, i + 1).equals(word) && dp(s, wordDir, mem, i - word.length())) {

                mem[i] = 1;
                System.out.println("WORD2:" + word);
                return true;
            }

        }

        mem[i] = 0;
        return false;

    }

    private static boolean wordBreakDp(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length()];
        Set<String> words = new HashSet<>(wordDict);

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || dp[j - 1]) {
                    if (words.contains(s.substring(j, i + 1))) {
                        dp[i] = true;
                    }
                }

            }
        }

        return dp[s.length() - 1];
    }

    public static void main(String[] args) {

        List<String> ls = new ArrayList<>();

        ls.add("car");
        ls.add("ca");
        ls.add("rs");

        System.out.println(breakWord2("cars", ls));
    }

}
