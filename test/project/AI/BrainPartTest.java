package project.AI;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BrainPartTest {


    @Test
    void cloneTest(){
        BrainPart bp = new BrainPart(3,5);
        BrainPart bpClone = new BrainPart(bp);

        for (int i = 0; i < 30; i++) {
            double[] information = Math2.randomArray(3);

            assertEquals(bp.testBrain(information), bpClone.testBrain(information));
        }
    }

    @Test
    void modifiedCloneTest(){
        int height = 5;
        int width = 3;
        BrainPart bp = new BrainPart(height,width);
        BrainPart bpClone = new BrainPart(bp);
        bpClone.evolve(0.3);

        for (int i = 0; i < 30; i++) {
            double[] information = Math2.randomArray(height);
            assertNotEquals(bp.testBrain(information), bpClone.testBrain(information));
        }

        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 30; i++) {
            int w = random.nextInt(width);
            int h1 = random.nextInt(height);
            int h2 = random.nextInt(height);
            assertNotEquals(bp.getWeights()[w][h1][h2],
                    bpClone.getWeights()[w][h1][h2]);


            assertNotEquals(bp.getBiais()[w][h1],
                    bpClone.getBiais()[w][h1]);


            assertNotEquals(bp.getFinalWeight()[w][h1],
                    bpClone.getFinalWeight()[w][h1]);


            assertNotEquals(bp.getFinalBiais(),
                        bpClone.getFinalBiais());

        }

    }

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