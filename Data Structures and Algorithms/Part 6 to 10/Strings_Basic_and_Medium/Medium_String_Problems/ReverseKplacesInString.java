package Strings_Basic_and_Medium.Medium_String_Problems;
/*
 * Q8 part 1
 * 541. Reverse String II
Easy
Topics
Companies
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

 

Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"
 

Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 104
Seen this question in a real interview before?
1/5
Yes
No
Accepted
247.1K
Submissions
486.6K
Acceptance Rate
50.8%
 */
public class ReverseKplacesInString {
    public String reverseStr(String s, int k) {
        int n=s.length();
        StringBuilder sb = new StringBuilder();
        int shifts=(n+k-1)/k; // ceil of n/k
        for (int i=1; i<= shifts; i++){
            int l=(i-1)*k; int r= Math.min((l+k-1), n-1);
            if(i%2==0){
                while(l<=r){
                    sb.append(s.charAt(l));
                    l++;
                }
            }
            else if(i%2!=0){
                while(r>=l){
                    sb.append(s.charAt(r));
                    r--;
                }
            }
        } return sb.toString();
    }

    public static void main(String[] args) {
        ReverseKplacesInString solution = new ReverseKplacesInString();
        
        // Test cases
        String s1 = "abcdefg";
        int k1 = 2;
        System.out.println(solution.reverseStr(s1, k1));  // Output: "bacdfeg"
        
        String s2 = "abcd";
        int k2 = 2;
        System.out.println(solution.reverseStr(s2, k2));  // Output: "bacd"
    }
}

// // More efficient soln.
// class Solution {
//     public String reverseStr(String s, int k) {
//         char[] str = s.toCharArray();
//         int n = str.length;
//         for(int i = 0 ; i <= n-1; i += 2*k){
//             if(i+k-1 <= n-1){
//                 reverseK(i,i+k-1,str);
//             }else{
// 				//for fewer than k characters left (edge case)
//                 reverseK(i,n-1,str);
//             }
//         }
//         String ans = new String(str);
//         return ans;
//     }
//     public void reverseK(int i, int j, char[] str){
//         while(i < j){
//             char temp = str[i];
//             str[i] = str[j];
//             str[j] = temp;
//             i++;
//             j--;
//         }
//     }
// }