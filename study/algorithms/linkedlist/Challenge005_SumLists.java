package algorithms.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored
 * in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers
 * and returns the sum as a linked list.
 *
 * Example:
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is 617 + 295
 * Output: 2 -> 1 -> 9. That is 912
 *
 * #7, #30, #71, #95, #109
 */
public class Challenge005_SumLists {

    private class Node {
        int data;
        int carry;
        Node next;
        Node (int data) {
            this.data = data;
        }

        Node (int data, int carry) {
            this.data = data;
            this.carry = carry;
        }
    }

    Node sumLists(Node a, Node b) {
        if (a == null && b == null) {
            return null;
        }

        if (a == null) {
            a = new Node(0);
        }

        if (b == null) {
            b = new Node(0);
        }

        int sum = a.data + b.data;
        int data = sum % 10;
        int carry_over = sum / 10;
        Node sum_node = new Node(data);

        Node a_next = a == null ? null : a.next;
        Node b_next = b == null ? null : b.next;

        if (a_next != null) {
            a_next.data += carry_over;
        } else if (b_next != null) {
            b_next.data += carry_over;
        }
        Node next = sumLists(a_next, b_next);
        sum_node.next = next;
        return sum_node;
    }

    Node sumListsForward(Node a, Node b) {
        if (a == null && b == null) {
            return null;
        }

        if (a == null) {
            a = new Node(0);
        }

        if (b == null) {
            b = new Node(0);
        }

        Node a_next = a == null ? null : a.next;
        Node b_next = b == null ? null : b.next;
        Node sumList = sumListsForward(a_next, b_next);

        int sum = a.data + b.data + (sumList != null ? sumList.carry : 0);
        int data = sum % 10;
        int carry_over = sum / 10;
        Node sum_node = new Node(data, carry_over);
        sum_node.next = sumList;
        return sum_node;
    }

    Node sumListsForwardPad(Node a, Node b) {

        int a_count = 0;
        int b_count = 0;

        Node a_curr = a;
        Node b_curr = b;
        while (a_curr != null || b_curr != null) {

            if (a_curr != null) {
                a_count ++;
                a_curr = a_curr.next;
            }

            if (b_curr != null) {
                b_count ++;
                b_curr = b_curr.next;
            }
        }

        if (a_count > b_count) {
            int size = a_count - b_count;
            for (int i = 0; i < size; i++) {
                Node pad = new Node(0);
                pad.next = b;
                b = pad;
            }
        } else if (b_count > a_count) {
            int size = b_count - a_count;
            for (int i = 0; i < size; i++) {
                Node pad = new Node(0);
                pad.next = a;
                a = pad;
            }
        }
        Node head = sumListsForward(a, b);
        return head;
    }

    @Test
    public void sumListsTest() {
        Node b = new Node(7);
        b.next = new Node(1);
        b.next.next = new Node(6);

        Node a = new Node(5);
        a.next = new Node(9);
        a.next.next = new Node(2);
        a.next.next.next = new Node(3);

        Node expected_sum = new Node(2);
        expected_sum.next = new Node(1);
        expected_sum.next.next = new Node(9);
        expected_sum.next.next.next = new Node(3);

        Node actual_sum = sumLists(a, b);

        Node actual_sum_curr = actual_sum;
        Node expected_sum_curr = expected_sum;
        while (actual_sum_curr != null) {
            assertEquals(actual_sum_curr.data, expected_sum_curr.data);
            actual_sum_curr = actual_sum_curr.next;
            expected_sum_curr = expected_sum_curr.next;
        }


        a = new Node(3);
        a.next = new Node(2);
        a.next.next = new Node(9);
        a.next.next.next = new Node(5);

        b = new Node(6);
        b.next = new Node(1);
        b.next.next = new Node(7);
        b.next.next.next = new Node(5);

        expected_sum = new Node(9);
        expected_sum.next = new Node(4);
        expected_sum.next.next = new Node(7);
        expected_sum.next.next.next = new Node(0);

        actual_sum = sumListsForward(a, b);

        actual_sum_curr = actual_sum;
        expected_sum_curr = expected_sum;
        while (actual_sum_curr != null) {
            assertEquals(actual_sum_curr.data, expected_sum_curr.data);
            actual_sum_curr = actual_sum_curr.next;
            expected_sum_curr = expected_sum_curr.next;
        }


        a = new Node(3);
        a.next = new Node(2);
        a.next.next = new Node(9);
        a.next.next.next = new Node(5);

        b = new Node(6);
        b.next = new Node(1);
        b.next.next = new Node(7);

        expected_sum = new Node(3);
        expected_sum.next = new Node(9);
        expected_sum.next.next = new Node(1);
        expected_sum.next.next.next = new Node(2);

        actual_sum = sumListsForwardPad(a, b);

        actual_sum_curr = actual_sum;
        expected_sum_curr = expected_sum;
        while (actual_sum_curr != null) {
            assertEquals(actual_sum_curr.data, expected_sum_curr.data);
            actual_sum_curr = actual_sum_curr.next;
            expected_sum_curr = expected_sum_curr.next;
        }
    }
}
