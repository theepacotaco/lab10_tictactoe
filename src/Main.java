import java.util.Scanner;

public class Main {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];
    private static String currentPlayer = "X";

    public static void main(String[] args) {
        clearBoard();
        displayBoard();

        while (true) {
            int rowMove = getRangedInt(new Scanner(System.in), "Enter row (1-3): ", 1, 3);
            int colMove = getRangedInt(new Scanner(System.in), "Enter column (1-3): ", 1, 3);

            if (isValidMove(rowMove - 1, colMove - 1)) {
                board[rowMove - 1][colMove - 1] = currentPlayer;
                displayBoard();

                if (isWin(currentPlayer)) {
                    System.out.println(currentPlayer + " wins!");
                    break;
                } else if (isTie()) {
                    System.out.println("It's a tie!");
                    break;
                }

                currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private static void clearBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < ROW; i++) {
            System.out.print("| ");
            for (int j = 0; j < COL; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < ROW; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true; // Row win
            }
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true; // Column win
            }
        }

        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true; // Diagonal win (top-left to bottom-right)
        }

        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            return true; // Diagonal win (top-right to bottom-left)
        }

        return false; // No win
    }

    private static boolean isTie() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(" ")) {
                    return false; // There is an empty space, so the game is not a tie
                }
            }
        }
        return true; // All spaces are filled, so the game is a tie
    }

    private static int getRangedInt(Scanner scanner, String prompt, int min, int max) {
        int input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number between " + min + " and " + max + ": ");
                scanner.next();
            }
            input = scanner.nextInt();
        } while (input < min || input > max);
        return input;
    }
}
