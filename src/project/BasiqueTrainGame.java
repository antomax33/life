package project;

import javafx.scene.layout.Pane;
import project.AI.Brain;
import project.board.Board;
import project.board.Position;
import project.life.*;

import java.util.List;

public class BasiqueTrainGame extends Game {
    private final Board board;
    private final Monster monster;
    private double score = 0;

    public BasiqueTrainGame(int seed, int food, Board board, int maxStep, Monster monster){
        super(maxStep);
        this.board = board;
        addFoodRandom(food, seed);
        this.monster = monster;
    }

    @Override
    public boolean step() {
        Position position = monster.getPosition();
        List<Piece> pieces = board.getPiece(position);

        for (Piece piece: pieces) {
            if(piece instanceof Food){
                score += score(step, ((Food) piece).getEnergiesWhenEaten());
                board.removePiece(piece);
            }
        }

        monster.step();
        return super.step();
    }

    @Override
    public Pane pane() {
        return null;
    }

    @Override
    public double getScore(){
        return score;
    }

    public Monster getMonster(){
        return monster;
    }

    private void addFoodRandom(int amount, int seed){
        if(amount<0) throw new IllegalArgumentException();

        board.setSeed(seed);
        for (int i = 0; i < amount; i++) {
            Position position = board.randomPosition();
            board.addPiece(new Apple(position));
        }

    }

    private double score(int step, int amount){
        return amount * Math.log((double) maxStep/(step+1));
    }
}
