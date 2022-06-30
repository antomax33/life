package project.board;

import project.life.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RectangleBoard extends Board{
    private final int width;
    private final int height;
    private final Random random = new Random(0);

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

    @Override
    public Position randomPosition() {
        return new Position(this, random.nextInt(width), random.nextInt(height));
    }

    @Override
    public List<Piece> getPiece(Intervale intervale) {
        List<Piece> piecesInsideInterval = new ArrayList<>();

        for (Piece piece: pieces) {
            if(intervale.inside(piece.getPosition()))
                piecesInsideInterval.add(piece);
        }

        return piecesInsideInterval;
    }

    public static class IntervalRectangle extends Intervale{

        private final int minX, maxX, minY, maxY;

        /**
         * An interval on a rectangle board
         *
         * @param minX include
         * @param maxX include
         * @param minY include
         * @param maxY include
         */
        public IntervalRectangle(int minX, int maxX, int minY, int maxY){
            this.minX = minX;
            this.maxX = maxX;
            this.minY = minY;
            this.maxY = maxY;
        }

        public boolean inside(Position position){
            int x = position.getX();
            int y = position.getY();
            return (minX <= x && y <= maxX &&
                minY <= y && y <= maxY);
        }
    }
}
