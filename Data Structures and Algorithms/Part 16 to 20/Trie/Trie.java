package Trie;

class Node{
    //declare
    Node links[];
    boolean flag;
    Node(){
        //initialize
        links = new Node[26];
        flag = false;
    }
    boolean containsKey(char ch){
        return (links[ch - 'a'] != null);
    }
    Node get(char ch){
        return links[ch - 'a'];
    }
    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }
    public void setEnd() {
        flag = true;
    }
    public boolean isEnd() {
        return flag;
    }
}

public class Trie{
    Node root; //declare

    Trie(){
        root = new Node(); //init
    }

    public void insert(String word){
        Node traverser = root;
        int n = word.length();
        for(int i=0; i<n ; i++){
            char ch = word.charAt(i);
            if(traverser.containsKey(ch)) traverser = traverser.get(ch);
            else {
                traverser.put(ch, new Node());
                traverser = traverser.get(ch);
            }
        } 
        traverser.setEnd();
    }

    public boolean search(String word){
        Node traverser = root;
        int n = word.length();
        for(int i=0; i<n ; i++){
            char ch = word.charAt(i);
            if(traverser.containsKey(ch)) traverser = traverser.get(ch);
            else return false;
        }
        if(traverser.isEnd()) return true;
        //else
        return false;
    }

    public boolean startsWith(String word){
        Node traverser = root;
        int n = word.length();
        for(int i=0; i<n ; i++){
            char ch = word.charAt(i);
            if(traverser.containsKey(ch)) traverser = traverser.get(ch);
            else return false;
        }
        return true;
    }
}