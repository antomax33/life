package project.life;

import project.AI.Brain;
import project.AI.Math2;
import project.board.Board;
import project.board.Intervale;
import project.board.Position;
import project.board.RectangleBoard;

import java.util.List;

public class Blob extends Monster{
    private final Brain brain;
    private final static int VIEW_DISTANCE = 3;
    private final static int LIFE_TIME = 100;
    private int counterTime = 0;
    /*
        the blob see 7x7 rectangles (3 left + 1 + 3 right)
        On top of him he can see 1 rectangle
        then 3 rectangles, then 5 and 7.
     */

    public Blob(Brain brain, Position position){
        super(position);

        this.brain = brain;
    }

    @Override
    public boolean step(){
        counterTime++;
        move();
        return counterTime <= LIFE_TIME;
    }

    @Override
    public String toString(){
        return "blob " + super.toString();
    }


    private void move(){
        Intervale intervale = new RectangleBoard.IntervalRectangle(
                position.getX() - VIEW_DISTANCE, position.getX() + VIEW_DISTANCE,
                position.getY() - VIEW_DISTANCE, position.getY() + VIEW_DISTANCE);

        Board board = position.getBoard();
        List<Piece> pieces = board.getPiece(intervale);

        // Top, right, bottom, left
        double[] information = new double[]{0, 0, 0, 0};
        for (Piece piece: pieces) {
            int x = piece.getPosition().getX();
            int y =  piece.getPosition().getY();

            // It's on purpose to add information in two catégories if the piece is on the
            // diagonale.
            if(y >= -x && y >= x) information[0]+=1;
            if(y >= -x && y <= x) information[1]+=1;
            if(y <= -x && y <= x) information[2]+=1;
            if(y <= -x && y >= x) information[3]+=1;
        }

        Math2.printArray(information, "info");
        Action action = brain.nextAction(information);
        System.out.println(action);
        switch (action){
            case MOVE_LEFT -> moveLeft();
            case MOVE_DOWN -> moveDown();
            case MOVE_UP -> moveUp();
            case MOVE_RIGHT -> moveRight();
        }
    }

}
