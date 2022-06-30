package project.life;

import project.board.Board;
import project.board.Position;

public class Apple extends Food{

    private final static int APPLE_ENERGIE = 5;

    public Apple(Position position){
        super(APPLE_ENERGIE, position);
    }

    @Override
    public String toString(){
        return "Apple" + super.toString();
    }
}
