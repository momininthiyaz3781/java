package day20;
/*Task 2: Longest Common Subsequence
Implement int LCS(string text1, string text2)  to find the length of the longest common subsequence between two strings.*/


public class LCS {

    // Function to find the length of the longest common subsequence
    public static int LCS(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Build the dp table in bottom-up fashion
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The length of the longest common subsequence
        // is in the bottom-right corner of the table
        return dp[m][n];
    }

    // Main method to test the LCS function
    public static void main(String[] args) {
        String text1 = "AGGTAB";
        String text2 = "GXTXAYB";
        System.out.println("The length of the LCS is: " + LCS(text1, text2));
    }
}
