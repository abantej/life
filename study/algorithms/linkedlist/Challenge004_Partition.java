package algorithms.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need
 * to be after the elements less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 *
 * Hint #1: There are many solutions to this problem, most of which are equally optimal in runtime.
 * Some have shorter, cleaner code than others. Can you brainstorm different solutions?
 *
 * Hint #2: Consider that the elements don't have to stay in the same relative order. We only need
 * to ensure that elements less than the pivot must be before elements greater than the
 * pivot. Does that help you come up with more solutions?
 */
public class Challenge004_Partition {

    private class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
        }
    }

    Node partition(Node head, int x) {
        Node less = null;
        Node more = null;

        Node curr = head;
        while (curr != null) {
            if (curr.data < x) {
                if (less == null) {
                    less = curr;
                } else {
                    less.next = curr;
                }
            } else {
                if (more == null) {
                    more = curr;
                } else {
                    more.next = curr;
                }
            }
            curr = curr.next;
        }

        if (less == null) {
            less = more;
        } else {
            less.next = more;
        }

        return less;
    }

    @Test
    public void partitionTest() {
        Node head = new Node(3);
        head.next = new Node(5);
        head.next.next = new Node(8);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);

        Node uptd_head = new Node(3);
        uptd_head.next = new Node(1);
        uptd_head.next.next = new Node(2);
        uptd_head.next.next.next = new Node(10);
        uptd_head.next.next.next.next = new Node(5);
        uptd_head.next.next.next.next.next = new Node(5);
        uptd_head.next.next.next.next.next.next = new Node(8);

        head = partition(head, 5);

        Node curr = head;
        Node uptd_curr = uptd_head;
        while (curr != null) {
            assertEquals(curr.data, uptd_curr.data);
            curr = curr.next;
            uptd_curr = uptd_curr.next;
        }
    }
}
