package project.life;

import project.board.Position;
import javafx.beans.property.SimpleObjectProperty;

public abstract class Food extends Piece {
    private final int energiesWhenEaten;
    public Food (SimpleObjectProperty<Position> positionProperty, int energies){
        super(positionProperty);
        this.energiesWhenEaten = energies;
    }

    public int getEnergiesWhenEaten(){return energiesWhenEaten;}

}
