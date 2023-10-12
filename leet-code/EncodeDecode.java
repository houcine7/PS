import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

    public String encode(String[] strs) {
        String encodedValue = "";
        for (String str : strs) {
            String delimiter = str.length() + "#";
            encodedValue += delimiter + str;
        }
        return encodedValue;
    }

    public List<String> decode(String str) {

        int i = 0;
        List<String> ans = new ArrayList<>();
        while (i < str.length()) {
            int j = i;
            int len = 0;
            while (str.charAt(j) != '#') {
                len += Integer.parseInt("" + str.charAt(j));
                j++;
            }
            String result = "";
            for (int k = j + 1; k < +j + 1 + len; k++) {
                result += str.charAt(k);
            }
            ans.add(result);
            i = j + 1 + len;
        }

        return ans;
    }

    public static void main(String[] args) {
        EncodeDecode ed = new EncodeDecode();

        System.out.println(ed.encode(new String[] { "le#et#", "code@", "#premium", "sik#e" }));
        System.out.println(ed.decode(ed.encode(new String[] { "le#et#", "code@", "#premium", "sik#e" })));
    }

}
