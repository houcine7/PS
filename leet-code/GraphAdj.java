import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
import java.util.Iterator;

public class GraphAdj {

    private int V;
    private LinkedList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    GraphAdj(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int edge) {
        adj[v].add(edge);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;

        Iterator<Integer> i = adj[v].listIterator();
        System.out.print(" " + v + " ");
        while (i.hasNext()) {
            int temp = i.next();
            if (!visited[temp]) {
                DFSUtil(temp, visited);
            }
        }
    }

    void DFS(int v) {
        boolean[] visited = new boolean[this.V];

        DFSUtil(v, visited);
    }

    public static void main(String[] args) {
        GraphAdj graph = new GraphAdj(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);

        System.out.println(Arrays.toString(graph.adj));

        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

    }
}
