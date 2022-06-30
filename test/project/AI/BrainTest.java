package project.AI;

import project.life.Action;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BrainTest {

    @Test
    void classique(){

        Thinkable thinkable = new Brain(2, 7);
        Action action = thinkable.nextAction(new double[] {1d, 2d});
        System.out.println(action);
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
    void cloneDifferent(){
        Brain a = new Brain(3,2);
        Brain b = new Brain(a);
        Random r = new Random(System.currentTimeMillis());

        boolean different = false;
        int i = 0;
        while (i<100 && !different){
            System.out.println(i);

            b.evolve(0.1);
            double[] information = {r.nextGaussian(), r.nextGaussian(), r.nextGaussian()};

            Action actionA = a.nextAction(information);
            Action actionB = b.nextAction(information);
            if(actionA != actionB){
                different = true;
            }

            i++;
        }

        assertTrue(different);

    }


    @Test
    void evolve(){
        Brain brain = new Brain(3,4);
        Random random = new Random(System.currentTimeMillis());

        double[] information = new double[]{random.nextGaussian(), random.nextGaussian(),
                random.nextGaussian()};

        Action notExpected = brain.nextAction(information);
        System.out.println(notExpected);

        int i=0;
        boolean identique = true;
        while (i < 1000 && identique){
            brain.evolve(0.1);
            Action newAction = brain.nextAction(information);
            System.out.println(newAction);

            if(newAction != notExpected) identique=false;

            i++;
        }

    }

}