package project.life;

import project.board.Position;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Concrete object on the project.board.
 */
public abstract class Piece {
    private final SimpleObjectProperty<Position> positionProperty;

    protected Piece(SimpleObjectProperty<Position> positionProperty){
        this.positionProperty = positionProperty;
    }

    public Position getPosition() {
        return positionProperty.get().copy();
    }

    /**
     * Move if possible the piece one case up.
     *
     * @return if the piece has moved.
     */
    public boolean moveUp(){
        return move(0, -1);
    }


    /**
     * Move if possible the piece one case down.
     *
     * @return if the piece has moved.
     */
    public boolean moveDown(){
        return move(0, 1);
    }


    /**
     * Move if possible the piece one case left.
     *
     * @return if the piece has moved.
     */
    public boolean moveLeft(){
        return move(-1, 0);
    }


    /**
     * Move if possible the piece one case right.
     *
     * @return if the piece has moved.
     */
    public boolean moveRight(){
        return move(1,0);
    }

    /**
     * Move if possible the piece of (x,y) case(s).
     *
     * @return if the piece has moved.
     */
    private boolean move(int x, int y){
        Position position = positionProperty.get();
        if(position.move(x,y)){
            positionProperty.set(position);
            return true;
        }
        return false;
    }
}
