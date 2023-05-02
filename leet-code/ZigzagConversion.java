public class ZigzagConversion {

    public static String convert(String str, int numRows) {

        if (str.length() < numRows) {
            return str;
        }

        String result = "";

        for (int i = 0; i <= numRows - 1; i++) {
            //
            result += str.charAt(i);

            int j = 0;
            int curr;

            // if number of rows is not odd
            if (numRows == 2) {
                curr = i + 2;
                while (curr < str.length()) {
                    result += str.charAt(curr);
                    curr += 2;
                }

            } else if (numRows % 2 != 0) {
                if (i % 2 == 0)
                    curr = numRows + 1 + i;
                else
                    curr = i + numRows - 1;
                System.out.println(curr);
                while (curr < str.length()) {
                    result += str.charAt(curr);
                    if (i % 2 == 0)
                        curr += numRows + 1;
                    else
                        curr += numRows - 1;
                }
            }
            // row number is odd

            else {
                //

                if (i == (numRows / 2) - 1) {
                    curr = i + numRows;
                } else if (i == (numRows / 2)) {
                    curr = i + (numRows / 2);
                } else {
                    curr = i + numRows + 2;
                }

                while (curr < str.length()) {

                    result += str.charAt(curr);

                    if (i == (numRows / 2) - 1) {
                        if (j % 2 == 0) {
                            curr += numRows / 2;
                            j++;
                        } else {
                            curr += numRows;
                            j++;
                        }

                    } else if (i == (numRows / 2)) {
                        if (j % 2 == 0) {
                            curr += numRows;
                            j++;
                        } else {
                            curr += numRows / 2;
                            j++;
                        }

                    } else {
                        curr += numRows + 2;
                    }
                }

            }
        }

        return result;
    }

    public static String convert2(String s, int numRows) {
        //
        if (s == null || s.isEmpty() || numRows <= 0)
            return "";

        if (numRows == 1)
            return s;

        StringBuilder result = new StringBuilder();

        int step = (2 * numRows) - 2;

        for (int i = 0; i < numRows; i++) {
            //
            for (int j = i; j < s.length(); j += step) {
                result.append(s.charAt(j));
                //
                if (i != 0 && i != numRows - 1 && (j + step - (2 * i) < s.length())) {
                    result.append(s.charAt(j + step - (2 * i)));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(ZigzagConversion.convert("PAYPALISHIRING", 4));
    }

}
