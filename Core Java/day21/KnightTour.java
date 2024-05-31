package day21;

public class KnightTour {
    static final int N = 8;

    public static void main(String[] args) {
        solveKnightsTour();
    }

    static void solveKnightsTour() {
        int[][] board = new int[N][N];

        // Initialize the board with -1, indicating unvisited cells
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }

        // The knight's possible moves
        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

        // Starting position of the knight
        board[0][0] = 0;

        // Start the knight's tour from the first cell
        if (!solveKnightsTourUtil(0, 0, 1, board, xMove, yMove)) {
            System.out.println("Solution does not exist");
        } else {
            printSolution(board);
        }
    }

    static boolean solveKnightsTourUtil(int x, int y, int moveCount, int[][] board, int[] xMove, int[] yMove) {
        if (moveCount == N * N) {
            return true; // All cells have been visited
        }

        // Try all next moves from the current position
        for (int k = 0; k < 8; k++) {
            int nextX = x + xMove[k];
            int nextY = y + yMove[k];
            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = moveCount;
                if (solveKnightsTourUtil(nextX, nextY, moveCount + 1, board, xMove, yMove)) {
                    return true;
                } else {
                    board[nextX][nextY] = -1; // Backtracking
                }
            }
        }

        return false;
    }

    static boolean isSafe(int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
