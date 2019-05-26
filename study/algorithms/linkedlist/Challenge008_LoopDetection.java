package algorithms.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 * Example: 1 -> 2 -> 3 -> (4) -> 5 -> 6 -> 7 -> (4)
 */
public class Challenge008_LoopDetection {

    private class Node{
        int data;
        Node next;
        Node (int data) {
            this.data = data;
        }
    }

    Node findBeginning(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    @Test
    public void findBeginningTest() {
        Node beginning = new Node(4);

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = beginning;
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = beginning;

        assertEquals(beginning, findBeginning(head));
    }
}
