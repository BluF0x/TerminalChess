import java.io.IOException;
import java.util.Scanner;

import Board.Board;

public class Main {
    public static void main(String... arg) throws IOException, InterruptedException {

        Board playBoard = new Board();

        Scanner input = new Scanner(System.in);

        boolean isPlaying = true;

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        while (isPlaying){

            //Comando para limpar a tela
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 

            playBoard.printBoard();

            System.out.print("Digite o seu comando: ");

            String command = input.nextLine();

            switch (command) {
                case "q":
                    isPlaying = false;                    
                    break;
                
                case "su":
                    playBoard.setScaleFactor(false);
                    break;

                case "sd":
                    playBoard.setScaleFactor(true);
                    break;
            
                default:
                    break;
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
        
        for (int i = 0; i < board.length; i++)
        {
            for ( int j = 0; j < board[i].length; j++)
            {
                displayBoard[i][j + 3] = "A";
                
            }
        }


    }


}
