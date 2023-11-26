package Piece;

// import Team.Team;

public abstract class Piece {
    private final char piece_name;
    private final int value;
    private final Team team_color;
    public int[] position;

    public Piece(char piece_name, int value, Team team_color, int[] position){
       this.piece_name = piece_name; 
       this.value = value;
       this.team_color = team_color;
       this.position = position;
    }

    char getPieceName() {
        return this.piece_name;
    }

    int getValue() {
        return this.value;
    }

    Team getTeamColor() {
        return this.team_color;
    }
    
    public enum Team {
        WHITE,
        BLACK
    }


}
