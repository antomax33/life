package project.executable;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import project.AI.Brain;
import project.Game;
import project.BasiqueTrainGame;
import project.board.Board;
import project.board.Position;
import project.board.RectangleBoard;
import project.life.Blob;
import project.life.Monster;

public class train {

    private final static int NUMBER_MONSTER = 200;
    private final double SPEED_EVOLVE = 1;
    private final int ROUNDS = 30;
    private final int NUMBER_OF_MAPS = 10;
    private final int WIDTH = 101;
    private final int HEIGHT = 101;
    private final static int FOOD = 500;

    @RepeatedTest(20)
    void train(){
        double maxScore = -1;
        Monster bestMonster = null;
        for (int i = 0; i < NUMBER_MONSTER; i++) {
            BasiqueTrainGame game = basiqueGame(0);
            double score = train(game);

            if(score > maxScore){
                maxScore = score;
                bestMonster = game.getMonster();
            }
            //System.out.println("score " + score);
        }
        System.out.println("meilleur score " + maxScore);

        for (int i = 0; i < ROUNDS; i++) {
            bestMonster = train(bestMonster);
        }
    }

    public Monster train(Monster monster){
        double maxScore = 0;
        Monster bestMonster = null;
        Board board = monster.getPosition().getBoard();
        for (int i = 0; i < NUMBER_MONSTER; i++) {
            Monster newMonster = monster.clone(new Position(board, WIDTH/2,HEIGHT/2));
            monster.evolve(SPEED_EVOLVE);
            double score = 0;
            for (int j = 0; j < NUMBER_OF_MAPS; j++) {
                Game game = basiqueGame(j, newMonster);
                score += train(game);
            }

            if(score > maxScore){
                maxScore = score;
                bestMonster = newMonster;
            }
        }
        System.out.println("ms " + maxScore);
        return bestMonster;
    }


    private BasiqueTrainGame basiqueGame(int seed){
        Board board = new RectangleBoard(WIDTH, HEIGHT, seed);
        Brain brain = new Brain(4, 1);
        Monster monster = new Blob(brain, new Position(board, WIDTH/2, HEIGHT/2));
        return new BasiqueTrainGame(seed, FOOD, board, 100, monster);
    }

    private BasiqueTrainGame basiqueGame(int seed, Monster monster){
        Board board = new RectangleBoard(WIDTH, HEIGHT, seed);
        return new BasiqueTrainGame(seed, FOOD, board, 100, monster);
    }

    private double train(Game game){

        for (int j = 0; j < 100; j++) {
            game.step();
        }
        return game.getScore();
    }
}
