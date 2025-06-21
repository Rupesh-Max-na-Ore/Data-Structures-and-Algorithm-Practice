package Two_Pointer_and_Sliding_Window.java.Lec1_MediumQ;
/*Q7 1358. Number of Substrings Containing All Three Characters
Medium
Topics
Companies
Hint
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1
 

Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
113.7K
Submissions
169.3K
Acceptance Rate
67.2% */
public class Number_of_Substrings_Containing_All_Three_Characters {
    //submission 1
    public int numberOfSubstrings(String s) {
        int lastSeen[] = {-1,-1,-1};
        int cnt=0;
        char[] c = s.toCharArray();
        for(int i=0; i<c.length; i++){
            lastSeen[c[i]-'a']=i;
            if(lastSeen[0] !=-1 && lastSeen[1] !=-1 && lastSeen[1] !=-1)
            {
                cnt+=1+Math.min(Math.min(lastSeen[0], lastSeen[1]),lastSeen[2]);
            }
        } return cnt;
    }
}
//submission 2
// class Solution {
//     public int numberOfSubstrings(String s) {
//     // j-(length of min. substring with all 3 chars)-i counts no. of substrings we can form from front->reach with i++
//     int count[] = {0, 0, 0}, cnt = 0 , i = 0, n = s.length();
//     char c[] = s.toCharArray();
//     for (int j = 0; j < n; ++j) {
//         ++count[c[j] - 'a'];
//         while (count[0] > 0 && count[1] > 0 && count[2] > 0) --count[c[i++] - 'a'];
//         cnt += i;
//     }
//     return cnt;
// }
// }