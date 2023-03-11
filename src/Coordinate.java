/**
 * Coordinate Class
 */
public class Coordinate {
    private int x, y;
    private CoordinateValue coordinateValue;

    /**
     * Coordinate Constructor
     * @param x X
     * @param y Y
     * @param coordinateValue Value
     */
    public Coordinate(int x, int y, CoordinateValue coordinateValue) {
        this.x = x;
        this.y = y;
        this.coordinateValue = coordinateValue;
    }

    //Main Coordinate Constructor.
    public Coordinate() {

    }

    /**
     * Getter for X
     * @return X
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for Y
     * @return Y
     */
    public int getY() {
        return y;
    }

    /**
     * Getter method for the value in Coordinates.
     * @return The value inside the coordinates.
     */
    public CoordinateValue getCoordinateValue() {
        return coordinateValue;
    }

    public void setCoordinateValue(CoordinateValue coordinateValue) {
        this.coordinateValue = coordinateValue;
    }

    /**
     * Getter method for the character.
     * @return Returns the character based on the coordinateValue case.
     */
    public char getChar() {
        char value = ' ';
        switch (coordinateValue) {
            case EMPTY:
                value = '_';
                break;
            case SHIP:
                value = 'S';
                break;
            case HIT:
                value = 'X';
                break;
            case MISS:
                value = 'O';
                break;
        }
        return value;
    }

}
