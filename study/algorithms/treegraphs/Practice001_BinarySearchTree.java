package algorithms.treegraphs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Practice001_BinarySearchTree {
    private class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }
        if (data <= node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    @Test
    public void insertTest() {
        Node root = insert(null, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);
        insert(root, 90);
    }
}
