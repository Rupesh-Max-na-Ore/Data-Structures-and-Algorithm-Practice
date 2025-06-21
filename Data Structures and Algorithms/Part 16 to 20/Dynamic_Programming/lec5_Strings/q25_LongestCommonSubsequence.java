package Dynamic_Programming.lec5_Strings;
/*1143. Longest Common Subsequence
Medium
Topics
Companies
Hint
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.3M
Submissions
2.2M
Acceptance Rate
57.8% */
public class q25_LongestCommonSubsequence {
    //! array optimization
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
    
    public int longestCommonSubsequence_(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] curr = new int[n + 1];
    
        for (int i = 1; i <= m; i++) {
            int p2 = 0; //or curr[0];// This represents curr[j-1] from the previous row (diagonal value)
            for (int j = 1; j <= n; j++) {
                int p1 = curr[j]; // Save the current value of curr[j] to update p2 after the loop
    
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + p2; // Use p2 (diagonal) for match case
                } else {
                    curr[j] = Math.max(curr[j], curr[j - 1]); // Max of left (curr[j-1]) and top (curr[j])
                }
    
                // Update p2 to be the value of curr[j] for use in the next iteration of j
                p2 = p1;
            }
        }
    
        return curr[n]; // The length of the longest common subsequence
        }
    

    // public int longestCommonSubsequence(String s1, String s2) {
    //     int m=s1.length();
    //     int n=s2.length();
    //     int []curr=new int[n+1];
    //     int p1=0,p2=0;
    //     for(int i=1;i<=m;i++){
    //         p1=curr[1]; p2=curr[0];
    //         for(int j=1;j<=n;j++){
    //             if(s1.charAt(i-1)==s2.charAt(j-1)) curr[j]=1+p2;
    //             else{
    //                 int take1=p1;
    //                 int take2=p2;
    //                 curr[j]=Math.max(take1, take2);
    //             }
    //             p1=curr[j]; p2=curr[j-1];
    //         } 
    //     } return curr[n];
    // }


    // public int longestCommonSubsequence(String s1, String s2) {
    //     int m=s1.length();
    //     int n=s2.length();
    //     int []curr=new int[n+1];
    //     int p1=0,p2=0;
    //     for(int i=1;i<=m;i++){
    //         for(int j=1;j<=n;j++){
    //             //int prev1=curr[j],prev2=curr[j-1];
    //             //Wrong
    //             //if(s1.charAt(i-1)==s2.charAt(j-1)) curr[j]=1+curr[j];//or 1+p1;
    //             if(s1.charAt(i-1)==s2.charAt(j-1)) curr[j]=1+p2;//
    //             else{
    //                 int take1=p1;
    //                 int take2=p2;
    //                 curr[j]=Math.max(take1, take2);
    //             }
    //             // p1=prev1;
    //             // p2=prev2;
    //             p1=curr[j];
    //             p2=curr[j-1];
    //         } 
    //     } return curr[n];
    // }
}
