package day19;

import java.util.Arrays;
 
/*Task 2: Traveling Salesman Problem
Create a function int FindMinCost(int[,] graph)
that takes a 2D array representing the graph where graph[i][j] is
the cost to travel from city i to city j. The function should return
the minimum cost to visit all cities and return to the starting city. 
Use dynamic programming for this solution.show in java*/




public class TravelingSalesman {

    // Function to find the minimum cost to visit all cities
    public static int findMinCost(int[][] graph) {
        int n = graph.length;
        int VISITED_ALL = (1 << n) - 1;
        int[][] dp = new int[n][1 << n];
        
        // Initialization of dp array
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        // Utilizing the TSP dynamic programming approach
        return tsp(0, 1, graph, dp, VISITED_ALL);
    }

    // Helper function for the TSP using dynamic programming
    private static int tsp(int currentCity, int visited, int[][] graph, int[][] dp, int VISITED_ALL) {
        if (visited == VISITED_ALL) {
            return graph[currentCity][0]; // Return to starting city
        }
        
        // Already computed state, return stored result
        if (dp[currentCity][visited] != -1) {
            return dp[currentCity][visited];
        }
        
        int ans = Integer.MAX_VALUE;
        
        // Visit all the unvisited cities and take the min
        for (int city = 0; city < graph.length; city++) {
            if ((visited & (1 << city)) == 0) {
                int newAns = graph[currentCity][city] + tsp(city, visited | (1 << city), graph, dp, VISITED_ALL);
                ans = Math.min(ans, newAns);
            }
        }
        
        // Save result in memoization table and return
        return dp[currentCity][visited] = ans;
    }

    public static void main(String[] args) {
        int[][] graph = {
            { 0, 10, 15, 20 },
            { 10, 0, 35, 25 },
            { 15, 35, 0, 30 },
            { 20, 25, 30, 0 }
        };
        
        System.out.println("The minimum cost is: " + findMinCost(graph));
    }
}
