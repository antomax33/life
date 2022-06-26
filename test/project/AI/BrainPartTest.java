package project.AI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrainPartTest {

    @Test
    void concreteExample(){
        double[][] biais = new double[][]{{0.2, 0.4}};
        double[] finalBiais = new double[]{0.4};

        double[][][] weight = new double[][][]{
                {{1.4,0.4},{0.3,1.1}}
        };
        double[][] finalWeight = new double[][]{{0.4,0.7}};

        BrainPart brainPart = new BrainPart(weight, biais, finalWeight, finalBiais);
        double answer = brainPart.testBrain(new double[]{0.2, 0.4});

        assertEquals(0.76111, answer, 1e-4);
    }

    @Test
    void concreteExample2(){
        double[][] biais = {{0.7, 0.6}, {0.2, 0.5}};
        double[] finalBiais = {0.3};

        double[][][] weight = new double[][][]{{
                {0.8, 0.7}, {1.3, 1.2}},
                {{0.1, 0.4}, {0.2, 0.7}}};
        double[][] finalWeight = new double[][]{{0.4, 0.5}};

        BrainPart brainPart = new BrainPart(weight, biais, finalWeight, finalBiais);
        double answer = brainPart.testBrain(new double[]{0.8, 0.4});

        assertEquals(0.7207684146, answer, 1e-9);
    }
}