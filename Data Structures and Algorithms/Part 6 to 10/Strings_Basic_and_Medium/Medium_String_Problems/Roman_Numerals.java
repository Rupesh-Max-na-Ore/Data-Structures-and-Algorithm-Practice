package Strings_Basic_and_Medium.Medium_String_Problems;
/*Q3
 * 
Code
Testcase
Test Result
Test Result
13. Roman to Integer
Easy
Topics
Companies
Hint
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
Seen this question in a real interview before?
1/5
Yes
No
Accepted
3.7M
Submissions
6M
Acceptance Rate
61.4%
 */
public class Roman_Numerals {
    public int romanToInt(String s) {
        char[] ch= s.toCharArray();
        int ans=0;
        for(int i=0; i<ch.length;i++){
            int val= ConvertRomanToInt(ch[i]);
            int preVal= (i>=1)?ConvertRomanToInt(ch[i-1]):0;
            ans+= val;
            if(i>=1 && preVal<val) ans-=2*preVal;

        } return ans;
    }

    private int ConvertRomanToInt(char c) {
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        } return 0; // never executed
    }

    public static void main(String[] args) {
        Roman_Numerals converter = new Roman_Numerals();

        // Test cases
        String s1 = "III";
        String s2 = "LVIII";
        String s3 = "MCMXCIV";

        System.out.println("Roman numeral III converts to: " + converter.romanToInt(s1)); // Output: 3
        System.out.println("Roman numeral LVIII converts to: " + converter.romanToInt(s2)); // Output: 58
        System.out.println("Roman numeral MCMXCIV converts to: " + converter.romanToInt(s3)); // Output: 1994
    }
}
