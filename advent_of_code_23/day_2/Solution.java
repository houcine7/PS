package day_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    static final Map<String, Integer> count = Map.of("red", 12, "green", 13, "blue", 14);

    public static int countWordGameNumber(String str) {
        int min_green = Integer.MIN_VALUE, min_red = Integer.MIN_VALUE, min_blue = Integer.MIN_VALUE;
        if (str.length() == 0)
            return 0;
        String gameInfo = str.split(":")[0];
        String[] sets = str.split(":")[1].split(";");
        for (String set : sets) {
            String[] colors = set.split(",");
            for (String color : colors) {
                String[] revealed = color.split(" ");
                // System.out.println(Arrays.toString(revealed));
                if (revealed[2].equals("red")) {
                    min_red = Math.max(Integer.parseInt(revealed[1]), min_red);
                } else if (revealed[2].equals("green")) {
                    min_green = Math.max(Integer.parseInt(revealed[1]), min_green);
                } else if (revealed[2].equals("blue")) {
                    min_blue = Math.max(Integer.parseInt(revealed[1]), min_blue);
                } else {
                    System.out.println(Arrays.toString(revealed));
                }
            }
        }
        System.out.println(min_blue + " " + min_green + " " + min_red);
        return min_blue * min_red * min_green;
    }

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
            AtomicInteger totalCounter = new AtomicInteger();

            br.lines().forEach((line) -> {
                int cnt = countWordGameNumber(line);
                totalCounter.addAndGet(cnt);
            });
            br.close();
            System.out.println(totalCounter.get());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
