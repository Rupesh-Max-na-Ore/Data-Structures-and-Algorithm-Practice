package Strings_Basic_and_Medium.Basic_and_Easy_String_Problems;

import java.util.Arrays;

/*
 * Q4
 * 14. Longest Common Prefix
Easy
Topics
Companies
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
3.4M
Submissions
7.8M
Acceptance Rate
42.9%
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] A) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(A);
        String first = A[0]; 
        String last = A[A.length-1];
        int n1=first.length();
        int nlast=last.length();
        int stop= (n1<nlast)?n1: nlast;
        for (int i=0; i<stop; i++) {
            if (first.charAt(i) == last.charAt(i)) {
                ans.append(first.charAt(i));     
            } else break;
        }
        return ans.toString();
    }
}
// //lc submission
// class Solution {
//     public String longestCommonPrefix(String[] A) {
//         StringBuilder ans = new StringBuilder();
//         Arrays.sort(A);
//         String first = A[0];
//         String last = A[A.length-1];
//         int n1=first.length();
//         int nlast=last.length();
//         int stop= (n1<nlast)?n1: nlast;
//         for (int i=0; i<stop; i++) {
//             if (first.charAt(i) == last.charAt(i)) {
//                 ans.append(first.charAt(i));     
//             } else return ans.toString();
//         }
//         return ans.toString();
//     }
// }

//another lc submission, little faster
// class Solution {
//     public String longestCommonPrefix(String[] A) {
//         //StringBuilder ans = new StringBuilder();
//         Arrays.sort(A);
//         String first = A[0];
//         String last = A[A.length-1];
//         int n1=first.length();
//         int nlast=last.length();
//         int stop= (n1<nlast)?n1: nlast;
//         int i;
//         for (i=0; i<stop; i++) {
//             if (first.charAt(i) == last.charAt(i)) {
//                 //ans.append(first.charAt(i));
//                 continue;  
//             } else break;
//         }
//         return first.substring(0,i);
//     }
// }