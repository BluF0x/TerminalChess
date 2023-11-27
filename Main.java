import java.io.IOException;
import java.util.Scanner;

import Board.Board;
import Board.Coordinate;
import Board.DisplayBoard;
import Piece.Piece;
import Piece.Rook;
import Piece.Piece.Team;
import Piece.Bishop;
import Piece.Knight;
import Piece.King;
import Piece.Queen;
import Piece.Pawn;

public class Main {
    public static void main(String... arg) throws IOException, InterruptedException {

        DisplayBoard displayBoard = new DisplayBoard();
        Board playBoard = new Board();

        // Piece[] pieces = new Piece[]{
        //     new Rook(Team.WHITE, Coordinate.A, 1),
        //     new Rook(Team.WHITE, Coordinate.H, 1),
        //     new Rook(Team.BLACK, Coordinate.A, 8),
        //     new Rook(Team.BLACK, Coordinate.H, 8),
        //     new Bishop(Team.WHITE, Coordinate.C, 1),
        //     new Bishop(Team.WHITE, Coordinate.F, 1),
        //     new Bishop(Team.BLACK, Coordinate.C, 8),
        //     new Bishop(Team.BLACK, Coordinate.F, 8),
        //     new Knight(Team.WHITE, Coordinate.B, 1),
        //     new Knight(Team.WHITE, Coordinate.G, 1),
        //     new Knight(Team.BLACK, Coordinate.B, 8),
        //     new Knight(Team.BLACK, Coordinate.G, 8),
        //     new King(Team.WHITE, Coordinate.E, 1),
        //     new King(Team.BLACK, Coordinate.E, 8),
        //     new Queen(Team.WHITE, Coordinate.D, 1),
        //     new Queen(Team.BLACK, Coordinate.D, 8)

        // };

        // Piece[] blackPawns = new Piece[8];
        // Piece[] whitePawns = new Piece[8];

        // for (int i =0; i < 8; i++) {
        //     blackPawns[i] = new Pawn(Team.BLACK, new int[]{6, i});
        // }

        // for (int i =0; i < 8; i++) {
        //     whitePawns[i] = new Pawn(Team.WHITE, new int[]{1, i});
        // }


        Rook rook = new Rook(Team.WHITE, Coordinate.E, 4);
        Queen queen = new Queen(Team.BLACK, Coordinate.H, 4);
        // Rook rook2 = new Rook(Team.WHITE, Coordinate.H, 1);
        playBoard.placePiece(rook);
        playBoard.placePiece(queen);
        // playBoard.placePiece(rook2);


        Scanner input = new Scanner(System.in);

        boolean isPlaying = true;

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        while (isPlaying){

            //Comando para limpar a tela
            // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
            rook.calculateMovement(playBoard);

            System.out.println("==============================================");
            System.out.println("|| ██████ ╗██╗  ██╗███████╗███████╗███████╗ ||");
            System.out.println("|| ██╔════╝██║  ██║██╔════╝██╔════╝██╔════╝ ||");
            System.out.println("|| ██║     ███████║█████╗  ███████╗███████╗ ||");
            System.out.println("|| ██║     ██╔══██║██╔══╝  ╚════██║╚════██║ ||");
            System.out.println("|| ███████╗██║  ██║███████╗███████║███████║ ||");
            System.out.println("|| ╚══════╝╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝ ||");
            System.out.println("==============================================");

            displayBoard.printBoard(playBoard);

            System.out.print("Digite o seu comando: ");

            String command = input.nextLine();

            switch (command) {
                case "q":
                    isPlaying = false;                    
                    break;
                
                case "su":
                    displayBoard.setScaleFactor(false);
                    break;

                case "sd":
                    displayBoard.setScaleFactor(true);
                    break;
                default:
                    int yPos;
                    char[] splitCommand = command.toCharArray();
                    switch(Character.toUpperCase(splitCommand[1])) {
                        case 'A':
                            yPos = Coordinate.A.numberCoordinate;
                            break;
                        case 'B':
                            yPos = Coordinate.B.numberCoordinate;
                            break;
                        case 'C':
                            yPos = Coordinate.C.numberCoordinate;
                            break;
                        case 'D':
                            yPos = Coordinate.D.numberCoordinate;
                            break;
                        case 'F':
                            yPos = Coordinate.F.numberCoordinate;
                            break;
                        case 'G':
                            yPos = Coordinate.G.numberCoordinate;
                            break;
                        case 'H':
                            yPos = Coordinate.H.numberCoordinate;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid input character: ");
                    }
                    rook.MovePiece(Character.getNumericValue(splitCommand[2]-1), yPos);

                    break;
                }

            }

            input.close();
            
            // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        }
    }
