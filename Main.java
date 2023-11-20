import java.io.IOException;
import java.util.Scanner;

import Board.DisplayBoard;

public class Main {
    public static void main(String... arg) throws IOException, InterruptedException {

        DisplayBoard playBoard = new DisplayBoard();

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
}
