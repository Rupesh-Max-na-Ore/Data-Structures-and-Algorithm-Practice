package Bit_Manipulation.Basics;
/*Q3 Odd or Even
SchoolAccuracy: 60.6%Submissions: 68K+Points: 0
Be the comment of the day in POTD and win a GfG T-Shirt!
Solve right now

banner
Given a positive integer N, determine whether it is odd or even.

Example 1:

Input:
N = 1
Output:
odd
Explanation:
The output is self-
explanatory.
 

Example 2:

Input:
N = 2
Output:
even
Explanation:
The output is self-
explanatory.
 

Your Task:

You don't need to read input or print anything. Your task is to complete the function oddEven() which takes the integer N and return "even" if number is even and "odd" if the number is odd.

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

Constraints:
0 <= N <= 10000

 */
public class OddOrEven {
    static String oddEven(int n){
        // code here
        if((n&1)==1) return "odd";
        //else
        return "even";
    }
}
