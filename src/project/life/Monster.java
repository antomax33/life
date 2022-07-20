package project.life;

import project.board.Position;
import javafx.beans.property.SimpleObjectProperty;

public abstract class Monster extends Piece{
    protected Monster(Position position) {
        super(position);
    }

    public abstract Monster clone(Position position);
    public abstract void evolve(double speed);
}
