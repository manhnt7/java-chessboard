package constants;

public enum PieceType {

    KING("K"), KNIGHT("N"), ROOK("R"), QUEEN("Q"), BISHOP("B"), PAWN("P");

    private String value;

    PieceType(String value) {
        this.value = value;

    }

    @Override
    public String toString() {
        return this.value;
    }
    public static PieceType of(String value){
        for (PieceType piece :PieceType.values()) {
            if (piece.value.equalsIgnoreCase(value)) {
                return piece;
            }
        }
        return null;
    }
}

