package algorithms.treegraphs.graphs;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Practice002_GraphDFS_AdjacencyList {
    private class Graph {
        int verticesCount;
        LinkedList<Integer>[] adj;

        Graph(int verticesCount) {
            this.verticesCount = verticesCount;
            adj = new LinkedList[verticesCount];
            for (int i = 0; i < verticesCount; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        void depthFirstSearch(int v, boolean visited[]) {
            visited[v] = true;
            System.out.print(v + " ");

            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    depthFirstSearch(n, visited);
                }
            }
        }

        void depthFirstSearch(int v) {
            boolean visited[] = new boolean[verticesCount];
            depthFirstSearch(v, visited);
        }
    }

    @Test
    public void depthFirstSearchTest() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal (starting from vertex 2)" );
        graph.depthFirstSearch(2);
    }
}
