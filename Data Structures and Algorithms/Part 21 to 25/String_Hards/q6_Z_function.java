//package String_Hards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q6_Z_function{
    static int [] z_val(String s){
        int n = s.length();
        int [] z = new int[n];
        int left=0,right=0;
        char [] str = s.toCharArray();
        for(int i = 1; i < n; i++){
            if(i<=right){
                //activation boost
                z[i] = Math.min(right-i+1, z[i-left]);
            }

            while(i+z[i]<n && str[z[i]]==str[i+z[i]]){ 
                z[i]++;
            }

            if(i+z[i]-1 > right){
                left = i;
                right = i + z[i] -1;
            }
        }
        System.out.println("z = " + Arrays.toString(z));
        return z;
    }


    public static void main(String[] args) {
        String pattern = "ABCDABD";  // Try variations: "ABCDABC", "ABAB", "ANPANMAN"
        find_all_occurences_(pattern,pattern);
    }


    static List<Integer> find_all_occurences(String txt, String pat){
        List<Integer> found_at = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();
        StringBuilder new_s = new StringBuilder();
        new_s.append(pat);
        new_s.append("#");
        new_s.append(txt);
        int[] z = z_val(new_s.toString());
        for(int i = m+1; i < m + n; i++){
            if(z[i]==m) found_at.add(i - m - 1);
        }
        return found_at;
    }

    static void find_all_occurences_(String txt, String pat){
        List<Integer> found_at = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();
        StringBuilder new_s = new StringBuilder();
        new_s.append(pat);
        new_s.append("#");
        new_s.append(txt);
        int[] z = z_val(new_s.toString());
        for(int i = m+1; i < m + n; i++){
            if(z[i]==m) found_at.add(i - m - 1);
        }
        System.out.println("found_at = " + Arrays.toString(found_at.toArray()));
        //return found_at;
    }
}

////https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/solutions/6617473/optimal-kmp-rabin-karp-z-algorithm-solutions-with-detailed-inline-comments-and-break-down/
// Optimal KMP, Rabin Karp & Z-Algorithm Solutions with detailed inline comments and break down

// Kandan
// 100 Days Badge 2025
// 711
// Apr 05, 2025
// Two Pointers
// String
// String Matching
// Java
// Approach
// KMP Solution
// Rabin Karp Solution
// Z Algorithm Solution
// Links to useful youtube explanations:

// KMP -Abdul Bari
// Rabin Karp - Abdul Bari
// Z Algorithm - Tushar Roy
// Time complexity:
// KMP - O(haystack_length+needle_length)

// Rabin Karp

// Average: O(haystack_length+needle_length)
// Worst Case: O(haystack_length∗needle_length)
// Z Algorithm - O(haystack_length+needle_length)

// Space complexity:
// KMP - O(needle_length)
// Rabin Karp - O(1)
// Z Algorithm - O(haystack_length+needle_length)
// When to use what?
// KMP: Guaranteed worst-case linear time, best for single pattern in large text.
// Z - algorithm: Multiple pattern matches, faster to implement, works well for short patterns
// Rabin Karp: Multiple pattern matches, especially long patterns, needs low memory
// Real-World Examples
// KMP: Text editors compilers, IDS, log scanners, DNA search

// Rabin-Karp: Plagiarism check, search engines, forensics, anti-virus, blockchain

// Z-Algorithm: Autocomplete, plagiarism detection, compression, spell check

// Code
// class Solution {

//     // Method 1: KMP-based implementation
//     public int strStrKMP(String haystack, String needle) {
//         int n = haystack.length();
//         int m = needle.length();

//         if (n < m)
//             return -1;

//         // Preprocess the needle to get LPS array
//         int[] LPS = preprocess(needle);

//         return KMP(haystack, needle, LPS);
//     }

//     // KMP search: uses the LPS array to avoid rechecking characters
//     private int KMP(String str, String pattern, int[] LPS) {
//         int sptr = 0; // Pointer in haystack
//         int pptr = 0; // Pointer in pattern
//         int n = str.length(), m = pattern.length();

//         while (sptr < n) {
//             if (str.charAt(sptr) == pattern.charAt(pptr)) {
//                 // Characters match; move both pointers
//                 sptr++;
//                 pptr++;

//                 // Full pattern matched
//                 if (pptr == m)
//                     return sptr - m;
//             } else {
//                 // Mismatch
//                 if (pptr == 0) {
//                     // Start from next char in haystack
//                     sptr++;
//                 } else {
//                     // Jump to the last known good prefix
//                     pptr = LPS[pptr - 1];
//                 }
//             }
//         }

//         return -1;
//     }

//     // Preprocess the pattern to build the LPS (Longest Prefix Suffix) array
//     private int[] preprocess(String pattern) {
//         int len = pattern.length();
//         int[] LPS = new int[len];
//         int prev = 0; // Length of previous longest prefix suffix
//         int i = 1;

//         LPS[0] = 0; // First char has no proper prefix/suffix

//         while (i < len) {
//             if (pattern.charAt(i) == pattern.charAt(prev)) {
//                 // If match, extend the prefix
//                 prev++;
//                 LPS[i] = prev;
//                 i++;
//             } else {
//                 if (prev == 0) {
//                     // No match and no prefix to fallback to
//                     LPS[i] = 0;
//                     i++;
//                 } else {
//                     // Fallback to previous LPS
//                     prev = LPS[prev - 1];
//                 }
//             }
//         }

//         return LPS;
//     }

//     // Method 2: Rabin-Karp based implementation
//     public int strStrRabinKarp(String haystack, String needle) {
//         if (needle.length() > haystack.length())
//             return -1;
//         return rabinKarp(haystack, needle);
//     }

//     // Rabin-Karp algorithm for substring search using rolling hash
//     private int rabinKarp(String text, String pattern) {
//         int BASE = 31; // A prime base for polynomial rolling hash
//         int MOD = (int) 1e9 + 7; // A large prime modulus to avoid collisions
//         long power = 1;

//         int n = text.length(), m = pattern.length();
//         long textHash = 0, patternHash = 0;

//         // Compute the initial hash of the pattern and the first window of text
//         for (int i = 0; i < m; i++) {
//             patternHash = (patternHash * BASE + pattern.charAt(i)) % MOD;
//             textHash = (textHash * BASE + text.charAt(i)) % MOD;
//             if (i > 0)
//                 power = (power * BASE) % MOD; // power = BASE^(m-1)
//         }

//         // Early check for the first window
//         if (textHash == patternHash && text.substring(0, m).equals(pattern))
//             return 0;

//         // Rolling hash: slide the window one character at a time
//         for (int i = m; i < n; i++) {
//             // Remove leading char from hash
//             textHash = (textHash - text.charAt(i - m) * power % MOD + MOD) % MOD;

//             // Add trailing char to hash
//             textHash = (textHash * BASE + text.charAt(i)) % MOD;

//             // Check if hashes match and then confirm with string comparison to avoid false positives
//             if (patternHash == textHash && text.substring(i - m + 1, i + 1).equals(pattern)) {
//                 return i - m + 1;
//             }
//         }
//         return -1;
//     }

//     // Method 3: Z-Algorithm based implementation
//     public int strStrZAlgorithm(String haystack, String needle) {
//         // Combine needle + '#' + haystack to form the Z-string
//         StringBuilder newStr = new StringBuilder(needle).append("#");
//         newStr.append(haystack);

//         // Calculate Z array for the combined string
//         int[] Z = calculateZ(newStr);

//         // Scan Z array to find index where pattern length matches
//         for (int i = 0; i < Z.length; i++) {
//             if (Z[i] == needle.length()) {
//                 // i - needle.length() - 1 skips over the needle + '#' prefix
//                 return i - needle.length() - 1;
//             }
//         }
//         return -1;
//     }

//     // Helper method to compute the Z-array
//     private int[] calculateZ(StringBuilder zString) {
//         int n = zString.length();
//         int[] Z = new int[n];
//         int left = 0, right = 0;

//         for (int k = 1; k < n; k++) {
//             if (k > right) {
//                 // Outside the current Z-box; start fresh
//                 left = right = k;

//                 // Extend the Z-box while characters match
//                 while (right < n && zString.charAt(right) == zString.charAt(right - left)) {
//                     right++;
//                 }

//                 Z[k] = right - left;
//                 right--;
//             } else {
//                 // Inside the current Z-box
//                 int k1 = k - left;

//                 // If value doesn't stretch past right boundary, copy it
//                 if (k + Z[k1] <= right) {
//                     Z[k] = Z[k1];
//                 } else {
//                     // Otherwise, start matching from current right
//                     left = k;
//                     while (right < n && zString.charAt(right) == zString.charAt(right - left)) {
//                         right++;
//                     }

//                     Z[k] = right - left;
//                     right--;
//                 }
//             }
//         }
//         return Z;
//     }

   
// }
// If you have made it this far, please consider upvoting this solution! Thank you! :)