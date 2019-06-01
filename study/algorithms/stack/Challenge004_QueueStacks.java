package algorithms.stack;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class Challenge004_QueueStacks {


    private class QueueStack {
        Stack<Integer> stack = new Stack<>();

        void enqueue(int data) {
            stack.push(data);
        }

        int dequeue() {
            Stack<Integer> reverseStack = new Stack<>();
            while (!stack.isEmpty()) {
                reverseStack.push(stack.pop());
            }
            int data = reverseStack.pop();
            while (!reverseStack.isEmpty()) {
                stack.push(reverseStack.pop());
            }
            return data;
        }
    }

    @Test
    public void queueStacksTest() {
        QueueStack queue = new QueueStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());

    }
}
