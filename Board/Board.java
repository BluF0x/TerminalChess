package Board;

import Piece.Piece;
import Tile.Tile;
import Piece.Rook;

import java.util.ArrayList;

public class Board {
    private int board_height;
    private int board_width;
    private ArrayList<Piece> pieces;
    private int scale_factor = 1;

    public Tile[][] playBoard;

    public Board(){
        this.board_height = 8;
        this.board_width = 8;
        this.playBoard = new Tile[board_height][board_width];
        this.pieces = new ArrayList<>();

        for (int i = 0; i < playBoard.length; i++){
            for (int j = 0; j < playBoard[i].length; j++){
                playBoard[i][j] = new Tile();
            }
        }
    }

    public void setScaleFactor(boolean isDecrease) {
        if (isDecrease) {
            int bufferScale = (scale_factor - 2 < 1) ? 1 : scale_factor-2;
            scale_factor = bufferScale;
        } else {
            scale_factor +=2;
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
        this.playBoard = new Tile[board_height][board_width];
        for (int i = 0; i < playBoard.length; i++){
            for (int j = 0; j < playBoard[i].length; j++){
                playBoard[i][j] = new Tile();
            }
        }
        for (Piece iteratorPiece : pieces) {
            playBoard[iteratorPiece.position[0]][iteratorPiece.position[1]].currentPiece = iteratorPiece;
            iteratorPiece.calculateMovement(this);
        }
    }

    public void placePiece(Piece piece) {
        pieces.add(piece);
    }

    public void placePiece(Piece[] pieceArray) {
        for (int i = 0; i < pieceArray.length; i++){
            pieces.add(pieceArray[i]);
        }
    }

    public void movePiece(char pieceName, int y, int x ) {
        System.out.println("piece name:" +pieceName);
        System.out.println("x coordinate: " +x);
        System.out.println("y coordinate: " +y);
        for ( Piece possiblePiece : playBoard[y][x].possibleMoves ){

            if ( possiblePiece instanceof Rook ) {

                playBoard[possiblePiece.position[0]][possiblePiece.position[1]].currentPiece = null;
                possiblePiece.position = new int[]{y, x};

                playBoard[y][x].currentPiece = possiblePiece;
            }
        }
    }

    public void printBoard() {
        String[][] display_board = new String[board_width * scale_factor][board_height * scale_factor];

        for (Piece iteratorPiece : pieces){
            int y = iteratorPiece.position[0];
            int x = iteratorPiece.position[1];
            System.out.println(x);
            System.out.println(y);
            display_board[(7-y) * scale_factor + (scale_factor/2)][ x* scale_factor + (scale_factor/2)] = iteratorPiece.getPieceName() + " ";
        }

        boolean startBlack = false;
        int bufferScale = 0;
        int yPos = 8;
        for (int i = 0; i < display_board.length; i++){
            if (bufferScale == scale_factor /2) {
                System.out.print(yPos + "| ");
            } else{ 
                System.out.print(" | ");
            }

            int j = 0;
            if (startBlack) { 
                while (j < display_board[i].length) {
                    for (int b = 1; b <= scale_factor; b++){
                        if (display_board[i][j] == null) {display_board[i][j] = "▓▓";}
                        System.out.print(display_board[i][j]);
                        j++;
                    }
                    for (int w = 1; w <= scale_factor; w++){
                        if (display_board[i][j] == null) {display_board[i][j] = "██";}
                        System.out.print(display_board[i][j]);
                        j++;
                    }
                }
            } else {
                while (j < display_board[i].length) {
                    for (int w = 1; w <= scale_factor; w++){
                        if (display_board[i][j] == null) {display_board[i][j] = "██";}
                        System.out.print(display_board[i][j]);
                        j++;
                    }
                    for (int b = 1; b <= scale_factor; b++){
                        if (display_board[i][j] == null) {display_board[i][j] = "▓▓";}
                        System.out.print(display_board[i][j]);
                        j++;
                    }
                }
            }
            bufferScale++;
            System.out.println("");
            if (bufferScale >= scale_factor){
                startBlack = !startBlack; 
                bufferScale = 0;
                yPos--;
            }
        }

        StringBuilder letterPadding = new StringBuilder();

        for (int i = 1; i < scale_factor; i++){
            letterPadding.append("  ");
        }


        System.out.print("   ");

        for (int i = 0; i < display_board[0].length; i++){
            System.out.print("--");
        }

        System.out.println("");

        for (int a = 0; a < scale_factor/2; a++){
            System.out.print("  ");
        }

        System.out.print("   ");

        System.out.print("A "+letterPadding+"B "+letterPadding+"C "+letterPadding+"D "+letterPadding+
                         "E "+letterPadding+"F "+letterPadding+"G "+letterPadding+"H ");
        System.out.println("\n");
    }

}