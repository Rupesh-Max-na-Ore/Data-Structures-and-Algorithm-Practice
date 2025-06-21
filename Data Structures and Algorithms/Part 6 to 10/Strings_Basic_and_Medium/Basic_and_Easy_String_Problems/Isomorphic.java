package Strings_Basic_and_Medium.Basic_and_Easy_String_Problems;
/*Q5
 * 205. Isomorphic Strings
Solved
Easy
Topics
Companies
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.4M
Submissions
3M
Acceptance Rate
45.2%
 */
public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;

        int pos1[]=new int[256];
        int pos2[]=new int[256];

        for(int i=0;i<s.length();i++)
        {
            if(pos1[s.charAt(i)]!=pos2[t.charAt(i)])
                return false;

            pos1[s.charAt(i)]=i+1;
            pos2[t.charAt(i)]=i+1;
        }
        return true;
    }
}
/*
 * //anOTHER WAY TO DO SAME, JUST FASTER
 * class Solution {
        public boolean isIsomorphic(String s, String t) {

        int pos1[]=new int[128];
        int pos2[]=new int[128];

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int i = 0;

        for(char ch1: arr1)
        {   
            char ch2 = arr2[i++];
            if(pos1[ch1] != pos2[ch2])
                return false;

            pos1[ch1]=i+1;
            pos2[ch2]=i+1;
        }
        return true;
    }
}
 */