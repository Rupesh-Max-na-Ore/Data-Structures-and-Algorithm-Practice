package Graphs.Lec2_ProblemsOnBfsDfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*127. Word Ladder
Hard
Topics
Companies
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.3M
Submissions
3.1M
Acceptance Rate
42.0% */
public class q29_Word_Ladder_1 {
    class Pair {
        int lvl;
        String word;
        Pair(String w, int l){
            lvl=l;
            word = w;
        }
    }
    
    public int ladderLength(String beg, String end, List<String> words) {
        HashSet<String> set = new HashSet<>(); int n = words.size();
        for(int i=0;i<n;i++) set.add(words.get(i));//o[n]
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beg, 1));
        set.remove(beg);
        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(curr.word.equals(end)) return curr.lvl;
            for(int i=0;i<curr.word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char repl[] = curr.word.toCharArray();
                    //replace ith letter and check if in set ot not
                    repl[i]=ch;
                    String rw = new String(repl);
                    if(set.contains(rw)){
                        set.remove(rw);
                        q.add(new Pair(rw, curr.lvl+1));
                    }
                }
            }
        } return 0;
    }
}
