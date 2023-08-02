import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] str) {

        List<List<String>> result = new ArrayList<>();
        List<Map<Character, Integer>> maps = new ArrayList<>();

        for (int i = 0; i < str.length; i++) {
            String temp = str[i];
            Map<Character, Integer> count = new HashMap<>();
            for (char c : temp.toCharArray()) {
                count.put(c, count.getOrDefault(c, 0) + 1);
            }

            maps.add(i, count);
        }

        System.out.println(maps);
        for (int i = 0; i < str.length; i++) {
            List<String> tmp = new ArrayList<>();
            tmp.add(str[i]);
            System.out.println(maps.get(i));
            for (int j = i + 1; j < str.length; j++) {
                System.out.println(maps.get(j));
                if (maps.get(i).equals(maps.get(j))) {
                    tmp.add(str[j]);
                }
            }

            result.add(tmp);
        }

        System.out.println(result);
        return result;

    }

    public static void main(String[] args) {
        groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
    }

}
