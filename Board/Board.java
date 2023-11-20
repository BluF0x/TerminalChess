package Board;

import Tile.Tile;

public class Board {
    private int board_height;
    private int board_width;
    
    public Tile[][] Board;

    public Board(){
        board_height = 8;
        board_width = 8;
        Board =  new Tile[board_height][board_width];
    }

    public int getWidth() {
        return this.board_width;
    }

    public int getHeight() {
        return this.board_height;
    }

}