package Two_Pointer_and_Sliding_Window.java.Lec2_HardQ;
/*Q1 340. Longest Substring with At Most K Distinct Characters 🔒
中文文档

Description
Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.

 

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
 

Constraints:

1 <= s.length <= 5 * 104
0 <= k <= 50*/
import java.util.HashMap;

public class Longest_Substring_with_At_Most_K_Distinct_Characters {
    public int lengthOfLongestSubstring(String str, int k){
        int maxL=0; int l=0,r=0;
        char s[] = str.toCharArray();
        HashMap<Character, Integer> hmap=new HashMap<>();
        while(r<s.length){
            hmap.put(s[r], (hmap.getOrDefault(s[r], 0)+1));
            if(hmap.size()>k){
                hmap.put(s[l], (hmap.getOrDefault(s[l], 0)-1));
                if(hmap.get(s[l])==0) hmap.remove(s[l]);
                l++;
            }
            //if(hmap.size()<=k)
            maxL = Math.max(maxL, (r-l+1));
            r++;
        } return maxL;
    }
}
// GFG submission for similar problem - https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
// public int longestkSubstr(String str, int k) {
//     int maxL=-1; int l=0,r=0;
//     char s[] = str.toCharArray();
//     HashMap<Character, Integer> hmap=new HashMap<>();
//     while(r<s.length){
//         hmap.put(s[r], (hmap.getOrDefault(s[r], 0)+1));
//         while(hmap.size()>k){
//             hmap.put(s[l], (hmap.getOrDefault(s[l], 0)-1));
//             if(hmap.get(s[l])==0) hmap.remove(s[l]);
//             l++;
//         }
//         if(hmap.size()==k) maxL = Math.max(maxL, (r-l+1));
//         r++;
//     } return maxL;
// }