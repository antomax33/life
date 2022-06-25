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
    }
}