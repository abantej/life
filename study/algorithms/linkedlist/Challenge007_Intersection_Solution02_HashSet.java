package algorithms.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.HashSet;

/**
 * Given two (singly) linked lists, determine if the two lists interact. Return the intersecting node.
 * Note that the intersection is defined based on reference, not value. That is, if the kth node of the first
 * linked list is the exact same node (by reference) as the jth node of the second linked list, then they are
 * intersecting.
 */
public class Challenge007_Intersection_Solution02_HashSet {

    private class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
        }
    }

    Node intersectHash(Node head, Node another_head) {
        Set<Node> set = new HashSet<>();
        while (head != null) {
            set.add(head);
            head = head.next;
        }

        while (another_head != null) {
            if (set.contains(another_head)) {
                return another_head;
            }
            another_head = another_head.next;
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

        assertEquals(common, intersectHash(head, another_head));
    }
}
