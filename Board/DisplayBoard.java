package Board;

import Piece.Piece;
import Tile.Tile;

public class DisplayBoard {
   
    private String[][] display_board;
    private int scale_factor;

    public Board base_board;

    public enum HorizontalTiles {
        A(0), B(1), C(2), D(3), E(4), F(5), G(6), H(7);

        private int pos;

        private HorizontalTiles(int pos){
            this.pos = pos;
        }

        public int getPos() {
            return pos;
        }
    }

    public DisplayBoard(){
        base_board = new Board();
        scale_factor = 1;
        display_board = new String[8 * scale_factor][8 * scale_factor];
    }

    public DisplayBoard(Board base_board){
        this.base_board = base_board;
        this.scale_factor = 3;
        display_board = new String[base_board.getWidth() * scale_factor][base_board.getHeight() * scale_factor];
    }


    public void setScaleFactor(boolean isDecrease) {
        if (isDecrease) {
            int bufferScale = (scale_factor - 2 < 1) ? 1 : scale_factor-2;
            scale_factor = bufferScale;
            display_board = new String[8 * scale_factor][8 * scale_factor];
        } else {
            scale_factor +=2;
            display_board = new String[8 * scale_factor][8 * scale_factor];
        }
    }


    public void placePieces() {

    }

    public void printBoard(Board playBoard) {
        Tile[][] originalBoard = playBoard.playBoard;

        for (int i = 0 ; i < originalBoard.length; i++){
            for (int j = 0; j < originalBoard[i].length; j++){
                Piece pieceName = originalBoard[i][j].currentPiece;
                if (pieceName != null) {
                    display_board[(7-i) * scale_factor + (scale_factor/2)][ j* scale_factor + (scale_factor/2)] = pieceName.getPieceName() + " ";
                    // System.out.println(pieceName.getPieceName());
                }
            }
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
            if (startBlack) { // Switch to a switch case 
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