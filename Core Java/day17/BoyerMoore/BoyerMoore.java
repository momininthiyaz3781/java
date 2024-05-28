package day17;

public class BoyerMoore {
    public int lastIndexOf(String text, String pattern) {
        if (pattern.length() == 0) return text.length();
        int[] last = new int[256]; // ASCII table size
        for (int i = 0; i < 256; i++) last[i] = -1; // -1 indicates no occurrence
        for (int i = 0; i < pattern.length(); i++) last[pattern.charAt(i)] = i;

        int n = text.length();
        int m = pattern.length();
        int skip;

        for (int i = m - 1; i < n; i += skip) {
            skip = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i - m + 1 + j)) {
                    skip = Math.max(1, j - last[text.charAt(i - m + 1 + j)]);
                    break;
                }
            }
            if (skip == 0) return i - m + 1; // Found
        }
        return -1; // Not found
    }
    public static void main(String[] args) {
        String text = "This is an example text where we want to find the last occurrence of 'example'.";
        String pattern = "example";
        BoyerMoore bm = new BoyerMoore();
        int lastIndex = bm.lastIndexOf(text, pattern);
        if (lastIndex != -1) {
            System.out.println("Pattern found at index: " + lastIndex);
        } else {
            System.out.println("Pattern not found.");
        }
    }
} 
