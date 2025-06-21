package Strings_Basic_and_Medium.Medium_String_Problems;
/*Q2
 * 1614. Maximum Nesting Depth of the Parentheses
Easy
Topics
Companies
Hint
Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

 

Example 1:

Input: s = "(1+(2*3)+((8)/4))+1"

Output: 3

Explanation:

Digit 8 is inside of 3 nested parentheses in the string.

Example 2:

Input: s = "(1)+((2))+(((3)))"

Output: 3

Explanation:

Digit 3 is inside of 3 nested parentheses in the string.

Example 3:

Input: s = "()(())((()()))"

Output: 3

 

Constraints:

1 <= s.length <= 100
s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
It is guaranteed that parentheses expression s is a VPS.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
331K
Submissions
395.5K
Acceptance Rate
83.7%
 */
public class MaxNestingDepthofParentheses {
    public int maxDepth(String s) {
        int max = 0;
        int opened = 0;
    
        for (char c : s.toCharArray())
          {
            if (c == '('){
            max = (max >= ++opened)? max:opened;
          }
          else if (c == ')')
            {
                --opened;
            }
    }
        return max;
      }
}
