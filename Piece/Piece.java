package Piece;

import Board.Coordinate;

// import Team.Team;
import Board.Board;

public abstract class Piece {
    private char piece_name;
    private int value;
    private final Team team_color;
    public int[] position;

    public Piece( Team team_color, int[] position){
       this.team_color = team_color;
       this.position = position;
    }

    public Piece(Team team_color, Coordinate x, int y ){
        this.team_color = team_color;
        this.position = new int[]{ y -1, x.numberCoordinate};
    }

    public void setPieceName(char name) {
        this.piece_name = name;
    }

    public String getPieceName() {
        return String.valueOf(this.piece_name);
    }

    public char getPieceName(boolean isGettingChar) {
        return this.piece_name;
    }

    public int getValue() {
        return this.value;
    }

    public Team getTeamColor() {
        return this.team_color;
    }

    public void calculateMovement(Board board){

    }

    public void MovePiece(int y, int x) {
        this.position = new int[]{y, x};
        
    }
    
    public enum Team {
        WHITE,
        BLACK
    }


}
