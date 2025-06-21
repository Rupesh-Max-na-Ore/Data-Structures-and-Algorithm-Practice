package Strings_Basic_and_Medium.Basic_and_Easy_String_Problems;
/*
 * Q1
 * 1021. Remove Outermost Parentheses
Easy
A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.

For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.

Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

 

Example 1:

Input: s = "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: s = "()()"
Output: ""
Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
 

Constraints:

1 <= s.length <= 105
s[i] is either '(' or ')'.
s is a valid parentheses string.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
316.2K
Submissions
382.3K
Acceptance Rate
82.7%
 */

import java.util.Stack;

public class Remove_Outermost_Parentheses {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder ans=new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(!(stack.isEmpty())) ans.append("(");
                stack.push('(');
            } else if(ch==')'){
                stack.pop();
                if(stack.isEmpty()) continue;
                else ans.append(")");
            }
        } return ans.toString();
    }

    public static void main(String[] args) {
        Remove_Outermost_Parentheses solution = new Remove_Outermost_Parentheses();

        // Test cases
        String s1 = "(()())(())";
        String s2 = "(()())(())(()(()))";
        String s3 = "()()";

        System.out.println(solution.removeOuterParentheses(s1)); // Output: "()()()"
        System.out.println(solution.removeOuterParentheses(s2)); // Output: "()()()()(())"
        System.out.println(solution.removeOuterParentheses(s3)); // Output: ""
    }
}
// Lc submission, better SC
// class Solution {
//     public String removeOuterParentheses(String s) {
//         StringBuilder result = new StringBuilder();
//         int opened = 0;
        
//         for (char c : s.toCharArray()) {
//             if ((c == '(' && opened++ > 0) || 
//                 (c == ')' && opened-- > 1)) {
//                 result.append(c);
//             }
//         }

//         return result.toString();
//     }
// }