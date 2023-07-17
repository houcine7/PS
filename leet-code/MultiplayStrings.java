public class MultiplayStrings {

    public int mulStr(String s1, String s2) {
        //
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            num1 += (s1.charAt(i) - '0') * Math.pow(10, (s1.length() - i - 1));
        }

        for (int i = 0; i < s2.length(); i++) {
            num2 += (s2.charAt(i) - '0') * Math.pow(10, (s2.length() - i - 1));
        }

        return num1 * num2;
    }

    public static void main(String[] args) {
        MultiplayStrings ms = new MultiplayStrings();
        System.out.println(ms.mulStr("55", "1"));
    }

}
