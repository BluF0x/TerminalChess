package Board;

import Piece.Piece;
import Tile.Tile;

public class Board {
    private int board_height;
    private int board_width;
    
    public Tile[][] playBoard;

    public Board(){
        this.board_height = 8;
        this.board_width = 8;
        this.playBoard = new Tile[board_height][board_width];

        for (int i = 0; i < playBoard.length; i++){
            for (int j = 0; j < playBoard[i].length; j++){
                playBoard[i][j] = new Tile();
            }
        }
    }

    public int getWidth() {
        return this.board_width;
    }

    public int getHeight() {
        return this.board_height;
    }

    public Tile[][] getPlayBoard() {
        return this.playBoard;
    }

    public void calculateMoves() {

    }

    public void placePiece(Piece piece) {
        playBoard[piece.position[0]][piece.position[1]].currentPiece = piece;
    }

    public void placePiece(Piece[] pieceArray) {
        for (int i = 0; i < pieceArray.length; i++){
            playBoard[pieceArray[i].position[0]][pieceArray[i].position[1]].currentPiece = pieceArray[i];
        }
    }

    public void initializeBoard() {
        
    }

}