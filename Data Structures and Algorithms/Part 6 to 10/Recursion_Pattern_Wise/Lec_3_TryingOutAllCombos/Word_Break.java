package Recursion_Pattern_Wise.Lec_3_TryingOutAllCombos;
import java.util.HashMap;
/*Q5 139. Word Break
Medium
Topics
Companies
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.7M
Submissions
3.6M
Acceptance Rate
46.9% */
import java.util.List;

public class Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
	// for memoization
        HashMap<String,Boolean> dp= new HashMap<>();
        return canConstruct(s, wordDict, dp);
    }
    
    public boolean canConstruct(String targetSub,List<String> words, HashMap<String,Boolean> dp)
    {
	
	    // if answer already cached, return it
        if(dp.containsKey(targetSub))
            return dp.get(targetSub);
			
		// if targetSub string is empty
		// it can always be constructed by taking no elems. from Dict.
        // taking no elems.==taking empty or null string
        if(targetSub.isEmpty())
            return true;
			
		// for each and every word in the Dict.
        for(String word: words)
        {
		    // if the targetSub starts with the given word
            if(targetSub.startsWith(word))
            {
			    // and it is possible to construct the rest of the string
			    // from the words in the Dict.
                if(canConstruct(targetSub.substring(word.length()),words, dp))
                {
				
				    // save and return true
                    dp.put(targetSub, true);
                    return true;
                }
            }
        }
		
		// if it was not possible to construct the targetSub from words from the Dict.
		// save and return false to the previous call
        dp.put(targetSub,false);
        return false;
    }
    // public boolean wordBreak(String s, List<String> wordDict) {

    //     //first attempt
    //     // int n= s.length();
    //     // //char[] c=s.toCharArray();
    //     // boolean [] dp=new boolean[n+1];
    //     // //dp[0] = true;
    //     // int l=0; int r=0;
    //     // while(r!=n){
    //     //     String sub=s.substring(l, r+1);
    //     //     String start=s.substring(0, r+1);
    //     //     boolean flag=false;
    //     //     for(int i=0;i<wordDict.size();i++){
    //     //         if((wordDict.get(i).equals(sub) && dp[l]==true)||wordDict.get(i).equals(start)){
    //     //             flag=true;
    //     //             dp[r]=true;
    //     //         }
    //     //     }
    //     //     if(flag==true){
    //     //         l=r+1;
    //     //     }
    //     //     r++;
    //     // } return dp[n];
        
    // }
    public static void main(String[] args) {
        Word_Break wb = new Word_Break();

        // Test Case 1
        System.out.println(wb.wordBreak("leetcode", List.of("leet", "code"))); // Expected output: true

        // Test Case 2
        System.out.println(wb.wordBreak("applepenapple", List.of("apple", "pen"))); // Expected output: true

        // Test Case 3
        System.out.println(wb.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); // Expected output: false
    }
}
//LC forum codes, for revising later on
/*4 different ways to solve this with detailed explanation.

DonaldTrump
2349
18871
Dec 21, 2016



/*
 SOLUTION 1: bfs
    Idea is to try to chop off prefix of s that is in the dict
    enqueue the left-over of each chop off
    if there is a time the left over happens to be in the dict as well
        we know word is breakable, b/c all the previous chops are all in the dict
    otherwise the original world is not breakable.
    
    we can use a set to store all the leftovers that we have tried, to avoid enqueue the 
    same leftover multiple times.

*/
// public class Solution {
//     public boolean wordBreak(String s, Set<String> wordDict) {
//         int index = 0;
//         Queue<String> queue = new LinkedList<String>();
//         queue.offer(s);
//         Set<String> visited = new HashSet<String>();
//         while(!queue.isEmpty()){
//             String candidate = queue.poll();
//             if(wordDict.contains(candidate)) return true;
//             for(int i = 0; i < candidate.length(); i++){
//                 String chop = candidate.substring(0,i);
//                 String next = candidate.substring(i, candidate.length());
//                 if(!visited.contains(next) && wordDict.contains(chop)){
//                     next = candidate.substring(i, candidate.length());
//                     queue.offer(next);
//                     visited.add(next);
//                 }
//             }
//         }
//         return false;
//     }
// }

/* SOLUTION 2: dfs
    use a set to record the substring (i, s.length) that is not breakable
    start from the front, try to see if the substring (0,i) is in the dict,
    if so, recursively check if there is a way to break (i, s.length)
    
    
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s.length() == 0) return false;
        Set<Integer> set = new HashSet<Integer>();
        return helper(s, 0, set, wordDict);
    }
    
    private boolean helper(String s, int index, Set<Integer> set, Set<String> dict){
        if(index == s.length()) return true;
        for(int i = index + 1; i <= s.length(); i++){
            if(set.contains(i)) continue;
            if(dict.contains(s.substring(index, i))){
                 if (helper(s, i, set, dict)) return true;
                 set.add(i);
            }
        }
        return false;
    }
}


/* SOLUTION 3: dp
    dp[i] represents if substring (0,i) is breakable.
    for each longer substring, we just need to check 

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s.length() == 0) return false;
        boolean[] breakable = new boolean[s.length() + 1];
        breakable[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(breakable[j] && wordDict.contains(s.substring(j, i))){
                    breakable[i] = true;
                    break;
                }
            }
        }
        //for(boolean b : breakable) System.out.print(b + ", ");
        return breakable[s.length()];
    }
}
*/

/* SOLUTION 4: TRIE + MAP  


public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        Trie trie = new Trie();
        for(String d : wordDict){
            trie.insert(d);
        }
        List<String> prefix = findPrefix(trie, s);
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        for(String split : prefix){
            if(canBeSplitted(trie, s.replaceFirst(split, ""), map)){
                map.put(split, true);
                return true;
            }
        }
        return false;   
    }
    
    private boolean canBeSplitted(Trie root, String input, Map<String, Boolean> map){
        if(map.containsKey(input)) return map.get(input);
        if(root.search(input) || input.length() == 0) return true;
        List<String> prefix = findPrefix(root, input);
        for(String s : prefix){
            String copy = new String(input);
            if(canBeSplitted(root, copy.replaceFirst(s, ""), map)){
                map.put(input, true);
                return true;
            } 
        }
        map.put(input, false);
        return false;
    }
    
    private List<String> findPrefix(Trie root, String input){
        char[] split = input.toCharArray();
        List<String> result = new ArrayList<String>();
        TrieNode pointer = root.root;
        for(int i = 0; i < split.length; i++){
            pointer = pointer.next[split[i] - 'a'];
            if(pointer == null) break;
            if(pointer.word != null) result.add(pointer.word);
        }
        return result;
    }    

    class TrieNode {
    
        public String word;
        public TrieNode[] next;
        public TrieNode() {
            word = null;
            next = new TrieNode[26];
        }
    }

    public class Trie {
        private TrieNode root;
    
        public Trie() {
            root = new TrieNode();
        }
    
        public void insert(String word) {
            TrieNode pointer = root;
            for(int i = 0; i < word.length(); i++){
                if(pointer.next[word.charAt(i) - 'a'] == null){
                    pointer.next[word.charAt(i) - 'a'] = new TrieNode();
                }
                pointer = pointer.next[word.charAt(i) - 'a'];
            }
            pointer.word = word;
        }
    
        public boolean search(String word) {
            TrieNode pointer = root;
            if(root.word != null && root.word.equals(word)) return true;
            for(int i = 0; i < word.length(); i++){
                if(pointer.next[word.charAt(i) - 'a'] == null) return false;
                pointer = pointer.next[word.charAt(i) - 'a'];
            }
            if(pointer.word == null) return false;
            return pointer.word.equals(word);
        }
    
    }    
    
}*/ //
// [Pyhon] dfs, using lru_cache, explained

// DBabichev
// 100 Days Badge 2023
// 41898
// 1767
// Sep 29, 2020
// Let dfs(k) be a possibility to split string s[k:] into words from wordSet. Then to check if word s[k:] can be splitted, we need to check if for some i word s[k:i] in our wordSet and if s[i:] can be splitted, which is dfs(i).

// Complexity: let T be the maximum length of word in our wordSet. Then we need O(T) time to check if word in our set, so we have overall O(n^2T) complexity. Space complexity is O(n +Tn) : to keep our cache and to keep our set of wordSet

// class Solution:
//     def wordBreak(self, s, wordDict):
//         wordSet = set(wordDict)
//         n = len(s)
   
//         @lru_cache(None)
//         def dfs(k):
//             if k == n: return True
//             for i in range(k + 1, n + 1):
//                 if s[k:i] in wordSet and dfs(i):
//                     return True        
//             return False
        
//         return dfs(0)
// Further discussion: Another approach is to use KMP for each of the m words and create n x n table Mem, where Mem[i][j] is equal to 1 if s[i:j] is in our Dict.. The complexity to generate Mem table is O(mn) and O(n^2) to update dp. Finally, we have O(n^2 + nm) time and O(n^2) memory.

// One more approach is to use Tries to preprocess our dictionary with O(mk) time, where k is the average length of words. Then we can fill dp table in O(n^2) time (CHECK, I am not 100 percent sure). Finally, we have O(mk + n^2) time and O(mk) memory.

// If you have any questions, feel free to ask. If you like solution and explanations, please Upvote!

// Previous
// Fastest JavaScript BFS 44ms
// Next
// Accepted Java Solution
// Comments (2)

// Sort by:Best
// Type comment here... (Markdown supported)
// Preview
// Comment

// cy171
// Annual Badge 2023
// Apr 08, 2023
// python code using tire.

// def wordBreak(self, s: str, wordDict: List[str]) -> bool:
//     head = {}
//     for word in wordDict:
//         dic = head
//         for l in word:
//             dic = dic.setdefault(l,{}) 
//         dic["*"] = True

//     @lru_cache
//     def dfs(i):
//         dic = head
//         for j, l in enumerate(s[i:], start=i):
//             if dic.get("*", False) and dfs(j):
//                 return True
//             if l in dic:
//                 dic = dic[l]
//             else:
//                 return False
//         return dic.get("*", False)
//     return dfs(0)
// 0
// Reply
//https://leetcode.com/problems/word-break/solutions/4453481/conquering-dp-mastering-word-break-with-expert-strategies-beginner-friendly