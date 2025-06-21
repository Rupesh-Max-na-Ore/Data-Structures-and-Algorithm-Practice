package Graphs.Lec2_ProblemsOnBfsDfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


/*126. Word Ladder II
Hard
Topics
Companies
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 5
endWord.length == beginWord.length
1 <= wordList.length <= 500
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
The sum of all shortest transformation sequences does not exceed 105.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
400.2K
Submissions
1.5M
Acceptance Rate
27.1% */
public class q30_Word_Ladder_2_CP {
    public List<List<String>> findLadders(String start, String end, List<String> words) {
        Set<String> set = new HashSet<>();
        int wl=start.length(); int l = words.size();
        for(int i=0; i<l;i++) set.add(words.get(i));
        Queue<String> q = new LinkedList<>();
        q.add(start);
        HashMap<String,Integer> mp = new HashMap<>();
        mp.put(start, 1);
        set.remove(start);

        //find separate path w/o overlap except pt. of divergence from start to end point
        while(!q.isEmpty()){
            String curr = q.poll();
            int steps = mp.get(curr);
            if(curr.equals(end)) break;
            for(int i=0;i<wl;i++){
                for(char ch='a';ch<='z';ch++){
                    char repl[] = curr.toCharArray();
                    //replace ith letter and check if in set ot not
                    repl[i]=ch;
                    String rw = new String(repl);
                    if(set.contains(rw)){
                        q.add(rw);
                        set.remove(rw);
                        mp.put(rw, steps+1);
                    }
                }
            }
        }

        //dfs to backtrack(end-->start) from solution path and add to Ans
        List<List<String>> ans = new ArrayList<>();
        if(mp.containsKey(end)){
            List<String> seqn = new ArrayList<>();
            seqn.add(end);
            DFS(end,seqn,start,ans,mp);
        }
        return ans;
    }
            
                private void DFS(String wrd, List<String> seqn, String start, List<List<String>> ans, HashMap<String, Integer> mp) {
                    if(wrd.equals(start)){
                        //seqn.add(start);//already done at called fn.
                        List<String> dupli = new ArrayList<>(seqn);
                        Collections.reverse(dupli);
                        ans.add(dupli);
                        return;
                    }
                    int steps = mp.get(wrd);
                    int wl = wrd.length();
                    for(int i=0;i<wl;i++){
                        for(char ch='a';ch<='z';ch++){
                            char repl[] = wrd.toCharArray();
                            repl[i]=ch;
                            String rw = new String(repl);
                            if(mp.containsKey(rw) && mp.get(rw)==steps-1){
                                seqn.add(rw);
                                DFS(rw, seqn, start, ans, mp);
                                seqn.remove(seqn.size()-1);//BT
                            }
                        }
                    }
                }
}
/*//https://chatgpt.com/share/67d133e8-54dc-8005-a162-c8792725afe9
//https://chatgpt.com/share/67d133e8-54dc-8005-a162-c8792725afe9
//chatGPT fails again, lol
//more standard implementation
package Graphs.Lec2_ProblemsOnBfsDfs;

import java.util.*;

public class q30_Word_Ladder_2_CP {
    public List<List<String>> findLadders(String start, String end, List<String> words) {
        Set<String> set = new HashSet<>(words);
        List<List<String>> ans = new ArrayList<>();

        // Edge case: If end word is not in the word list, return empty answer
        if (!set.contains(end)) return ans;

        // Step 1: BFS to find the shortest path and store levels
        Map<String, Integer> mp = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.add(start);
        mp.put(start, 1);
        set.remove(start);

        boolean found = false;
        int wordLength = start.length();

        // For level-based word removal
        Set<String> wordsOnCurrentLevel = new HashSet<>();

        while (!q.isEmpty() && !found) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                int steps = mp.get(curr);

                char[] currArray = curr.toCharArray();

                // Generate all possible next words
                for (int j = 0; j < wordLength; j++) {
                    char originalChar = currArray[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == originalChar) continue;

                        currArray[j] = ch;
                        String nextWord = new String(currArray);

                        if (set.contains(nextWord)) {
                            // If encountering end word, stop BFS early
                            if (nextWord.equals(end)) found = true;

                            // Only process new words or words at the current shortest distance
                            if (!mp.containsKey(nextWord)) {
                                mp.put(nextWord, steps + 1);
                                q.add(nextWord);
                                wordsOnCurrentLevel.add(nextWord);
                            }
                        }
                    }
                    currArray[j] = originalChar; // Restore the original character
                }
            }
            // Remove words of this level after the loop to allow multiple paths to access them
            set.removeAll(wordsOnCurrentLevel);
            wordsOnCurrentLevel.clear();
        }

        // Step 2: If we found the end word, perform DFS to collect all valid sequences
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(start);
            dfs(start, end, path, ans, mp);
        }

        return ans;
    }

    // DFS to backtrack and collect all valid sequences
    private void dfs(String curr, String end, List<String> path, List<List<String>> ans, Map<String, Integer> mp) {
        if (curr.equals(end)) {
            ans.add(new ArrayList<>(path));
            return;
        }

        int steps = mp.get(curr);
        char[] currArray = curr.toCharArray();

        for (int i = 0; i < currArray.length; i++) {
            char originalChar = currArray[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == originalChar) continue;

                currArray[i] = ch;
                String nextWord = new String(currArray);

                // Check if the next word is on the correct path (steps + 1)
                if (mp.containsKey(nextWord) && mp.get(nextWord) == steps + 1) {
                    path.add(nextWord);
                    dfs(nextWord, end, path, ans, mp);
                    path.remove(path.size() - 1); // Backtrack
                }
            }
            currArray[i] = originalChar; // Restore character after exploring
        }
    }
}

 */