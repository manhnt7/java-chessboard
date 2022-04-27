package chess;

import java.util.ArrayList;

import boardgame.Board;
import constants.PlayerType;

public abstract class Piece {

    public PlayerType color;
    public Tile currentTile;

    public Piece(PlayerType pieceColor) {
        color = pieceColor;
    }

    public boolean canMove(Board board) {
        // Assume that the piece cannot move.
        boolean movable = false;

        // Determine if any of the piece's natural moves are actually currently possible.
        ArrayList<Tile> possibleMoves = this.potentialMoves(board);
        for(int i = 0; i < possibleMoves.size(); i++) {
            if(this.canMoveTo(possibleMoves.get(i), board)) {
                movable = true;
            }
        }

        return movable;
    }

    public abstract boolean canMoveTo(Tile destination, Board board);

    public abstract ArrayList<Tile> potentialMoves(Board board);

    public PlayerType getColor() {
        return color;
    }

}
