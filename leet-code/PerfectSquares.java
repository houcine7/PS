import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;

public class PerfectSquares {

    // it is a common thing that we we face a problem to search for the
    // most efficient criteria to solve a problem we usually use a problem

    // BFS approach
    static int perfectSquares(int n) {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        if (n > 0)
            queue.add(n);
        int counter = 0;

        while (!queue.isEmpty()) {

            counter++;
            // do level traversal
            int queue_size = queue.size();
            for (int i = 0; i < queue_size; i++) {
                int curr = queue.poll();

                int temp = (int) Math.sqrt(curr);

                for (int j = 1; j <= temp; j++) {
                    if (curr - (i * i) == 0)
                        return counter;
                    else if (visited.add(curr - i * i))
                        queue.add(curr - i * i);
                }
            }

        }

        return counter;

    }

    static public void main(String[] args) {

    }

}
