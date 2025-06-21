
/*214. Shortest Palindrome
Hard
Topics
Companies
You are given a string s. You can convert s to a palindrome by adding characters in front of it.

Return the shortest palindrome you can find by performing this transformation.

 

Example 1:

Input: s = "aacecaaa"
Output: "aaacecaaa"
Example 2:

Input: s = "abcd"
Output: "dcbabcd"
 

Constraints:

0 <= s.length <= 5 * 104
s consists of lowercase English letters only.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
307.2K
Submissions
757.1K
Acceptance Rate
40.6%
Topics
String
Rolling Hash
String Matching
Hash Function
Companies
Similar Questions
Longest Palindromic Substring
Medium
Find the Index of the First Occurrence in a String
Easy
Palindrome Pairs
Hard
Maximum Deletions on a String
Hard
Smallest Palindromic Rearrangement I
Medium */
public class q7_Shortest_Palindrome {
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

    public String shortestPalindrome(String s) {
        int n = s.length(); //int tn = comb_s.length() == n+n+1
        String rev_s=new StringBuilder(s).reverse().toString();
        String comb_s = new StringBuilder(s+"#"+rev_s).reverse().toString();
        //String comb_s = new StringBuilder(rev_s+"#"+s).reverse().toString();//wrong, careful
        int[] lps = get_lps(comb_s, n+n+1);
        int longest_pal_part_len = lps[n+n+1-1];
        String culprit = rev_s.substring(0, n - longest_pal_part_len);
        return new StringBuilder(culprit+s).toString();
        //above 2 lines == below 2 lines in result
        // String extra = s.substring(longest_pal_part_len, n);
        // return new StringBuilder(rev_s+extra).toString();
    }

    //brute force
    public String shortestPalindrome_1(String s) {
        int n = s.length();
        String rev_s=new StringBuilder(s).reverse().toString();
        String culprit = "";
        for(int i =0 ;i< n; i++){
            if(s.substring(0, n-i).equals(rev_s.substring(i))) {
                culprit = rev_s.substring(0, i); 
                return new StringBuilder(culprit+s).toString();
            }
        }
        return new StringBuilder(rev_s+s).toString();
    }
}

// 1. Brute Force
class Solution1 {
    public String shortestPalindrome(String s) {
        String r = new StringBuilder(s).reverse().toString();
        for (int i = 0; i <= s.length(); i++) {
            if (s.substring(0, s.length() - i).equals(r.substring(i))) {
                return r.substring(0, i) + s;
            }
        }
        return "";
    }
}

// 2. Brute Force - More Pythonic Style
class Solution2 {
    public String shortestPalindrome(String s) {
        String r = new StringBuilder(s).reverse().toString();
        for (int i = 0; i <= s.length(); i++) {
            if (s.startsWith(r.substring(i))) {
                return r.substring(0, i) + s;
            }
        }
        return "";
    }
}

// 3. Another Brute Force, gives tle at 121/126 on lc
class Solution3 {
    public String shortestPalindrome(String s) {
        int maxPalPrefLen = 0;
        for (int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0, i + 1);
            String reversed = new StringBuilder(prefix).reverse().toString();
            if (prefix.equals(reversed)) {
                maxPalPrefLen = i + 1;
            }
        }
        return new StringBuilder(s.substring(maxPalPrefLen)).reverse().toString() + s;
    }
}

// 4. KMP
class Solution4 {
    public String shortestPalindrome(String s) {
        String r = new StringBuilder(s).reverse().toString();
        String ts = s + "#" + r;
        int[] pi = new int[ts.length()];
        for (int i = 1; i < ts.length(); i++) {
            int j = pi[i - 1];
            while (j > 0 && ts.charAt(i) != ts.charAt(j)) {
                j = pi[j - 1];
            }
            if (ts.charAt(i) == ts.charAt(j)) j++;
            pi[i] = j;
        }
        return r.substring(0, r.length() - pi[pi.length - 1]) + s;
    }
}

// 5. Rabin-Karp
class Solution5 {
    public String shortestPalindrome(String s) {
        int n = s.length();
        int P = 31;
        int MOD = 1_000_000_007;
        long h1 = 0, h2 = 0, POW = 1;
        int maxPalPrefLen = 0;
        for (int i = 0; i < n; i++) {
            int charVal = s.charAt(i) - 'a' + 1;
            h1 = (h1 * P + charVal) % MOD;
            h2 = (charVal * POW + h2) % MOD;
            if (h1 == h2) maxPalPrefLen = i + 1;
            POW = (POW * P) % MOD;
        }
        return new StringBuilder(s.substring(maxPalPrefLen)).reverse().toString() + s;
    }
}

// 6. Z-Algorithm
class Solution6 {
    public String shortestPalindrome(String s) {
        String rs = new StringBuilder(s).reverse().toString();
        String ts = s + "#" + rs;
        int n = ts.length();
        int[] z = new int[n];
        int l = 0, r = 0, maxLen = 0;

        for (int i = 1; i < n; i++) {
            if (i <= r) z[i] = Math.min(r - i + 1, z[i - l]);
            while (i + z[i] < n && ts.charAt(z[i]) == ts.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (z[i] == n - i) {
                //This condition checks whether:
                //The substring starting at index i and of length z[i] reaches the end of the string s.
                //i + z[i] == n  ⟺  substring s[i:] is of length z[i]  ⟺  it reaches the end of s
                //Since z[i] is a match of the prefix at position i, this means that:
                //The prefix of length z[i] is also a suffix of the string s starting at position i.
                maxLen = z[i];
                break;
            }
        }
        return new StringBuilder(s.substring(maxLen)).reverse().toString() + s;
        //==
        //return new StringBuilder(rs.substring(0, (n-1)/2 - maxLen)).toString() + s;
    }
}
/*Python3] Brute Force -> KMP -> Rabin Karp (Rolling Hash) -> Z-Algorithm - Simple Solutions

Chau Long
Apr LeetCoding Challenge
1632
Feb 22, 2024
String
Rolling Hash
String Matching
Hash Function

1+
Intuition
Approach
This problem is finding the longest panlindromic prefix of string s

Code
1. Brute Force
class Solution:
    def shortestPalindrome(self, s: str) -> str:
        r = s[::-1]
        for i in range(len(s) + 1):
            if s[:len(s)-i]==r[i:]:
                return r[:i] + s
Time complexity: O(N 
2
 )

Space complexity: O(N)

2. Brute Force in more Pythonic Way
class Solution:
    def shortestPalindrome(self, s: str) -> str:
        r = s[::-1]
        for i in range(len(s) + 1):
            if s.startswith(r[i:]):
                return r[:i] + s
Time complexity: O(N 
2
 )

Space complexity: O(N)

3. Another Brute Force
class Solution:
    def shortestPalindrome(self, s: str) -> str:
        n = len(s)
        max_pan_pref_len = 0
        for i in range(n):
            if s[:i + 1] == s[:i + 1][::-1]: max_pan_pref_len = i + 1
        
        return s[max_pan_pref_len:][::-1] + s
Time complexity: O(N 
2
 )

Space complexity: O(N)

4. KMP
We can see that in the brute force way, we need to find the longest prefix of s match with the suffix of r => it is KMP

class Solution:
    def shortestPalindrome(self, s: str) -> str:
        r = s[::-1]
        ts = s + "#" + r
        n = len(ts)
        pi = [0 for _ in range(n)]
        for i in range(1, n):
            j = pi[i - 1]
            while j > 0 and ts[i] != ts[j]: j = pi[j - 1]
            if ts[i] == ts[j]: j += 1
            pi[i] = j

        return r[: len(r) - pi[-1]] + s
Time complexity: O(N)

Space complexity: O(N)

5. Rabin-Karp (Rolling Hash)
class Solution:
    def shortestPalindrome(self, s: str) -> str:
        n = len(s)
        P, MOD, POW = 31, 10**9 + 7, 1
        h1 = h2 = max_pan_pref_len = 0
        for i in range(n):
            char_int = ord(s[i]) - ord("a") + 1
            h1 = (h1 * P + char_int) % MOD
            h2 = (char_int * POW + h2) % MOD
            if h1 == h2: max_pan_pref_len = i + 1
            POW = POW * P % MOD

        return s[max_pan_pref_len:][::-1] + s     
Time complexity: O(N)

Space complexity: O(N)

6. Z-Algorithm
class Solution:
    def shortestPalindrome(self, s: str) -> str:
        rs = s[::-1]
        ts = s + "#" + rs
        n = len(ts)
        z = [0 for _ in range(n)]
        l = r = max_len = 0
        for i in range(1, n):
            if i <= r: z[i] = min(r - i + 1, z[i - l])
            while i + z[i] < n and ts[z[i]] == ts[i + z[i]]: z[i] += 1
            if i + z[i] - 1 > r: l, r = i, i + z[i] - 1
        for i in range(n):
            if z[i] == n - i:
                max_len = z[i]
                break
        return s[::-1][:len(s) - max_len] + s
Time complexity: O(N)

Space complexity: O(N)
https://leetcode.com/problems/shortest-palindrome/solutions/4766688/python3-brute-force-kmp-rabin-karp-rolling-hash-z-algorithm-simple-solutions/
 */