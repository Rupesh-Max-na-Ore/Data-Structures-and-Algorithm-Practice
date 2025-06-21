package Two_Pointer_and_Sliding_Window.java.Lec2_HardQ;
/*Q4 727. Minimum Window Subsequence
Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.

If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.

Example 1:

Input:
S = "abcdebdde", T = "bde"
Output: "bcde"
Explanation:
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of T in the window must occur in order.
 

Note:

All the strings in the input will only contain lowercase letters.
The length of S will be in the range [1, 20000].
The length of T will be in the range [1, 100].
 

Difficulty:
Hard
Lock:
Prime
Company:
Amazon Bloomberg eBay Google Houzz Microsoft
Problem Solution
727-Minimum-Window-Subsequence */
//similar q at gfg - https://www.geeksforgeeks.org/problems/minimum-window-subsequence/0
public class Minimum_Window_Subsequence {
    public String minWindow(String str, String ttr){
        int n=str.length(), m=ttr.length(), sIndx=-1, eIndx=n;
        int minL=n, i=0,j=0;
        char[] s = str.toCharArray(), t=ttr.toCharArray();
        while(i<n){
            if(s[i]==t[j]){
                j++;
                if(j==m){
                    int end=i;//found valid window end
                    j--; //bring j back to last char of t
                    while(j>=0){
                        //backtrack to find start
                        if(s[i]==t[j])j--;
                        i--;
                    }
                    //bring i and j back to on boundary
                    j++;
                    i++;
                    int start=i;//found valid window start
                    int currL= end -start +1;
                    if(currL<minL){
                        minL=currL;
                        sIndx=start;
                        eIndx=end;
                    }
                }
            }
            ++i;
        }
        return (sIndx==-1)?"":str.substring(sIndx, eIndx+1);
    }
}
/*public class Minimum_Window_Subsequence {
    public String minWindow(String str, String ttr) {
        int n = str.length(), m = ttr.length();
        // Start and end indices of the minimum window
        int sIndex = -1, eIndex = n;
        // Minimum length of the window
        int minLength = n;
        // Pointers for traversing strings
        int i = 0, j = 0;
        // Convert strings to character arrays for easy access
        char[] s = str.toCharArray(), t = ttr.toCharArray();

        // Traverse the main string
        while (i < n) {
            // If characters match, move the pointer for the subsequence
            if (s[i] == t[j]) {
                j++;
                // If we have found the entire subsequence
                if (j == m) {
                    int end = i;
                    j--; // Bring j back to the last character of t
                    // Move backwards to find the start of the window
                    while (j >= 0) {
                        if (s[i] == t[j]) j--;
                        i--;
                    }
                    // Bring i and j back to the boundary
                    j++;
                    i++;
                    int start = i;
                    // Calculate the length of the current window
                    int currLength = end - start + 1;
                    // Update the minimum length and window indices if needed
                    if (currLength < minLength) {
                        minLength = currLength;
                        sIndex = start;
                        eIndex = end;
                    }
                }
            }
            // Move the main pointer forward
            ++i;
        }
        // Return the minimum window or an empty string if no valid window is found
        return (sIndex == -1) ? "" : str.substring(sIndex, eIndex + 1);
    }

    public static void main(String[] args) {
        Minimum_Window_Subsequence obj = new Minimum_Window_Subsequence();
        System.out.println(obj.minWindow("abcdebdde", "bde")); // Output: "bcde"
    }
} */