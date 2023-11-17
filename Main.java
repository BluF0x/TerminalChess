import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String... arg) throws IOException, InterruptedException {

        final int BOARD_WIDTH = 8, BOARD_HEIGHT = 8;

        String[][] board =  new String[BOARD_HEIGHT][BOARD_WIDTH];
        String[][] displayBoard = new String[BOARD_HEIGHT * 2][BOARD_WIDTH * 2];
        // String[][] board =  new String[24][24];
        Scanner input = new Scanner(System.in);

        boolean isPlaying = true;

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        while (isPlaying){

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            printBorad(board);

            System.out.print("Digite o seu comando: ");

            String command = input.nextLine();

            if (command.equals("q") ){
                isPlaying = false;
                break;
            } else {
                board[4][4] = command;
            }

        }

        input.close();
        
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

    }

    /* Esse método converte um board em um novo multiplicador
    */
    static void scaleBoard(String[][] board, int newSizeMult) {
        int board_x = board.length, board_y = board[board_x].length;
        String[][] displayBoard =  new String[board_x * newSizeMult][board_y * newSizeMult];
        


    }

    static void printBorad(String[][] board) {
        for (int i = 0; i < board.length; i++){
            boolean startWhite = i % 2 == 0;
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == null) {
                    if (startWhite) {
                        if (j % 2 == 0) {
                            board[i][j] = "██";

                        } else {
                            board[i][j] = "▓▓";
                        } 
                    } else {
                        if (j % 2 != 0) {
                            board[i][j] = "██";
                        } else {
                            board[i][j] = "▓▓";
                        } 
                    }
                } 
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }

    }
}
