package project;

import org.junit.jupiter.api.Test;
import project.board.Board;
import project.board.RectangleBoard;

import static org.junit.jupiter.api.Assertions.*;

class basiqueTrainGameTest {


    @Test
    void classic(){
        Board board = new RectangleBoard(5,7);
        Game game = new basiqueTrainGame(10, board);

        boolean alive = true;
        while (alive){
            alive = game.step();
            System.out.println("*");
        }


    }

}