package chess.pieces;

import static java.lang.Math.abs;

import java.util.ArrayList;

import boardgame.Board;
import chess.Location;
import chess.Piece;
import chess.Tile;
import constants.PlayerType;

public class King extends Piece {

    public King(PlayerType pieceColor) {
        super(pieceColor);
    }

    @Override
    public boolean canMoveTo(Tile destination, Board board) {
        // Check if the destination tile is the same as your current location.
        if(destination == currentTile) {
            return false;
        }

        // Check if the destination tile already has one of your own pieces.
        Piece destPiece = destination.getPiece();
        if(destPiece != null && destPiece.getColor() == this.getColor()) {
            return false;
        }

        // Collect the necessary information and set up variables.
        boolean movable = true;
        Location myLocation = currentTile.getLocation();
        Location destLocation = destination.getLocation();
        int myX = myLocation.getX();
        int myY = myLocation.getY();
        int destX = destLocation.getX();
        int destY = destLocation.getY();

        // Destination is in the same file but in a higher rank.
        if(abs(destX - myX) < 2 && abs(destY - myY) < 2) {
            return true;
        }
        // Destination is some other tile on the board (can't move there).
        else {
            movable = false;
        }

        return movable;
    }

    @Override
    public ArrayList<Tile> potentialMoves(Board board) {
        // Set up the necessary variables.
        Location myLocation = currentTile.getLocation();
        Tile[][] currentBoard = board.getTiles();
        ArrayList<Tile> moves = new ArrayList<Tile>();
        int myX = myLocation.getX();
        int myY = myLocation.getY();
        int width = board.getWidth();
        int height = board.getHeight();

        // Add each of the king's moves individually.
        if((myY + 1) < height) {
            moves.add(currentBoard[myX][myY + 1]);
            if(myX - 1 >= 0) {
                moves.add(currentBoard[myX - 1][myY + 1]);
            }
            if(myX + 1 < width) {
                moves.add(currentBoard[myX + 1][myY + 1]);
            }
        }
        if((myY - 1) >= 0) {
            moves.add(currentBoard[myX][myY - 1]);
            if(myX - 1 >= 0) {
                moves.add(currentBoard[myX - 1][myY - 1]);
            }
            if(myX + 1 < width) {
                moves.add(currentBoard[myX + 1][myY - 1]);
            }
        }
        if((myX - 1) >= 0) {
            moves.add(currentBoard[myX - 1][myY]);
        }
        if((myX + 1) < width) {
            moves.add(currentBoard[myX + 1][myY]);
        }

        return moves;
    }
}
