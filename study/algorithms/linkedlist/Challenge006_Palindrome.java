package algorithms.linkedlist;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Stack;

/**
 * Implement a function to check if a linked list is a palindrome.
 *
 * Hints: #5, #13, #29, #61, #101
 */
public class Challenge006_Palindrome {

    private class Node {
        char data;
        Node next;
        Node (char data) {
            this.data = data;
        }
    }

    String append(Node node) {
        if (node == null) {
            return "";
        }
        String s = append(node.next);
        return s + node.data;
    }

    boolean isPalindrome(Node node) {
        String reverse = append(node);
        Node curr = node;
        for (char c: reverse.toCharArray()) {
            System.out.println(curr.data + " - " + c);
            if (c != curr.data) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    boolean isPalindromeStack(Node node) {
        Stack<Character> stack = new Stack<Character>();
        Node curr = node;
        while (curr != null) {
            stack.push(curr.data);
            curr = curr.next;
        }

        curr = node;
        while (!stack.isEmpty()) {
            if (curr.data != stack.pop()) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    @Test
    public void isPalindromeTest() {
        Node head = new Node('a');
        head.next = new Node('b');
        head.next.next = new Node('c');
        head.next.next.next = new Node('d');
        head.next.next.next.next = new Node('c');
        head.next.next.next.next.next = new Node('b');
        head.next.next.next.next.next.next = new Node('a');

        assertTrue(isPalindrome(head));
        assertTrue(isPalindromeStack(head));

        head = new Node('j');
        head.next = new Node('o');
        head.next.next = new Node('e');
        head.next.next.next = new Node('w');
        head.next.next.next.next = new Node('a');
        head.next.next.next.next.next = new Node('r');
        head.next.next.next.next.next.next = new Node('d');

        assertFalse(isPalindrome(head));
        assertFalse(isPalindromeStack(head));
    }
}
