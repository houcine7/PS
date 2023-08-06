import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestCycleInGraph {

    public static int findShortestCycle(int n, int[][] edges) {

        int result = Integer.MAX_VALUE;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(i, new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);

        }

        for (int i = 0; i < n; i++) {

            int[] distances = new int[n];
            Arrays.fill(distances, (int) 1e9);

            int[] parent = new int[n];
            Arrays.fill(parent, -1);

            distances[i] = 0;
            Queue<Integer> que = new LinkedList<>();

            que.add(i);

            while (!que.isEmpty()) {

                int curr = que.poll();

                for (int element : adj.get(curr)) {
                    if (distances[element] == (int) 1e9) {

                        distances[element] = 1 + distances[curr];

                        parent[element] = curr;

                        que.add(element);
                    } else if (parent[curr] != element && parent[element] != curr) {
                        result = Math.min(result, distances[curr] + distances[element] + 1);
                    }
                }
            }
        }
        return result != Integer.MAX_VALUE ? result : -1;
    }

    public int findRec(int n, int[][] edges, int[] crr) {

        return 0;

    }

    public static void main(String[] args) {
        System.out.println(findShortestCycle(6,
                new int[][] { { 4, 1 }, { 3, 2 }, { 5, 0 }, { 3, 0 }, { 2, 1 }, { 4, 0 }, { 5, 1 } }));
    }
}
