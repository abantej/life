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
        Node less_head = null;
        Node less = null;

        Node more_head = null;
        Node more = null;

        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = null;
            if (curr.data < x) {
                if (less == null) {
                    less = curr;
                    less_head = less;
                } else {
                    less.next = curr;
                    less = less.next;
                }
            } else {
                if (more == null) {
                    more = curr;
                    more_head = more;
                } else {
                    more.next = curr;
                    more = more.next;
                }
            }
            curr = next;
        }

        if (less_head == null) {
            less_head = more_head;
        } else {
            less.next = more_head;
        }

        return less_head;
    }

    Node partition2(Node node, int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        while (node != null) {
            Node next = node.next;
            node.next = null;
            if (node.data < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    Node partition3(Node node, int x) {
        Node head = null;
        Node tail = null;

        Node curr = node;
        while (curr != null) {
            Node next = curr.next;
            curr.next = null;
            if (curr.data < x) {
                if (head == null) {
                    head = curr;
                    tail = curr;
                } else {
                    curr.next = head;
                    head = curr;
                }
            } else {
                if (tail == null) {
                    tail = curr;
                    head = curr;
                } else {
                    tail.next = curr;
                    tail = tail.next;
                }
            }
            curr = next;
        }
        return head;
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

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();


        Node uptd_head = new Node(3);
        uptd_head.next = new Node(2);
        uptd_head.next.next = new Node(1);
        uptd_head.next.next.next = new Node(5);
        uptd_head.next.next.next.next = new Node(8);
        uptd_head.next.next.next.next.next = new Node(5);
        uptd_head.next.next.next.next.next.next = new Node(10);

        head = partition(head, 5);

        curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();

        curr = head;
        Node uptd_curr = uptd_head;
        while (curr != null) {
            assertEquals(curr.data, uptd_curr.data);
            curr = curr.next;
            uptd_curr = uptd_curr.next;
        }

        Node head2 = new Node(3);
        head2.next = new Node(5);
        head2.next.next = new Node(8);
        head2.next.next.next = new Node(5);
        head2.next.next.next.next = new Node(10);
        head2.next.next.next.next.next = new Node(2);
        head2.next.next.next.next.next.next = new Node(1);

        head2 = partition2(head2, 5);

        Node uptd_head2 = new Node(3);
        uptd_head2.next = new Node(2);
        uptd_head2.next.next = new Node(1);
        uptd_head2.next.next.next = new Node(5);
        uptd_head2.next.next.next.next = new Node(8);
        uptd_head2.next.next.next.next.next = new Node(5);
        uptd_head2.next.next.next.next.next.next = new Node(10);

        Node curr2 = head2;
        Node uptd_curr2 = uptd_head2;
        while (uptd_curr2 != null) {
            assertEquals(curr2.data, uptd_curr2.data);
            curr2 = curr2.next;
            uptd_curr2 = uptd_curr2.next;
        }


        Node head3 = new Node(3);
        head3.next = new Node(5);
        head3.next.next = new Node(8);
        head3.next.next.next = new Node(5);
        head3.next.next.next.next = new Node(10);
        head3.next.next.next.next.next = new Node(2);
        head3.next.next.next.next.next.next = new Node(1);

        head3 = partition3(head3, 5);

        Node uptd_head3 = new Node(1);
        uptd_head3.next = new Node(2);
        uptd_head3.next.next = new Node(3);
        uptd_head3.next.next.next = new Node(5);
        uptd_head3.next.next.next.next = new Node(8);
        uptd_head3.next.next.next.next.next = new Node(5);
        uptd_head3.next.next.next.next.next.next = new Node(10);

        Node curr3 = head3;
        Node uptd_curr3 = uptd_head3;
        while (uptd_curr3 != null) {
            assertEquals(curr3.data, uptd_curr3.data);
            curr3 = curr3.next;
            uptd_curr3 = uptd_curr3.next;
        }

    }
}
