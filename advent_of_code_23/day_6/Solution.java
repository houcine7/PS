package day_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./input.txt"));
            List<String> lines = br.lines().toList();
            String time = "";
            String dis = "";

            for (String str : lines.get(0).split(":")[1].trim().split(" ")) {
                if (str.trim().length() == 0) {
                    continue;
                }
                time += str;
            }

            for (String str : lines.get(1).split(":")[1].trim().split(" ")) {
                if (str.trim().length() == 0) {
                    continue;
                }
                dis += str;
            }

            Long intTime = Long.parseLong(time);
            Long intDis = Long.parseLong(dis);
            int total = 0;

            int mid = (int) (intTime / 2);

            ExecutorService executor = Executors.newFixedThreadPool(2);

            for (int j = 1; j < intTime; j++) {
                long left_ms = intTime - j;
                // System.out.println("LEFT ms: " + left_ms);
                long mm_to_pass = left_ms * j;

                if (mm_to_pass > intDis) {
                    // System.out.println("DISTANCE : " + intDis);
                    // System.out.println("MM TO PASS " + mm_to_pass);
                    // System.out.println("HOLDING MS: " + j);
                    total++;
                }
            }

            System.out.println(total);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            ;
        }
    }

}
