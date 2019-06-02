package algorithms.stack;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Stack;


public class Challenge005_SortStack {

    Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> other = new Stack<>();
        while (!stack.isEmpty()) {
            int data = stack.pop();
            while (other.size() > 0 && data > other.peek()) {
                stack.push(other.pop());
            }
            other.push(data);
        }
        return other;
    }

    @Test
    public void sortStackTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(6);
        stack.push(1);
        stack.push(8);
        stack.push(7);
        stack.push(10);
        stack.push(9);

        stack = sortStack(stack);

        assertEquals(1, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(6, stack.pop());
        assertEquals(7, stack.pop());
        assertEquals(8, stack.pop());
        assertEquals(9, stack.pop());
        assertEquals(10, stack.pop());

    }
}
