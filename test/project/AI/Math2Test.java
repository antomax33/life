package project.AI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Math2Test {
    @Test
    void cloneTest(){

        double[][] a = Math2.randomArray(5,2);
        double[][] b = Math2.clone(a);
        b[0][0] += 1;

        assertEquals(a[0][0] + 1, b[0][0]);


        double[][][] c = Math2.randomArray(5,2, 3);
        double[][][] d = Math2.clone(c);
        d[0][0][0] += 5;

        assertEquals(c[0][0][0] + 5, d[0][0][0]);


        double[] e = Math2.randomArray(5);
        double[] f = Math2.clone(e);
        f[0] += 1;

        assertEquals(e[0] + 1, f[0]);
    }


    @Test
    void Math2TestClone(){
        double[] a = Math2.randomArray(3);
        double[] b = Math2.clone(a);

        for (int i = 0; i < a.length; i++) {
            assertEquals(a[i], b[i]);
        }
        double[][] c = Math2.randomArray(3, 4);
        double[][] d = Math2.clone(c);

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                assertEquals(c[i][j], d[i][j]);

            }
        }

        double[][][] e = Math2.randomArray(3, 4, 5);
        double[][][] f = Math2.clone(e);

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                for (int k = 0; k < e[0][0].length; k++) {
                    assertEquals(e[i][j][k], f[i][j][k]);
                }
            }
        }
    }
}