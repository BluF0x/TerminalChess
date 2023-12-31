package Piece;

import Board.Coordinate;

public class Bishop extends Piece{
    private final int value = 3;

    public Bishop(Team team_color, int[] position) {
        super(team_color, position);
        
        if (team_color == Team.WHITE){
            // this.piece_name = 'R';
            setPieceName('B');
        } else {
            // this.piece_name = 'r';
            setPieceName('b');
        }
    }

    public Bishop(Team team_color, Coordinate y, int x) {
        super(team_color, y, x);
        
        if (team_color == Team.WHITE){
            // this.piece_name = 'R';
            setPieceName('B');
        } else {
            // this.piece_name = 'r';
            setPieceName('b');
        }

    } 
}
