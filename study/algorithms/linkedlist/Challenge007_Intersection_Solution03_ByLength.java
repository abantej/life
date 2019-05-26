package algorithms.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given two (singly) linked lists, determine if the two lists interact. Return the intersecting node.
 * Note that the intersection is defined based on reference, not value. That is, if the kth node of the first
 * linked list is the exact same node (by reference) as the jth node of the second linked list, then they are
 * intersecting.
 */
public class Challenge007_Intersection_Solution03_ByLength {

    private class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
        }
    }

    private class NodeLength {
        int length;
        Node tail;
        NodeLength(int length, Node  tail) {
            this.length = length;
            this.tail = tail;
        }
    }

    NodeLength getNodeLength(Node head) {
        int count = 0;
        while (head != null) {
            count ++;
            head = head.next;
        }
        return new NodeLength(count, head);
    }

    Node intersect(Node head, Node another_head) {
        NodeLength headNodeLength = getNodeLength(head);
        NodeLength another_headNodeLength = getNodeLength(another_head);

        Node bigger = headNodeLength.length >= another_headNodeLength.length ? head : another_head;
        Node smaller =  headNodeLength.length >= another_headNodeLength.length ? another_head : head;
        int extraNodesSize = Math.abs(headNodeLength.length - another_headNodeLength.length);

        for (int i = 0; i < extraNodesSize; i++) {
            bigger = bigger.next;
        }

        while (bigger != null) {

            if (bigger == smaller) {
                return bigger;
            }

            bigger = bigger.next;
            smaller = smaller.next;
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
