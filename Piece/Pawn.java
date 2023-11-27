package Piece;

import Board.Coordinate;

public class Pawn extends Piece{
    private final int value = 1;

    public Pawn(Team team_color, int[] position) {
        super(team_color, position);
        
        if (team_color == Team.WHITE){
            // this.piece_name = 'R';
            setPieceName('P');
        } else {
            // this.piece_name = 'r';
            setPieceName('p');
        }
    }

    public Pawn(Team team_color, Coordinate y, int x) {
        super(team_color, y, x);
        
        if (team_color == Team.WHITE){
            // this.piece_name = 'R';
            setPieceName('P');
        } else {
            // this.piece_name = 'r';
            setPieceName('p');
        }

    }

}
