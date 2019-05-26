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

    boolean isPalindromeRunner(Node head) {
        Stack<Character> stack = new Stack<Character>();
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.data != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

    int lengthOfList(Node n) {
        int size = 0;
        while (n != null) {
            size ++;
            n = n.next;
        }
        return size;
    }

    private class Result {
        Node node;
        boolean result;
        Result(Node node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

    boolean isPalindromeRecurseMain(Node head) {
        int length = lengthOfList(head);
        Result p = isPalindromeRecurse(head, length);
        return p.result;
    }

    Result isPalindromeRecurse(Node head, int length) {
        if (head == null || length <= 0) {
            return new Result(head, true);
        } else if (length == 1) {
            return new Result(head.next, true);
        }

        Result res = isPalindromeRecurse(head.next, length - 2);

        if (!res.result || res.node == null) {
            return res;
        }

        res.result = (head.data == res.node.data);

        res.node = res.node.next;

        return res;
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
        assertTrue(isPalindromeRunner(head));
        assertTrue(isPalindromeRecurseMain(head));

        head = new Node('j');
        head.next = new Node('o');
        head.next.next = new Node('e');
        head.next.next.next = new Node('w');
        head.next.next.next.next = new Node('a');
        head.next.next.next.next.next = new Node('r');
        head.next.next.next.next.next.next = new Node('d');

        assertFalse(isPalindrome(head));
        assertFalse(isPalindromeStack(head));
        assertFalse(isPalindromeRunner(head));
        assertFalse(isPalindromeRecurseMain(head));
    }
}
