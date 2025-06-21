package Recursion_Pattern_Wise;
/*Q1 8. String to Integer (atoi)

Medium

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
1.6M
Submissions
8.9M
Acceptance Rate
17.4% */
public class Atoi_Recursion {
    public int myAtoi(String str){
        char[] s= str.toCharArray();
        int sign=1;
        long accum=0;
        int l=s.length; int i=0; boolean signSeen=false;
        return atoiRecursive(s,l,i,sign,accum, signSeen);
    }

    private int atoiRecursive(char[] s, int l, int i, int sign, long accum, boolean signSeen) {
        //Base case
        if(i==l) {
            System.out.println("limit a="+accum);
            return (int)((sign)*accum);
        }
        //Recursive cases

        //skip leading spaces
        if(signSeen==false && (s[i]==' ')) {
            System.out.println("space a="+accum);

            return atoiRecursive(s, l, i+1, sign, accum, false); 
        }
            // sign encounter updation
        if (!signSeen && (s[i] == '-' || s[i] == '+')) {
            if (s[i] == '-') sign = -1;
            System.out.println("sign a="+accum);

            return atoiRecursive(s, l, i + 1, sign, accum, true);
        }

        //general case, check char
        int ch=s[i];
        if (ch >= '0' && ch <= '9') {
            if(!signSeen) signSeen=true;//once enter here accept no sign
            // ch is a digit
            int val= ch - '0';//ascii to int
            accum=(long)(accum*10 + val);
            // if at any pt. accum becomes too great for 32bit signed int
            if(accum>Integer.MAX_VALUE){
                if(sign==-1) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
           // go deeper in recursion
           System.out.println("digit char a="+accum);

           //return atoiRecursive(s, l, i+1, sign, accum, signSeen);
           return atoiRecursive(s, l, i+1, sign, accum, true);
        } 
            // ch is not a digit
            // If a non-digit character is encountered after any valid digit
            if(accum>0)
            {
                System.out.println("non digit char a="+accum);

                return (int)((sign)*accum);
                
            }
          
          // If no valid digits were found
          return 0;

    }

    public static void main(String[] args) {
        Atoi_Recursion solution = new Atoi_Recursion();

        // Test cases
        System.out.println("Ans is = "+ solution.myAtoi("77"));           // Output: 42
        System.out.println("Ans is = "+ solution.myAtoi("   -42"));       // Output: -42
        System.out.println("Ans is = "+ solution.myAtoi("4193 with words")); // Output: 4193
        System.out.println("Ans is = "+ solution.myAtoi("words and 987")); // Output: 0
        System.out.println("Ans is = "+ solution.myAtoi("-91283472332")); // Output: -2147483648
        System.out.println("Ans is = "+ solution.myAtoi("0-1"));          // Output: 0
    }

}
// very short soln found, with good comments, might come handy for revision
// class Solution {
//     public int myAtoi(String s) {
//         s = s.trim(); // Remove leading and trailing whitespace
//         if (s.isEmpty()) return 0; // Return 0 if the string is empty after trimming
//         return atoiRecursive(s, 0, 1, 0); // Call the recursive helper function
//     }

//     public int atoiRecursive(String s, int idx, int sign, long res) {
//         if (idx == s.length()) return (int) (sign * res); // Base case: return the final result
        
//         char c = s.charAt(idx); // Get the character at index idx
        
//         if (Character.isDigit(c)) {
//             // If the character is a digit, update the result
//             res = (res * 10) + (c - '0');
            
//             // Check for overflow/underflow
//             if (res * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
//             if (res * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            
//             // Continue recursively with the next character
//             return atoiRecursive(s, idx + 1, sign, res);
//         } else if (idx == 0 && (c == '+' || c == '-')) {
//             // If the character is '+' or '-' and it's the first character, update the sign
//             if (c == '-') sign = -1;
            
//             // Continue recursively with the next character
//             return atoiRecursive(s, idx + 1, sign, res);
//         }
        
//         // If the character is not a digit and it's not the first character,
//         // or if it's an invalid character, return the current result
//         return (int) (sign * res);
//     }
// }
// first try
// class Solution {
//     public int myAtoi(String str) {
//         char[] s= str.toCharArray();
//         int sign=1;
//         long accum=0;
//         int l=s.length; int i=0;
//         return atoiRecursive(s,l,i,sign,accum);
//     }

//         private int atoiRecursive(char[] s, int l, int i, int sign, long accum) {
//         //Base case
//         if(i==l) return (int)((sign)*accum);
//         //Recursive cases

//         //skip leading spaces and 0s
//         if(i<l && accum==0 && (s[i]==' '||s[i]=='0)') 
//             return atoiRecursive(s, l, i+1, sign, accum); 
//         // sign encounter updation
//         if(i<l && accum==0 && (s[i]=='-'||s[i]=='+')){
//             if(s[i]=='-') sign=-1;
//             return atoiRecursive(s, l, i+1, sign, accum);
//         }

//         //general case, check char
//         int ch=s[i];
//         if (ch >= '0' && ch <= '9') {
//             // ch is a digit
//             int val= ch - '0';//ascii to int
//             accum=(long)(accum*10 + val);
//             // if at any pt. accum becomes too great for 32bit signed int
//             if(accum>Integer.MAX_VALUE){
//                 if(sign==-1) return Integer.MIN_VALUE;
//                 else return Integer.MAX_VALUE;
//             }
//           } else {
//             // ch is not a digit
//             return (int)((sign)*accum);
//           }
//           // go deeper in recursion
//           return atoiRecursive(s, l, i+1, sign, accum);

//     }

// }
// //lc submission
// class Solution {
//     public int myAtoi(String str){
//             char[] s= str.toCharArray();
//             int sign=1;
//             long accum=0;
//             int l=s.length; int i=0; boolean signSeen=false;
//             return atoiRecursive(s,l,i,sign,accum, signSeen);
//         }
    
//         private int atoiRecursive(char[] s, int l, int i, int sign, long accum, boolean signSeen) {
//             //Base case
//             if(i==l) {
//                 return (int)((sign)*accum);
//             }
//             //Recursive cases
    
//             //skip leading spaces
//             if(signSeen==false && (s[i]==' ')) {
    
//                 return atoiRecursive(s, l, i+1, sign, accum, false); 
//             }
//                 // sign encounter updation
//             if (!signSeen && (s[i] == '-' || s[i] == '+')) {
//                 if (s[i] == '-') sign = -1;
    
//                 return atoiRecursive(s, l, i + 1, sign, accum, true);
//             }
    
//             //general case, check char
//             int ch=s[i];
//             if (ch >= '0' && ch <= '9') {
//                 if(!signSeen) signSeen=true;//once enter here accept no sign
//                 // ch is a digit
//                 int val= ch - '0';//ascii to int
//                 accum=(long)(accum*10 + val);
//                 // if at any pt. accum becomes too great for 32bit signed int
//                 if(accum>Integer.MAX_VALUE){
//                     if(sign==-1) return Integer.MIN_VALUE;
//                     else return Integer.MAX_VALUE;
//                 }
//                // go deeper in recursion
    
//                //return atoiRecursive(s, l, i+1, sign, accum, signSeen);
//                return atoiRecursive(s, l, i+1, sign, accum, true);
//             } 
//                 // ch is not a digit
//                 // If a non-digit character is encountered after any valid digit
//                 if(accum>0)
//                 {
    
//                     return (int)((sign)*accum);
                    
//                 }
              
//               // If no valid digits were found
//               return 0;
    
//         }
//     }
    
    