/*Q5 204. Count Primes
Solved
Medium
Topics
Companies
Hint
Given an integer n, return the number of prime numbers that are strictly less than n.

 

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
 

Constraints:

0 <= n <= 5 * 106
Seen this question in a real interview before?
1/5
Yes
No
Accepted
878.7K
Submissions
2.6M
Acceptance Rate
33.7%
 */
public class power {
    //My Iterative soln.
    public double myPow(double x, int n) {
        int sign=1;
        if (x==1) return x;
        if (x==0) return 0;
        if (n==0) return 1;
        if (n<0) sign =-1;
        int absPow= sign*n; 
        double mag=1;
        while(absPow!=0){
            if(absPow%2==0)//even n
            {
                x=x*x;
                absPow=(absPow >>> 1); // == absPow/2; //TLE if use this
            }else{//odd n
                mag = mag*x;
                absPow = absPow-1; // == (absPow&(absPow-1)); // unset least significant set bit
            }
        }
        return (sign==-1)? (1/mag):mag;
    }
}
/*//My recursive soln.
class Solution {
    public double myPow(double x, int n) {
        int sign=1;
        if (n<0) sign =-1;
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

} */