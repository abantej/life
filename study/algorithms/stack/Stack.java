package algorithms.stack;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * A stack data structure is precisely what it sounds like: a stack of data. In certain types of problems,
 * it can be favorable to store data in a stack rather than in an array. A stack uses LIFO (last-in first-out)
 * ordering. That is, as in a stack of dinner plates, the most recent item added to the stack is the first item
 * to be removed.
 *
 * Operations of stack data structure:
 *
 * pop
 * push
 * peek
 * isEmpty
 *
 * Unlike an array, a stack does not offer constant-time access to the ith item. However, it does allow constant-
 * time adds and removes, as it doesn't require shifting elemenets around.
 */
public class Stack {

    private class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
        }
    }

    Node head;

    void push(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node node = new Node(data);
            node.next = head;
            head = node;
        }
    }

    int pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("stack is empty");
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    int peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("stack is empty");
        }
        return head.data;
    }

    boolean isEmpty() {
        return head == null;
    }

    @Test
    public void stackTest() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.peek());

        stack.push(4);
        stack.push(5);

        assertEquals(5, stack.peek());
        assertEquals(5, stack.pop());
        assertEquals(4, stack.peek());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());

        try {
            assertEquals(0, stack.pop());
        } catch (Exception e) {
            assertEquals("stack is empty", e.getMessage());
        }

    }
}
