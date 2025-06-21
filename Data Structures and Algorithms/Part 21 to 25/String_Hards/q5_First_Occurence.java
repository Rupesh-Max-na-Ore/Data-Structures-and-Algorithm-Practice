package String_Hards;

import java.util.ArrayList;
import java.util.List;

import lectures.08-arrays.code.src.com.kunal.Input;

/*28. Find the Index of the First Occurrence in a String
Solved
Easy
Topics
Companies
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
3.3M
Submissions
7.3M
Acceptance Rate
44.8%
Topics
Two Pointers
String
String Matching
Companies
Similar Questions
Shortest Palindrome
Hard
Repeated Substring Pattern
Easy */
public class q5_First_Occurence {
    //kmp
    int[] get_lps(String pattern, int m){
        int [] lps = new int[m];
        lps[0] = 0;
        int len=0;
        int j=1;
        while(j<m){
            if(pattern.charAt(j) == pattern.charAt(len)){
                len++;
                lps[j] = len;
                j++;
            }else{
                if(len > 0){
                    //len--; //wrong for below case
                    // Input
                    // haystack =
                    // "adcadcaddcadde"
                    // needle =
                    // "adcadde"
                    // Output
                    // 7
                    // Expected
                    // -1

                    len = lps[len-1];
                }else{
                    lps[j]=0;
                    j++;
                }
            }
        } return lps;
    }
    public int strStr(String haystack, String needle) {
        int n = haystack.length(); //txt
        int m = needle.length(); //pat
        //below 2 not reqd., but no harm
        if(m>n || m == 0) return -1;
        if(m==n){
            if(haystack.equals(needle)) return 0;
            else return -1;
        }
        int[]lps = get_lps(needle, m);
        int i = 0;//ptr for txt
        int j = 0;//ptr for pat
        while(i<n){
            if(haystack.charAt(i)==needle.charAt(j)){
                //match
                i++;
                j++;
                if (j == m) {
                //pat found
                return i-j;//or i - m
                }
            }
            else if(haystack.charAt(i)!=needle.charAt(j))){
                //not match
                if(j > 0) j = lps[j-1];
                else i++;
            }
        }
        return -1; //not found
    }

    //Best using Java API
    public int strStr_2(String haystack, String needle) {
        if(haystack.contains(needle)) return haystack.indexOf(needle);
        return -1;
    }

    //z-fn
    int [] z_val(String s){
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
        return z;
    }

    List<Integer> find_all_occurences(String txt, String pat){
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

    public int strStr_3(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        StringBuilder new_s = new StringBuilder();
        new_s.append(needle);
        new_s.append("#");
        new_s.append(haystack);
        int[] z = z_val(new_s.toString());
        for(int i = m+1; i < m + 1 + n; i++){
            if(z[i]==m) return (i - m - 1);
        }
        return -1;
        //return 111;
    }
}
// //Using Rabin Karp
// public class Solution {
//     private static final int d = 26;  // Base (alphabet size)
//     private static final int p = 5381;  // Large prime modulus

//     public int strStr(String haystack, String needle) {
//         if (needle.equals("")) return 0;
//         if (needle.length() > haystack.length()) return -1;
//         return search(needle, haystack);
//     }

//     private static int search(String pat, String txt) {
//         int m = pat.length();
//         int n = txt.length();
//         int patHash = 0, txtHash = 0;
//         int power = 1;

//         // Precompute power = d^(m-1) % p
//         for (int i = 1; i < m; i++) {
//             power = (power * d) % p;
//         }

//         // Compute initial hashes
//         for (int i = 0; i < m; i++) {
//             patHash = (patHash * d + (pat.charAt(i) - 'A' + 1)) % p;
//             txtHash = (txtHash * d + (txt.charAt(i) - 'A' + 1)) % p;
//         }

//         // Slide the window
//         for (int i = 0; i <= n - m; i++) {
//             if (patHash == txtHash) {
//                 if (txt.substring(i, i + m).equals(pat)) return i;
//             }
//             if (i < n - m) {
//                 txtHash = (txtHash - (txt.charAt(i) - 'A' + 1) * power) % p;
//                 if (txtHash < 0) txtHash += p;
//                 txtHash = (txtHash * d + (txt.charAt(i + m) - 'A' + 1)) % p;
//             }
//         }

//         return -1;
//     }
// }
// // sth wrong in below
// class Solution {
//     public int strStr(String haystack, String needle) {
//         if(needle.equals(haystack)) return 0;
//         return search(needle, haystack);
//     }
//     private static final int d = 26; // Base value of alphabets
//   private static final int p = 5381; // Large prime number

//   public static int search(String pat, String txt)
//   {
//     if(pat.length()>txt.length()) return -1;
//     int patHash = 0; // Hash value of pattern
//     int txtHash = 0; // Hash value of text

//     for (int i = 0; i < pat.length(); i++) // Generating Hash values for pattern and first window text
//     {
//       patHash = patHash * d;
//       txtHash = txtHash * d;
//         patHash = (patHash * d + (pat.charAt(i) - 'A' + 1)) % p;
//       txtHash = (txtHash + (txt.charAt(i) - 'A' + 1) )% p;
//     }

    
//     for (int i = 0; i <= txt.length() - pat.length(); i++) // Loop of text size minus  window
//     {
//       if (patHash == txtHash)
//       {
//         if(txt.substring(i, i+pat.length()).equals(pat)) return i;
//         else continue;
//       }

//       if (i < txt.length() - pat.length())
//       {
//         txtHash = txtHash - ((txt.charAt(i) - 'A' + 1) * (int)Math.pow(d, pat.length() - 1));  // Subtracting first element from current hash of d^window-1
//         if (txtHash < 0) txtHash += p;
//         txtHash = txtHash * d + (txt.charAt(i + pat.length()) - 'A' + 1);  // multiplying obtained hash with d to left shift the number and then adding the next new element
//       }
//     }
//     return -1;
//   }
// }

// //KMP REFERENCE SOLN.
// class Solution {

//     ArrayList<Integer> search(String pat, String txt) {
//         ArrayList<Integer> result = new ArrayList<>();
//         int N = txt.length();
//         int M = pat.length();

//         int[] lps = computeLPS(pat);

//         int i = 0; // Index for text
//         int j = 0; // Index for pattern

//         while (i < N) {
//             if (j < M && pat.charAt(j) == txt.charAt(i)) {
//                 i++;
//                 j++;
//             }

//             if (j == M) {
//                 result.add(i - j); // Pattern found at index i - j + 1 (IF 1-based indexing)
//                 j = lps[j - 1];
//             } else if (i < N && (j == 0 || pat.charAt(j) != txt.charAt(i))) {
//                 if (j != 0) {
//                     j = lps[j - 1];
//                 } else {
//                     i++;
//                 }
//             }
//         }

//         return result;
//     }

//     private int[] computeLPS(String pattern) {
//         int M = pattern.length();
//         int[] lps = new int[M];
//         int len = 0; // Length of the previous longest prefix suffix

//         lps[0] = 0; // Because there is no proper suffix and prefix of pattern[0..0]

//         int i = 1;
//         while (i < M) {
//             if (pattern.charAt(i) == pattern.charAt(len)) {
//                 len++;
//                 lps[i] = len;
//                 i++;
//             } else {
//                 if (len != 0) {
//                     len = lps[len - 1]; //You can also write, len = len-1;
//                 } else {
//                     lps[i] = 0;
//                     i++;
//                 }
//             }
//         }

//         return lps;
//     }
// }
/*We cannot use len--, we have to do len=lps[len-1].
The logic behind this is that let's say upto some
index i, len is 10, that means that prefix of length 10 characters is equal to the suffix (upto i) of 10 characters,
Now let's say at the index 9(i.e length 10) if the Ips[9] is let's say 3, that means that the prefix of the length 3 is equal to suffix of length 3 (upto index 9), which in turn would mean that those same three characters will be present in the suffix of length 10 (upto i) as the whole string of length 10 (from 0) is repeated at the end as the suffix till index i, this is the most important part of this logic (remember this)
With all this in mind if we want to find lps[i+1] and s[i+1]!=s[len], since we know that the last three characters(ie. i,j-1,i-2) are equal to the first three characters from O and also equal to the last three characters upto index 9 (from the above point marked as remember this), so if we check at index 3(i.e length 4) and it matches with s[i+1], we can have the lps[i+1]=4. This will be achieved if we set the len to lps[len-1], i.e set the length to the length of the longest prefix suffix pair, at the index len-1, then apply the basic idea of kmp.
Also with doing len--, with duplicates present
we can incorrectly match s[i]=s[len] at some higher len value, where prefix might not be equal to suffix. */
