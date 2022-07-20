package project;

import org.junit.jupiter.api.Test;
import project.AI.Brain;
import project.board.Board;
import project.board.Position;
import project.board.RectangleBoard;
import project.life.Blob;
import project.life.Monster;

class basiqueTrainGameTest {


    @Test
    void classic(){
        Board board = new RectangleBoard(5,7, 0);
        Brain brain = new Brain(4,1);
        Monster monster = new Blob(brain, new Position(board, 3, 2));
        Game game = new BasiqueTrainGame(0, 10, board, 100, monster);

        boolean alive = true;
        while (alive){
            alive = game.step();
        }


    }

}