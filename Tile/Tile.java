package Tile;
import java.util.ArrayList;
import java.util.List;

import Piece.Piece;

public class Tile {
    boolean isAttackedWhite;
    boolean isAttackedBlack;
    Piece currentPiece;
    // List<Piece> possibleMove;
    ArrayList<Piece> possibleMoves;

    public Tile() {
        isAttackedBlack = false;
        isAttackedWhite = false;
        currentPiece = null;
        possibleMoves = new ArrayList<Piece>();
            
    }
}
