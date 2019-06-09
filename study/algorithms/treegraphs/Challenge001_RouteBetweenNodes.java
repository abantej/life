package algorithms.treegraphs;

import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Given a directed graph, design an algorithm to find out whether  there is a route between two nodes.
 */
public class Challenge001_RouteBetweenNodes {

    private enum State {
        Unvisited, Visited, Visiting;
    }

    private class Node {
        Node[] adjacent;
        int adjacentCount;
        String vertex;
        State state;
        Node (String vertex, int adjacentLength) {
            this.vertex = vertex;
            adjacentCount = 0;
            adjacent = new Node[adjacentLength];
        }

        void addAdjacent(Node node) {
            if (this.adjacentCount < adjacent.length) {
                this.adjacent[adjacentCount] = node;
                adjacentCount ++;
            } else {
                throw new RuntimeException("No more adjacent can be added.");
            }
        }
    }

    private class Graph {
        Node vertices[];
        int count;
        Graph() {
            vertices = new Node[6];
            count = 0;
        }

        void addNode(Node node) {
            if (count < vertices.length) {
                vertices[count] = node;
                count ++;
            } else {
                throw new RuntimeException("Graph is full.");
            }
        }
    }

    Graph createNewGraph() {
        Graph graph = new Graph();
        Node[] temp = new Node[6];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 3);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);

        for (int i = 0; i < 6; i++) {
            graph.addNode(temp[i]);
        }
        return graph;
    }

    boolean search(Graph graph, Node start, Node end) {
        if (start == end) return true;

        LinkedList<Node> queue = new LinkedList<>();

        for (Node u : graph.vertices) {
            u.state = State.Unvisited;
        }

        start.state = State.Visiting;
        queue.add(start);

        Node u;
        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            if (u != null) {
                for (Node v: u.adjacent) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            queue.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }

    @Test
    public void searchTest() {
        Graph graph = createNewGraph();
        Node a = graph.vertices[0];
        Node f = graph.vertices[5];
        assertTrue(search(graph, a, f));
    }
}
