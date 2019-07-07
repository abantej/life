package algorithms.treegraphs.graphs;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Practice001_GraphBFS_AdjacencyList {
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

        void breadthFirstSearch(int s) {
            boolean visited[] = new boolean[verticesCount];
            LinkedList<Integer> queue = new LinkedList<Integer>();
            visited[s] = true;
            queue.add(s);

            while (queue.size() != 0) {
                s = queue.poll();
                System.out.print(s + " ");
                Iterator<Integer> i = adj[s].listIterator();
                while(i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
    }

    @Test
    public void breadthFirstSearch() {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal (starting from vertex 2)");
        graph.breadthFirstSearch(2);
    }
}
