import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] str) {

        List<List<String>> result = new ArrayList<>();
        Map<Map<Character, Integer>, Integer> counter = new HashMap<>();

        for (int i = 0; i < str.length; i++) {
            String temp = str[i];
            Map<Character, Integer> count = new HashMap<>();
            for (char c : temp.toCharArray()) {
                count.put(c, count.getOrDefault(c, 0) + 1);
            }

            if (counter.containsKey(count)) {
                result.get(counter.get(count)).add(temp);
            } else {
                counter.put(count, result.size());
                List<String> t1 = new ArrayList<>();
                t1.add(str[i]);
                result.add(t1);
            }
        }

        // System.out.println(maps);
        // for (int i = 0; i < str.length; i++) {
        // List<String> tmp = new ArrayList<>();
        // if (maps.get(i) == null)
        // continue;
        // tmp.add(str[i]);

        // for (int j = i + 1; j < str.length; j++) {
        // System.out.println(maps.get(j));
        // if (maps.get(i).equals(maps.get(j))) {
        // tmp.add(str[j]);
        // maps.set(j, null);
        // }
        // }

        // result.add(tmp);
        // }

        System.out.println(result);
        return result;

    }

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