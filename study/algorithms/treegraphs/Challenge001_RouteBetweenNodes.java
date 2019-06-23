package algorithms.treegraphs;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Challenge001_RouteBetweenNodes {

    private enum State {
        UNVISITED, VISITING, VISITED;
    }

    private class Vertex {
        String name;
        ArrayList<Vertex> adjacentVertices = new ArrayList<>();
        State state = State.UNVISITED;
        public Vertex(String name) {
            this.name = name;
        }
    }

    private class Graph {
        ArrayList<Vertex> vertices = new ArrayList<>();
    }

    private boolean search(Vertex s, Vertex e) {
        if (s == e) return true;

        LinkedList<Vertex> queue = new LinkedList<>();
        s.state = State.VISITING;
        queue.add(s);

        while (!queue.isEmpty()) {
            Vertex vertex = queue.removeFirst();
            for (Vertex v: vertex.adjacentVertices) {
                if (v.state == State.UNVISITED) {
                    if (v == e) {
                        return true;
                    } else {
                        v.state = State.VISITING;
                        queue.add(v);
                    }
                }
            }
            vertex.state = State.VISITED;
        }

        return false;
    }

    @Test
    public void searchTest() {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");

        a.adjacentVertices.add(b);
        a.adjacentVertices.add(c);
        a.adjacentVertices.add(d);
        d.adjacentVertices.add(e);
        e.adjacentVertices.add(f);

        Graph graph = new Graph();
        graph.vertices.add(a);
        graph.vertices.add(b);
        graph.vertices.add(c);
        graph.vertices.add(d);
        graph.vertices.add(e);
        graph.vertices.add(f);

        assertTrue(search(a, b));
    }
}
