import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * suggestionSys
 */
public class suggestionSys {

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> suggestions = new ArrayList<>();

        Arrays.sort(products);
        int i = 1;

        while (i <= searchWord.length()) {
            String subSearch = searchWord.substring(0, i);
            System.out.println(subSearch);

            int j = 0;
            List<String> str = new ArrayList<>();
            while (j < products.length) {
                if (products[j].startsWith(subSearch)) {
                    str.add(products[j]);
                }

                j++;
                if (str.size() == 3)
                    break;
            }
            suggestions.add(str);
            i++;
        }

        return suggestions;
    }

    public static void main(String[] args) {
        String[] suggestions = new String[] { "mobile", "mouse", "moneypot", "monitor", "mousepad" };

        System.out.println(suggestedProducts(suggestions, "mouse"));
    }
}
