package project;

import javafx.scene.layout.Pane;
import project.AI.Brain;
import project.board.Board;
import project.board.Position;
import project.life.Apple;
import project.life.Blob;
import project.life.Monster;

public class basiqueTrainGame extends Game {
    private final Board board;
    private final Monster monster;

    public basiqueTrainGame(int food, Board board){
        this.board = board;
        addFoodRandom(food);
        monster = new Blob(new Brain(4,1), board.randomPosition());
    }

    public boolean step() {
        return monster.step();
    }

    public Pane pane() {
        return null;
    }


    private void addFoodRandom(int amount){
        if(amount<0) throw new IllegalArgumentException();

        for (int i = 0; i < amount; i++) {
            Position position = board.randomPosition();
            System.out.println(position);
            board.addPiece(new Apple(position));
        }

    }
}
