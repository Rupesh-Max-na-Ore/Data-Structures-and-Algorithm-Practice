package Strings_Basic_and_Medium.Medium_String_Problems;
/*
 * Q8 part 2
 * 557. Reverse Words in a String III
Easy
Topics
Companies
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "Mr Ding"
Output: "rM gniD"
 

Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
906.2K
Submissions
1.1M
Acceptance Rate
83.1%
 */
public class ReverseStringCharByChar {
    public String reverseWords(String s) {
        int l=0;
        int r=0;
        int n=s.length();
        if(n==1) return s;
        char str[]=s.toCharArray();
        while(l<n){
            while(r<n && str[r]!=' ')  r++;
            //reverse part
            //r-1 cuz r is currently pointing at blank space when r++ stops on encountering a space
            reverse(str,l,r-1);             
            l=r+1;
            // skip all spaces after reversal
            while(l<n && str[l]==' ') l++;
            r=l;
        }
        return new String(str);
    }
     public void reverse(char s[],int l,int r){
         while(l<r){
             char tmp=s[l];
             s[l]=s[r];
             s[r]=tmp;
             l++;
             r--;
         }
     }

}
// // Another soln using regular expression, but less efficient ultimately
// class Solution {

//     static String reverse(StringBuilder s){
//         return s.reverse().toString();
//     }
//     public String reverseWords(String s) {
//         String arr[] = s.split(" ");

//         int n = arr.length;

//         StringBuilder ans = new StringBuilder("");

//         for(int i=0; i<n; i++){
//             StringBuilder x = new StringBuilder(arr[i]);
//             ans.append(reverse(x));

//             if(i!=n-1) ans.append(" ");
//         }
//         return ans.toString();
//     }
// }