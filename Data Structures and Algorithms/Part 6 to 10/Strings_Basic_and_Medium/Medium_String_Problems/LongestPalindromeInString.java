package Strings_Basic_and_Medium.Medium_String_Problems;
/*
 * Q6
 * 5. Longest Palindromic Substring
Solved
Medium
Topics
Companies
Hint
Given a string s, return the longest 
palindromic
 
substring
 in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
3.1M
Submissions
9.1M
Acceptance Rate
33.9%
 */
public class LongestPalindromeInString {
    public String longestPalindrome(String s) {
        int n= s.length();
        if (n <= 1) {
            return s;
        }

        String maxStr = s.substring(0, 1);
        int maxLen=1;
        for (int i = 0; i < n - 1; i++) {
            // early exit, maxLen reach peak here if left ptr already above n/2 when maxLen> n/2
            // cuz after this whatever Pal substring we get, 
            // its len is at max n/2-1 (==(n/4)*2-1 for even pals in best(max) case)
            if (maxLen > n/2 && i>n/2) return maxStr; 
            // keep track of potential odd and even pals simultaneously
            String odd = expandFromCenter(s, n, i, i); int oddLen=odd.length();
            String even = expandFromCenter(s, n, i, i + 1); int evenLen=even.length();
            // // early exit, maxLen reach peak here if left ptr already above n/2 when maxLen> n/2
            // if (maxLen > n/2 && i>n/2) return maxStr; 
            
            if (oddLen > maxLen) {
                maxStr = odd;
                maxLen = oddLen;
            }
            if (evenLen > maxLen) {
                maxStr = even;
                maxLen = evenLen;
            }
        }

        return maxStr;
    }

    private String expandFromCenter(String s, int n, int l, int r) {
        while ((l >= 0) && (r < n) && (s.charAt(l) == s.charAt(r))) {
            l--;
            r++;
        }
        return s.substring(l + 1, r); // because after the loop ends, l and r are one step beyond the actual palindrome bounds.
    }

    public static void main(String[] args) {
        LongestPalindromeInString obj = new LongestPalindromeInString();

        // Test cases
        String s1 = "babad";
        System.out.println("Longest Palindromic Substring in " + s1 + ": " + obj.longestPalindrome(s1)); // Output: "bab" or "aba"

        String s2 = "cbbd";
        System.out.println("Longest Palindromic Substring in " + s2 + ": " + obj.longestPalindrome(s2)); // Output: "bb"

        String s3 = "a";
        System.out.println("Longest Palindromic Substring in " + s3 + ": " + obj.longestPalindrome(s3)); // Output: "a"

        String s4 = "ac";
        System.out.println("Longest Palindromic Substring in " + s4 + ": " + obj.longestPalindrome(s4)); // Output: "a" or "c"
    }
}
