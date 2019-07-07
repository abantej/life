package algorithms.treegraphs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g. if you have a tree with depth D, you'll have D linked lists)
 */
public class Challenge003_ListOfDepths {

    private class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    void createLevelLinkedList(Node root, ArrayList<LinkedList<Node>> lists, int level) {
        if (root == null) return;

        LinkedList list = null;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    ArrayList<LinkedList<Node>> createLevelLinkedList(Node root) {
        ArrayList<LinkedList<Node>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    @Test
    public void createLevelLinkedList() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<LinkedList<Node>> lists = createLevelLinkedList(root);
        System.out.println();
    }
}
