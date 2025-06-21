package Strings_Basic_and_Medium.Medium_String_Problems;
/*
 * Q5
 * Count number of substrings
MediumAccuracy: 20.46%Submissions: 90K+Points: 4
Get Internship at GfG by submitting your Entries in: Data Science Blogathon

banner
Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct) that have exactly k distinct characters. 

Example 1:

Input:
S = "aba", K = 2
Output:
3
Explanation:
The substrings are: "ab", "ba" and "aba".
Example 2:

Input: 
S = "abaaca", K = 1
Output:
7
Explanation:
The substrings are: "a", "b", "a", "aa", "a", "c", "a". 
Your Task:
You don't need to read input or print anything. Your task is to complete the function substrCount() which takes the string S and an integer K as inputs and returns the number of substrings having exactly K distinct characters.

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ |S| ≤ 106
1 ≤ K ≤ 26


 */
import java.util.HashMap;

public class CountSubstringWithKUniqueChars {
    public long substrCount(String s, int k) {
        if (k == 0) return 0;
        if(k>s.length()) return 0;
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
        //return ExactKDistinct(s, k);
    }
    // // Not work for some repeat cases, will figure later
    // private long ExactKDistinct(String s, int k) {
    //     if (k == 0) return 0;
    //     if(k>s.length()) return 0;
    //     HashMap<Character, Integer> freq = new HashMap<>();
    //     int start = 0;
    //     long count = 0;
    //     long cnt=0;
    //     for (int end = 0; end < s.length(); end++) {
    //         char ch = s.charAt(end);
    //         freq.put(ch, freq.getOrDefault(ch, 0) + 1);
    //         if(freq.size() > k)
    //         {while (freq.size() > k) {
    //             char startChar = s.charAt(start);
    //             freq.put(startChar, freq.get(startChar) - 1);
    //             if (freq.get(startChar) == 0) {
    //                 freq.remove(startChar);
    //             } else if(freq.get(startChar) >0 && freq.size() > k) cnt++;
    //             start++;
    //             //if(freq.size() == k) cnt++;
    //         }}
    //         if(freq.size() == k) cnt++;
    //         //count += end - start + 1;
    //     }

    //     while(start<s.length()){
    //         if(freq.size() >= k)
    //         {
    //             while (freq.size() >= k) {
    //                 char startChar = s.charAt(start);
    //                 freq.put(startChar, freq.get(startChar) - 1);
    //                 if (freq.get(startChar) == 0) {
    //                     freq.remove(startChar);
    //                 }
    //                 start++;
    //             if(freq.size() == k) cnt++;
    //             }
                
    //         } else start++;
    //     }
    //     //return count;
    //     return cnt;
    // }


    private long atMostKDistinct(String s, int k) {
        if (k == 0) return 0;
        if(k>s.length()) return 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        int start = 0;
        long count = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            
            while (freq.size() > k) {
                char startChar = s.charAt(start);
                freq.put(startChar, freq.get(startChar) - 1);
                if (freq.get(startChar) == 0) {
                    freq.remove(startChar);
                }
                start++;
            }
            count += end - start + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        CountSubstringWithKUniqueChars obj = new CountSubstringWithKUniqueChars();
        // Test cases
        String s1 = "aba";
        int k1 = 2;
        System.out.println("Count of substrings with " + k1 + " distinct characters: " + obj.substrCount(s1, k1)); // Output: 3

        String s2 = "abaaca";
        int k2 = 1;
        System.out.println("Count of substrings with " + k2 + " distinct characters: " + obj.substrCount(s2, k2)); // Output: 7

        String s3 = "abcabdabbcfa";
        int k3 = 2;
        System.out.println("Count of substrings with " + k3 + " distinct characters: " + obj.substrCount(s3, k3)); // Output: 12
    }
    // Brute way
    // long substrCount (String s, int k) {
    //     long cnt=0;
    //     int n=s.length();
    //     for(int i=0;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             String substr=s.substring(i, j+1);
    //             int cntUni=CountUniqueChars(substr);
    //             if(cntUni==k) cnt++;
    //         }
    //     } return cnt;
    // }

    // private int CountUniqueChars(String s) {
    //     HashMap <Character,Integer> freq=new HashMap<>();
    //     int unique=0;
    //     for (char ch: s.toCharArray()){
    //         if(freq.containsKey(ch)) freq.put(ch, freq.get(ch)+1);
    //         else {
    //             freq.put(ch,1);
    //             unique++;
    //         }
    //     } return unique;
    // }
}

// // Array soln, only soln that gfg would accept, code 360 accepts both tho
// class Solution
// {
//     public long substrCount(String s, int k) {
//         if (k == 0) return 0;
//         if(k>s.length()) return 0;
//         //return countSubstringsWithAtMostKDistinctChars(s, k);
//         return countSubstringsWithAtMostKDistinctChars(s, k) - countSubstringsWithAtMostKDistinctChars(s, k - 1);
//     }

//     private long countSubstringsWithAtMostKDistinctChars(String s, int k) {
//         if (k == 0) return 0;
//         if(k>s.length()) return 0;
//         int i = 0, j = 0, currCount = 0;
// 		int result = 0;

// 		// Array to store count of characters.
// 		int[] count = new int[26];

// 		while (j < s.length()) {
// 			// Index for current character.
// 			int index = s.charAt(j) - 'a';

// 			// Increment count for the current character.
// 			count[index]++;

// 			if (count[index] == 1) {
// 				currCount++;
// 			}

// 			// Decrement count and increase ith pointer.
// 			while (currCount > k) {
// 				count[s.charAt(i) - 'a']--;
// 				if (count[s.charAt(i) - 'a'] == 0) {
// 					currCount--;
// 				}

// 				i++;
// 			}

// 			// Total substrings.
// 			result += (j - i + 1);
// 			j++;
// 		}
// 		return result;
//     }
// }

// // FInal GFG submission, array based, works, best soln.
// public class CountSubstringWithKUniqueChars {
//     public long substrCount(String s, int k) {
//         if (k == 0) return 0;
//         if(k>s.length()) return 0;
//         return countSubstringsWithAtMostKDistinctChars(s, k) - countSubstringsWithAtMostKDistinctChars(s, k - 1);
//     }

//     private long countSubstringsWithAtMostKDistinctChars(String s, int k) {
//         if (k == 0) return 0;
//         if(k>s.length()) return 0;
//         int[] freq = new int[26]; // Array to store frequency of characters
//         int start = 0;
//         long count = 0;
//         int uniqueCount = 0;

//         for (int end = 0; end < s.length(); end++) {
//             char ch = s.charAt(end);
//             if (freq[ch - 'a'] == 0) uniqueCount++; // New character added to window
//             freq[ch - 'a']++;

//             while (uniqueCount > k) {
//                 char startChar = s.charAt(start);
//                 freq[startChar - 'a']--;
//                 if (freq[startChar - 'a'] == 0) uniqueCount--; // Character removed from window
//                 start++;
//             }
//             count += end - start + 1;
//         }
//         return count;
//     }

//     public static void main(String[] args) {
//         CountSubstringWithKUniqueChars obj = new CountSubstringWithKUniqueChars();
//         // Test cases
//         String s1 = "aba";
//         int k1 = 2;
//         System.out.println("Count of substrings with " + k1 + " distinct characters: " + obj.substrCount(s1, k1)); // Output: 3

//         String s2 = "abaaca";
//         int k2 = 1;
//         System.out.println("Count of substrings with " + k2 + " distinct characters: " + obj.substrCount(s2, k2)); // Output: 7

//         String s3 = "abcabdabbcfa";
//         int k3 = 2;
//         System.out.println("Count of substrings with " + k3 + " distinct characters: " + obj.substrCount(s3, k3)); // Output: 16
//     }
// }
