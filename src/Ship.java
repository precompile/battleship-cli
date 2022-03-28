import java.util.List;

/**
 * Ship Class.
 */
public class Ship {

    private static ShipType shipType;
    private static ShipOrientation shipOrientation;
    private List <Coordinate> NewShip;

    /**
     * Ship Constructor.
     * @param newShip The ship
     * @param shipType Type of the ship.
     * @param shipOrientation Orientation of the ship.
     */
    public Ship(List <Coordinate> newShip, ShipType shipType, ShipOrientation shipOrientation) {
        NewShip = newShip;
        Ship.shipType = shipType;
        Ship.shipOrientation = shipOrientation;
    }

    /**
     * Getter method for the orientation.
     * @return Returns the orientation of the ship.
     */
    public static ShipOrientation getShipOrientation() {
        return shipOrientation;
    }

    /**
     * Getter method for the ship type.
     * @return Returns the type of the ship.
     */
    public ShipType getShipType() {
        return shipType;
    }

    /**
     * Getter method for the ship size.
     * @return Returns the size of the ship.
     */
    public int getShipTypeSize() {
        return shipType.getSize();
    }

    /**
     * Gets the field of Ship.
     * @return Returns the ship.
     */
    public List <Coordinate> getField() {
        return NewShip;
    }

    /**
     * Method to add a ship to the coordinates.
     * @param coordinate Coordinates.
     */
    public void add(Coordinate coordinate) {
        NewShip.add(coordinate);
    }

    /**
     * Method that checks if the placement of the ship is ok to place.
     * @param givenShip The ship that is being checked.
     * @param ships The list of all the other ships.
     * @return Returns true or false.
     */
    public boolean isPlacementOk(Ship givenShip, List <Ship> ships) {
        int count = 0;
        for (int i = 0; i < givenShip.getField().size(); i++) {
            if (givenShip.getField().get(i).getY() > Board.SIZE || givenShip.getField().get(i).getX() > Board.SIZE) {
                count++;
            }
            for (int k = 0; k < ships.size(); k++) {
                for (int z = 0; z < ships.get(k).getField().size(); z++) {
                    if ((givenShip.getField().get(i).getX() == ships.get(k).getField().get(z).getX() &&
                            givenShip.getField().get(i).getY() == ships.get(k).getField().get(z).getY())) {
                        count++;
                    }
                }
            }

        }
        return count == 0;
    }

}
