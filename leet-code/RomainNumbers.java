import java.util.HashMap;
import java.util.Map;

/*
 * 
V             5
X             10
L             50
C             100
D             500
M             1000
 */
public class RomainNumbers {

    public static String intToRomain(int number) {
        //
        // Map<Integer, String> mp = Map.of(1, "I", 5, "V", 10, "X", 50, "L", 100, "C",
        // 500, "D", 1000, "M");

        String str = "";
        while (number - 1000 >= 0) {
            str += "M";
            number -= 1000;

        }

        if (number - 900 >= 0) {
            str += "CM";
            number -= 900;
        }

        while (number - 500 >= 0) {
            str += "D";
            number -= 500;

        }

        if (number - 400 >= 0) {
            str += "CD";
            number -= 400;
        }
        while (number - 100 >= 0) {
            str += "C";
            number -= 100;
        }
        if (number - 90 >= 0) {
            str += "XC";
            number -= 90;
        }

        while (number - 50 >= 0) {
            str += "L";
            number -= 50;
        }
        if (number - 40 >= 0) {
            str += "XL";
            number -= 40;
        }
        while (number - 10 >= 0) {
            str += "X";
            number -= 10;
        }
        if (number - 9 >= 0) {
            str += "IX";
            number -= 9;
        }
        while (number - 5 >= 0) {
            str += "V";
            number -= 5;
        }
        if (number - 4 >= 0) {
            str += "IV";
            number -= 400;
        }
        while (number - 1 >= 0) {
            str += "I";
            number -= 1;
        }

        System.out.println(str);
        return str;

    }

    public static void main(String[] args) {
        RomainNumbers.intToRomain(1994);
    }
}