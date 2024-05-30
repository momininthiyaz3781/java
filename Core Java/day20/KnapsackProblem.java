package day20;
/*Task 1: Knapsack Problem
Write a function int Knapsack(int W, int[] weights, int[] values) in Java that determines the maximum value of items that can fit into a knapsack with a capacity W. 
The function should handle up to 100 items. Find the optimal way to fill the knapsack with the given items to achieve the maximum total value.
You must consider that you cannot break items, but have to include them whole.*/

public class KnapsackProblem {

    // Function to solve the knapsack problem
    public static int Knapsack(int W, int[] weights, int[] values) {
        int N = weights.length; // Number of items
        int[][] dp = new int[N + 1][W + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= N; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[N][W]; // Return the maximum value that can be put in a knapsack of capacity W
    }

    // Example usage
    public static void main(String[] args) {
        int W = 50; // Example capacity
        int[] weights = {10, 20, 30}; // Example weights
        int[] values = {60, 100, 120}; // Example values

        System.out.println("Maximum value we can obtain = " + Knapsack(W, weights, values));
    }
}
