package chess;


public class Tile {

    private final Location location;	// Location of the tile on the board
    private final String color;			// Color of the tile (WHITE or BLACK)
    private final String name;			// Name of the tile in chess notation
    private Piece currentPiece;		// Which piece is currently on the tile

    public Tile(Location location, String color, String name, Piece currentPiece) {
        this.location = location;
        this.color = color;
        this.name = name;
        this.currentPiece = null;
    }

    public Location getLocation() {
        return location;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }

    public void setPiece(Piece newPiece) {
        currentPiece = newPiece;
    }

    public Piece getPiece() {
        return currentPiece;
    }

    public boolean isOccupied() {
        return (currentPiece == null);
    }
}
