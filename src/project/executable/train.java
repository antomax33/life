package project.executable;

import org.junit.jupiter.api.RepeatedTest;
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
    private final double SPEED_EVOLVE = 0.5;
    private final int ROUNDS = 30;
    private final int NUMBER_OF_MAPS = 100;
    private final int WIDTH = 101;
    private final int HEIGHT = 101;
    private final static int FOOD = 500;
    private final static int MAX_STEP = 100;

    @RepeatedTest(2)
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
        }

        for (int i = 0; i < ROUNDS; i++) {
            bestMonster = train(bestMonster);
        }

        System.out.println("not trained");
        double scoreNotTrained = 0;
        for (int i = 0; i < NUMBER_OF_MAPS; i++) {
            bestMonster.getPosition().setPosition(WIDTH/2, HEIGHT/2);
            Game gameNotTrained = basiqueGame(NUMBER_OF_MAPS + i + 1, bestMonster);
            scoreNotTrained += gameNotTrained.autoGame();
        }
        System.out.println(scoreNotTrained/NUMBER_OF_MAPS);

    }


    @RepeatedTest(5)
    void notTrained(){
        double score = 0;
        for (int i = 0; i < NUMBER_OF_MAPS; i++) {
            BasiqueTrainGame game = basiqueGame(NUMBER_OF_MAPS + 1 + i);
            score+= game.autoGame();
        }
        System.out.println(score/NUMBER_OF_MAPS);
    }

    private double testMap(Monster monster, int firstSeed, int numberOfMap){
        double score = 0;
        for (int i = firstSeed; i < firstSeed + numberOfMap; i++) {
            Board board = new RectangleBoard(WIDTH, HEIGHT, firstSeed + i);
            Game game = new BasiqueTrainGame(i, FOOD, board, MAX_STEP, monster);
            score += game.autoGame();
        }
        return score;
    }

    private Monster train(Monster monster){
        double bestScore = 0;
        Monster bestMonster = null;
        Board board = monster.getPosition().getBoard();
        for (int i = 0; i < NUMBER_MONSTER; i++) {
            Monster newMonster = monster.clone();
            newMonster.changeBoard(new Position(board, WIDTH/2, HEIGHT/2));
            newMonster.evolve(SPEED_EVOLVE);
            double score = 0;
            for (int j = 0; j < NUMBER_OF_MAPS; j++) {
                newMonster.getPosition().setPosition(WIDTH/2, HEIGHT/2);
                Game game = basiqueGame(j, newMonster);
                score += train(game);
            }

            if(score > bestScore){
                bestScore = score;
                bestMonster = newMonster;
            }
        }
        System.out.println("ms " + bestScore/NUMBER_OF_MAPS);
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
        return new BasiqueTrainGame(seed, FOOD, board, MAX_STEP, monster);
    }



    private double train(Game game){

        for (int j = 0; j < 100; j++) {
            game.step();
        }
        return game.getScore();
    }
}
