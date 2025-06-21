package Strings_Basic_and_Medium.Basic_and_Easy_String_Problems;

import java.util.HashMap;

/*Q7
242. Valid Anagram
Easy
Topics
Companies
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

Seen this question in a real interview before?
1/5
Yes
No
Accepted
3.5M
Submissions
5.5M
Acceptance Rate
64.7%
*/
public class ValidAnagrams {
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        if(t.length()!=n) return false;
        HashMap<Character,Integer> Freq = new HashMap<>();
        // Ini. freq. of all LoCase letters to 0
        // for(int i = 0; i < 26; i++){
        //     Freq.put((char)(i + 'a'), 0);
        // }
        // Count freq. of chars in s
        for(int i = 0; i < n; i++){
            // store current char of s in ch
            char ch = s.charAt(i);
            //check if ch is present in HM
            //if(Freq.containsKey(ch)){
                //if present, store its (int)
                //freq. of occurence in count var.
                int count = (Freq.containsKey(ch))?Freq.get(ch):0;
                //increase freq. of ch by 1
                Freq.put(ch, count + 1);
            //}

            char ct=t.charAt(i);
            //if(Freq.containsKey(ct)){
                int cnt=(Freq.containsKey(ct))?Freq.get(ct):0;
                Freq.remove(ct);
                Freq.put(ct, cnt-1);
            //}
        }
        for (char key : Freq.keySet()) {
                if(Freq.get(key)!=0) return false;
            } return true;
    }
}

/*
 * lc soln
 * class Solution {
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        if(t.length()!=n) return false;
        HashMap<Character,Integer> Freq = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
                int count = (Freq.containsKey(ch))?Freq.get(ch):0;
                Freq.put(ch, count + 1);

            char ct=t.charAt(i);
                int cnt=(Freq.containsKey(ct))?Freq.get(ct):0;
                Freq.remove(ct);
                Freq.put(ct, cnt-1);
        }
        for (char key : Freq.keySet()) {
                if(Freq.get(key)!=0) return false;
            } return true;
    }
}
 */

//  //lc submission using count array
//  public boolean isAnagram(String str1, String str2) {

//     // Convert both to lowercase to ignore case match
//     str1 = str1.toLowerCase();
//     str2 = str2.toLowerCase();

//     // Strip of all the white spaces
//     str1 = str1.replace(" ", "");
//     str2 = str2.replace(" ", "");

//     // Initialize the bucket array
//     int[] counts = new int[26];

//     // Fill the buckets
//     for (int i = 0; i < str1.length(); i++) {
//       counts[str1.charAt(i) - 'a']++;
//     }

//     // Empty the buckets
//     for (int i = 0; i < str2.length(); i++) {
//       counts[str2.charAt(i) - 'a']--;
//     }

//     // Check if all buckets are empty
//     for (int count : counts) {
//       if (count != 0)
//         return false;
//     }

//     return true;
//   }

// // More optimized array soln
// public boolean isAnagram(String str1, String str2) {
//     int n=str1.length();
//     if(str2.length()!=n) return false;
// // Convert both to lowercase to ignore case match
// str1 = str1.toLowerCase();
// str2 = str2.toLowerCase();

// // Strip of all the white spaces
// str1 = str1.replace(" ", "");
// str2 = str2.replace(" ", "");

// // Initialize the bucket array
// int[] counts = new int[26];

// // Fill the buckets
// for (int i = 0; i < str1.length(); i++) {
//   counts[str1.charAt(i) - 'a']++;
//   counts[str2.charAt(i) - 'a']--;
// }


// // Check if all buckets are empty
// for (int count : counts) {
//   if (count != 0)
//     return false;
// }

// return true;
// }