import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WonderfulString {

    public long wonderfulStringBase(String s) {
        long[] count = new long[1024];
        long res = 0;
        int mask = 0; // the mask first is null

        count[0] = 1;

        for (char c : s.toCharArray()) {
            mask = mask ^ 1 << (c - 'a'); // ( MASK XOR 2^(position of char in the alphabet with 0 indexed))
            res += count[mask];

            for (int i = 0; i < 10; i++) {
                res += count[mask ^ (1 << i)];
            }

            count[mask]++;
        }

        return res;
    }

    // CORRECT RESULTS BUT VERY LOW ==> incorrect method
    public long wonderfulString(String s) {

        int counter = s.length();
        for (int x = 0; x < s.length(); x++) {
            int i = x;
            int j = 2;
            while (i + j <= s.length()) {
                String subStr = s.substring(i, i + j);
                System.out.println(subStr);
                if (isWonderful(subStr)) {
                    counter++;
                    j++;
                } else {
                    j++;
                }
            }
        }

        return counter;
    }

    public boolean isWonderful(String word) {

        Set<Character> temp = new HashSet<>();
        for (char c : word.toCharArray()) {
            if (temp.add(c)) {
                continue;
            } else {
                temp.remove(c);
            }
        }

        return temp.size() <= 1;
    }

    public static void main(String[] args) {

        System.out.println('d' - 'a');
    }

}
