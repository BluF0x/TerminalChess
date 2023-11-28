package Tile;
import java.util.ArrayList;

import Piece.Piece;

public class Tile {
    public boolean isAttackedWhite;
    public boolean isAttackedBlack;
    public Piece currentPiece;
    public ArrayList<Piece> possibleMoves;

    public Tile() {
        isAttackedBlack = false;
        isAttackedWhite = false;
        currentPiece = null;
        possibleMoves = new ArrayList<Piece>();
    }

    public void removePiece() {
        this.currentPiece = null;
    }
    
}
