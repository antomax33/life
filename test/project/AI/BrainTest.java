package project.AI;

import project.matrix.MatrixUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BrainTest {

    @Test
    void classique(){

        Thinkable thinkable = new Brain(2, 7);
        thinkable.nextAction(new double[] {1d, 2d});
    }


    @Test
    void example1(){
        Brain a = new Brain(2,4);

        new Brain(a);
    }

    @Test
    void example2(){
    }

    @Test
    void array(){
        double[] a = Math2.randomArray(5);
        Math2.printArray(a, "a");

        double[][] b = Math2.randomArray(5,4);
        Math2.printArray(b, "b");

        double[][][] c = Math2.randomArray(5,3,7);
        Math2.printArray(c, "c");
    }


    @Test
    void concreteExample(){
        double[][] biais = new double[][]{{0.2, 0.4}};
        double[] finalBiais = new double[]{0.4};

        double[][][] weight = new double[][][]{
                {{1.4,0.4},{0.3,1.1}}
        };
        double[][] finalWeight = new double[][]{{0.4,0.7}};

        Brain brain = new Brain(weight, biais, finalWeight, finalBiais);
        double answer = brain.testBrain(new double[]{0.2, 0.4});

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

        Brain brain = new Brain(weight, biais, finalWeight, finalBiais);
        double answer = brain.testBrain(new double[]{0.8, 0.4});

        assertEquals(0.7207684146, answer, 1e-9);
    }
}