package Two_Pointer_and_Sliding_Window.java.Lec1_MediumQ;

import java.util.HashMap;

/*Q1 3. Longest Substring Without Repeating Characters
Medium
Topics
Companies
Hint
Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
6M
Submissions
17M
Acceptance Rate
35.0% */
public class Longest_Substring_Without_Repeating_Characters {
    // 1st attempt, works, cleaner soln.
    // public int lengthOfLongestSubstring(String s) {
    //     HashMap <Character,Integer> hmap = new HashMap<>();
    //     //StringBuilder sb = new StringBuilder();
    //     char c[] = s.toCharArray();
    //     int n = c.length;
    //     int l=0; int r=0; int maxL=0;
    //     while(r<n){
            
    //         if(hmap.containsKey(c[r])){
    //             hmap.remove(c[l]);
    //             l++;
    //             continue;
    //             //l++;
    //         }
    //         int currL= r-l+1;
    //         maxL = Math.max(maxL, currL);
    //         r++;
    //         hmap.put(c[r-1], 1);
    //     }
    //     return maxL;
    //     //StringBuilder sb = new StringBuilder(s.substring(l, r+1));
    //     //return sb;
    // }
    // faster soln., using array to cache instead of hashmap
    public int lengthOfLongestSubstring(String s) {
        //HashMap <Character,Integer> hmap = new HashMap<>();
        int cache[] = new int[256];
        char c[] = s.toCharArray();
        int n = c.length;
        int l=0; int r=0; int maxL=0;
        while(r<n){
            if(cache[c[r]]==1){
                cache[c[l]]=0;
                l++;
                continue;
            }
            int currL= r-l+1;
            maxL = Math.max(maxL, currL);
            cache[c[r]]=1;
            r++;
        }
        return maxL;
    }
}
// //found on lc forum, hashset soln
// public int lengthOfLongestSubstring(String s) {
//     Set<Character> set = new HashSet();
//     int max = 0;
//     int left = 0;
//     for (int right = 0; right < s.length(); right++) {
//         while(!set.add(s.charAt(right))) {
//             set.remove(s.charAt(left++));
//         }
//         max = Math.max(max, right - left + 1);
//     }
//     return max;
// }
// }
/*By using a HashSet you are increasing the time complexity compared 
to the fastest solution which uses a HashMap. 
You are performing a while loop within a for loop that could be 
avoided if you store the index of the character found (the reason why HashMap is needed) 
and place the left pointer to the character found index + 1 = O(1). 
I still would say that there is a tradeoff between space and time complexity 
(this solution has the potential to require less memory as values are added and 
removed from the HashSet compared to storing all characters in the HashMap), 
so it really comes down to understanding which one we give priority in a given context. */