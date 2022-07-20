import org.junit.jupiter.api.Test;
import project.AI.Math2;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class understandTest {


    @Test
    void a(){

        for (int i = 0; i <10000; i++) {
            Math.log(i);
        }
    }

    @Test
    void b(){

        for (int i = 0; i <10000; i++) {
            Math.log1p(i);
        }
    }
    @Test
    void c(){

        for (int i = 0; i <10000; i++) {
            Math.log10(i);
        }
    }

}
