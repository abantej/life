package algorithms.treegraphs;

import java.util.LinkedList;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Given a directed graph, design an algorithm to find out whether  there is a route between two nodes.
 */
public class Challenge001_RouteBetweenNodes {

    private enum State {
        Unvisited, Visited, Visiting;
    }

    private class Vertex {
        String name;
        State state = State.Unvisited;;
        ArrayList<Vertex> adjacentVertices = new ArrayList<>();
        Vertex(String name) {
            this.name = name;
        }

        void addAdjacentVertex(Vertex vertex) {
            this.adjacentVertices.add(vertex);
        }
    }

    private class Graph {
        ArrayList<Vertex> vertices = new ArrayList<>();
        void addVertex(Vertex vertex) {
            vertices.add(vertex);
        }
    }

    boolean search(Graph graph, Vertex start, Vertex end) {
        if (start == end) return true;

        LinkedList<Vertex> queue = new LinkedList<>();
        start.state = State.Visiting;
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex vertex = queue.removeFirst();
            for (Vertex v: vertex.adjacentVertices) {
                if (v.state == State.Unvisited) {
                    if (v == end) {
                        return true;
                    } else {
                        v.state = State.Visiting;
                        queue.add(v);
                    }
                }
            }
            vertex.state = State.Visited;
        }
        return false;
    }

    @Test
    public void searchTest() {
        Graph graph = new Graph();
        Vertex[] temp = new Vertex[6];

        temp[0] = new Vertex("a");
        temp[1] = new Vertex("b");
        temp[2] = new Vertex("c");
        temp[3] = new Vertex("d");
        temp[4] = new Vertex("e");
        temp[5] = new Vertex("f");

        temp[0].addAdjacentVertex(temp[1]);
        temp[0].addAdjacentVertex(temp[2]);
        temp[0].addAdjacentVertex(temp[3]);
        temp[3].addAdjacentVertex(temp[4]);
        temp[4].addAdjacentVertex(temp[5]);

        for (int i = 0; i < 6; i++) {
            graph.addVertex(temp[i]);
        }

        Vertex a = graph.vertices.get(0);
        Vertex f = graph.vertices.get(5);
        assertTrue(search(graph, a, f));
    }
}
