import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimilarStrings {

    public int similarStrings(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs.length - 1; i++) {
            Set<Character> st = new HashSet<>();
            for (char cr1 : strs[i].toCharArray()) {
                st.add(cr1);
            }

            for (int j = i + 1; j < strs.length; i++) {
                boolean exists = true;
                for (char cr2 : strs[j].toCharArray()) {
                    if (!st.contains(cr2)) {
                        exists = false;
                        break;
                    }
                }

                if (exists) {
                    count++;
                }
            }
        }

        return count;

    }
}