public class MultiplayStrings {

    // not working for big nums
    public int mulStr(String num1, String num2) {
        //
        int paresedNum1 = 0;
        int paresedNum2 = 0;
        for (int i = 0; i < num1.length(); i++) {
            paresedNum1 += (num1.charAt(i) - '0') * Math.pow(10, (num1.length() - i - 1));
        }

        for (int i = 0; i < num2.length(); i++) {
            paresedNum2 += (num2.charAt(i) - '0') * Math.pow(10, (num2.length() - i - 1));
        }

        return paresedNum1 * paresedNum2;
    }

    //

    public String mulitplyStrings(String num1, String num2) {

        int[] holder = new int[num1.length() + num2.length()];

        //
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {

                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = temp + holder[i + j + 1];

                holder[i + j] += sum / 10;
                holder[i + j + 1] = sum % 10;
            }
        }

        String str = "";
        printArray(holder);
        for (int i = 0; i < holder.length; i++) {
            System.out.println(i + " holder: " + holder[i]);

            if (holder[i] == 0 && str.length() == 0)
                continue;
            str += holder[i];
        }

        if (str == "")
            return "0";
        return str;
    }

    public void printArray(int[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
        }

        System.out.println(str);
    }

    public static void main(String[] args) {
        MultiplayStrings ms = new MultiplayStrings();
        System.out.println(ms.mulitplyStrings("456", "123"));
    }

}
