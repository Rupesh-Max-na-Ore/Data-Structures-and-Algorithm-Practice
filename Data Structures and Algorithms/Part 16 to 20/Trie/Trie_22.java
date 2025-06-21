package Trie;

class Node {
    private final Node[] links;
    private int countEndWith;
    private int countPrefix;

    public Node() {
        links = new Node[26];
        countEndWith = 0;
        countPrefix = 0;
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    public void incrementEndWith() {
        countEndWith++;
    }

    public void incrementPrefix() {
        countPrefix++;
    }

    public void decrementEndWith() {
        countEndWith--;
    }

    public void decrementPrefix() {
        countPrefix--;
    }

    public int getEndWith() {
        return countEndWith;
    }

    public int getPrefix() {
        return countPrefix;
    }
}

public class Trie_22 {
    private final Node root;

    public Trie_22() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node.incrementPrefix();
            node = node.get(ch);
        }
        node.incrementEndWith();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                return 0;
            }
            node = node.get(ch);
        }
        return node.getEndWith();
    }

    public int countWordsStartingWith(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.containsKey(ch)) {
                return 0;
            }
            node = node.get(ch);
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        if (countWordsEqualTo(word) == 0) {
            return; // Word does not exist
        }

        Node node = root;
        for (char ch : word.toCharArray()) {
            node.decrementPrefix();
            node = node.get(ch);
        }
        node.decrementEndWith();
    }
}
