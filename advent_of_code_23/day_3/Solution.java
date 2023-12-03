package day_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
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
            // String test1 =
            // ".........874.772...........787..........556.....292......141................910............54...............................................";
            // System.out.println(Arrays.toString(readFullNumber(test1, 9)));

            int total = 0;
            for (int i = 0; i < lines.size(); i++) {
                // line
                // iterate through the line
                String item = lines.get(i);
                int start = 0;
                while (start < item.length()) {
                    if (isDigit(item.charAt(start))) {

                        int[] ans = readFullNumber(item, start);
                        System.out.println(Arrays.toString(ans));
                        int left = ans[1];
                        int right = ans[2];

                        if (left - 1 >= 0 && isSymbol(item.charAt(left - 1))) {
                            System.out.println("1");
                            total += ans[0];
                            start = right + 2;
                            continue;
                        }

                        if (right + 1 < item.length() && isSymbol(item.charAt(right + 1))) {
                            System.out.println("3");
                            total += ans[0];
                            start = right + 2;
                            continue;
                        }

                        if (i - 1 >= 0) {
                            System.out.println("4");
                            String above = lines.get(i - 1);
                            boolean foundedSymbole = false;
                            for (int a = left - 1; a <= right + 1; a++) {
                                if (a >= 0 && a < above.length() && isSymbol(above.charAt(a))) {
                                    total += ans[0];
                                    start = right + 2;
                                    foundedSymbole = true;
                                    break;
                                }
                            }
                            if (foundedSymbole)
                                continue;
                        }

                        if (i + 1 < lines.size()) {
                            System.out.println("5");
                            String above = lines.get(i + 1);
                            boolean foundedSymbole = false;
                            for (int a = left - 1; a <= right + 1; a++) {
                                System.out.println(a);
                                if (a >= 0 && a < above.length() && isSymbol(above.charAt(a))) {
                                    total += ans[0];
                                    start = right + 2;
                                    foundedSymbole = true;
                                    break;
                                }
                            }
                            if (foundedSymbole)
                                continue;
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
}
