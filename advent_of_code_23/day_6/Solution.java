package day_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Solution {

    static class LoopProcessor implements Callable<Integer> {
        private final long start;
        private final long end;
        private final long intTime;
        private final long intDis;

        LoopProcessor(long start, long end, long intTime, long intDis) {
            this.start = start;
            this.end = end;
            this.intTime = intTime;
            this.intDis = intDis;
        }

        @Override
        public Integer call() {
            int count = 0;
            for (long j = start; j <= end; j++) {
                long left_ms = intTime - j;
                long mm_to_pass = left_ms * j;

                if (mm_to_pass > intDis) {
                    count++;
                }
            }
            return count;
        }
    }

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

            long mid = (intTime / 2);

            ExecutorService executor = Executors.newFixedThreadPool(2);

            Future<Integer> future1 = executor.submit(new LoopProcessor(1, mid, intTime, intDis));
            Future<Integer> future2 = executor.submit(new LoopProcessor(mid + 1, intTime - 1, intTime, intDis));

            int result1 = future1.get();
            int result2 = future2.get();

            int totalResult = result1 + result2;
            System.out.println("Total Count: " + totalResult);

            executor.shutdown();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            ;
        }
    }

}
