package Bit_Manipulation.Basics;

/*Q8 29. Divide Two Integers
Medium
Topics
Companies
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

 

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 

Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0
Seen this question in a real interview before?
1/5
Yes
No
Accepted
757.1K
Submissions
4.3M
Acceptance Rate
17.6% */
public class DivideWithoutDivideOperator {
    public int divide(int dividend, int divisor) {
        // Handle edge cases
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Prevent overflow
        }
        if(divisor == dividend) return 1; // Improve best case
        
        // Determine sign of quotient, using xor
        int sign = ((dividend < 0) ^ (divisor < 0))? -1 : 1;

        // Convert to long to handle overflow cases
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long quotient = 0;
        while (n >= d) {
            long temp = d, multiple = 1;
            while (n >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            n -= temp;
            quotient += multiple;
        }

        // Apply the sign to the quotient
        quotient = (sign==-1)? (-quotient):quotient;

        // Ensure the quotient is within the 32-bit signed integer range
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) quotient;
    }
    //1st attmpt, not able to handle edge cases
    // public int divide(int dividend, int divisor) {
    //     // Handle edge cases
    //     if (divisor == 0) {
    //         throw new IllegalArgumentException("Divisor can't be zero");
    //     }
    //     if (dividend == Integer.MIN_VALUE && divisor == -1) {
    //         return Integer.MAX_VALUE; // Prevent overflow
    //     }
    //     //if(dividend<divisor) return 0;//wrong thinking
    //     if(dividend==divisor) return 1;
    //     int sign=1;
    //     if((dividend>=0 && divisor<0)||(dividend<=0 && divisor>0)) sign=-1;
    //     long n= Math.abs(dividend); long d= Math.abs(divisor);
    //     long ans=0;
    //     while(n>=d){
    //         long cnt=0;
    //         while(n>=(d<<(cnt+1))) cnt++;
    //         ans+=1<<cnt;
    //         n-= d*(1<<cnt);
    //     }
    //     if(sign==-1) ans=-ans;
    //     if(ans<Integer.MIN_VALUE) return Integer.MIN_VALUE;
    //     if(ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;

    //     return (int)ans;
    // }

    public static void main(String[] args) {
        DivideWithoutDivideOperator solution = new DivideWithoutDivideOperator();
        System.out.println(solution.divide(10, 3));  // Output: 3
        System.out.println(solution.divide(7, -3)); // Output: -2
        System.out.println(solution.divide(-10, -2)); // Output: 5
        System.out.println(solution.divide(1, 1)); // Output: 1
        System.out.println(solution.divide(-2147483648, -1)); // Output: 2147483647
    }
}
// ANother way to do it, given problem constraints, O(32) soln.
// class Solution {
//     public int divide(int A, int B) {
//         if (A == 1 << 31 && B == -1) return (1 << 31) - 1;// handle overflow case 1st
//         int a = Math.abs(A), b = Math.abs(B), q = 0;
//         for (int x = 31; x >= 0; x--)
//             // can also check like: if(a >= b<<x), but cause overflow in case  A=-2147483648, B=1, as a=2^31
//             //(a>>x) not works as it moves the sign bit to right too, being arithmetic shift, which we don't want
//             if ((a >>> x) >= b) { //itr bwds till a/2^x < b
//                 //subtract greatest b*2^x that's still under a from a
//                 q = q + 1 << x; // add 2^x to quotient
//                 a = a - b << x;
//             }
//         return (A > 0) == (B > 0) ? q : -q; //check if a and b have same sign or not
//     }
// }
//inspired from
//https://leetcode.com/problems/divide-two-integers/solutions/142849/c-java-python-should-not-use-long-int/
//nice explanations-
//https://leetcode.com/problems/divide-two-integers/solutions/1516367/complete-thinking-process-intuitive-explanation-all-rules-followed-c-code/
//https://leetcode.com/problems/divide-two-integers/solutions/1601170/java-1ms-single-recursive-function/

//a wrong attempt, tho learnt a lot from it
// class Solution {
//     public int divide(int A, int B) {
//         if (A == 1 << 31 && B == -1) return (1 << 31) - 1;// handle overflow case 1st
//         if (A == -(1 << 31) && B == 1) return -(1 << 31);// handle overflow case 
//         if (A == -(1 << 31) && B == -1) return (1 << 31) - 1;// handle overflow case 1st
//         // even after this still problems in A=-2147483648, B=2, expected- -1073741824, cuz a=2^31 can't be stored(overflow)

//         int a = Math.abs(A), b = Math.abs(B), q = 0;
//         for (int x = 31; x >= 0; x--)
//             // can also check like: 
//             if(a >= (b*Math.pow(2,x))){
//             //if ((a >>> x) >= b) { //itr bwds till a/2^x < b
//                 //subtract greatest b*2^x that's still under a from a
//                 q = q + (1 << x); // add 2^x to quotient
//                 a = a - (b << x);
//             }
//         return (A > 0) == (B > 0) ? q : -q; //check if a and b have same sign or not
//     }
// }
//ANother code to recount possibilitities and edge cases w/o long for all cases but overflow ones, even tho it uses '/' op.
// class Solution {
//     public int divide(int A, int B) {
//         if (A == 1 << 31 && B == -1) return (1 << 31) - 1;// handle overflow case 1st
//         if (A == -(1 << 31) && B == 1) return -(1 << 31);// handle overflow case 
//         if (A == -(1 << 31) && B == -1) return (1 << 31) - 1;// handle overflow case 1st
//         if (A == -(1 << 31)) return -(int)(((long)1 << 31)/B);// handle overflow case 
//         if (A == -(1 << 31)||B == -(1 << 31)) return -(int)(((long)A)/(long)B);// handle overflow case 

//         int a = Math.abs(A), b = Math.abs(B), q = 0;
//         for (int x = 31; x >= 0; x--)
//             // can also check like: 
//             if(a >= (b*Math.pow(2,x))){
//             //if ((a >>> x) >= b) { //itr bwds till a/2^x < b
//                 //subtract greatest b*2^x that's still under a from a
//                 q = q + (1 << x); // add 2^x to quotient
//                 a = a - (b << x);
//             }
//         return (A > 0) == (B > 0) ? q : -q; //check if a and b have same sign or not
//     }
// }