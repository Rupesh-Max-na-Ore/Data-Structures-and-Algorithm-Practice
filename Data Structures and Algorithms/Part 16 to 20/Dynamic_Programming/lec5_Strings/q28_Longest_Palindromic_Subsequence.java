package Dynamic_Programming.lec5_Strings;

public class q28_Longest_Palindromic_Subsequence {
    public int longestPalindromeSubseq(String s) {
        return longestCommonSubsequence(s, new StringBuilder(s).reverse().toString());
    }

    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] curr = new int[n + 1];
    
        for (int i = 1; i <= m; i++) {
            int p2 = 0; int p1 = curr[1];
            for (int j = 1; j <= n; j++) {
    
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + p2; 
                } else {
                    curr[j] = Math.max(curr[j], curr[j - 1]); 
                }
                p2 = p1;
                p1=(j!=n)?curr[j+1]:p1;
            }
        }
        return curr[n]; 
    }
}
