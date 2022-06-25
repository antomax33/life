import org.junit.jupiter.api.Test;
import project.AI.Math2;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class understandTest {


    @Test
    void a(){

        double[][] a = Math2.randomArray(5,2);
        double[][] b = Math2.clone(a);
        b[0][0] += 1;

        assertEquals(a[0][0] + 1, b[0][0]);
        Math2.printArray(a, "a");
        Math2.printArray(b, "b");
    }
}
