package Graphs.Lec3_Topo_Sort_and_Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*Alien Dictionary
Difficulty: HardAccuracy: 47.81%Submissions: 151K+Points: 8
A new alien language uses the English alphabet, but the order of letters is unknown. You are given a list of words[] from the alien language’s dictionary, where the words are claimed to be sorted lexicographically according to the language’s rules.

Your task is to determine the correct order of letters in this alien language based on the given words. If the order is valid, return a string containing the unique letters in lexicographically increasing order as per the new language's rules. If there are multiple valid orders, return any one of them.

However, if the given arrangement of words is inconsistent with any possible letter ordering, return an empty string ("").

A string a is lexicographically smaller than a string b if, at the first position where they differ, the character in a appears earlier in the alien language than the corresponding character in b. If all characters in the shorter word match the beginning of the longer word, the shorter word is considered smaller.

Your implementation will be tested using a driver code. It will print true if your returned order correctly follows the alien language’s lexicographic rules; otherwise, it will print false.

Examples:

Input: words[] = ["cb", "cba", "a", "bc"]
Output: true
Explanation: You need to return "cab" as the correct order of letters in the alien dictionary.
Input: words[] = ["ab", "aa", "a"]
Output: ""
Explanation: You need to return "" because "aa" is lexicographically larger than "a", making the order invalid.
Input: words[] = ["ab", "cd", "ef", "ad"]
Output: ""
Explanation: You need to return "" because "a" appears before "e", but then "e" appears before "a", which contradicts the ordering rules.
Constraints:

1 <= words.length <= 500
1 <= words[i].length <= 100
words[i] consists only of lowercase English letters.
Company Tags
FlipkartAmazonMicrosoftOYO RoomsWalmartGoogle */
public class q26_Alien_Dictionary {
    //way 1 - use Kahn's algo modified BFS w/indegree[v]
    public String findOrder(String[] words) {
        int n = words.length;
        HashSet<Integer> letters = new HashSet<>();
        //s1 - construct directed graph
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < 26; i++) g.add(new ArrayList<>());//init inner list
        //Get all unique letters by iterating over all words
        for(String w : words){
            for(char ch : w.toCharArray()) 
                if(!letters.contains(ch - 'a')) letters.add(ch-'a');
        }

        int uniqueLetters = letters.size();

        //compare 2 consecutive strings till point of difference and add edges
        for(int i=0;i<n-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int l1 = s1.length();
            int l2 = s2.length();
            int len = Math.min(l1,l2);
            // an case that improves best case, but can skip honestly if question gurantees it
            // Invalid prefix check (e.g., "abc" -> "ab")
            if(l1>l2 && s1.startsWith(s2) ) return  "";//O[l2] check

            for(int j=0;j<len;j++){
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if(c1==c2) continue;
                //else
                g.get(c1-'a').add(c2-'a'); break;
            }
        }
        //s2- get indegree
        //int[]indegree=new int[26];
        // can use hash map as below to save space
            // HashMap<Integer, Integer> indegree = new HashMap<>();

            // // Initialize indegree map for all unique letters
            // for (int letter : letters) {
            // indegree.put(letter, 0);
            // }

            // // Update in-degrees based on graph edges
            // for (int i = 0; i < 26; i++) {
            // for (int nbr : g.get(i)) {
            // indegree.put(nbr, indegree.getOrDefault(nbr, 0) + 1);
            // }
            // }
        //Arrays faster if fixed no.  of alphabets like 26 lower cases, or even 511 extended ascii sometimes
        int[] indegree = new int[26];
        for (int i = 0; i < 26; i++) {
            for (int nbr : g.get(i)) {
                indegree[nbr]++;
            }
        }
        //s3 - topo sort
        Queue<Integer> q=new LinkedList<>();
        //push all indeg=0 and must exist 
        //for(int i=0;i<26;i++) if(letters.contains(i) && indegree[i]==0) q.offer(i);
        //better
        for (int letter : letters) if (indegree[letter] == 0) q.offer(letter); //consider only valid letters

        //get ordering
        StringBuilder sb=new StringBuilder();
        int cnt=0;
        while (!q.isEmpty()) {
            int curr=q.poll();
            sb.append((char)(curr+'a'));
            cnt++;
            for (int nbr : g.get(curr)) {
                indegree[nbr]--; //curr removed, all it connects to(nbrs) get -1 indegree
                if (indegree[nbr] == 0) q.offer(nbr);
            }
        }

        return (cnt==uniqueLetters)?sb.toString():"";
    }
    //Way 2 - use DFS+stack+vis[v]
    public String findOrder2(String[] words) {
        int n = words.length;
        HashSet<Integer> letters = new HashSet<>();
        //s1 - construct directed graph
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i < 26; i++) g.add(new ArrayList<>());//init inner list
        //Get all unique letters by iterating over all words, char by char
        for(String w : words){
            for(char ch : w.toCharArray()) 
                if(!letters.contains(ch - 'a')) letters.add(ch-'a');
        }

        int uniqueLetters = letters.size();

        //compare 2 consecutive strings till point of difference and add edges
        for(int i=0;i<n-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int l1 = s1.length();
            int l2 = s2.length();
            int len = Math.min(l1,l2);
            // an case that improves best case, but can skip honestly if question gurantees it
            // Invalid prefix check (e.g., "abc" -> "ab")
            if(l1>l2 && s1.startsWith(s2) ) return  "";//O[l2] check

            for(int j=0;j<len;j++){
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if(c1==c2) continue;
                //else
                g.get(c1-'a').add(c2-'a'); break;
            }
        }
        //s2- use vis and dfs, fill stack
        Stack<Integer>st=new Stack<>();
        int vis[]=new int[26]; // 0 = unvisited, 1 = visiting, 2 = visited
        for (int letter : letters) {
            if (vis[letter] == 0) {
                if (!dfs(g, letter, vis, st)) return ""; // Cycle detected
            }
        }

        //s3- build answer by poping out of stack
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append((char) (st.pop() + 'a'));
        }

        return ans.toString();
    }
    private boolean dfs(ArrayList<ArrayList<Integer>> g, int currletter, int[] vis, Stack<Integer> st) {
        vis[currletter] =1; //visiting curr letter

        for(int nbr : g.get(curr)){
            if(vis[nbr]==1) return false;//cycle detected!!!!
            if(vis[nbr]==0) if(!dfs(g, nbr, vis, st)) return false;
            //if (visited[neighbor] == 0) return dfs(g, neighbor, visited, stack); 
            //dont use above cuz: "In DFS, you need to check all neighbors of the current node. 
            //If you immediately return dfs(...), it only explores one neighbor and ignores the others."
        }
        vis[currletter] = 2;//fully visited
        st.push(currletter);
        return true;
    }

            
}
