package Piece;
import Piece.Piece.Team;

public class Rook extends Piece {
    public int[] position;


    public Rook(Team team_color, int[] position) {
        
        this.position = position;
        this.team_color = team_color;
        if (team_color == Team.WHITE){
            this.piece_name = 'R';
        } else {
            this.piece_name = 'r';
        }
    }
}
