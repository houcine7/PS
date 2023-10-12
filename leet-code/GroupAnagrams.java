import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAngrams2(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();

        for (String str : strs) {

            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String sortedString = new String(temp);

            mp.putIfAbsent(sortedString, new ArrayList<>());
            mp.get(sortedString).add(str);
        }

        System.out.println(mp);
        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : mp.entrySet()) {
            result.add(entry.getValue());
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(groupAngrams2(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }

}
