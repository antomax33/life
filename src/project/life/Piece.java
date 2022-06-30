package project.life;

import project.board.Position;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Concrete object on the project.board.
 */
public abstract class Piece {
    protected final Position position;
    protected Piece(Position position){
        this.position = position;
    }

    /**
     * Move if possible the piece one case up.
     *
     * @return if the piece has moved.
     */
    public boolean moveUp(){
        return position.move(0, -1);
    }


    /**
     * Move if possible the piece one case down.
     *
     * @return if the piece has moved.
     */
    public boolean moveDown(){
        return position.move(0, 1);
    }


    /**
     * Move if possible the piece one case left.
     *
     * @return if the piece has moved.
     */
    public boolean moveLeft(){
        return position.move(-1, 0);
    }


    /**
     * Move if possible the piece one case right.
     *
     * @return if the piece has moved.
     */
    public boolean moveRight(){
        return position.move(1, 0);
    }

    public Position getPosition(){
        return position;
    }

    @Override
    public String toString(){
        return position.toString();
    }

    public boolean step(){
        return true;
    }
}
