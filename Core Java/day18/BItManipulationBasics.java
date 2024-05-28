package day18;

/*Task 1: Bit Manipulation Basics
Create a function that counts the number of set bits (1s) in the binary representation of an integer. Extend this to count the total number of set bits in all integers from 1 to n.*/
public class BItManipulationBasics {

    // Function to count the number of set bits in a single integer
    public static int countSetBits(int number) {
        int count = 0;
        while (number > 0) {
            count += number & 1;
            number >>= 1;
        }
        return count;
    }

    // Function to count the total number of set bits from 1 to n
    public static int countTotalSetBits(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += countSetBits(i);
        }
        return total;
    }

    public static void main(String[] args) {
        int n = 5; // Example input
        System.out.println("Total set bits from 1 to " + n + ": " + countTotalSetBits(n));
    }
}
