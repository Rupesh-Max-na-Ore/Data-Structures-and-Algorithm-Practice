package Strings_Basic_and_Medium.Medium_String_Problems;
/*
 * Q5
 * 8. String to Integer (atoi)
Solved
Medium
Topics
Companies
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result.

 

Example 1:

Input: s = "42"

Output: 42

Explanation:

The underlined characters are what is read in and the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^
Example 2:

Input: s = " -042"

Output: -42

Explanation:

Step 1: "   -042" (leading whitespace is read and ignored)
            ^
Step 2: "   -042" ('-' is read, so the result should be negative)
             ^
Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
               ^
Example 3:

Input: s = "1337c0d3"

Output: 1337

Explanation:

Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
         ^
Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
             ^
Example 4:

Input: s = "0-1"

Output: 0

Explanation:

Step 1: "0-1" (no characters read because there is no leading whitespace)
         ^
Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
          ^
Example 5:

Input: s = "words and 987"

Output: 0

Explanation:

Reading stops at the first non-digit character 'w'.

 

Constraints:

0 <= s.length <= 200
s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.5M
Submissions
8.9M
Acceptance Rate
17.3%
 */
public class AtoiProblem {
    public int myAtoi(String s) {
        char[]str=s.toCharArray();
        int i=0;

        //skip all spaces           
        while(i<str.length && str[i]==' ')i++;

        //check if string is empty or only contains spaces
        if(i==str.length)return 0;

        //check for the first sign
        int sign=1;
        if(str[i]=='-'){
            sign=-1;
            i++;
        }
        else if(str[i]=='+')i++;

        //long var to hold num because int var will overflow
        long num=0l;

        //continue untill the character is a number
        while(i<str.length && Character.isDigit(str[i]))
            {
                num*=10l;
                num+=str[i++]-'0'; //ascii char code to int coversion

                //check for overflow
                if(num>Integer.MAX_VALUE)
                {
                    if(sign==-1)return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                }

                //i++;
            }
        //return the result along with its sign
        return sign*(int)num;
    }
}
