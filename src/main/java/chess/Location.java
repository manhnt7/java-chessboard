package chess;

public class Location {
    private final int x;
    private final int y;

    public Location(int tileX, int tileY) {
        x = tileX;
        y = tileY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        char rank = (char)('a' + x);
        return "" + rank + y;
    }
}
