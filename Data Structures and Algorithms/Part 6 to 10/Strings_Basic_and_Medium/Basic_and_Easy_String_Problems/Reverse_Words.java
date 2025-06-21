package Strings_Basic_and_Medium.Basic_and_Easy_String_Problems;
/*
 * Q2
 * 151. Reverse Words in a String
Medium

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 

Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?

Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.5M
Submissions
3.6M
Acceptance Rate
43.0%
 */
import java.util.Stack;

public class Reverse_Words {
    public String reverseWords(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder ans=new StringBuilder();
        for(int i=s.length()-1; i>=-1; i--){
            char ch=(i>=0)?s.charAt(i):' ';
            if(ch==' '||i==-1) {
                while(!(stack.isEmpty()))
                {
                    char c= stack.pop();
                    ans.append(c);
                } if (ans.length()>=1 && ans.charAt(ans.length()-1)!=' ') ans.append(ch);
            } else stack.push(ch);
        } return ans.toString().trim() ;

    }

    public static void main(String[] args) {
        Reverse_Words solution = new Reverse_Words();

        // Test cases
        String s1 = "the sky is blue";
        String s2 = "  hello world  ";
        String s3 = "a good   example";

        System.out.println(solution.reverseWords(s1)); // Output: "blue is sky the"
        System.out.println(solution.reverseWords(s2)); // Output: "world hello"
        System.out.println(solution.reverseWords(s3)); // Output: "example good a"
    }
}
// //lc faster soln
// class Solution {
//     public String reverseWords(String s) {
//         StringBuilder ans = new StringBuilder();
//         int i = s.length() - 1;

//         while (i >= 0) {
//             while (i >= 0 && s.charAt(i) == ' ') i--; // Skip trailing spaces
//             int j = i;
//             if (i < 0) break; // Break if no more words
//             while (i >= 0 && s.charAt(i) != ' ') i--; // Find the start of the word
//             if (ans.length() > 0) ans.append(' '); // Append a space before the next word
//             ans.append(s.substring(i + 1, j + 1)); // Append the word
//         }

//         return ans.toString();
//     }
// }
// another lc soln, using regular expressions
// class Solution {
//     public String reverseWords(String s) {
//         String[] arr = s.trim().split("\\s+");
//         int i=0,j=arr.length-1;
//         while(i<j) {
//             String t = arr[i];
//             arr[i] = arr[j];
//             arr[j] = t;
//             i++;
//             j--;
//         }
//         return String.join(" ", arr);
//     }
// }