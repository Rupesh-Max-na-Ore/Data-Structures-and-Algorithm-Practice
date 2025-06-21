package Strings_Basic_and_Medium.Basic_and_Easy_String_Problems;
/*
 * Q6
 * 796. Rotate String
Solved
Easy
Topics
Companies
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
 

Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
314.2K
Submissions
539.5K
Acceptance Rate
58.2%
 */
public class RotationOfString {
    public boolean rotateString(String A, String B) {
        if(A == null || B == null) {
            //throw exception on A and B both being null
            return false;
        }
        if(A.length() != B.length()) {
            return false;
        }
        int N=A.length();
        if(N == 0) {
            return true;
        }
        for(int i = 0; i < N; i++) {
            if(CheckRotatedString(A, B, N, i)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean CheckRotatedString(String A, String B, int N, int rotation) {
        for(int i = 0; i < N; i++) {
            if(A.charAt(i) == B.charAt((i+rotation)%N)) continue;
            else return false;
        }
        return true;
    }
}

// //lc solution, small code, little less efficient
// class Solution {
//     public boolean rotateString(String A, String B) {
//          return (A.length() == B.length() && (B+B).contains(A));
//      }
//  }