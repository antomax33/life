import main.java.matrices.DMatrix;
import main.java.matrices.GMatrix;
import main.java.matrices.util.MatMaths;
import org.junit.jupiter.api.Test;
import project.matrix.MatrixUtil;

import java.util.Random;

public class understandTest {


    @Test
    void a(){
        GMatrix<Float> matrix = new GMatrix<Float>(3,5);
        System.out.println("h " + matrix.height());
        System.out.println("w " + matrix.width());
        matrix.set(2,4,2f);

        Random r = new Random(0);

        DMatrix m1 = new DMatrix(4,3);
        DMatrix m2 = new DMatrix(3,7);
        m1.map(x -> r.nextGaussian());
        m2.map(x -> r.nextGaussian());
        DMatrix m3 = MatMaths.mul(m1, m2);
        MatrixUtil.printMatrix(m3, "m3");
    }
}
