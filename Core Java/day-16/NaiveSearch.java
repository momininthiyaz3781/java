//task 3 :
//Naive Pattern Search Implement the naive pattern searching algorithm to find all occurrences of a pattern within a given text string. Count the number of comparisons made during the search to evaluate the efficiency of the algorithm.

package day16;


public class NaiveSearch {
    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        
        searchPattern(text, pattern);
    }
    
    public static void searchPattern(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int comparisonCount = 0;
        
        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;
            for (j = 0; j < patternLength; j++) {
                comparisonCount++;
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            
            if (j == patternLength) {
                System.out.println("Pattern found at index " + i);
            }
        }
        
        System.out.println("Total comparisons made: " + comparisonCount);
    }
}
