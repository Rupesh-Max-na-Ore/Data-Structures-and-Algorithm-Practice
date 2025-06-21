package String_Hards;
/*921. Minimum Add to Make Parentheses Valid
Medium
Topics
Companies
A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

 

Example 1:

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3
 

Constraints:

1 <= s.length <= 1000
s[i] is either '(' or ')'.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
606.1K
Submissions
811.2K
Acceptance Rate
74.7%
Topics
String
Stack
Greedy
Companies
Similar Questions
Minimum Number of Swaps to Make the String Balanced
Medium */
public class q1_Minimum_Add_to_Make_Parentheses_Valid {
    public int minAddToMakeValid(String s) {
        int extra_closed = 0; //for cases when have extra extra_closed ')', i.e., extra_opened = 0, but extra_closed > 0
        int extra_opened = 0; //use like stack
        //char prev_ch = ' ';
        for(char ch : s.toCharArray()){ 
            if(ch == '(') extra_opened++;
            else if(ch == ')'){
                if(extra_opened > 0){
                    extra_opened--;
                }
                else if (extra_opened == 0){
                    extra_closed++;
                }
            }
        }
        int total_needed = extra_opened + extra_closed; 
        return total_needed;
    }
    //Wrong 1st attempt
    // public int minAddToMakeValid(String s) {
    //     int tot_cnt = 0;
    //     int cnt = 0;
    //     char prev_ch = ' ';
    //     for(char ch : s.toCharArray()){
    //         //Transition from A to B if AB is the string
    //         if(prev_ch == ')' && ch == '(') {
    //             tot_cnt += Math.abs(cnt);
    //             cnt = 0;//reset cnt
    //         } 
    //         if(ch == '(') cnt++;
    //         else if(ch == ')') cnt--;
    //         prev_ch = ch;
    //         //else continue; //ignore any other characters
    //     }
    //     //for last cnt
    //     tot_cnt += Math.abs(cnt);
    //     return tot_cnt;
    // }
}
