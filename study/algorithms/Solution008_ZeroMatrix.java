package algorithms;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Solution008_ZeroMatrix {

    void zeroMatrix(int[][] mtx) {
        for (int i = 0; i < mtx.length; i++) {
            for (int k = 0; k < mtx.length; k++) {
                if (mtx[i][k] == 0) {
                    for (int g = 0; g < mtx.length; g++) {
                        mtx[i][g] = 0;
                        mtx[g][k] = 0;
                    }
                    return;
                }
            }
        }
    }

    @Test
    public void zeroMatrixTest() {
        int[][] mtx = new int[5][];
        mtx[0] = new int[]{ 1,  2,  3,  4, 5};
        mtx[1] = new int[]{16, 17, 18, 19, 6};
        mtx[2] = new int[]{15, 24, 25,  0, 7};
        mtx[3] = new int[]{14, 23, 22, 21, 8};
        mtx[4] = new int[]{13, 12, 11, 10, 9};

        print(mtx);

        zeroMatrix(mtx);

        print(mtx);

        int[][] z_mtx = new int[5][];
        z_mtx[0] = new int[]{ 1,  2,  3,  0, 5};
        z_mtx[1] = new int[]{16, 17, 18,  0, 6};
        z_mtx[2] = new int[]{ 0,  0,  0,  0, 0};
        z_mtx[3] = new int[]{14, 23, 22,  0, 8};
        z_mtx[4] = new int[]{13, 12, 11,  0, 9};

        assertmtx(mtx, z_mtx);
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
