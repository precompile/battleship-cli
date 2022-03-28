import java.util.ArrayList;
import java.util.List;


public class Generator {

    private Board board = new Board();
    private List <Integer> shipWithCoord = new ArrayList <>();

    /**
     * Calculates a random value.
     * @param max Max value.
     * @return Returns the generated value.
     */
    public static int getRandom(int max) {
        return (int) (Math.random() * max);
    }

    /**
     * Getter method for the board.
     * @return Returns the board.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Generates a ship at random location and orientation.
     * @param givenShipType Ship type
     * @return Returns the ship with the coordinates.
     */
    public List <Integer> getRandomShip(int givenShipType) {
        this.shipWithCoord = new ArrayList <>();


        int randX = getRandom(Board.SIZE);
        int randY = getRandom(Board.SIZE);
        int randShipOrientation = getRandom(2);


        shipWithCoord.add(randX);
        shipWithCoord.add(randY);
        shipWithCoord.add(givenShipType);
        shipWithCoord.add(randShipOrientation);

        return shipWithCoord;

    }

    /**
     * Generates the board with the ships.
     * @param givenShipType Given ship type.
     * @return Returns the ship.
     */
    public Ship generateBoardAndShips(int givenShipType) {

        Coordinate shipPart;
        Ship ship;

        shipWithCoord = getRandomShip(givenShipType);


        int row = shipWithCoord.get(0);
        int col = shipWithCoord.get(1);
        int shipType = shipWithCoord.get(2);
        int shipOrientation = shipWithCoord.get(3);

        shipPart = new Coordinate(row, col, CoordinateValue.SHIP);

        ship = new Ship(new ArrayList <>(), ShipType.values()[ shipType ], ShipOrientation.values()[ shipOrientation ]);
        board.placeShip(shipPart, ship);


        return ship;
    }
}
