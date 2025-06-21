package Strings_Basic_and_Medium.Basic_and_Easy_String_Problems;
/* Q3
 * 1903. Largest Odd Number in String
Easy
You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: num = "52"
Output: "5"
Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
Example 2:

Input: num = "4206"
Output: ""
Explanation: There are no odd numbers in "4206".
Example 3:

Input: num = "35427"
Output: "35427"
Explanation: "35427" is already an odd number.
 

Constraints:

1 <= num.length <= 105
num only consists of digits and does not contain any leading zeros.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
249K
Submissions
394.3K
Acceptance Rate
63.1%

 */
public class LargestOdd {
    public String largestOddNumber(String s) {
        int i=s.length()-1;
        while(i>=0){
            int n= Integer.parseInt(s.charAt(i)+"");
            if(n%2==0) {
                i--; continue;
            } else break;
        } return s.substring(0, i+1);
    }
}
// lc submission, fastest
// class Solution {
//     public String largestOddNumber(String s) {
//         int i=s.length()-1;
//         while(i>=0){
//             int n= s.charAt(i) - '0';
//             if(n%2==0) {
//                 i--;
//             } else break;
//         } return s.substring(0, i+1);
//     }
// }

// another lc submission, using different in-built method
// class Solution {
//     public String largestOddNumber(String s) {
//         int i=s.length()-1;
//         while(i>=0){
//             int n= Character.getNumericValue(s.charAt(i));
//             if(n%2==0) {
//                 i--;
//             } else break;
//         } return s.substring(0, i+1);
//     }
// }