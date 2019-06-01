package algorithms.stack;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Stack;

/**
 * How would you design a stack which, in addition to push and pop, has a function main which
 * returns the minimum element? Push, pop, and min should all operate in O(1) time.
 *
 * Hint #1: Observe that the minimum element doesn't change very often. It only changes when a smaller
 * element is added, or when the smallest elements is popped.
 *
 * Hint #3: Consider have each node know the minimum of its "substack" (all the elements beneath it,
 * including itself).
 */
public class Challenge002_StackMin {

    private class NodeWithMin {
        int value;
        int min;
        NodeWithMin(int v, int min) {
            value = v;
            this.min = min;
        }
    }

    private class StackWithMin extends Stack<NodeWithMin>{
        void push(int value) {
            int newMin = Math.min(value, min());
            super.push(new NodeWithMin(value, newMin));
        }

        int min() {
            if (this.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return peek().min;
            }
        }
    }

    @Test
    public void stackTest() {
        StackWithMin stack = new StackWithMin();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.peek().value);
        assertEquals(1, stack.peek().min);

        stack.push(4);
        stack.push(5);

        assertEquals(5, stack.peek().value);
        assertEquals(5, stack.pop().value);
        assertEquals(4, stack.peek().value);
        assertEquals(4, stack.pop().value);
        assertEquals(3, stack.pop().value);
        assertEquals(2, stack.pop().value);
        assertEquals(1, stack.pop().value);


    }
}
