package day_10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public static void main(String[] ags) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("./input.txt"));

            String line;
            StringBuilder input = new StringBuilder();
            while ((line = bf.readLine()) != null) {
                input.append(line).append("\n");
            }

            String[] grid = input.toString().trim().split("\n");
            int[] posStart = new int[2];

            for (int row = 0; row < grid.length; row++) {
                boolean startFounded = false;
                for (int col = 0; col < grid[row].length(); col++) {
                    if (grid[row].charAt(col) == 'S') {
                        posStart[0] = row;
                        posStart[1] = col;
                        startFounded = true;
                        break;
                    }
                }
                if (startFounded) {
                    break;
                }
            }
            // System.out.println(Arrays.toString(posStart));
            Queue<int[]> queue = new LinkedList<>();
            Set<String> seen = new HashSet<>();

            queue.add(posStart);
            seen.add(posStart[0] + "," + posStart[1]);

            while (!queue.isEmpty()) {
                //
                int[] currPos = queue.poll();

                int r = currPos[0], c = currPos[1];

                char ch = grid[r].charAt(c);

                if (r > 0 && "S|JL".indexOf(ch) != -1 && "|7F".indexOf(grid[r - 1].charAt(c)) != -1 &&
                        !seen.contains((r - 1) + "," + c)) {
                    seen.add((r - 1) + "," + c);
                    queue.add(new int[] { r - 1, c });
                }

                if (r < grid.length - 1 && "S|7F".indexOf(ch) != -1 && "|JL".indexOf(grid[r + 1].charAt(c)) != -1 &&
                        !seen.contains((r + 1) + "," + c)) {
                    seen.add((r + 1) + "," + c);
                    queue.add(new int[] { r + 1, c });
                }

                if (c > 0 && "S-J7".indexOf(ch) != -1 && "-LF".indexOf(grid[r].charAt(c - 1)) != -1 &&
                        !seen.contains(r + "," + (c - 1))) {
                    seen.add(r + "," + (c - 1));
                    queue.add(new int[] { r, c - 1 });
                }

                if (c < grid[r].length() - 1 && "S-LF".indexOf(ch) != -1 && "-J7".indexOf(grid[r].charAt(c + 1)) != -1
                        &&
                        !seen.contains(r + "," + (c + 1))) {
                    seen.add(r + "," + (c + 1));
                    queue.add(new int[] { r, c + 1 });
                }
            }
            System.out.println(seen.size() / 2);
            bf.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
