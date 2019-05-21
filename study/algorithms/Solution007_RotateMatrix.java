package algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 *
 * Hint #1: Try thinking about it layer by layer. Can you rotate a specific layer?
 *
 * Hint #2: Rotating a specific layer would just mean swapping the values in four arrays.
 * If you were asked to swap the values in two arrays, could you do this? Can you then
 * extend it to four arrays?
 */
public class Solution007_RotateMatrix {

    public void rotate(int[][] mtx) {
        int rotation = mtx.length - 1;
        for (int g = 0, h = rotation; g < rotation; g++, h--) {
            for (int i = g, k = h; i < rotation; i++, k--) {
                int tmp = mtx[g][i];
                mtx[g][i] = mtx[k][g];
                mtx[k][g] = mtx[h][k];
                mtx[h][k] = mtx[i][h];
                mtx[i][h] = tmp;
            }
            rotation--;
        }
    }

    @Test
    public void rotateTest() {
        int[][] mtx = new int[4][];
        mtx[0] = new int[] {1,   2,  3, 4};
        mtx[1] = new int[] {12, 13, 14, 5};
        mtx[2] = new int[] {11, 16, 15, 6};
        mtx[3] = new int[] {10,  9,  8, 7};

        print(mtx);

        rotate(mtx);

        // expected output
        int[][] rtd_mtx = new int[4][];
        rtd_mtx[0] = new int[] {10, 11, 12, 1};
        rtd_mtx[1] = new int[] { 9, 16, 13, 2};
        rtd_mtx[2] = new int[] { 8, 15, 14, 3};
        rtd_mtx[3] = new int[] { 7,  6,  5, 4};

        print(mtx);

        assertmtx(mtx, rtd_mtx);

        int[][] mtx_5 = new int[5][];
        mtx_5[0] = new int[]{ 1,  2,  3,  4, 5};
        mtx_5[1] = new int[]{16, 17, 18, 19, 6};
        mtx_5[2] = new int[]{15, 24, 25, 20, 7};
        mtx_5[3] = new int[]{14, 23, 22, 21, 8};
        mtx_5[4] = new int[]{13, 12, 11, 10, 9};

        print(mtx_5);

        rotate(mtx_5);

        int[][] rtd_mtx_5 = new int[5][];
        rtd_mtx_5[0] = new int[]{13, 14, 15, 16, 1};
        rtd_mtx_5[1] = new int[]{12, 23, 24, 17, 2};
        rtd_mtx_5[2] = new int[]{11, 22, 25, 18, 3};
        rtd_mtx_5[3] = new int[]{10, 21, 20, 19, 4};
        rtd_mtx_5[4] = new int[]{ 9,  8,  7,  6, 5};

        print(rtd_mtx_5);

        assertmtx(mtx_5, rtd_mtx_5);


        int[][] mtx_6 = new int[6][];
        mtx_6[0] = new int[]{ 1,  2,  3,  4,  5,  6};
        mtx_6[1] = new int[]{20, 21, 22, 23, 24,  7};
        mtx_6[2] = new int[]{19, 32, 33, 34, 25,  8};
        mtx_6[3] = new int[]{18, 31, 36, 35, 26,  9};
        mtx_6[4] = new int[]{17, 30, 29, 28, 27, 10};
        mtx_6[5] = new int[]{16, 15, 14, 13, 12, 11};

        print(mtx_6);

        rotate(mtx_6);

        int[][] rtd_mtx_6 = new int[6][];
        rtd_mtx_6[0] = new int[]{16, 17, 18, 19, 20, 1};
        rtd_mtx_6[1] = new int[]{15, 30, 31, 32, 21, 2};
        rtd_mtx_6[2] = new int[]{14, 29, 36, 33, 22, 3};
        rtd_mtx_6[3] = new int[]{13, 28, 35, 34, 23, 4};
        rtd_mtx_6[4] = new int[]{12, 27, 26, 25, 24, 5};
        rtd_mtx_6[5] = new int[]{11, 10,  9,  8,  7, 6};

        print(mtx_6);

        assertmtx(mtx_6, rtd_mtx_6);


    }

    private void assertmtx(int[][] mtx, int[][] rtd_mtx) {
        for (int i = 0; i < rtd_mtx.length; i++) {
            for (int k = 0; k < rtd_mtx.length; k++) {
                assertEquals(mtx[i][k], rtd_mtx[i][k]);
            }
        }
    }

    private void print(int[][] mtx) {
        System.out.println("-----------------");
        for (int[] n : mtx) {
            for (int m : n) {
                System.out.print(m + "\t");
            }
            System.out.println();
        }
    }
}
