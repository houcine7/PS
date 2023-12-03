package day_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isStar(char c) {
        return c == '*';
    }

    public static boolean isSymbol(char c) {
        return !isDigit(c) && c != '.';
    }

    public static int[] readFullNumber(String str, int start) {
        String st = "";
        int i = start;
        for (; i < str.length(); i++) {
            if (!isDigit(str.charAt(i)))
                break;
            else
                st += str.charAt(i);
        }

        int[] res = new int[] { Integer.parseInt(st), start, i - 1 };
        return res;
    }

    public static int[] readFullNumberRversed(String str, int end) {
        String digit = "";
        int i = end;
        for (; i >= 0; i--) {
            if (!isDigit(str.charAt(i)))
                break;
            else
                digit = str.charAt(i) + digit;
        }
        int[] res = new int[] { Integer.parseInt(digit), i + 1, end };
        return res;
    }

    public static void main(String[] args) throws IOException {
        try {

            BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
            // AtomicInteger totalCounter = new AtomicInteger();
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();

            int total = 0;
            for (int i = 0; i < lines.size(); i++) {
                // line
                // iterate through the line
                String item = lines.get(i);
                int start = 0;

                while (start < item.length()) {
                    int ratio = 1;
                    int adjCount = 0;
                    if (isStar(item.charAt(start))) {
                        if (start + 1 < item.length() && isDigit(item.charAt(start + 1))) {
                            int[] num = readFullNumber(item, start + 1);
                            ratio *= num[0];
                            adjCount++;
                        }

                        if (start - 1 >= 0 && isDigit(item.charAt(start - 1))) {
                            int[] num = readFullNumberRversed(item, start - 1);
                            ratio *= num[0];
                            adjCount++;
                        }

                        if (i - 1 >= 0) {

                            String aboveLine = lines.get(i - 1);

                            if (start < aboveLine.length() && isDigit(aboveLine.charAt(start))) {
                                if ((start + 1 < aboveLine.length() && isDigit(aboveLine.charAt(start + 1)))
                                        && start - 1 >= 0 && isDigit(aboveLine.charAt(start - 1))) {
                                    String num = aboveLine.charAt(start - 1) + "" + aboveLine.charAt(start)
                                            + "" + aboveLine.charAt(start + 1);
                                    ratio *= Integer.parseInt(num);
                                    adjCount++;
                                } else if (start + 1 < aboveLine.length() && isDigit(aboveLine.charAt(start + 1))) {
                                    int[] num = readFullNumber(aboveLine, start);
                                    ratio *= num[0];
                                    adjCount++;
                                } else if (start - 1 >= 0 && isDigit(aboveLine.charAt(start - 1))) {
                                    int[] num = readFullNumberRversed(aboveLine, start);
                                    ratio *= num[0];
                                    adjCount++;
                                } else {
                                    ratio *= Integer.parseInt("" + aboveLine.charAt(start));
                                    adjCount++;

                                }
                            } else {
                                if (start + 1 < aboveLine.length() && isDigit(aboveLine.charAt(start + 1))) {
                                    int[] nums = readFullNumber(aboveLine, start + 1);
                                    ratio *= nums[0];
                                    adjCount++;
                                }
                                if (start - 1 >= 0 && isDigit(aboveLine.charAt(start - 1))) {
                                    int[] nums = readFullNumberRversed(aboveLine, start - 1);
                                    ratio *= nums[0];
                                    adjCount++;
                                }
                            }
                        }

                        if (i + 1 <= lines.size()) {

                            String aboveLine = lines.get(i + 1);

                            if (start < aboveLine.length() && isDigit(aboveLine.charAt(start))) {

                                if ((start + 1 < aboveLine.length() && isDigit(aboveLine.charAt(start + 1)))
                                        && start - 1 >= 0 && isDigit(aboveLine.charAt(start - 1))) {
                                    String num = aboveLine.charAt(start - 1) + "" + aboveLine.charAt(start)
                                            + "" + aboveLine.charAt(start + 1);
                                    ratio *= Integer.parseInt(num);
                                    adjCount++;
                                } else if (start + 1 < aboveLine.length() && isDigit(aboveLine.charAt(start + 1))) {
                                    int[] num = readFullNumber(aboveLine, start);
                                    ratio *= num[0];
                                    adjCount++;
                                } else if (start - 1 >= 0 && isDigit(aboveLine.charAt(start - 1))) {
                                    int[] num = readFullNumberRversed(aboveLine, start);
                                    ratio *= num[0];
                                    adjCount++;
                                } else {
                                    ratio *= Integer.parseInt("" + aboveLine.charAt(start));
                                    adjCount++;

                                }
                            } else {
                                if (start + 1 < aboveLine.length() && isDigit(aboveLine.charAt(start + 1))) {
                                    int[] nums = readFullNumber(aboveLine, start + 1);
                                    ratio *= nums[0];
                                    adjCount++;
                                }
                                if (start - 1 >= 0 && isDigit(aboveLine.charAt(start - 1))) {
                                    int[] nums = readFullNumberRversed(aboveLine, start - 1);
                                    ratio *= nums[0];
                                    adjCount++;
                                }
                            }
                        }

                        if (adjCount == 2) {
                            total += ratio;
                        }
                    }
                    start++;

                }

            }

            System.out.println(total);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // to test readfullNumber2
    // String test2 =
    // ".........874.772...........787..........556.....292......141................910............54...............................................";
    // System.out.println(Arrays.toString(readFullNumberRversed(test2, 11)));
    // PART 1
    /*
     * while (start < item.length()) {
     * if (isDigit(item.charAt(start))) {
     * 
     * int[] ans = readFullNumber(item, start);
     * System.out.println(Arrays.toString(ans));
     * int left = ans[1];
     * int right = ans[2];
     * 
     * if (left - 1 >= 0 && isSymbol(item.charAt(left - 1))) {
     * System.out.println("1");
     * total += ans[0];
     * start = right + 2;
     * continue;
     * }
     * 
     * if (right + 1 < item.length() && isSymbol(item.charAt(right + 1))) {
     * System.out.println("3");
     * total += ans[0];
     * start = right + 2;
     * continue;
     * }
     * 
     * if (i - 1 >= 0) {
     * System.out.println("4");
     * String above = lines.get(i - 1);
     * boolean foundedSymbole = false;
     * for (int a = left - 1; a <= right + 1; a++) {
     * if (a >= 0 && a < above.length() && isSymbol(above.charAt(a))) {
     * total += ans[0];
     * start = right + 2;
     * foundedSymbole = true;
     * break;
     * }
     * }
     * if (foundedSymbole)
     * continue;
     * }
     * 
     * if (i + 1 < lines.size()) {
     * System.out.println("5");
     * String above = lines.get(i + 1);
     * boolean foundedSymbole = false;
     * for (int a = left - 1; a <= right + 1; a++) {
     * System.out.println(a);
     * if (a >= 0 && a < above.length() && isSymbol(above.charAt(a))) {
     * total += ans[0];
     * start = right + 2;
     * foundedSymbole = true;
     * break;
     * }
     * }
     * if (foundedSymbole)
     * continue;
     * }
     * 
     * }
     * start++;
     * }
     * 
     */
}
