import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];
    private static String currentPlayer = "X";

    public static void main(String[] args) {
        initializeBoard();
        displayBoard();

        while (!isGameFinished()) {
            int[] move = getPlayerMove();
            int row = move[0];
            int col = move[1];

            row--;
            col--;

            if (isValidMove(row, col)) {
                makeMove(row, col);
                displayBoard();

                if (isWin(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                if (isTie()) {
                    System.out.println("It's a tie!");
                    break;
                }

                togglePlayer();
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }

        System.out.println("Game Over! Do you want to play again? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = SafeInput.getYNConfirm(scanner, "Enter your choice (Y/N): ");
        if (playAgain) {
            main(null); // Restart the game
        } else {
            System.out.println("Thank you for playing Tic Tac Toe!");
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void displayBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.print(board[i][j]);
                if (j < COL - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < ROW - 1) {
                System.out.println("---------");
            }
        }
    }

    private static int[] getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];
        System.out.println("Player " + currentPlayer + ", enter your move (row column): ");
        move[0] = SafeInput.getRangedInt(scanner, "Enter row (1-3): ", 1, 3);
        move[1] = SafeInput.getRangedInt(scanner, "Enter column (1-3): ", 1, 3);
        return move;
    }

    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    private static void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    private static boolean isWin(String player) {
        return isColWin(player) || isRowWin(player) || isDiagonalWin(player);
    }

    private static boolean isColWin(String player) {
        for (int i = 0; i < COL; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROW; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
                || (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isGameFinished() {
        return isWin(currentPlayer) || isTie();
    }

    private static void togglePlayer() {
        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
    }
}

