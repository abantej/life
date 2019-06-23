package algorithms.treegraphs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height.
 */
public class Challenge002_MinimalTree {

    private class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    Node createMinimalBST(int arr[], int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        Node n = new Node(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }

    Node creaetMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    @Test
    public void creaetMinimalBSTTest() {
        int[] arr = new int[15];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;
        arr[5] = 5;
        arr[6] = 6;
        arr[7] = 7;
        arr[8] = 8;
        arr[9] = 9;
        arr[10] = 10;
        arr[11] = 11;
        arr[12] = 12;
        arr[13] = 13;
        arr[14] = 14;
        Node bst = creaetMinimalBST(arr);
        assertEquals(7, bst.data);
    }
}
