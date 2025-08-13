import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        CareTaker caretaker = new CareTaker();

        caretaker.save(game.save());

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Enter moves as row and column (0, 1 or 2).");
        System.out.println("Type 'u' to undo last move.");
        System.out.println();

        while (true) {
            game.printBoard();
            System.out.print("Player " + game.getCurrentPlayer() + ", enter your move (row col) or 'u' to undo: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("u")) {
                if (caretaker.canUndo()) {
                    TicTacToe.Memento prev = caretaker.undo();
                    if (prev != null) {
                        game.restore(prev);
                        System.out.println("Undo successful.");
                    }
                } else {
                    System.out.println("Nothing to undo!");
                }
                continue;
            }

            String[] parts = input.split("\\s+");
            if (parts.length != 2) {
                System.out.println("Invalid input. Enter row and column separated by space.");
                continue;
            }

            try {
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);

                if (row <0 || row >2 || col <0 || col >2) {
                    System.out.println("Invalid position! Rows and columns must be 0, 1, or 2.");
                    continue;
                }

                if (!game.placeMark(row, col)) {
                    System.out.println("Position already occupied! Try again.");
                    continue;
                }

                caretaker.save(game.save()); // Save after move

                if (game.checkWin()) {
                    game.printBoard();
                    System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                    break;
                } else if (game.isBoardFull()) {
                    game.printBoard();
                    System.out.println("It's a tie!");
                    break;
                }

                game.switchPlayer();

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter numbers for row and column.");
            }
        }

        scanner.close();
    }
}
