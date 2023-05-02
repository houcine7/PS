import java.util.Map;

public class RomanToInteger {

    public static int romanToInteger(String s) {

        /*
         * (1, "I", 5, "V", 10, "X", 50, "L", 100, "C",500, "D", 1000, "M");
         */
        Map<Character, Integer> mp = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            //
            if (i + 1 < s.length() && mp.get(s.charAt(i)) < mp.get(s.charAt(i + 1))) {
                //
                number += mp.get(s.charAt(i + 1)) - mp.get(s.charAt(i));
                i += 1;
            } else {
                number += mp.get(s.charAt(i));

            }

        }

        System.out.println(number);
        return 0;
    }

    public static void main(String[] args) {

        romanToInteger("MCMXCIV");
    }

}
