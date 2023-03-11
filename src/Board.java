/**
 * Board class that extends the Coordinates class.
 */
public class Board extends Coordinate {
    public static final int SIZE = 8;
    //The game board of Coordinates.
    public Coordinate[][] gameBoard;

    /**
     * Main constructor.
     */
    public Board() {
        super();
        fillBoard();
    }

    /**
     * Getter method for the coordinates.
     * @param x X
     * @param y Y
     * @return Returns the x,y coordinates.
     */
    public Coordinate getCoordinate(int x, int y) {
        return gameBoard[ x ][ y ];
    }

    /**
     * Fills the gameBoard with default values.
     */
    public void fillBoard() {
        gameBoard = new Coordinate[ SIZE ][ SIZE ];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                gameBoard[ i ][ j ] = new Coordinate(i, j, CoordinateValue.EMPTY);
            }
        }
    }

    /**
     * Method that places a ship according to the given Coordinates and Ship orientation.
     * @param coordinate Randomly generated Coordinates.
     * @param ship Ship''s orientation.
     */
    public void placeShip(Coordinate coordinate, Ship ship) {
        switch (ship.getShipType().size) {
            case 2:
                coordinate.setCoordinateValue(CoordinateValue.SHIP);
                ship.add(coordinate);
                int x = coordinate.getX();
                int y = coordinate.getY();
                if (Ship.getShipOrientation() == ShipOrientation.VERTICAL) {
                    ship.add(new Coordinate(x, y + 1, CoordinateValue.SHIP));
                } else if (Ship.getShipOrientation() == ShipOrientation.HORIZONTAL) {
                    ship.add(new Coordinate(x + 1, y, CoordinateValue.SHIP));
                }
                break;

            case 3:
                coordinate.setCoordinateValue(CoordinateValue.SHIP);
                ship.add(coordinate);
                x = coordinate.getX();
                y = coordinate.getY();
                if (Ship.getShipOrientation() == ShipOrientation.VERTICAL) {
                    ship.add(new Coordinate(x, y + 1, CoordinateValue.SHIP));
                    ship.add(new Coordinate(x, y + 2, CoordinateValue.SHIP));
                } else if (Ship.getShipOrientation() == ShipOrientation.HORIZONTAL) {
                    ship.add(new Coordinate(x + 1, y, CoordinateValue.SHIP));
                    ship.add(new Coordinate(x + 2, y, CoordinateValue.SHIP));
                }
                break;
            case 4:
                coordinate.setCoordinateValue(CoordinateValue.SHIP);
                ship.add(coordinate);
                x = coordinate.getX();
                y = coordinate.getY();
                if (Ship.getShipOrientation() == ShipOrientation.VERTICAL) {
                    ship.add(new Coordinate(x, y + 1, CoordinateValue.SHIP));
                    ship.add(new Coordinate(x, y + 2, CoordinateValue.SHIP));
                    ship.add(new Coordinate(x, y + 3, CoordinateValue.SHIP));
                } else if (Ship.getShipOrientation() == ShipOrientation.HORIZONTAL) {
                    ship.add(new Coordinate(x + 1, y, CoordinateValue.SHIP));
                    ship.add(new Coordinate(x + 2, y, CoordinateValue.SHIP));
                    ship.add(new Coordinate(x + 3, y, CoordinateValue.SHIP));
                }
                break;

            case 5:
                coordinate.setCoordinateValue(CoordinateValue.SHIP);
                ship.add(coordinate);
                x = coordinate.getX();
                y = coordinate.getY();
                if (Ship.getShipOrientation() == ShipOrientation.VERTICAL) {
                    ship.add(new Coordinate(x, y + 1, CoordinateValue.SHIP));
                    ship.add(new Coordinate(x, y + 2, CoordinateValue.SHIP));
                    ship.add(new Coordinate(x, y + 3, CoordinateValue.SHIP));
                    ship.add(new Coordinate(x, y + 4, CoordinateValue.SHIP));
                } else if (Ship.getShipOrientation() == ShipOrientation.HORIZONTAL) {
                    ship.add(new Coordinate(x + 1, y, CoordinateValue.SHIP));
                    ship.add(new Coordinate(x + 2, y, CoordinateValue.SHIP));
                    ship.add(new Coordinate(x + 3, y, CoordinateValue.SHIP));
                    ship.add(new Coordinate(x + 4, y, CoordinateValue.SHIP));
                }
                break;
        }
    }

}