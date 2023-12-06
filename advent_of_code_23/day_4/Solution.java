import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
            AtomicInteger index = new AtomicInteger(0);

            int[] totals = new int[201]; // n
            Arrays.fill(totals, 1);

            br.lines().forEach((line) -> {
                int matches = 0;
                String[] card = line.split(": ")[1].split(" \\| ");
                Set<Integer> st = new HashSet<>();

                for (String str : card[0].split(" ")) {
                    if (str.trim().length() > 0)
                        st.add(Integer.parseInt(str.trim()));
                }

                for (String str : card[1].split(" ")) {
                    if (str.trim().length() > 0 && st.contains(Integer.parseInt(str.trim()))) {
                        matches++;
                    }
                }

                // here we have the matchings at the scratchcards
                if (matches > 0) {
                    //
                    System.out.println("matches :" + matches);
                    int i = index.get() + 1;
                    for (; +i <= index.get() + matches && i < totals.length; i++) {
                        totals[i] += 1 * totals[index.get()];
                    }
                    System.out.println(Arrays.toString(totals));
                }

                index.incrementAndGet();

            });

            System.out.println(index.get());

            br.close();
            int ans = 0;
            for (int i = 0; i < totals.length; i++) {
                ans += totals[i];
            }
            System.out.println(ans);

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}