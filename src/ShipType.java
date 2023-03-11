public enum ShipType {
    DESTROYER(5),
    BATTLESHIP(4),
    SUBMARINE(3),
    PATROL(2);

    public final int size;

    ShipType(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

}
