package Trie.Lec2_Problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 1858. Longest Word With All Prefixes 🔒
中文文档

Description
Given an array of strings words, find the longest string in words such that every prefix of it is also in words.

For example, let words = ["a", "app", "ap"]. The string "app" has prefixes "ap" and "a", all of which are in words.
Return the string described above. If there is more than one string with the same length, return the lexicographically smallest one, and if no string exists, return "".

 

Example 1:

Input: words = ["k","ki","kir","kira", "kiran"]
Output: "kiran"
Explanation: "kiran" has prefixes "kira", "kir", "ki", and "k", and all of them appear in words.
Example 2:

Input: words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: Both "apple" and "apply" have all their prefixes in words.
However, "apple" is lexicographically smaller, so we return that.
Example 3:

Input: words = ["abc", "bc", "ab", "qwe"]
Output: ""
 

Constraints:

1 <= words.length <= 105
1 <= words[i].length <= 105
1 <= sum(words[i].length) <= 105
words[i] consists only of lowercase English letters.*/
class Node{
    Node links[];
    boolean flag;
    Node(){
        links = new Node[26];
        flag = false;
    }
    public boolean containsKey(char ch) {
        return links[ch -'a']!=null ;
    }
    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }
    public Node get(char ch) {
        return links[ch - 'a'];
    }
    public void setEnd() {
        flag = true;
    }
    public boolean isEnd() {
        return flag;
    }

}

class Trie{
    Node root;
    Trie(){
        root = new Node();
    }
    Node getRoot(){
        return root;
    }
    void insert(String word){
        Node trvl = root;
        int n = word.length();
        for(char ch : word.toCharArray()){
            if(!trvl.containsKey(ch)) trvl.put(ch, new Node());
            trvl = trvl.get(ch);
        }
        trvl.setEnd();
    }

    boolean search(String word){
        Node trvl = root;
        int n = word.length();
        for(char ch : word.toCharArray()){
            if(!trvl.containsKey(ch)) return false;
            trvl = trvl.get(ch);
        }
        return trvl.isEnd();
    }

    boolean startsWith(String word){
        Node trvl = root;
        int n = word.length();
        for(char ch : word.toCharArray()){
            if(!trvl.containsKey(ch)) return false;
            trvl = trvl.get(ch);
        }
        return true;
    }
}

public class q3_Complete_String {
    //2nd  attempt , better, use trie property
    public String longestWord(String[] words){
        Trie trie = new Trie();
        for(String word : words) trie.insert(word);
    
        String result = "";
    
        for(String word : words){
            //Only check for bigger OR EQUAL to Strings than current result
            if(word.length() < result.length()) continue;
            //CHeck for complete by starting from root, go next refrnce node
            Node node = trie.root;
            boolean complete = true;
            for(char ch : word.toCharArray()){
                node = node.get(ch);
                if (node == null || !node.isEnd()) {
                    complete = false;
                    break;
                }
            }
    
            if (complete) {
                if (word.length() > result.length() || 
                   (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
    
        return result;//returns "" if no compelete word
    }
    

    // First Attempt, correct but inefficient cuz use substring() thats O(n^2)
    public String longestWord_(String[] words){
        //Insert all words in trie
        Trie trie = new Trie();
        for(String word : words) trie.insert(word);

        //Check each word for complete
        String largestCompleteWord = "";
        int lenLCW = 0;
        for(String word : words){
            boolean complete = false;
            int n = word.length();
            //i=end
            for(int i = 0; i < n; i++){
                //char ch = word.charAt(i);
                String curr = word.substring(0, i+1);
                if(!trie.search(curr)) break;
                //else
                if(i==n-1) complete = true; 
            }
            if(complete){
                if(n > lenLCW){
                    largestCompleteWord = word;
                    lenLCW = n;
                }
                else if(n == lenLCW){//lexicographic check
                    if(word.compareTo(largestCompleteWord) < 0){
                        largestCompleteWord = word;
                    }
                }
            }
        }
        return largestCompleteWord;
    }

    //way 2 - greedy way - sorting + hashset
    //very small code, suitable for OAs
    public String longestWord_2(String[] words){
        //lexi sort arr
        Arrays.sort(words);
        HashSet<String> build = new HashSet<>();
        String res = "";
        int rlen = 0;
        //for each word, check if their 
        //1 less len substring is present or not
        for(String  word : words){
            int n = word.length();
            if(n ==1 || build.contains(word.substring(0, n-1))){
                build.add(word);
                //chk if n gt res len or not
                if(n > rlen){
                    //add to res
                    res = word;
                    rlen = n;
                }
            }
        }
        return res;
    }
    //way 3 - trie + DFS
    public String longestWord_3(String[] words){
        //String best = ""; //pass by val won't preserve b/w fn calls
        Trie trie = new Trie();
        for( String word : words) trie.insert(word);
        StringBuilder currString = new StringBuilder();
        String[] best = new String[]{""};  // use array to pass by reference
        dfs(trie.getRoot(), best, currString);
        return best[0];

    }


    private void dfs(Node node, String[] best, StringBuilder currString) {
        //chk in lexi order, a to z
        for(int i=0; i< 26; i+=1){
            char currChar = (char)(i + 'a');
            if(node.containsKey(currChar)){
                Node nextNode = node.get(currChar);
                //every substring need to be a word, 
                //so only consider if letter isEnd
                //else just return as not worth chking
                if(nextNode.isEnd()){
                    currString.append(currChar);
                    if(currString.length() > best[0].length()){
                        best[0] = currString.toString();
                    }
                    dfs(nextNode, best, currString);
                    //backtrack
                    currString.deleteCharAt(currString.length()-1);
                }
            }
        }
    }
    //way 4 - Hashset
    public String longestWord_4(String[] words){
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });

        for (String word : words) {
            boolean ok = true;
            for (int i = 1; i < word.length(); i++) {
                if (!set.contains(word.substring(0, i))) {
                    ok = false;
                    break;
                }
            }
            if (ok) return word;
        }
        return "";
    }
}
