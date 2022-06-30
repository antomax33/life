package project.life;

import project.board.Position;
import javafx.beans.property.SimpleObjectProperty;

public abstract class Monster extends Piece{
    protected Monster(Position position) {
        super(position);
    }

}
