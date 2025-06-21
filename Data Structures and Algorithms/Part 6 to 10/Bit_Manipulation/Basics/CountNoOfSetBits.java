package Bit_Manipulation.Basics;
/*Q5 Count total set bits
MediumAccuracy: 35.77%Submissions: 158K+Points: 4
Be the comment of the day in POTD and win a GfG T-Shirt!
Solve right now

banner
You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).

Example 1:

Input: N = 4
Output: 5
Explanation:
For numbers from 1 to 4.
For 1: 0 0 1 = 1 set bits
For 2: 0 1 0 = 1 set bits
For 3: 0 1 1 = 2 set bits
For 4: 1 0 0 = 1 set bits
Therefore, the total set bits is 5.
Example 2:

Input: N = 17
Output: 35
Explanation: From numbers 1 to 17(both inclusive), 
the total number of set bits is 35.

Your Task: The task is to complete the function countSetBits() that takes n as a parameter and returns the count of all bits.

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 108 */
//Brute force, 1st attempt, TLE
// public class CountNoOfSetBits {
//     //Function to return sum of count of set bits in the integers from 1 to n.
//     public static int countSetBits(int n){
//         int count=0;
//         for(int i=1;i<=n;i++){
//             count+= cntSetBits(i);
//         }
//         return count;
//     }
//     //Fn to count set bits in a individual no.
//     public static int cntSetBits(int n){
//         int cnt=0;
//         while(n!=0){
//             //remove a set bit per itr and ++cnt;
//             n=n&(n-1);
//             cnt++;
//         } return cnt;       
//     }
// }

public class CountNoOfSetBits {
    // Function to return sum of count of set bits in the integers from 1 to n.
    //iterative soln.
    public static int countSetBits(int n) {
        int cnt=0;
        int x;
        while(n>0){
            x=0;
            //find highest pow of 2 =< n
            while((1<<(x+1))<=n) x++;
            //no. of set bits from 1 to 2^x-1
            int setBitsTill2x = (1<<(x-1))*x;
            //msb bits after 2^x-1 == nos. remaining after 2^x-1 (incl. 2^x itself hence the +1)
            int msbBitsAfter2xMinus1 = n - (1<<(x)) + 1;
            //reduce n size problem to n-2^x size subproblem
            n= n - (1<<x); //continue in next itr, till n becomes==0
            //incr cnt
            cnt+=setBitsTill2x+msbBitsAfter2xMinus1;
        } return cnt;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(countSetBits(3)); // Output: 4

        System.out.println(countSetBits(4));  // Output: 5
        System.out.println(countSetBits(5)); // Output: 7
        System.out.println(countSetBits(16)); // Output: 33

        System.out.println(countSetBits(17)); // Output: 35
        System.out.println(countSetBits(19)); // Output: 40

    }
}
// //Recursive soln., tried on gfg, works
// class Solution{
    
//     //Function to return sum of count of set bits in the integers from 1 to n.
// public static int countSetBits(int n) {
//     if (n == 0) return 0; //Base

//     // Get the highest power of 2 <= n
//     int x = highestPowerOf2(n);
    
//     // Calc. set bits in numbers from 1 to 2^x - 1
//     int bitsUpTo2X = x * (1 << (x - 1));

//     // Calc. the set bits in the MSB of remaining numbers
//     int msb2XToN = n - (1 << x) + 1;

//     // Recursively count the remaining bits
//     int remaining = n - (1 << x);
    
//     return bitsUpTo2X + msb2XToN + countSetBits(remaining);
// }

// // Fn to find the highest power of 2 <= 'n'
// public static int highestPowerOf2(int n) {
//     int x = 0;
//     while ((1 << x) <= n) x++;
//     return x - 1;
// }

// }
// //Dp soln top down, found on StackOverflow forum

// A quick search for the values of the sequence F lead to this integer sequence http://oeis.org/A000788

// There I spotted a formula: a(0) = 0, a(2n) = a(n)+a(n-1)+n, a(2n+1) = 2a(n)+n+1 (a is the same as F since I just copy the formula from oeis)

// which could be used to compute a(n) in log(n).

// Here's my sample C++ code:

// memset(cache, -1, sizeof(cache))
// cache[0] = 0

// int f(int n)
//     if cache[n] != -1 return cache[n];
//     cache[n] = n % 2 ? (2 * f(n / 2) + n / 2 + 1) : (f(n / 2) + f(n / 2 - 1) + n / 2)
// Share
// Improve this answer
// Follow
// answered Mar 21, 2012 at 22:26