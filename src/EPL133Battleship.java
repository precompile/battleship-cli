/**
 * @author Alexandros Papadopoulou Sabaiduc
 * @id 1032790
 * @Description Battleship game. The main goal is to shoot at the different size ships that are hidden from you.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EPL133Battleship {
    private static int numOfRounds;
    private boolean isGameActive = false;
    //Main board.
    private Board compBoard = new Board();
    //List of ships.
    private final List <Ship> ships = new ArrayList <>();

    /**
     * Adds a round.
     */
    public static void addNumOfRounds() {
        numOfRounds += 1;
    }

    /**
     * Removes a round.
     */
    public static void remNumOfRounds() {
        numOfRounds -= 1;
    }

    /**
     * Returns the List of ships.
     * @return List of ships.
     */
    public List <Ship> getShips() {
        return ships;
    }

    /**
     *The main logic of the game.
     */
    public void runGame() {
        Generator generator = new Generator();

        compBoard = generator.getBoard();

        //Generates the 4 different types.
        for (int i = 0; i <= 3; i++) {
            //Tries to generate a ship.
            Ship ship = generator.generateBoardAndShips(i);
            while (!ship.isPlacementOk(ship, ships)) {
                //If it fails, it tries to re-generate it.
                ship = generator.generateBoardAndShips(i);
            }
            //Adds the generated ship to the List of ships.
            ships.add(ship);
        }

        Computer computer = new Computer(ships, compBoard);

        printOptions();

        int numberOfShips = computer.countShipsLeft(ships);

        numOfRounds = 0;

        isGameActive = true;
        while (isGameActive) {
            drawFinishedBoard(compBoard);
            drawFancyBoard(compBoard);
            //Reads user input.
            Scanner scan = new Scanner(System.in);
            System.out.print("\n> ");
            String choice = scan.nextLine().toLowerCase();


            //Menu user input algorithm handling all user input cases.
            mainLoop:
            {
                while (!((choice.contains("quit")) || (choice.contains("help")) || (choice.contains("fire")))) {
                    System.out.println("Invalid option. Please give valid options [ fire / quit / help ]");
                    System.out.print("\n> ");
                    choice = scan.nextLine().toLowerCase();
                }

                if (choice.contains("help")) {
                    printOptions();
                    break mainLoop;
                }

                char coordX = ' ';
                char coordY = ' ';

                if (choice.contains("quit")) {
                    isGameActive = false;
                } else {

                    if (choice.contains("fire")) {
                        //If the option is fire but no arguments are given, asks the user again.
                        if (!(choice.contains(" "))) {
                            System.out.println("Give coordinates with the correct format: >fire <A-H> <A-H>.");
                            System.out.print("\n> ");
                            break mainLoop;
                        }
                        //Splits the user input to the arguments as coordinates.
                        String[] splittedChoice = choice.split("\\s+");

                        try {
                            coordX = Character.toUpperCase(splittedChoice[ 1 ].charAt(0));
                            coordY = Character.toUpperCase(splittedChoice[ 2 ].charAt(0));
                        } catch (Exception e) {
                        }

                        if (splittedChoice[ 0 ].equals("fire")) {
                            Scanner scanChar = new Scanner(System.in);
                            while (coordX < 'A' || coordX > 'H') {
                                System.out.println("\nGive correct X coordinate. <A-H>");
                                System.out.print("\n> fire ");
                                coordX = Character.toUpperCase(scanChar.next().charAt(0));

                            }
                            while (coordY < 'A' || coordY > 'H') {
                                System.out.println("\nGive correct Y coordinate. <A-H>");
                                System.out.print("\n> fire " + coordX + " ");
                                coordY = Character.toUpperCase(scanChar.next().charAt(0));
                            }

                            int intCoordX = coordToInt(coordX);
                            int intCoordY = coordToInt(coordY);

                            System.out.println("\nFired at " + coordX + " " + coordY);

                            addNumOfRounds();

                            if (computer.isShotValid(intCoordX, intCoordY)) {
                                numberOfShips--;
                                //System.out.println(numberOfShips);
                            }
                        }

                    }
                }
            }

            //If there are no ship parts left, exit.
            if (numberOfShips == 0) {
                printExit();
            }

        }
        //Game exit successfully.
        System.exit(0);
    }

    /**
     * Prints the exit message with the ship placements.
     */
    private void printExit() {
        System.out.println("\nGame finished in " + numOfRounds + " rounds.\n");
        drawFinishedBoard(compBoard);
        isGameActive = false;
    }

    /**
     * Draws the board at it''s current state.
     * @param board The board at current state.
     */
    public void drawBoard(Board board) {
        char tempCh = 65;
        System.out.println();
        System.out.println("  A B C D E F G H");
        for (int i = 0; i < Board.SIZE; i++) {
            System.out.print((char) (tempCh + i));
            for (int j = 0; j < Board.SIZE; j++) {
                System.out.print(" " + board.getCoordinate(i, j).getChar());
            }
            System.out.println();
        }
    }

    /**
     * A fancier board to print instead of the default one.
     * @param board The board at current state.
     */
    public void drawFancyBoard(Board board) {
        char tempCh = 65;
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.println("█    CURRENT BOARD    █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
        System.out.println("█    A B C D E F G H  █");
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                if (j == 0) {
                    System.out.print("█  " + (char) (tempCh + i) + " ");
                }
                System.out.print(board.getCoordinate(i, j).getChar() + " ");
            }
            System.out.println(" █");
        }
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
    }


    /**
     * Draws a clean board with the ships.
     * @param board The current board.
     */
    private void drawFinishedBoard(Board board) {
        char tempCh = 65;
        System.out.println("\n");
        System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
        System.out.println("█   BATTLESHIP BOARD  █");
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
        System.out.println("█    A B C D E F G H  █");
        for (int i = 0; i < Board.SIZE; i++) {
            System.out.print("█  ");
            System.out.print((char) (tempCh + i));
            for (int j = 0; j < Board.SIZE; j++) {
                System.out.print(" ");
                if (board.getCoordinate(i, j).getCoordinateValue().equals(CoordinateValue.MISS)) {
                    System.out.print("_");
                } else {
                    System.out.print(board.getCoordinate(i, j).getChar());
                }
            }
            System.out.println("  █");
        }
        System.out.println("█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n\n");
    }

    /**
     * Translates a character to an integer.
     * @param coord The coordinate as a character.
     * @return Returns according integer.
     */
    private int coordToInt(char coord) {
        return (int) coord - 65;
    }

    /**
     * Prints the help options.
     */
    private void printOptions() {
        System.out.println("\nOptions:\nfire X Y\nquit \nhelp\n");
    }

}
