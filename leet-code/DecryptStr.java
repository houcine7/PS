
public class DecryptStr {

    public static void main(String[] args) {
    }

    public String freqAlphabets(String s) {

        int aCode = (int) 'a';
        int jCode = (int) 'j';

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '#') {
                i++;
                continue;
            } else {
                System.out.println(s.charAt(i));
                if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                    int num = Integer.parseInt(s.charAt(i) + "" + s.charAt(i + 1));
                    sb.append((char) (jCode + (num - 10)));
                    i = i + 2;
                } else {
                    int num = Integer.parseInt("" + s.charAt(i));
                    sb.append((char) (aCode + (num - 1)));
                    i++;
                }
            }

        }

        return sb.toString();
    }
}
