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
        System.out.println(this.position[0]); //x
        System.out.println(this.position[1]); //y
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
    }


}
