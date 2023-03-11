# Battleship Game CLI in Java

This is a command-line interface (CLI) implementation of the classic Battleship game written in Java.

## Requirements

- Java Development Kit (JDK) 15 or higher
- Git (optional)

## Installation

- Clone the repository or download the source code.

```bash
git clone https://github.com/precompile/battleship-cli.git
```

- Navigate to the project directory.

```bash
cd battleship-cli/src
```

- Compile the source code.

```bash
javac *.java
```

- Run the program.

```bash
java TestBattleship
```

## How to Play

> The computer places its ships by randomly generating the coordinates on the board.
  The player takes turns to guess the location of the computer's by entering the coordinates of the grid in the format "fire X Y",
  where X is a letter from A to H and Y is a letter from A to H.
  The game ends when all of the computer's ships are destroyed. 
  The player can quit the game by typing "quit" or display the help message by typing "help".

## Game Rules

> The game is played on an 8x8 grid.

### The computer has four ships of different lengths:
- PATROL (2)
- SUBMARINE (3)
- BATTLESHIP (4)
- DESTROYER (5).

> Ships cannot be placed diagonally or overlapping.
  Players cannot fire at the same coordinate twice.
  The game mentions if the player already shot at the same position.
  A hit is marked with an "X" on the grid.
  A miss is marked with an "O" on the grid.
  The game ends when all of the computer's ships are destroyed.

## Contributing

Contributions are welcome! Please open an issue or pull request if you have any suggestions or bug fixes.
License

This project is licensed under the MIT License. See the LICENSE file for details.
