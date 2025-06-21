package Trie.Lec2_Problems;

import java.util.HashSet;
import java.util.Set;

/*1698 - Number of Distinct Substrings in a String
Posted on July 24, 2020 · 5 minute read
Welcome to Subscribe On Youtube

1698. Number of Distinct Substrings in a String
Description
Given a string s, return the number of distinct substrings of s.

A substring of a string is obtained by deleting any number of characters (possibly zero) from the front of the string and any number (possibly zero) from the back of the string.

 

Example 1:

Input: s = "aabbaba"
Output: 21
Explanation: The set of distinct strings is ["a","b","aa","bb","ab","ba","aab","abb","bab","bba","aba","aabb","abba","bbab","baba","aabba","abbab","bbaba","aabbab","abbaba","aabbaba"]
Example 2:

Input: s = "abcdefg"
Output: 28
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
 

Follow up: Can you solve this problem in O(n) time complexity? */
class Node{
    Node links[];
    Node(){
        links = new Node[26];
    }
}

public class q4_Distinct_Substrings {
    //way 1 - hashset
    public int countDistinct_1(String s){
        Set<String> set = new HashSet<>();
        int n= s.length();
        //all substrings
        
        for(int i=0; i< n;i++){
            //i is start and j is end
            StringBuilder sb = new StringBuilder();
            for(int j=i; j<n; j++){
                char ch = s.charAt(j);
                sb.append(ch);
                set.add(sb.toString());
            }
        }

        return set.size() + 1;
    }

    //way 2 - trie
    public int countDistinct_2(String s){
        int n=s.length();
        //Store root
        Node root = new Node();
        int cnt = 0;
        //for each substring, i=start, j=end
        for(int i=0; i< n;i++){
            Node trav = root;
            for(int j=i;j<n;j++){
                char ch = s.charAt(j);
                if(trav.links[ch-'a']==null){
                    trav.links[ch-'a'] = new Node();
                    cnt++;
                }
                trav = trav.links[ch-'a'];
            }
        }
        return cnt + 1;
    }

    //way 3 - string hashing
    public int countDistinct_3(String s){
        int P = 31;
        int MOD = (int) 1e9+9;
        //int base = 131;
        int n = s.length();
        long[] pows = new long[n + 1];  // p^i
        long[] hash = new long[n + 1];  // prefix hashes
        pows[0] = 1;

        for (int i = 0; i < n; i++) {
            pows[i + 1] = (pows[i] * P) % MOD;
        }

        // Compute prefix hashes
        for (int i = 0; i < n; i++) {
            hash[i + 1] = (hash[i] * P + (s.charAt(i) - 'a' + 1)) % MOD;
        }

        Set<Long> substrHashes = new HashSet<>();

        // Enumerate all substrings and hash them
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long curHash = (hash[j + 1] - hash[i] * pows[j - i + 1] % MOD + MOD) % MOD;
                substrHashes.add(curHash);
            }
        }

        // +1 to include empty string
        return substrHashes.size() + 1;
    }
    //similar to above
    public int countDistinct(String s) {
        int base = 131;
        int n = s.length();
        long[] p = new long[n + 10];  // p[i] = base^i
        long[] h = new long[n + 10];  // h[i] = hash of prefix s[0..i-1]

        p[0] = 1;
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] * base;
            h[i + 1] = h[i] * base + s.charAt(i);
        }

        Set<Long> set = new HashSet<>();

        // For each substring s[i..j], use hash[j+1] - hash[i] * base^(j - i + 1)
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                long hash = h[j] - h[i - 1] * p[j - i + 1];
                set.add(hash);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        q4_Distinct_Substrings solver = new q4_Distinct_Substrings();
        System.out.println(solver.countDistinct("aabbaba")); // Output: 21
        System.out.println(solver.countDistinct("abcdefg")); // Output: 28
    }
}
