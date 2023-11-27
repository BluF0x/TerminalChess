package Piece;

import Board.Coordinate;

public class Knight extends Piece{
    private final int value = 3;

    public Knight(Team team_color, int[] position) {
        super(team_color, position);
        
        if (team_color == Team.WHITE){
            // this.piece_name = 'R';
            setPieceName('N');
        } else {
            // this.piece_name = 'r';
            setPieceName('n');
        }
    }

    public Knight(Team team_color, Coordinate y, int x) {
        super(team_color, y, x);
        
        if (team_color == Team.WHITE){
            // this.piece_name = 'R';
            setPieceName('N');
        } else {
            // this.piece_name = 'r';
            setPieceName('n');
        }

    }  
}
