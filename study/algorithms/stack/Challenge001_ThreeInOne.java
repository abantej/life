package algorithms.stack;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * Three in One: Describe how you could use a single array to implement three stacks.
 *
 *
 */
public class Challenge001_ThreeInOne {

    ArrayList<Integer> list = new ArrayList<>(3);

    int firstSize = 0;
    int secondSize = 0;
    int thirdSize = 0;

    private class Stack {

        int number = 0;

        Stack (int number) {
            this.number = number;
        }

        void push(int data) {
            if (list.isEmpty()) {
                list.add(data);
                if (number == 1) {
                    firstSize ++;
                } else if (number == 2) {
                    secondSize ++;
                } else if (number == 3) {
                    thirdSize ++;
                }
            } else {
                if (number == 1) {
                    list.add(firstSize++, data);
                } else if (number == 2) {
                    list.add(firstSize + secondSize ++, data);
                } else if (number == 3) {
                    list.add(firstSize + secondSize + thirdSize ++, data);
                }
            }
        }

        int peek() {
            if (isEmpty()) {
                throw new IllegalArgumentException("stack is empty");
            }

            if (number == 1) {
                return list.get(firstSize - 1);
            } else if (number == 2) {
                return list.get(firstSize + secondSize - 1);
            } else if (number == 3) {
                return list.get(firstSize + secondSize + thirdSize - 1);
            }

            return -1;
        }

        int pop() {
            if (isEmpty()) {
                throw new IllegalArgumentException("stack is empty");
            }

            if (number == 1) {
                return list.remove(firstSize -- - 1);
            } else if (number == 2) {
                return list.remove(firstSize + secondSize -- - 1);
            } else if (number == 3) {
                return list.remove(firstSize + secondSize + thirdSize -- - 1);
            }

            return -1;
        }

        boolean isEmpty() {
            return list.isEmpty();
        }

        int size() {
             return list.size();
        }
    }



    @Test
    public void threeInOneTest() {
        Stack stack1 = new Stack(1);
        Stack stack2 = new Stack(2);
        Stack stack3 = new Stack(3);
        stack1.push(11);
        stack2.push(21);
        stack3.push(31);
        stack3.push(32);
        assertEquals(11, stack1.peek());
        assertEquals(21, stack2.peek());
        assertEquals(32, stack3.peek());
        assertEquals(32, stack3.pop());
        assertEquals(31, stack3.pop());
    }
}
