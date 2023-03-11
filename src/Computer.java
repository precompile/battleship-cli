import java.util.List;

/**
 * Computer Class that computes the logic of the game.
 */
public class Computer {
    private final List <Ship> ships;
    private final Board board;

    /**
     * Computer Constructor.
     * @param ships List of ships.
     * @param board The board.
     */
    public Computer(List <Ship> ships, Board board) {
        this.ships = ships;
        this.board = board;
    }

    /**
     * Counts the remaining ships.
     * @param ships List of ships.
     * @return Returns the value of the remaining ships.
     */
    public int countShipsLeft(List <Ship> ships) {
        int sumOfShipCoords = 0;
        for (Ship ship : ships) {
            sumOfShipCoords += ship.getField().size();
        }
        return sumOfShipCoords;
    }

    /**
     * Analyzes if the shot is valid.
     * @param x X
     * @param y Y
     * @return Returns true/false accordingly.
     */
    public boolean isShotValid(int x, int y) {
        for (Ship ship : ships) {
            for (Coordinate coordinate : ship.getField()) {
                //If at the current coordinate there is a ship, it makes it a hit.
                if (coordinate.getX() == x && coordinate.getY() == y && coordinate.getCoordinateValue().equals(CoordinateValue.SHIP)) {
                    coordinate.setCoordinateValue(CoordinateValue.HIT);
                    board.getCoordinate(x, y).setCoordinateValue(CoordinateValue.HIT);
                    System.out.println("Hit!");
                    return true;
                    //If at the current coordinate there is a hit, it makes it a hit.
                } else if (coordinate.getX() == x && coordinate.getY() == y && coordinate.getCoordinateValue().equals(CoordinateValue.HIT)) {
                    coordinate.setCoordinateValue(CoordinateValue.HIT);
                    board.getCoordinate(x, y).setCoordinateValue(CoordinateValue.HIT);
                    System.out.println("There is already a hit");
                    EPL133Battleship.remNumOfRounds();
                    return false;
                }
            }
        }
        board.getCoordinate(x, y).setCoordinateValue(CoordinateValue.MISS);
        System.out.println("Miss!");
        return false;
    }


}
