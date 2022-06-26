import org.junit.jupiter.api.Test;
import project.AI.Math2;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class understandTest {


    @Test
    void a(){

        double[][][] a = Math2.randomArray(5, 2, 3);

        Math2.printArray(a, "a");
        Math2.printArray(a[0], "a[0]");
        System.out.println(a.length);
        System.out.println(a[0].length);
        System.out.println(a[0][0].length);
    }
}
