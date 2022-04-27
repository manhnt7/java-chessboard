package chess.pieces;

import java.util.ArrayList;

import boardgame.Board;
import chess.Location;
import chess.Piece;
import chess.Tile;
import constants.PlayerType;

public class Pawn extends Piece {

    public Pawn(PlayerType pieceColor) {
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
        Location myLocation = currentTile.getLocation();
        Location destLocation = destination.getLocation();
        Tile[][] currentBoard = board.getTiles();
        int myX = myLocation.getX();
        int myY = myLocation.getY();
        int destX = destLocation.getX();
        int destY = destLocation.getY();

        // Check relevant moves if the pawn is white.
        if(color == PlayerType.WHITE) {
            if(destX == myX && destY == (myY + 1) && !destination.isOccupied()) {
                return true;
            }
            else if(destX == myX && destY == (myY + 2) && !destination.isOccupied()) {
                if(!currentBoard[myX][myY + 1].isOccupied()) {
                    return true;
                }
            }
            else if((destX == (myX + 1) || destX == (myX - 1)) && destY == (myY + 1)) {
                if(destination.isOccupied() && destination.getPiece().getColor() == PlayerType.BLACK) {
                    return true;
                }
            }
            return false;
        }

        // Check relevant moves if the pawn in black.
        else {
            if(destX == myX && destY == (myY - 1) && !destination.isOccupied()) {
                return true;
            }
            else if(destX == myX && destY == (myY - 2) && !destination.isOccupied()) {
                if(!currentBoard[myX][myY - 1].isOccupied()) {
                    return true;
                }
            }
            else if((destX == (myX + 1) || destX == (myX - 1)) && destY == (myY - 1)) {
                if(destination.isOccupied() && destination.getPiece().getColor() == PlayerType.BLACK) {
                    return true;
                }
            }
            return false;
        }
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

        // Add relevant moves for a white pawn.
        if(color == PlayerType.WHITE) {
            if((myY + 1) < height) {
                moves.add(currentBoard[myX][myY + 1]);
                if((myX + 1) < width) {
                    moves.add(currentBoard[myX + 1][myY + 1]);
                }
                if((myX - 1) >= 0) {
                    moves.add(currentBoard[myX - 1][myY + 1]);
                }
            }
            if((myY + 2) < height) {
                moves.add(currentBoard[myX][myY + 2]);
            }
        }

        // Add relevant moves for a black pawn.
        else {
            if((myY - 1) >= 0) {
                moves.add(currentBoard[myX][myY - 1]);
                if((myX + 1) < width) {
                    moves.add(currentBoard[myX + 1][myY - 1]);
                }
                if((myX - 1) >= 0) {
                    moves.add(currentBoard[myX - 1][myY - 1]);
                }
            }
            if((myY - 2) >= 0) {
                moves.add(currentBoard[myX][myY - 2]);
            }
        }

        return moves;
    }
}