package day22;

/*Task 2: Rat in a Maze
mplement a function bool SolveMaze(int[,] maze) that uses backtracking to find a path from the top left corner to the bottom right corner of a maze.
The maze is represented by a 2D array where 1s are paths and 0s are walls. Find a rat's path through the maze. The maze size is 6x6.*/

public class RatMaze {

    final int N = 6;

    // A utility function to print solution matrix sol
    void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }

    // A utility function to check if x, y is valid
    boolean isSafe(int maze[][], int x, int y) {
        // if (x, y outside maze) return false
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    // This function solves the Maze problem using Backtracking.
    boolean SolveMaze(int maze[][]) {
        int sol[][] = new int[N][N];

        if (!solveMazeUtil(maze, 0, 0, sol)) {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    // A recursive utility function to solve Maze problem
    boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]) {
        // if (x, y is goal) return true
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y)) {
            // mark x, y as part of solution path
            sol[x][y] = 1;

            // Move forward in x direction
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;

            // If moving in x direction doesn't give solution
            // then Move down in y direction
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;

            // If none of the above movements work then
            // BACKTRACK: unmark x, y as part of solution path
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    public static void main(String args[]) {
        RatMaze rat = new RatMaze();
        int maze[][] = {{1, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1}};
        rat.SolveMaze(maze);
    }
}