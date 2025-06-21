package Two_Pointer_and_Sliding_Window.java.Lec1_MediumQ;

import java.util.HashMap;

/*Q4 424. Longest Repeating Character Replacement
Medium
Topics
Companies
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
Seen this question in a real interview before?
1/5
Yes
No
Accepted
777K
Submissions
1.4M
Acceptance Rate
54.4% */
public class Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        HashMap <Character,Integer> hmap = new HashMap<>();
        int maxL=0; int r=0,l=0,maxf=0;
        //Can make algo faster using cache[] of freq. for each alphabet, to ease char freq. retrieval, but too lazy
        char[] c = s.toCharArray();
        while(r<c.length){
            int currL= r-l+1;
            int v = hmap.getOrDefault(c[r],0);
            hmap.put(c[r], (v+1));
            maxf= Math.max((v+1) , maxf);
            int changes = currL - maxf;
            if(changes>k){
                hmap.put(c[l], (hmap.get(c[l])-1));
                if(hmap.get(c[l])==0) hmap.remove(c[l]);
                l++;
            }
            currL=r-l+1;
            changes = currL - maxf;
            if(changes <=k) maxL = Math.max(maxf, currL);
            r++;
        } return maxL;
    }
}
// //1st LC submission
// class Solution {
//     public int characterReplacement(String s, int k) {
//         HashMap <Character,Integer> hmap = new HashMap<>();
//         int maxL=0; int r=0,l=0,maxf=0;
//         char[] c = s.toCharArray();
//         while(r<c.length){
//             int currL= r-l+1;
//             hmap.put(c[r], (hmap.getOrDefault(c[r], 0)+1));
//             maxf= Math.max(hmap.get(c[r]) , maxf);
//             int changes = currL - maxf;
//             if(changes>k){
//                 hmap.put(c[l], (hmap.get(c[l])-1));
//                 if(hmap.get(c[l])==0) hmap.remove(c[l]);
//                 l++;
//             }
//             currL=r-l+1;
//             changes = currL - maxf;
//             if(changes <=k) maxL = Math.max(maxf, currL);
//             r++;
//         } return maxL;
//     }
// }

// //Using count[26]
// public int characterReplacement(String s, int k) {
//     int len = s.length();
//     int[] count = new int[26];
//     int start = 0, maxCount = 0, maxLength = 0;
//     for (int end = 0; end < len; end++) {
//         maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
//         if (end - start + 1 - maxCount > k) {
//             count[s.charAt(start) - 'A']--;
//             start++;
//         }
//         maxLength = Math.max(maxLength, end - start + 1);
//     }
//     return maxLength;
// }