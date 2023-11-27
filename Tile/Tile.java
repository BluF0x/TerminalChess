package Tile;
import java.util.ArrayList;

import Piece.Piece;

public class Tile {
    public boolean isAttackedWhite;
    public boolean isAttackedBlack;
    public Piece currentPiece;
    // List<Piece> possibleMove;
    public ArrayList<Piece> possibleMoves;

    public Tile() {
        isAttackedBlack = false;
        isAttackedWhite = false;
        currentPiece = null;
        possibleMoves = new ArrayList<Piece>();
    }
    
}
