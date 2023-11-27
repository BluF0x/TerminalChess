package Board;

public enum Coordinate {
    A(0),
    B(1),
    C(2),
    D(3),
    E(4),
    F(5),
    G(6),
    H(7);

    public final int numberCoordinate;

    Coordinate(int numberCoordinate) {
        this.numberCoordinate = numberCoordinate;
    }
}
