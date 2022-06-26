package project.AI;

import project.life.Action;
import project.matrix.MatrixUtil;
import org.junit.jupiter.api.Test;
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

}