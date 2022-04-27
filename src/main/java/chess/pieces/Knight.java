package chess.pieces;

import java.util.ArrayList;

import boardgame.Board;
import chess.Location;
import chess.Piece;
import chess.Tile;
import constants.PlayerType;

public class Knight extends Piece {

    public Knight(PlayerType pieceColor) {
        super(pieceColor);
    }

    @Override
    public boolean canMoveTo(Tile destination, Board board) {
        Piece destPiece = destination.getPiece();
        if(destPiece != null && destPiece.getColor() == this.getColor()) {
            return false;
        }
        return true;
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

        // Add each of the knight's moves individually.
        if((myX + 2) < width && (myY + 1) < height) {
            moves.add(currentBoard[myX + 2][myY + 1]);
        }
        if((myX + 1) < width && (myY + 2) < height) {
            moves.add(currentBoard[myX + 1][myY + 2]);
        }
        if((myX + 2) < width && (myY - 1) >= 0) {
            moves.add(currentBoard[myX + 2][myY - 1]);
        }
        if((myX + 1) < width && (myY - 2) >= 0) {
            moves.add(currentBoard[myX + 1][myY - 2]);
        }
        if((myX - 2) >= 0 && (myY + 1) < height) {
            moves.add(currentBoard[myX - 2][myY + 1]);
        }
        if((myX - 1) >= 0 && (myY + 2) < height) {
            moves.add(currentBoard[myX - 1][myY + 2]);
        }
        if((myX - 2) >= 0 && (myY - 1) >= 0) {
            moves.add(currentBoard[myX - 2][myY - 1]);
        }
        if((myX - 1) >= 0 && (myY - 2) >= 0) {
            moves.add(currentBoard[myX - 1][myY - 2]);
        }

        return moves;
    }

}
