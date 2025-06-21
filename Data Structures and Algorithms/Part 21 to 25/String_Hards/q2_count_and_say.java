package String_Hards;
/*38. Count and Say
Medium
Topics
Companies
Hint
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the run-length encoding of countAndSay(n - 1).
Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".

Given a positive integer n, return the nth element of the count-and-say sequence.

 

Example 1:

Input: n = 4

Output: "1211"

Explanation:

countAndSay(1) = "1"
countAndSay(2) = RLE of "1" = "11"
countAndSay(3) = RLE of "11" = "21"
countAndSay(4) = RLE of "21" = "1211"
Example 2:

Input: n = 1

Output: "1"

Explanation:

This is the base case.

 

Constraints:

1 <= n <= 30
 

Follow up: Could you solve it iteratively?
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.2M
Submissions
2M
Acceptance Rate
60.3%
Topics
String
Companies
Hint 1
Create a helper function that maps an integer to pairs of its digits and their frequencies. For example, if you call this function with "223314444411", then it maps it to an array of pairs [[2,2], [3,2], [1,1], [4,5], [1, 2]].
Hint 2
Create another helper function that takes the array of pairs and creates a new integer. For example, if you call this function with [[2,2], [3,2], [1,1], [4,5], [1, 2]], it should create "22"+"23"+"11"+"54"+"21" = "2223115421".
Hint 3
Now, with the two helper functions, you can start with "1" and call the two functions alternatively n-1 times. The answer is the last integer you will obtain. */
public class q2_count_and_say {
    //first attempt, passed LC compiler
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        for(int i=1;i<n;i++){
            StringBuilder sb_dash = new StringBuilder();
            int len = sb.length();
            int j=0;
            while(j<len){
                char curr_ch = sb.charAt(j);
                int cnt_curr = 1;
                char nxt_ch = (j<len-1)?sb.charAt(j+1):' ';
                while(curr_ch==nxt_ch && j<len){
                    cnt_curr++;
                    j++;
                    if(j==len-1) break;
                    nxt_ch = sb.charAt(j+1);
                }
                //sb_dash.append((char)cnt_curr);
                 sb_dash.append(cnt_curr);
                sb_dash.append(curr_ch);
                j++;
            }  
            sb = sb_dash;
        }
        return sb.toString();
    }
//     //CLeaner code
//     public String countAndSay(int n) {
//     if (n <= 0) return "";

//     StringBuilder sb = new StringBuilder("1");

//     for (int i = 1; i < n; i++) {
//         StringBuilder sb_dash = new StringBuilder();
//         int j = 0;

//         while (j < sb.length()) {
//             char curr_ch = sb.charAt(j);
//             int cnt_curr = 0;

//             // Count how many times curr_ch repeats
//             while (j < sb.length() && sb.charAt(j) == curr_ch) {
//                 cnt_curr++;
//                 j++;
//             }

//             sb_dash.append(cnt_curr);
//             sb_dash.append(curr_ch);
//         }

//         sb = sb_dash;
//     }

//     return sb.toString();
// }

}
/*//recursive version
class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String prev = countAndSay(n - 1);
        return encode(prev);
    }

    private String encode(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            char curr = s.charAt(i);
            int count = 1;

            while (i + 1 < s.length() && s.charAt(i + 1) == curr) {
                i++;
                count++;
            }

            sb.append(count);
            sb.append(curr);
            i++;
        }

        return sb.toString();
    }
} */