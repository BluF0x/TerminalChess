package Piece;

import Board.Coordinate;

public class Queen extends Piece{
    private final int value = 10;

    public Queen(Team team_color, int[] position) {
        super(team_color, position);
        
        if (team_color == Team.WHITE){
            // this.piece_name = 'R';
            setPieceName('Q');
        } else {
            // this.piece_name = 'r';
            setPieceName('q');
        }
    }

    public Queen(Team team_color, Coordinate y, int x) {
        super(team_color, y, x);
        
        if (team_color == Team.WHITE){
            // this.piece_name = 'R';
            setPieceName('Q');
        } else {
            // this.piece_name = 'r';
            setPieceName('q');
        }

    }
    
}
