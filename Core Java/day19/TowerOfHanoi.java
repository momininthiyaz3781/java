package day19;

/*Task 1: Tower of Hanoi Solver
Create a program that solves the Tower of Hanoi puzzle for n disks.
The solution should use recursion to move disks between three
pegs (source, auxiliary, and destination) according to the game's rules.
The program should print out each move required to solve the puzzle.*/

public class TowerOfHanoi {

    public static void solveHanoi(int n, char sourcePeg, char auxiliaryPeg, char destinationPeg) {
        if (n == 1) {
            System.out.println("Move disk 1 from peg " + sourcePeg + " to peg " + destinationPeg);
            return;
        }
        solveHanoi(n - 1, sourcePeg, destinationPeg, auxiliaryPeg);
        System.out.println("Move disk " + n + " from peg " + sourcePeg + " to peg " + destinationPeg);
        solveHanoi(n - 1, auxiliaryPeg, sourcePeg, destinationPeg);
    }

    public static void main(String[] args) {
        int numberOfDisks = 3; // Number of disks can be changed accordingly
        solveHanoi(numberOfDisks, 'A', 'B', 'C');
    }
}