package day13;
class TrieNode {
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // Assuming only lowercase English letters
        isEndOfWord = false;
    }

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public void setEndOfWord() {
        isEndOfWord = true;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEndOfWord();
    }

    // Returns if there is any word in the trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            if (!node.containsKey(currentChar)) {
                return false;
            }
            node = node.get(currentChar);
        }
        return true;
    }
}



 
