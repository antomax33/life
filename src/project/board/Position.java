package project.board;

public final class Position{
    private final Board board;
    private int x;
    private int y;

    public int getX(){return x;}
    public int getY(){return y;};

    public Position(Board board, int x, int y){
        if(!board.inside(x,y)) throw new IllegalArgumentException();

        this.board = board;
        this.x = x;
        this.y = y;
    }

    /**
     * Move if possible the piece (x,y) case(s).
     *
     * @return if the piece has moved.
     */


    public boolean move(int x, int y){
        int newX = this.x + x;
        int newY = this.y + y;
        if(board.inside(newX,newY)){
            this.x = newX;
            this.y = newY;
            return true;
        }
        return false;
    }

    public void setPosition(int x, int y){
        if(!board.inside(x, y)) throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    /**
     * Copy the position.
     *
     * @return A copy of the position.
     */
    public Position copy(){
        return new Position(board, x,y);
    }

    public Board getBoard(){
        return board;
    }
}