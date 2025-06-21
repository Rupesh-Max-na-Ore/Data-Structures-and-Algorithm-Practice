package Trie;
/*1804. Implement Trie II (Prefix Tree) 🔒
中文文档

Description
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and 
retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
int countWordsEqualTo(String word) Returns the number of instances of the string word in the trie.
int countWordsStartingWith(String prefix) Returns the number of strings in the trie that have the string prefix as a prefix.
void erase(String word) Erases the string word from the trie. */
class Node{
    //declare
    Node links[];
    int cw;
    int cp;
    public Node(){
        //initialize
        links = new Node[26];
        cw=0;
        cp=0;
    }
    //fns for next node
    public boolean containsKey(char ch){
        return (links[ch - 'a'] != null);
    }
    public Node get(char ch){
        return links[ch - 'a'];
    }
    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    //fns for cp/cw updates
    public int getCountEndWords(){
        return cw;
    }
    public int getCountStartWords(){
        return cp;
    }
    public void incrementCountEndWords(){
        cw++;
    }
    public void incrementCountStartWords(){
        cp++;
    }
    public void decrementCountEndWords(){
        cw--;
    }
    public void decrementCountStartWords(){
        cp--;
    }
}


public class Trie_2 {
    Node root;
    Trie_2(){
        root = new Node();
    }
    void insert(String word){
        Node trav = root;
        for(char ch : word.toCharArray()){
            if (!trav.containsKey(ch)) {
                trav.put(ch, new Node());
            }
            trav.incrementCountStartWords();
            trav = trav.get(ch);
        }
        trav.incrementCountEndWords();
    }
    
    // void insert(String word){
    //     Node trav = root;
    //     int n = word.length();
    //     for(int i=0; i<n ; i++){
    //         char ch = word.charAt(i);
    //         if(trav.containsKey(ch)){
    //             trav.incrementCountStartWords();
    //             trav = trav.get(ch);
    //         }else{
    //             trav.put(ch, new Node());
    //             trav.incrementCountStartWords();
    //             trav = trav.get(ch);
    //         }
    //     }
    //     trav.incrementCountEndWords();
    // }

    int countWordsEqualTo(String word){
        Node trav = root;
        int n = word.length();
        for(int i=0; i<n ; i++){
            char ch = word.charAt(i);
            if(trav.containsKey(ch)) trav = trav.get(ch);
            else return 0;
        }
        return trav.getCountEndWords();
    }

    int countWordsStartingWith(String word){
        Node trav = root;
        int n = word.length();
        for(int i=0; i<n ; i++){
            char ch = word.charAt(i);
            if(trav.containsKey(ch)) trav = trav.get(ch);
            else return 0;
        }
        return trav.getCountStartWords();
    }

    void erase(String word){
        if (countWordsEqualTo(word) == 0) {
            return; // Word does not exist
        }

        Node trav = root;
        int n = word.length();

        
        //word exists in trie
        for(int i=0; i<n ; i++){
            char ch = word.charAt(i);
            trav.decrementCountStartWords();
            trav = trav.get(ch);
        }
        trav.decrementCountEndWords();
        
        // /*First chk if has the word. If yes, then only update cw/cp */
        //boolean isThere = false;
        // //Better to resuse countWordsEqualTo(word) fn for same as below
        // for(int i=0; i<n ; i++){
        //     char ch = word.charAt(i);
        //     if(trav.containsKey(ch)) trav = trav.get(ch);
        //     else return; // can't delete what does not exists
        // }
        
        // if(trav.getCountEndWords()!=0){
        //     //word exists in trie
        //     for(int i=0; i<n ; i++){
        //         char ch = word.charAt(i);
        //         trav.decrementCountStartWords();
        //         trav = trav.get(ch);
        //     }
        //     trav.decrementCountEndWords();
        // }
    }

    // public static void main(String[] args) {
    //     Trie_2 trie = new Trie_2();
    //     //Trie_22 trie = new Trie_22();
    //     System.out.println("=== INSERTING WORDS ===");
    //     trie.insert("apple");
    //     trie.insert("apple");
    //     trie.insert("app");
    //     trie.insert("apply");
    //     trie.insert("banana");
    //     trie.insert("bat");

    //     System.out.println("countWordsEqualTo('apple') = " + trie.countWordsEqualTo("apple")); // 2
    //     System.out.println("countWordsEqualTo('app') = " + trie.countWordsEqualTo("app"));     // 1
    //     System.out.println("countWordsEqualTo('ap') = " + trie.countWordsEqualTo("ap"));       // 0
    //     System.out.println("countWordsStartingWith('app') = " + trie.countWordsStartingWith("app")); // 4
    //     System.out.println("countWordsStartingWith('ba') = " + trie.countWordsStartingWith("ba"));   // 2

    //     System.out.println("=== ERASING WORDS ===");
    //     trie.erase("apple");
    //     System.out.println("countWordsEqualTo('apple') after 1 erase = " + trie.countWordsEqualTo("apple")); // 1
    //     trie.erase("apple");
    //     System.out.println("countWordsEqualTo('apple') after 2 erases = " + trie.countWordsEqualTo("apple")); // 0

    //     trie.erase("apple"); // safe: does nothing
    //     System.out.println("countWordsStartingWith('app') after erasing apple twice = " + trie.countWordsStartingWith("app")); // 2 (only "app", "apply" remain)
    // }
}
