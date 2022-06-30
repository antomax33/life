package project.board;

import project.life.Piece;

import java.util.ArrayList;
import java.util.List;

public abstract class Board {

    protected final List<Piece> pieces;

    protected Board(){
        this.pieces = new ArrayList<>();
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
}
