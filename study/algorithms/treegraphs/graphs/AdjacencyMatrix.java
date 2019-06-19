package algorithms.treegraphs.graphs;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AdjacencyMatrix {
    int n;
    int[][] a;
    public AdjacencyMatrix(int n) {
        this.n = n;
        a = new int[n][n];
    }

    void addEdge(int i, int j) {
        a[i][j] = 1;
    }

    void removeEdge(int i, int j) {
        a[i][j] = 0;
    }

    boolean hasEdge(int i, int j) {
        return a[i][j] == 1;
    }

    void addTarget(int i, int j) {
        a[i][j] = 9;
    }

    void printMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    void findPath(AdjacencyMatrix mtx) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (hasEdge(i, j)) {

                }
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix mtx = new AdjacencyMatrix(8);
        mtx.addEdge(0,0);
        mtx.addEdge(0,1);
        mtx.addEdge(1,1);
        mtx.addEdge(2,1);
        mtx.addEdge(3,1);
        mtx.addEdge(3,2);
        mtx.addTarget(3, 3);
        mtx.printMatrix();

    }
}
