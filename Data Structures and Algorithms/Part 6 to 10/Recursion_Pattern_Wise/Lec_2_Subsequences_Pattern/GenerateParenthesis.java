package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;
// q2 
/*22. Generate Parentheses
Medium
Topics
Companies
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.8M
Submissions
2.5M
Acceptance Rate
74.7%
 */
import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    
    public List<String> genP(int n) {
        if(n<=0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        genPa(n, "", 0, 0, result);
        return result;
    }

    private void genPa(int n, String s, int open, int close, List<String> ans) {
        if(close==n) {
            ans.add(s);
            return;
        }
        if(open<n && open>close){
            genPa(n, s+"(", open+1, close, ans);
            genPa(n, s+")", open, close+1, ans);
        }
        if(open<n && open==close){
            genPa(n, s+"(", open+1, close, ans);
        }
        if(open==n && close<n){
            genPa(n, s+")", open, close+1, ans);
        }
    }
    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        System.out.println(gp.genP(3)); // Expected output: ["((()))","(()())","(())()","()(())","()()()"]
    }

}

/*
 * //cleaner code example, for revision
 * package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    
    public List<String> genP(int n) {
        if(n <= 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        genPa(n, "", 0, 0, result);
        return result;
    }

    private void genPa(int n, String s, int open, int close, List<String> ans) {
        // Base case: if the current string s has n pairs of parentheses
        if(s.length() == n * 2) {
            ans.add(s);
            return;
        }

        // If the number of open parentheses is less than n, add an open parenthesis
        if(open < n) {
            genPa(n, s + "(", open + 1, close, ans);
        }

        // If the number of close parentheses is less than the number of open parentheses, add a close parenthesis
        if(close < open) {
            genPa(n, s + ")", open, close + 1, ans);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        System.out.println(gp.genP(3)); // Expected output: ["((()))","(()())","(())()","()(())","()()()"]
    }
}

 */
/*
 * Time complexity discussion along with solution

ArchitGuleria
50 Days Badge 2022
388
566
May 22, 2022
Java
Backtracking
Recursion
For people confused about space complexity, it can be considered to be around O(2^ (2n)).
This much tight upper bound is sufficient for the interview.

Let me explain how it is O (2^ (2n) ).

The recursion tree will decrease in height linearly as n+n = 2n. Hence, itz height = O (2n).
It will almost be a complete tree and for a complete tree of height h , the number of nodes = O(2^h).

Hence, the number of nodes here = O 2^(2n) = O(4^n)

class Solution {
    List<String> strings;
    public List<String> generateParenthesis(int n) {
        strings = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        
        generate(str,'(',n-1,n);
        return strings;
    }
    
    void generate(StringBuilder str,char ch,int m, int n){
        str.append(ch);
        if(m==0 && n==0)
            strings.add(str.toString());
        else if(m<=n){
            if(m>0){
                generate(str,'(',m-1,n);
                str.deleteCharAt(str.length()-1);
            }
            if(n>0){
                generate(str,')',m,n-1);
                str.deleteCharAt(str.length()-1);
            }
        }
    }
}
 */