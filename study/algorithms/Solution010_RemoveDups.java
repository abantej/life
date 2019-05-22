package algorithms;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Write code to remove duplicates from an unsorted linked list.
 *
 *
 */
public class Solution010_RemoveDups {
    private class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
        }
    }

    void removeDups(Node head) {
        Set<Integer> nodes = new HashSet<>();
        Node curr = head;
        Node next = head.next;
        nodes.add(head.data);
        while (next != null) {
            if (nodes.contains(next.data)) {
                curr.next = next;
            } else {
                nodes.add(next.data);
            }
            next = next.next;
            curr = next;
        }
    }

    @Test
    public void removeDupsTest() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(5);

        removeDups(head);

        Node newHead = new Node(1);
        newHead.next = new Node(2);
        newHead.next.next = new Node(3);
        newHead.next.next.next = new Node(5);

        Node newHeadCurr = newHead;
        Node curr = head;
        while (newHeadCurr != null) {
            assertEquals(newHeadCurr.data, curr.data);
            newHeadCurr = newHeadCurr.next;
            curr = curr.next;
        }
    }
}
