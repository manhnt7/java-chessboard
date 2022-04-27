package chess.pieces;

import static java.lang.Math.abs;

import java.util.ArrayList;

import boardgame.Board;
import chess.Location;
import chess.Piece;
import chess.Tile;
import constants.PlayerType;

public class Queen extends Piece {

    public Queen(PlayerType pieceColor) {
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
        Tile[][] currentBoard = board.getTiles();
        int myX = myLocation.getX();
        int myY = myLocation.getY();
        int destX = destLocation.getX();
        int destY = destLocation.getY();

        // Destination is in the same file but in a higher rank.
        if(myX == destX && myY < destY) {
            for(int i = (myY + 1); i < destY; i++) {
                Tile toTest = currentBoard[myX][i];
                movable = (toTest.getPiece() == null);
                if(!movable) {
                    break;
                }
            }
        }
        // Destination is in the same file but in a lower rank.
        else if(myX == destX && myY > destY) {
            for(int i = (myY - 1); i > destY; i--) {
                Tile toTest = currentBoard[myX][i];
                movable = (toTest.getPiece() == null);
                if(!movable) {
                    break;
                }
            }
        }
        // Destination is in the same rank but in a higher file.
        else if(myY == destY && myX < destX) {
            for(int i = (myX + 1); i < destX; i++) {
                Tile toTest = currentBoard[i][myY];
                movable = (toTest.getPiece() == null);
                if(!movable) {
                    break;
                }
            }
        }
        // Destination is in the same rank but in a lower file.
        else if(myY == destY && myX > destX) {
            for(int i = (myX - 1); i > destX; i--) {
                Tile toTest = currentBoard[i][myY];
                movable = (toTest.getPiece() == null);
                if(!movable) {
                    break;
                }
            }
        }
        // Destination is diagonally in line with the current location.
        else if(abs(destX - myX) == abs(destY - myY)) {
            // Destination is up and to the right of the current location.
            if(myX < destX && myY < destY) {
                for(int i = (myX + 1), j = (myY + 1); i < destX && j < destY; i++, j++) {
                    Tile toTest = currentBoard[i][j];
                    movable = (toTest.getPiece() == null);
                    if(!movable) {
                        break;
                    }
                }
            }
            // Destination is down and to the right of the current location.
            else if(myX < destX && myY > destY) {
                for(int i = (myX + 1), j = (myY - 1); i < destX && j > destY; i++, j--) {
                    Tile toTest = currentBoard[i][j];
                    movable = (toTest.getPiece() == null);
                    if(!movable) {
                        break;
                    }
                }
            }
            // Destination is up and to the left of the current location.
            else if(myX > destX && myY < destY) {
                for(int i = (myX - 1), j = (myY + 1); i > destX && j < destY; i--, j++) {
                    Tile toTest = currentBoard[i][j];
                    movable = (toTest.getPiece() == null);
                    if(!movable) {
                        break;
                    }
                }
            }
            // Destination is down and to the left of the current location.
            else if(myX > destX && myY > destY) {
                for(int i = (myX - 1), j = (myY - 1); i > destX && j > destY; i--, j--) {
                    Tile toTest = currentBoard[i][j];
                    movable = (toTest.getPiece() == null);
                    if(!movable) {
                        break;
                    }
                }
            }
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

        // Add all squares in the same rank besides the one we're on.
        for(int i = 0; i < width; i++) {
            if(i != myX) {
                moves.add(currentBoard[i][myY]);
            }
        }

        // Add all squares in the same file besides the one we're on.
        for(int j = 0; j < height; j++) {
            if(j != myY) {
                moves.add(currentBoard[myX][j]);
            }
        }

        // Add all squares diagonally up and to the right from where we are.
        for(int i = (myX + 1), j = (myY + 1); i < width && j < height; i++, j++) {
            moves.add(currentBoard[i][j]);
        }

        // Add all squares diagonally down and to the right from where we are.
        for(int i = (myX + 1), j = (myY - 1); i < width && j >= 0; i++, j--) {
            moves.add(currentBoard[i][j]);
        }

        // Add all squares diagonally up and to the left from where we are.
        for(int i = (myX - 1), j = (myY + 1); i >= 0 && j < height; i--, j++) {
            moves.add(currentBoard[i][j]);
        }

        // Add all squares diagonally down and to the left from where we are.
        for(int i = (myX - 1), j = (myY - 1); i >= 0 && j >= 0; i--, j--) {
            moves.add(currentBoard[i][j]);
        }

        return moves;
    }

}
