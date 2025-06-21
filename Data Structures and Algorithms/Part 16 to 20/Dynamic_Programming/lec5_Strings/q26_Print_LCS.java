package Dynamic_Programming.lec5_Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* Print all LCS sequences
Difficulty: HardAccuracy: 30.64%Submissions: 41K+Points: 8
You are given two strings s and t. Now your task is to print all longest common sub-sequences in lexicographical order.

Note -  A Sub-sequence is derived from another string by deleting some or none of the elements without changing the order of the remaining elements.

Example 1:

Input: s = abaaa, t = baabaca
Output: aaaa abaa baaa
Explanation - Length of lcs is 4, in lexicographical order they are aaaa, abaa, baaa

Example 2:

Input: s = aaa, t = a
Output: a
Your Task:
You do not need to read or print anything. Your task is to complete the function all_longest_common_subsequences() which takes strings s and t as first and second parameters respectively and returns a list of strings which contains all possible longest common subsequences in lexicographical order.
 

Expected Time Complexity: O(n3)
Expected Space Complexity: O(k * n) where k is a constant less than n.
 

Constraints:
1 ≤ Length of both strings ≤ 50*/
public class q26_Print_LCS {
    //Memoization
    public List<String> all_longest_common_subsequences(String s, String t) {
        int m = s.length();
        int n = t.length();

        // Step 1: Create a DP table to store lengths of LCS
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Use backtracking with memoization to find all LCSs
        Map<String, Set<String>> memo = new HashMap<>();
        Set<String> lcsSet = backtrack(s, t, m, n, dp, memo);

        // Convert the set to a list and return
        List<String> al =  new ArrayList<>(lcsSet);
        // QUestion asks for sorted list
        Collections.sort(al);
        return al;
    }
    

    private Set<String> backtrack(String s, String t, int i, int j, int[][] dp, Map<String, Set<String>> memo) {
        // Base case: if we've reached the top or left edge of the matrix
        if (i == 0 || j == 0) {
            Set<String> base = new HashSet<>();
            base.add("");
            return base;
        }

        // Check if this state has already been computed
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        Set<String> result = new HashSet<>();

        // If characters match, include this character in the path
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            Set<String> prevSet = backtrack(s, t, i - 1, j - 1, dp, memo);
            for (String seq : prevSet) {
                result.add(seq + s.charAt(i - 1));
            }
        } else {
            // Explore paths where the LCS length stays the same
            if (dp[i - 1][j] == dp[i][j]) {
                result.addAll(backtrack(s, t, i - 1, j, dp, memo));
            }
            if (dp[i][j - 1] == dp[i][j]) {
                result.addAll(backtrack(s, t, i, j - 1, dp, memo));
            }
        }

        // Memoize the result for this state
        memo.put(key, result);
        return result;
    }
    // Pure Recursion
    // public List<String> all_longest_common_subsequences(String s, String t) {
    //     int m = s.length();
    //     int n = t.length();

    //     // Step 1: Create a DP table to store lengths of LCS
    //     int[][] dp = new int[m + 1][n + 1];

    //     // Fill the DP table
    //     for (int i = 1; i <= m; i++) {
    //         for (int j = 1; j <= n; j++) {
    //             if (s.charAt(i - 1) == t.charAt(j - 1)) {
    //                 dp[i][j] = 1 + dp[i - 1][j - 1];
    //             } else {
    //                 dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
    //             }
    //         }
    //     }

    //     // Step 2: Use backtracking to find all LCSs
    //     Set<String> lcsSet = new HashSet<>(); // To store unique LCSs
    //     backtrack(s, t, m, n, dp, new StringBuilder(), lcsSet);

    //     // Convert the set to a list and return
    //     List<String> al =  new ArrayList<>(lcsSet);
    //     // QUestion asks for sorted list
    //     Collections.sort(al);
    //     return al;
    // }

    // private void backtrack(String s, String t, int i, int j, int[][] dp, StringBuilder path, Set<String> lcsSet) {
    //     // Base case: if we've reached the top or left edge of the matrix
    //     if (i == 0 || j == 0) {
    //         // Store the LCS found (reverse the path to correct order)
    //         lcsSet.add(path.reverse().toString());
    //         path.reverse(); // Restore original order for backtracking
    //         return;
    //     }

    //     // If characters match, include this character in the path
    //     if (s.charAt(i - 1) == t.charAt(j - 1)) {
    //         path.append(s.charAt(i - 1));
    //         backtrack(s, t, i - 1, j - 1, dp, path, lcsSet);
    //         path.deleteCharAt(path.length() - 1); // Remove last character for next paths
    //     } else {
    //         // Explore both possible branches where the LCS length stays the same
    //         if (dp[i - 1][j] == dp[i][j]) {
    //             backtrack(s, t, i - 1, j, dp, path, lcsSet);
    //         }
    //         if (dp[i][j - 1] == dp[i][j]) {
    //             backtrack(s, t, i, j - 1, dp, path, lcsSet);
    //         }
    //     }
    // }

    // Illustrative test cases
    public static void main(String[] args) {
        q26_Print_LCS lcsFinder = new q26_Print_LCS();

        // Test Case 1
        String s1 = "abcde";
        String t1 = "ace";
        System.out.println("All LCS of '" + s1 + "' and '" + t1 + "':");
        System.out.println(lcsFinder.all_longest_common_subsequences(s1, t1));

        // Test Case 2
        String s2 = "abc";
        String t2 = "abc";
        System.out.println("All LCS of '" + s2 + "' and '" + t2 + "':");
        System.out.println(lcsFinder.all_longest_common_subsequences(s2, t2));

        // Test Case 3
        String s3 = "abc";
        String t3 = "def";
        System.out.println("All LCS of '" + s3 + "' and '" + t3 + "':");
        System.out.println(lcsFinder.all_longest_common_subsequences(s3, t3)); // Expected: []

        // Test Case 4
        String s4 = "aab";
        String t4 = "azb";
        System.out.println("All LCS of '" + s4 + "' and '" + t4 + "':");
        System.out.println(lcsFinder.all_longest_common_subsequences(s4, t4));
    }
}
