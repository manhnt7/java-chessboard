package boardgame;

import java.util.ArrayList;

import chess.Piece;
import chess.Tile;

public class Board {

    protected Tile[][] tiles; 			// A list of all the tiles that make up the board.
    protected ArrayList<Piece> pieces;	// A list of all the pieces currently on the board.
    protected boolean isInCheck;		// Whether or not there is a king currently in check.
    protected final int width;			// The width of the board (in number of tiles).
    protected final int height;			// The height of the board (in number of tiles).

    public Board(int boardWidth, int boardHeight) {
        tiles = new Tile[boardWidth][boardHeight];
        //this.initializeTiles(boardWidth, boardHeight);
        //this.initializePieces();
        width = boardWidth;
        height = boardHeight;
        isInCheck = false;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }
}
