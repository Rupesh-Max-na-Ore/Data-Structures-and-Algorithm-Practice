package Recursion_Pattern_Wise;
/*Q3 1922. Count Good Numbers
Medium
Topics
Companies
Hint
A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

 

Example 1:

Input: n = 1
Output: 5
Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
Example 2:

Input: n = 4
Output: 400
Example 3:

Input: n = 50
Output: 564908303
 

Constraints:

1 <= n <= 1015
Seen this question in a real interview before?
1/5
Yes
No
Accepted
59.4K
Submissions
132.5K
Acceptance Rate
44.9% */
public class CountGoodNos {
        //works now
    //just added %10^9+7 everywhere to avoid overflow at all cost, lol
    public int countGoodNumbers(long n) {
        if(n<=0) return 0;
        long odd = n/2;
        long even = (n+1)/2;
        return (int)(((recurPow(5,even,1)) * (recurPow(4,odd,1) )% 1_000_000_007));
    }
        private long recurPow(long x, long n, long ans) {
        //Base
        if(n==0) return ans%1_000_000_007;
        //Recursive case
        if(n%2==0){
            return recurPow(x*x%1_000_000_007, n/2, ans%1_000_000_007)%1_000_000_007;
        }
        else{
            return recurPow(x%1_000_000_007, n-1, ans*x%1_000_000_007)%1_000_000_007;
        }
    }
    // lc submission, works well, cleaner too
    // class Solution {
    //     //works now
    //     //just added %10^9+7 everywhere to avoid overflow at all cost
    //     public int countGoodNumbers(long n) {
    //         if(n<=0) return 0;
    //         long odd = n/2;
    //         long even = (n+1)/2;
    //         return (int)(((recurPow(5,even,1)) * (recurPow(4,odd,1) )% 1_000_000_007));
    //     }
    //         private long recurPow(long x, long n, long ans) {
    //         //Base
    //         if(n==0) return ans;
    //         //Recursive case
    //         if(n%2==0){
    //             return recurPow(x*x%1_000_000_007, n/2, ans);
    //         }
    //         else{
    //             return recurPow(x, n-1, ans*x%1_000_000_007);
    //         }
    //     }
    // }

    // A clean code that works, kept here for reference
    // private static final int MOD = 1_000_000_007;

    // public int countGoodNumbers(long n) {
    //     if (n <= 0) return 0;
    //     long odd = n / 2;
    //     long even = (n + 1) / 2;
    //     long evenPow = recurPow(5, even);
    //     long oddPow = recurPow(4, odd);
    //     return (int) ((evenPow * oddPow) % MOD);
    // }

    // private long recurPow(long x, long n) {
    //     if (n == 0) return 1;
    //     long half = recurPow(x, n / 2);
    //     long halfSquare = (half * half) % MOD;
    //     if (n % 2 == 0) {
    //         return halfSquare;
    //     } else {
    //         return (halfSquare * x) % MOD;
    //     }
    // }

    public static void main(String[] args) {
        CountGoodNos solution = new CountGoodNos();
        System.out.println(solution.countGoodNumbers(1)); // Output: 5
        System.out.println(solution.countGoodNumbers(4)); // Output: 400
        System.out.println(solution.countGoodNumbers(50)); // Output: 564908303
        System.out.println(solution.countGoodNumbers(1924)); // Output: 805821919

    }
    // almost works, except n>=500
    // public int countGoodNumbers(long n) {
    //     if(n<=0) return 0;
    //     long odd = n/2;
    //     long even = (n+1)/2;
    //     return (int)(recurPow(5,even,1) * recurPow(4,odd,1) % 1_000_000_007);
    // }
    //     private long recurPow(long x, long n, long ans) {
    //     //Base
    //     if(n==0) return ans%1_000_000_007;
    //     //Recursive case
    //     if(n%2==0){
    //         return recurPow(x*x, n/2, ans)%1_000_000_007;
    //     }
    //     else{
    //         return recurPow(x, n-1, ans*x)%1_000_000_007;
    //     }
    // }
}
/*//Works for small cases, upto n=29, breaks for larger ones
public int countGoodNumbers(long n) {
        if(n<=0) return 0;
        double ans=1;
        ans=(int)recurGN(n,ans)%((Math.pow(10, 9)+7));
        return (int)ans;
    }

    private double recurGN(long n, double ans) {
        if(n==0) return ans;
        if(n%2==0){
            return recurGN(n-1, 5*ans);
        }
        else{
            return recurGN(n-1, 4*ans);
        }
    }
 */