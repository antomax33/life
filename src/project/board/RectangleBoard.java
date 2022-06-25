package project.board;

public class RectangleBoard extends Board{
    private final int width;
    private final int height;

    public RectangleBoard(int width, int height){
        if(width <= 0 || height <= 0) throw new IllegalArgumentException();
        this.width = width;
        this.height = height;
    }

     @Override
    public boolean inside(int x, int y){
        return 0 <= x && x < width &&
                0 <= y && y < height;
     }

}
