package day13;


public class Main_trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("helium");

        System.out.println(trie.startsWith("hel")); // Should return true
        System.out.println(trie.startsWith("world")); // Should return false
    }
}
