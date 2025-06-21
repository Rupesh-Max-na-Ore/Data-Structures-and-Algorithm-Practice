package Trie;

public class TrieDriver {
    public static void main(String[] args) {
        // Trie_2 trie = new Trie_2();
        Trie_22 trie = new Trie_22();
        System.out.println("=== INSERTING WORDS ===");
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apply");
        trie.insert("banana");
        trie.insert("bat");

        System.out.println("countWordsEqualTo('apple') = " + trie.countWordsEqualTo("apple")); // 2
        System.out.println("countWordsEqualTo('app') = " + trie.countWordsEqualTo("app"));     // 1
        System.out.println("countWordsEqualTo('ap') = " + trie.countWordsEqualTo("ap"));       // 0
        System.out.println("countWordsStartingWith('app') = " + trie.countWordsStartingWith("app")); // 4
        System.out.println("countWordsStartingWith('ba') = " + trie.countWordsStartingWith("ba"));   // 2

        System.out.println("=== ERASING WORDS ===");
        trie.erase("apple");
        System.out.println("countWordsEqualTo('apple') after 1 erase = " + trie.countWordsEqualTo("apple")); // 1
        trie.erase("apple");
        System.out.println("countWordsEqualTo('apple') after 2 erases = " + trie.countWordsEqualTo("apple")); // 0

        trie.erase("apple"); // safe: does nothing
        System.out.println("countWordsStartingWith('app') after erasing apple twice = " + trie.countWordsStartingWith("app")); // 2 (only "app", "apply" remain)
    }
}
