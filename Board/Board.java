package Board;

public class Board {
    private String[][] display_board;
    private int scale_factor;

    public String[][] base_board;

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

    public Board(){
        base_board = new String[8][8];
        scale_factor = 3;
        display_board = new String[8 * scale_factor][8 * scale_factor];
        display_board[(Math.abs(0 - 7) * scale_factor) + scale_factor /2 ][(0 * scale_factor) + scale_factor /2 ] = "R ";
        display_board[(Math.abs(0 - 7) * scale_factor) + scale_factor /2 ][(7 * scale_factor) + scale_factor /2 ] = "R ";
    }

    public Board(int scale_factor){
        base_board = new String[8][8];
        this.scale_factor = scale_factor;
        display_board = new String[8 * scale_factor][8 * scale_factor];
    }


    public void setScaleFactor(boolean isDecrease) {
        if (isDecrease) {
            int bufferScale = (scale_factor < 1) ? 1 : scale_factor-1;
            scale_factor = bufferScale;
            display_board = new String[8 * scale_factor][8 * scale_factor];
        } else {
            scale_factor +=1;
            display_board = new String[8 * scale_factor][8 * scale_factor];
        }
    }


    // The size of the board will always be an 8x8 wich is referred to as the base board 
    // When refering to size of the board, what changes is the size of individual tiles, and it's called "display board"
    // Both base board and display board are 2d arrays, with the latter being multiple a of the former times the scale factor

    /* The base size of board is a 2x2, and every size is a multiple of 2, increasing both in
    *  height and width. To render a row of the base board, the size of the display board is the base board multiplied by the
    *  scale factor, then the string representing the tile is added to itself by the number of
    *  the scale factor, and then, the result of this process is copied to the next rows equal to the scale factor.
    *  
    *  To display the pieces of the board, each pieces position is multiplied by the scale factor and then placed
    *  into the display board 2d array.
    * 
    *  To finally print the board to the console, each row is concatenated into a single string and then printed one after
    *  the other.
    */
    public void placePieces() {

    }

    public void printBoard() {
        boolean startBlack = false;
        int bufferScale = 0;
        int yPos = 8;
        for (int i = 0; i < display_board.length; i++){
            if (bufferScale == scale_factor /2) {
                System.out.print(yPos + " ");
            } else{ 
                System.out.print("  ");
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

    }
}
