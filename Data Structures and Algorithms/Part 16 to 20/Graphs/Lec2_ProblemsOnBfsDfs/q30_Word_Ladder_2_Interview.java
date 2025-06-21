package Graphs.Lec2_ProblemsOnBfsDfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
public class q30_Word_Ladder_2_Interview {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //s0 - init reqd data structs
        Set<String> set = new HashSet<>();
        int l = wordList.size();
        int len = beginWord.length();
        //put words in set for easy removal w/o tampering data given
        for(int i=0;i<l;i++) set.add(wordList.get(i)); //o(l)
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ArrayList<String> usedOnLvl = new ArrayList<>();
        ls.add(beginWord);
        q.add(ls);
        usedOnLvl.add(beginWord);
        int lvl=0;
        int minLvl = Integer.MAX_VALUE;//max init for check 10 lines down
        List<List<String>> ans = new ArrayList<>();
        //s1 - start q loop
        while(!q.isEmpty()){
            ArrayList<String> curr = q.poll();
            if(curr.size()>lvl){//remove prev itr used words from set
                lvl++;
                for(String w:usedOnLvl) set.remove(w);
                usedOnLvl.clear();
                // If we already found the endWord at a lower level, stop further exploration
                if (lvl > minLvl) break;
            }
            //get last word from curr polled list
            String wrd = curr.get(lvl - 1);
            //String wrd = curr.get(lvl - 1);//same as above, more brain dead way, hahaha
            //if found end word, just take it as answer iff its seqn len is min.
            if(wrd.equals(endWord)){
                //first sequence capture
                if(ans.size()==0){
                    ans.add(new ArrayList<>(curr));
                    minLvl = lvl;
                }//for after 1st seqn.
                else if(curr.size()==minLvl) ans.add(curr);
            }
            //iterate over each letter of word, see if we can transform to words remaining in set yet
            for(int i=0;i<len;i++){
                for(char ch='a';ch<='z';ch++){
                    char repl[] = wrd.toCharArray();
                    //replace ith letter and check if in set ot not
                    repl[i]=ch;
                    String rw = new String(repl);
                    if(set.contains(rw) && !usedOnLvl.contains(rw)){
                        ArrayList<String> tmp = new ArrayList<>(curr);
                        tmp.add(rw);
                        q.add(tmp);
                        usedOnLvl.add(rw);
                    }
                }
            }

        }//if no path exists return empty list // redundant, just for clarity
        //if (ans.isEmpty()) return new ArrayList<>();
        return ans;
    }
}
