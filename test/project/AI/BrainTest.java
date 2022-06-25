package project.AI;

import main.java.matrices.DMatrix;
import project.matrix.MatrixUtil;
import org.junit.jupiter.api.Test;

class BrainTest {

    @Test
    void classique(){

        Thinkable thinkable = new Brain(2);
        thinkable.nextAction(new Double[] {1d, 2d});
        DMatrix matrix = MatrixUtil.randn(5,3);
    }


    @Test
    void example1(){
        DMatrix b = new DMatrix();
        b.addColumn(0.2,0.4);
        b.addColumn(0.2,0.5);

        DMatrix w = new DMatrix();
        w.addColumn(1.4, 0.3);
        w.addColumn(0.4, 1.1);

        Brain brain = new Brain(w,b);
        Double[] information = new Double[]{0.2,0.4};
        brain.nextAction(information);
    }

    @Test
    void example2(){
        DMatrix b = new DMatrix();
        b.addColumn(0.2,0.4, 0.8);
        b.addColumn(0.2,0.5, 0.8);

        DMatrix w = new DMatrix();
        w.addColumn(1.4, 1.1,0.5);
        w.addColumn(0.4, 0.3,0.3);

        Brain brain = new Brain(w,b);
        Double[] information = new Double[]{0.2,0.4, 0.8};
        brain.nextAction(information);
    }

}