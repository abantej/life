package algorithms.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given two (singly) linked lists, determine if the two lists interact. Return the intersecting node.
 * Note that the intersection is defined based on reference, not value. That is, if the kth node of the first
 * linked list is the exact same node (by reference) as the jth node of the second linked list, then they are
 * intersecting.
 */
public class Challenge007_Intersection_Solution01_Runner {

    private class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
        }
    }

    Node intersect(Node head, Node another_head) {
        Node head_curr = head;
        while (head_curr != null) {
            Node another_head_curr = another_head;
            while (another_head_curr != null) {
                if (head_curr == another_head_curr) {
                    return another_head_curr;
                }
                another_head_curr = another_head_curr.next;
            }
            head_curr = head_curr.next;
        }
        return new Node(-1);
    }

    @Test
    public void intersectTest() {
        Node common = new Node(7);
        common.next = new Node(2);
        common.next.next = new Node(1);

        Node head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(5);
        head.next.next.next = new Node(9);
        head.next.next.next = common;

        Node another_head = new Node(4);
        another_head.next = new Node(6);
        another_head.next.next = common;

        assertEquals(common, intersect(head, another_head));
    }
}
