package algorithms.stack;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * A queue implements FIFO (first-in first-out) ordering. As in a line or queue at a ticket stand, items are
 * removed from the data structure in the same order that they are added.
 *
 * Operations:
 * add, remove, peek, isEmpty
 */
public class Queue {
    private class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
        }
    }

    Node first;
    Node last;

    void add(int data) {
        if (first == null) {
            first = new Node(data);
            last = first;
        } else {
            last.next = new Node(data);;
            last = last.next;
        }
    }

    int remove() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        Node node = this.first;
        first = first.next;
        if (first == null) {
             last = null;
        }
        return node.data;
    }

    int peek() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return first.data;
    }

    boolean isEmpty() {
        return first == null;
    }

    @Test
    public void queueTest() {
        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        assertEquals(1, queue.peek());
        queue.add(5);
        assertEquals(1, queue.remove());
        assertEquals(2, queue.remove());
        assertEquals(3, queue.remove());
        assertEquals(4, queue.remove());
        assertEquals(5, queue.remove());
        try {
            assertEquals(6, queue.remove());
        } catch (Exception e) {
            assertEquals("queue is empty", e.getMessage());
        }
        queue.add(1);
        assertEquals(1, queue.peek());
    }
}
