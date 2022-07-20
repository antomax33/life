package project.board;

import project.life.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Board {

    protected Random random;
    protected final List<Piece> pieces;
    private final int seed;
    //TODO change arraylist by set
    protected Board(int seed){
        this.pieces = new ArrayList<>();
        this.seed = seed;
        random = new Random(seed);
    }

    public void addPiece(Piece piece){pieces.add(piece);}
    public void removePiece(Piece piece){pieces.remove(piece);}

    public abstract boolean inside(int x, int y);
    public abstract Position randomPosition();
    public List<Piece> getPiece(Intervale intervale){
        List<Piece> piecesInsideInterval = new ArrayList<>();

        for (Piece piece: pieces) {
            if(intervale.inside(piece.getPosition())) piecesInsideInterval.add(piece);
        }

        return piecesInsideInterval;
    }

    public List<Piece> getPiece(Position position){
        return getPiece(new RectangleBoard.IntervalRectangle(position.getX(), position.getY()));
    }

    public void setSeed(int seed){
        random = new Random(seed);
    }
}
