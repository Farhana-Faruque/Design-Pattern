import java.util.Scanner;
import java.util.concurrent.Future;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        CareTaker caretaker = new CareTaker();
        CommandInvoker invoker = new CommandInvoker();

        // Save initial state
        caretaker.save(game.save());

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Enter moves as row and column (0, 1 or 2).");
        System.out.println("Type 'u' to undo last move, 'r' to reset, or 'c' to cancel a move within 5 seconds.");
        System.out.println("You can also enter a new row and column within 5 seconds to change the move.");
        System.out.println();

        while (true) {
            game.printBoard();
            System.out.print("Player " + game.getCurrentPlayer() + ", enter your move (row col), 'u' to undo, or 'r' to reset: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("u")) {
                if (caretaker.canUndo()) {
                    Command undoCommand = new UndoCommand(game, caretaker);
                    invoker.executeCommand(undoCommand);
                    System.out.println("Undo successful.");
                } else {
                    System.out.println("Nothing to undo!");
                }
                continue;
            }

            if (input.equalsIgnoreCase("r")) {
                Command resetCommand = new ResetCommand(game, caretaker);
                invoker.executeCommand(resetCommand);
                System.out.println("Game reset.");
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

                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Invalid position! Rows and columns must be 0, 1, or 2.");
                    continue;
                }

                Command moveCommand = new MakeMoveCommand(game, caretaker, row, col);
                Future<?> future = invoker.executeCommandWithCancel(moveCommand);

                // Prompt for cancel or new position within 5 seconds
                System.out.println("You have 5 seconds to cancel ('c') or enter a new position (row col): ");
                long startTime = System.currentTimeMillis();
                boolean inputReceived = false;
                String newInput = "";

                // Non-blocking input check using Scanner
                while (System.currentTimeMillis() - startTime < 5000) {
                    if (scanner.hasNextLine()) {
                        newInput = scanner.nextLine().trim();
                        inputReceived = true;
                        break;
                    }
                    Thread.yield(); // Prevent busy-waiting
                }

                if (inputReceived) {
                    if (newInput.equalsIgnoreCase("c")) {
                        future.cancel(true);
                        System.out.println("Move canceled.");
                        continue;
                    } else {
                        String[] newParts = newInput.split("\\s+");
                        if (newParts.length == 2) {
                            try {
                                int newRow = Integer.parseInt(newParts[0]);
                                int newCol = Integer.parseInt(newParts[1]);
                                if (newRow >= 0 && newRow <= 2 && newCol >= 0 && newCol <= 2) {
                                    future.cancel(true); // Cancel original move
                                    moveCommand = new MakeMoveCommand(game, caretaker, newRow, newCol);
                                    invoker.executeCommand(moveCommand); // Execute new move immediately
                                } else {
                                    System.out.println("Invalid new position! Rows and columns must be 0, 1, or 2.");
                                    continue;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid new position! Enter numbers for row and column.");
                                continue;
                            }
                        } else {
                            System.out.println("Invalid input for new position.");
                            continue;
                        }
                    }
                }

                if (game.checkWin()) {
                    game.printBoard();
                    System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                    break;
                } else if (game.isBoardFull()) {
                    game.printBoard();
                    System.out.println("It's a tie!");
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter numbers for row and column.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
        invoker.shutdown();
    }
}
