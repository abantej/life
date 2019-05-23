package algorithms.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Implement an algorithm to delete a node in the middle (i.e any node but the first and last node,
 * not necessarily the exact middle) of a singly linked list, given only access to that node.
 *
 * EXAMPLE:
 *
 * a -> b -> c -> d -> e -> f
 *
 * Delete 'c'
 *
 * Result:
 *
 * a -> b -> d -> e -> f
 *
 * Hint #1: Picture the list 1- > 5 - >9 - > 12. Removing 9 would make it look like 1- > 5 - > 12. You only
 * have access to the 9 node. Can you make it look like the correct answer?
 */
public class Solution003_DeleteMiddleNode {

    private class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
        }
    }

    boolean deleteNode(Node node) {
        if (node == null || node.next == null) {
            return false;
        }

        Node next = node.next;
        node.data = next.data;
        node.next = next.next;

        return true;
    }

    @Test
    public void deleteNodeTest() {
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(9);
        head.next.next.next = new Node(12);

        Node uptd_head = new Node(1);
        uptd_head.next = new Node(5);
        uptd_head.next.next = new Node(12);

        deleteNode(head.next.next);

        Node curr = head;
        Node uptd_curr = uptd_head;
        while (curr != null) {
            assertEquals(curr.data, uptd_curr.data);
            curr = curr.next;
            uptd_curr = uptd_curr.next;
        }
    }
}
