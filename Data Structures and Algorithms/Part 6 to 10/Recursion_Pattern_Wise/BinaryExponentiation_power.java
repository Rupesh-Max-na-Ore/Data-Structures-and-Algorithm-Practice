package Recursion_Pattern_Wise;
/*Q2 50. Pow(x, n)
Attempted
Medium
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).


Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

Input: x = 2.00000, n = -2147483648
Output: 
Explanation:
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= xn <= 104
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.7M
Submissions
4.8M
Acceptance Rate
34.9% */ 
public class BinaryExponentiation_power {
    public double myPow(double x, int n) {
        if(x==0) return 0;
        if(n==0 && x!=0) return 1.0;
        if(x==1.0) return 1.0;
        if (x == -1.0) return (n % 2 == 0) ? 1.0 : -1.0;
        int sign=1;
        if (n<0) sign =-1; // long the exponent to handle edge cases
        double magnitude=recurPow(x,(long)sign*n,1);
        double ans = (sign==1)?magnitude:(1/magnitude)  ;
        return ans;
    }

    private double recurPow(double x, long n, double ans) {
        //Base
        if(n==0) return ans;
        //Recursive case
        if(n%2==0){
            return recurPow(x*x, n/2, ans);
        }
        else{
            return recurPow(x, n-1, ans*x);
        }
    }

    public static void main(String[] args) {
        BinaryExponentiation_power solution = new BinaryExponentiation_power();

        // Test cases
        System.out.println(solution.myPow(2.00000, 10)); // Output: 1024.00000
        System.out.println(solution.myPow(2.10000, 3));  // Output: 9.26100
        System.out.println(solution.myPow(2.00000, -2)); // Output: 0.25000
        System.out.println(solution.myPow(2.00000, -2147483648)); // Output: 0.0
    }

}
// // another, much cleaner soln found on lc forum, for revision
// class Solution {
//     public double myPow(double x, int n) {
        
//         // Base condition: If n is 0, x^0 is 1
//         if (n == 0) {
//             return 1;
//         }

//         // Convert n to a long integer to handle the edge case with Integer.MIN_VALUE
//         long N = n;

//         // If n is negative, take the reciprocal of x and make N positive
//         if (N < 0) {
//             N = -N;
//             x = 1 / x;
//         }

//         // If N is even, recursively compute the square of x^(N/2)
//         if (N % 2 == 0) {
//             return myPow(x * x, (int) (N / 2));
//         } 
    
//         // If N is odd, recursively compute x^(N-1) and multiply it by x
//         else {
//             return x * myPow(x, (int) (N - 1));
//         }
//     }
// }