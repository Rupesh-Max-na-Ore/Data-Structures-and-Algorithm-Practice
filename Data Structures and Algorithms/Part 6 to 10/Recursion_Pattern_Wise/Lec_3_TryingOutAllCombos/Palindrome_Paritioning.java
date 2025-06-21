package Recursion_Pattern_Wise.Lec_3_TryingOutAllCombos;

import java.util.ArrayList;
import java.util.List;

/*Q1 131. Palindrome Partitioning
Medium
Topics
Companies
Given a string s, partition s such that every 
substring
 of the partition is a 
palindrome
. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
901.9K
Submissions
1.3M
Acceptance Rate
69.4% */
public class Palindrome_Paritioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        int n = s.length();
        recurPalPartition(s,n,0,new ArrayList<String>(), ans);
        return ans;
    }
    //DFS approach
    private void recurPalPartition(String s, int n, int i, ArrayList<String> currSet, List<List<String>> ans) {
        if(i==n){// Base: last parition always at end of string
            ans.add(new ArrayList<>(currSet));
            return;
        }
        //Iterate through s checking for pals. and finding valid paritions
        for(int j=i; j<n;j++){
            //check if s[i to j] is pal. or not
            if(isPal(s,i,j)){
                // if yes, add to current partion
                String sub=s.substring(i, j+1);
                currSet.add(sub);
                // propagate further into recursion depth to find next partiions
                recurPalPartition(s, n, j+1, currSet, ans);
                // Backtrack by removing to explore next parallel possibility
                currSet.remove(currSet.size()-1);
            }
        }
    }
    private boolean isPal(String s, int i, int j) {
       //2 ptr. approach
       //keep a L at atart and R at end, go to mid while checking for matches
       int L=i; int R=j;
       while(L<=R)
       {if(s.charAt(L++)!=s.charAt(R--)){return false;} 
        }
        return true;
    }
}
