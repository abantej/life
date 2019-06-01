package algorithms.stack;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
 * threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
 * composed of several stacks and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack
 * (that is, pop ( ) should return the same values as it would if there were just a single stack).
 */
public class Challenge003_SetOfStacks {

    private class Stack {
        int size;
        int max;

        private class Node {
            int data;
            Node next;
            Node (int data) {
                this.data = data;
            }
        }

        Stack (int max) {
            this.max = max;
        }

        Node top;
        Node bottom;

        void push(int data) {
            if (this.size == this.max) {
                throw new RuntimeException("stack is full");
            }
            Node node = new Node(data);
            if (top == null) {
                top = node;
                bottom = top;
            } else {
                node.next = top;
                top = node;
            }
            size ++;
        }

        int pop() {
            if (isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            Node next = top.next;
            int data = top.data;
            top = next;
            if (top == null) {
                bottom = null;
            }
            size --;
            return data;
        }

        int peek() {
            if (isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            return top.data;
        }

        boolean isEmpty() {
            return this.size == 0;
        }

        boolean isFull() {
            return this.size == this.max;
        }
    }

    private class SetOfStack {
        ArrayList<Stack> stacks = new ArrayList<>();

        int max;

        SetOfStack (int max) {
            this.max = max;
        }

        void push(int data) {
            if (stacks.isEmpty()) {
                Stack stack = new Stack(this.max);
                stack.push(data);
                stacks.add(stack);
            } else {
                Stack top = stacks.get(stacks.size() - 1);
                if (top.isFull()) {
                    Stack stack = new Stack(this.max);
                    stack.push(data);
                    stacks.add(stack);
                } else {
                    top.push(data);
                }
            }
        }

        int pop() {
            if (stacks.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            Stack top = stacks.get(stacks.size() - 1);
            int data = top.pop();
            if (top.isEmpty()) {
                stacks.remove(top);
            }
            return data;
        }

        int popAt(int idx) {
            if (stacks.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            int data = stacks.get(idx).pop();
            return data;
        }

        int peek() {
            return -1;
        }

        boolean isEmpty() {
            return stacks.isEmpty();
        }
    }

    @Test
    public void setOfStackTest() {
        SetOfStack stack = new SetOfStack(5);
        stack.push(1);
        //assertEquals(1, stack.peek());
        stack.push(2);
        //assertEquals(2, stack.peek());
        stack.push(3);
        stack.push(4);
        stack.push(5);
        //assertEquals(5, stack.peek());
        //assertEquals(5, stack.pop());
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        assertEquals(5, stack.popAt(0));
        assertEquals(10, stack.pop());
        assertEquals(9, stack.pop());
        assertEquals(8, stack.pop());
        assertEquals(7, stack.pop());
        assertEquals(6, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());

        //stack.push(7);
        //stack.push(8);
        //stack.push(9);
        //stack.push(10);

//        try {
//            stack.push(11);
//        } catch (Exception e) {
//            assertEquals("stack is full", e.getMessage());
//            assertEquals(10, stack.pop());
//            stack.push(11);
//        }


    }
}
