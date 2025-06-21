package Greedy_Algorithms.Easy;
/*Q5 678. Valid Parenthesis String
Medium
Topics
Companies
Hint
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
 

Constraints:

1 <= s.length <= 100
s[i] is '(', ')' or '*'.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
386.8K
Submissions
1M
Acceptance Rate
38.1% */
public class Valid_Parenthesis_String {
    //Attempt 3 - success -> to check why attempt 1 not work but 3 work, dry run on s="(*)"
    public boolean checkValidString(String s) {
        int min=0,max=0;
        for(char c : s.toCharArray()){
            if(c=='(') {
                max++; min++;
            }
            else if(c==')'){
                max--; min--;
            }
            else //if(c=='*')
            {
                min--;
                max++;
            }
            if(min<0)min=0;
            if(max<0)return false;//means 
        }
        //if(min<0||max<0) return false;
        //else
        return(min==0);
        //return (min<=0 && max>=0);
    }
    //Attempt 1
    /*Wrong Answer
        52 / 83 testcases passed

        Editorial
        Input
        s =
        "(*)"

        Use Testcase
        Output
        false
        Expected
        true */
    // public boolean checkValidString(String s) {
    //     int min=0,max=0;
    //     for(char c : s.toCharArray()){
    //         if(c=='(') {
    //             max++; min++;
    //         }
    //         else if(c==')'){
    //             max--; min--;
    //         }
    //         else //if(c=='*')
    //         {
    //             if(min > 0) min--;
    //             max++;
    //         }
    //         if(max<0)return false;//means 
    //     }
    //     // if(min<0||max<0) return false;
    //     // //else
    //     return (min==0);
    // }
}
//attempt 2
/*Wrong Answer
72 / 83 testcases passed

Editorial
Input
s =
"(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"

Use Testcase
Output
true
Expected
false */
// class Solution {
//     public boolean checkValidString(String s) {
//         int min=0,max=0;
//         for(char c : s.toCharArray()){
//             if(c=='(') {
//                 max++; min++;
//             }
//             else if(c==')'){
//                 max--; min--;
//             }
//             else //if(c=='*')
//             {
//                 if(min > 0) min--;
//                 max++;
//             }
//             if(max<0)return false;//means 
//         }
//         //if(min<0||max<0) return false;
//         //else
//         return (min<=0 && max>=0);
//     }
// }
