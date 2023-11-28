package Piece;

import Board.Coordinate;
import Tile.Tile;
import Board.Board;

public class Rook extends Piece {
    private final int value = 5;

    public Rook(Team team_color, int[] position) {
        super(team_color, position);
        
        if (team_color == Team.WHITE){
            // this.piece_name = 'R';
            setPieceName('R');
        } else {
            // this.piece_name = 'r';
            setPieceName('r');
        }
    }

    public Rook(Team team_color, Coordinate y, int x) {
        super(team_color, y, x);
        
        if (team_color == Team.WHITE){
            // this.piece_name = 'R';
            setPieceName('R');
        } else {
            // this.piece_name = 'r';
            setPieceName('r');
        }

    }

    public void calculateMovement(Board board) {
        Tile[][] playBoard = board.getPlayBoard();
        // System.out.println(this.position[0]); //x
        // System.out.println(this.position[1]); //y
        // Calculates the squares to the right
        for (int i = this.position[1] + 1; i < playBoard[this.position[0]].length ; i++){
            if (playBoard[this.position[0]][i].currentPiece != null ) {
                if (playBoard[this.position[0]][i].currentPiece.getTeamColor() != this.getTeamColor()){
                    playBoard[this.position[0]][i].possibleMoves.add(this) ;
                    // playBoard[this.position[0]][i].currentPiece = this;
                }
                break;
            }else {
                playBoard[this.position[0]][i].possibleMoves.add(this) ;
                // playBoard[this.position[0]][i].currentPiece = this;
            }
        }
        // Calculates the squares to the left
        for (int i = this.position[1] -1 ; i >= 0; i--){
            if (playBoard[this.position[0]][i].currentPiece != null ) {
                System.out.println("printing");
                if (playBoard[this.position[0]][i].currentPiece.getTeamColor() != this.getTeamColor()){
                    playBoard[this.position[0]][i].possibleMoves.add(this) ;
                    // playBoard[this.position[0]][i].currentPiece = this;
                }
                break;
            }else {
                System.out.println("printing");
                playBoard[this.position[0]][i].possibleMoves.add(this);
                // playBoard[this.position[0]][i].currentPiece = this;
            }
        }
        // Calculates the square upwards
        for (int i = this.position[0] + 1; i < playBoard.length ; i++){
            // playBoard[i][this.position[1]]
            if (playBoard[i][this.position[1]].currentPiece != null ) {
                if (playBoard[i][this.position[1]].currentPiece.getTeamColor() != this.getTeamColor()){
                    playBoard[i][this.position[1]].possibleMoves.add(this) ;
                    // playBoard[i][this.position[1]].currentPiece = this;
                }
                break;
            }else {
                playBoard[i][this.position[1]].possibleMoves.add(this) ;
                // playBoard[i][this.position[1]].currentPiece = this;
            }
        }
        for (int i = this.position[0] - 1; i >= 0; i--){
            // playBoard[i][this.position[1]]
            if (playBoard[i][this.position[1]].currentPiece != null ) {
                if (playBoard[i][this.position[1]].currentPiece.getTeamColor() != this.getTeamColor()){
                    playBoard[i][this.position[1]].possibleMoves.add(this) ;
                    // playBoard[i][this.position[1]].currentPiece = this;
                }
                break;
            }else {
                playBoard[i][this.position[1]].possibleMoves.add(this) ;
                // playBoard[i][this.position[1]].currentPiece = this;
            }
        }
    }


}
