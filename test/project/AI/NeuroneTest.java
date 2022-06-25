package project.AI;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NeuroneTest {

    @Test
    void classique(){
        Neurone n = new NeuroneStart(10);
        n.clear();
        List<Neurone> nextRange = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nextRange.add(new NeuroneMiddle(2));
        }
        n.setLinks(nextRange);
        n.evolve(nextRange);

        List<Neurone> neuroneEnds = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            neuroneEnds.add(new NeuroneEnd());
        }

        for (Neurone next: nextRange) {
            next.setLinks(neuroneEnds);
        }


        n.set(0.8);
        System.out.println(n);
        n.send();
        System.out.println("-----------------------------next Range -----------------------------");
        for (Neurone next: nextRange) {
            System.out.println(next);
            next.send();
        }

        double sum=0;
        System.out.println("-----------------------------end Range -----------------------------");
        for(Neurone end: neuroneEnds){
            sum+= end.getValue();
            System.out.println(end);
        }

        assertTrue(sum != 0);

    }
}