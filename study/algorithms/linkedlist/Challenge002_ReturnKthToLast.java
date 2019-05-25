package algorithms.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Implement an algorithm to find the kth to last element of a singly linkedlist.
 *
 * Hint #1: What if you knew the linked list size? What is the difference between finding the Kth-to-last element
 * and finding the Xth element.
 *
 * Hint #2: If you don't know the linked list size, can you compute it? How does this impact the runtime?
 *
 * Hint #3: Try implementing it recursively. If you could find the (K - 1)th to last element, can you find
 * the Kth element?
 *
 * Hint #4: You might find it useful to return multiple values. Some languages don't directly support this,
 * but there are workarounds in essentially any language. What are some of those workarounds?
 */
public class Challenge002_ReturnKthToLast {

    private class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
        }
    }

    // counting size of linked list
    Node kthToLast(Node head, int k) {
        int s = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            s ++;
        }

        int n = s - k;
        int c = 0;
        curr = head;
        while (curr != null) {
            if (c == n) return curr;
            curr = curr.next;
            c ++;
        }
        return new Node(-1);
    }

    int kthToLastRecursion(Node node, int k) {
        if (node == null) {
            return 0;
        }
        int n = kthToLastRecursion(node.next, k) + 1;

        if (n == k) {
            System.out.println("kth (" + k + ") to last element is " + node.data);
        }
        return n;
    }

    private class Index {
        int idx = 0;
    }

    Node kthToLastWrapper(Node node, Index index, int k) {
        if (node == null) {
            return null;
        }
        Node kthNode = kthToLastWrapper(node.next, index, k);
        index.idx++;
        if (k == index.idx) {
            return node;
        }
        return kthNode;
    }

    Node kthToLastIterative(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }


    @Test
    public void kthToLastTest() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        assertEquals(4, kthToLast(head,3).data);
        kthToLastRecursion(head, 3);
        assertEquals(4, kthToLastWrapper(head, new Index(), 3).data);
        assertEquals(4, kthToLastIterative(head,3).data);
    }
}
