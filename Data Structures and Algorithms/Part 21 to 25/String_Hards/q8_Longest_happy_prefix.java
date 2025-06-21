/*
Code
Testcase
Test Result
Test Result
1392. Longest Happy Prefix
Hard
Topics
Companies
Hint
A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).

Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.

 

Example 1:

Input: s = "level"
Output: "l"
Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".
Example 2:

Input: s = "ababab"
Output: "abab"
Explanation: "abab" is the largest prefix which is also suffix. They can overlap in the original string.
 

Constraints:

1 <= s.length <= 105
s contains only lowercase English letters.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
66.1K
Submissions
135.5K
Acceptance Rate
48.8%
Topics
String
Rolling Hash
String Matching
Hash Function
Companies
Hint 1
Use Longest Prefix Suffix (KMP-table) or String Hashing.
Similar Questions
Sum of Scores of Built Strings
Hard
Maximum Deletions on a String
Hard
Minimum Time to Revert Word to Initial State II
Hard
Minimum Time to Revert Word to Initial State I
Medium*/

public class q8_Longest_happy_prefix {

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
                    len = lps[len-1];
                }else{
                    lps[j]=0;
                    j++;
                }
            }
        } return lps;
    }

    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = get_lps(s, n);
        return s.substring(0,lps[n-1]);    
    }
}
// KMP-Based Approach
class SolutionKMP {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        return s.substring(0, pi[n - 1]);
    }
}

// Rolling Hash Approach
class SolutionRollingHash {
    public String longestPrefix(String s) {
        int n = s.length();
        int P = 31;
        int MOD = 1000000007;
        long[] p_pow = new long[n];
        long[] h = new long[n + 1];
        p_pow[0] = 1;

        for (int i = 1; i < n; i++) {
            p_pow[i] = (p_pow[i - 1] * P) % MOD;
        }

        for (int i = 0; i < n; i++) {
            h[i + 1] = (h[i] + (s.charAt(i) - 'a' + 1) * p_pow[i]) % MOD;
        }

        int max_p = 0;
        for (int i = 0; i < n - 1; i++) {
            long suffix_hash = (h[n] - h[n - i - 1] + MOD) % MOD;
            long prefix_hash = (h[i + 1] * p_pow[n - i - 1]) % MOD;
            if (prefix_hash == suffix_hash) {
                max_p = i + 1;
            }
        }

        return s.substring(0, max_p);
    }
}

// Z-Algorithm Approach
class SolutionZAlgo {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }

            if (i + z[i] == n) {
                //This condition checks whether:
                //The substring starting at index i and of length z[i] reaches the end of the string s.
                //i + z[i] == n  ⟺  substring s[i:] is of length z[i]  ⟺  it reaches the end of s
                //Since z[i] is a match of the prefix at position i, this means that:
                //The prefix of length z[i] is also a suffix of the string s starting at position i.
                return s.substring(i, i + z[i]);
                //==
                //return s.substring(0, z[i]);
            }
        }

        return "";
    }
}

/*https://leetcode.com/problems/longest-happy-prefix/solutions/4763728/python3-kmp-z-z-rabin-karp-rolling-hash-simple-solution
 * [Python3] KMP -> Z -> Z Rabin-Karp (Rolling Hash) - Simple Solution

Chau Long
Apr LeetCoding Challenge
704
Feb 21, 2024
String
Rolling Hash
String Matching
Hash Function

1+
Intuition
Approach
Code
1. KMP
class Solution:
    def longestPrefix(self, s: str) -> str:
        n = len(s)
        pi = [0 for _ in range(n)]
        for i in range(1, n):
            j = pi[i - 1]
            while j > 0 and s[i] != s[j]: j = pi[j - 1]
            if s[i] == s[j]: j += 1
            pi[i] = j
        
        return s[:pi[-1]]
Time complexity: O(N)
Space complexity: O(N)
2. Rolling Hash
class Solution:
    def longestPrefix(self, s: str) -> str:
        n = len(s)
        P, MOD = 31, 10**9 + 7
        p_pow = [1 for _ in range(n)]
        for i in range(1, n):
            p_pow[i] = (p_pow[i - 1] * P) % MOD
        
        h = [0 for _ in range(n + 1)]
        for i in range(n):
            h[i + 1] = (h[i] + (ord(s[i]) - ord("a") + 1) * p_pow[i]) % MOD

        max_p = 0
        for i in range(n - 1):
            suffix_h = (h[n] - h[n - i - 1] + MOD) % MOD
            if h[i + 1] * p_pow[n - i - 1] % MOD == suffix_h : max_p = i + 1

        return s[:max_p]
Time complexity: O(N)
Space complexity: O(N)
3. Z-Function
class Solution:
    def longestPrefix(self, s: str) -> str:
        n = len(s)
        z = [0 for _ in range(n)]
        l = r = 0
        for i in range(1, n):
            if i <= r: z[i] = min(r - i + 1, z[i - l])
            while i + z[i] < n and s[i + z[i]] == s[z[i]]: z[i] += 1
            if r < z[i] + i - 1: l, r = i, z[i] + i - 1
            if i + z[i] == n: return s[i: i + z[i]]
        return ""
Time complexity: O(N)
Space complexity: O(N)
 */