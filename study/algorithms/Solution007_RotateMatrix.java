package algorithms;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class Solution007_RotateMatrix {

    public void rotate(int[][] mtx) {
        for (int i = 0, k = 3; i < 3; i++, k--) {
            int tmp = mtx[0][i];
            mtx[0][i] = mtx[k][0];
            mtx[k][0] = mtx[3][k];
            mtx[3][k] = mtx[i][3];
            mtx[i][3] = tmp;
        }
    }

    @Test
    public void rotateTest() {
        int[][] mtx = new int[4][];
        mtx[0] = new int[] {1,   2,  3, 4};
        mtx[1] = new int[] {12, 13, 14, 5};
        mtx[2] = new int[] {11, 16, 15, 6};
        mtx[3] = new int[] {10,  9,  8, 7};

        for (int[] n: mtx) {
            for (int m: n) {
                System.out.print(m + "\t");
            }
            System.out.println();
        }

        rotate(mtx);

        System.out.println("-------------");

        for (int[] n: mtx) {
            for (int m: n) {
                System.out.print(m + "\t");
            }
            System.out.println();
        }

    }
}
