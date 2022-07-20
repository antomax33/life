package project.board;

import project.life.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RectangleBoard extends Board{
    private final int width;
    private final int height;

    /**
     * Create a rectangle board of width and height given.
     * From 0 include to value not include
     *
     * @param width of the board.
     * @param height of the board.
     */
    public RectangleBoard(int width, int height, int seed){
        super(seed);
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

        /**
         * An interval of 1 case on a rectangle board
         *
         * @param x position
         * @param y position
         */
        public IntervalRectangle(int x, int y){
            this.minX = x;
            this.maxX = x;

            this.minY = y;
            this.maxY = y;
        }

        public boolean inside(Position position){
            int x = position.getX();
            int y = position.getY();
            return (minX <= x && x <= maxX &&
                minY <= y && y <= maxY);
        }
    }
}
