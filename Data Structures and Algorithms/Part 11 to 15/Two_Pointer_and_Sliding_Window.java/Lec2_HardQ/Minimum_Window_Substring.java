package Two_Pointer_and_Sliding_Window.java.Lec2_HardQ;
/*Q3 76. Minimum Window Substring
Solved
Hard
Topics
Companies
Hint
Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?

Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.4M
Submissions
3.2M
Acceptance Rate
43.3% */
import java.util.HashMap;

public class Minimum_Window_Substring {
    public String minWindow(String str, String ttr) {
        int n = str.length(), m = ttr.length();
        int l = 0, r = 0, cnt = 0, sIndx = -1, minL = Integer.MAX_VALUE;
        int hash[] = new int[256]; 
        char s[] = str.toCharArray(), t[] =ttr.toCharArray();
        // Preputting the values of string t into the hashmap
        for (int i = 0; i < m; i++) hash[t[i]]++;
        
        while (r < n) {
            if(hash[s[r]]>0) cnt++;//if rth char is in t, its inclusion must ++ cnt
            hash[s[r]]--;//count rth char 
            while(cnt==m){
                //when reach target count, try to shrink to get minimum size window with target count satisfied
                int currL=r-l+1;
                if(minL>currL){
                    minL=currL;
                    sIndx=l;
                }
                hash[s[l]]++;//uncount lth char
                if(hash[s[l]]>0) cnt--; //if lth char is in t, its exclusion must -- cnt
                l++;//shrink
            }
            r++;//expand
        }
        
        // If sIndx is never updated, return empty string
        return sIndx == -1 ? "" : str.substring(sIndx, sIndx + minL);
    }
} 
// Hashmap soln.
// public String minWindow(String s, String t) {
//     int l = 0, r = 0, cnt = 0, sIndx = -1, minL = Integer.MAX_VALUE;
//     HashMap<Character, Integer> hmap = new HashMap<>();
    
//     // Preputting the values of string t into the hashmap
//     for (int i = 0; i < t.length(); i++) {
//         hmap.put(t.charAt(i), hmap.getOrDefault(t.charAt(i), 0) + 1);
//     }
    
//     while (r < s.length()) {
//         char ch = s.charAt(r);
        
//         // If the character is in t and its count in the hashmap is greater than 0, increase cnt
//         if (hmap.containsKey(ch)) {
//             if (hmap.get(ch) > 0) {
//                 cnt++;
//             }
//             // Decrease the count in the hashmap
//             hmap.put(ch, hmap.get(ch) - 1);
//         }
        
//         // When all characters of t are matched (cnt == t.length())
//         while (cnt == t.length()) {
//             // Update the minimum length and starting index of the substring
//             if (r - l + 1 < minL) {
//                 minL = r - l + 1;
//                 sIndx = l;
//             }
            
//             // Try to contract the window from the left
//             char leftChar = s.charAt(l);
//             if (hmap.containsKey(leftChar)) {
//                 hmap.put(leftChar, hmap.get(leftChar) + 1);
//                 // If a character count goes above 0, it means we need more of this character
//                 if (hmap.get(leftChar) > 0) {
//                     cnt--;
//                 }
//             }
//             l++;
//         }
        
//         r++;
//     }
    
//     // If sIndx is not updated, return empty string
//     return sIndx == -1 ? "" : s.substring(sIndx, sIndx + minL);
// }