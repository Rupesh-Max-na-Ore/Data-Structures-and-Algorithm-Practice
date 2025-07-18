package Bit_Manipulation.Basics;
/*Q2 Check whether K-th bit is set or not
EasyAccuracy: 52.75%Submissions: 166K+Points: 2
Given a number N and a bit number K, check if Kth index bit of N is set or not. A bit is called set if it is 1. Position of set bit '1' should be indexed starting with 0 from LSB side in binary representation of the number.
Note: Index is starting from 0. You just need to return true or false, driver code will take care of printing "Yes" and "No".

Example 1:

Input: 
N = 4
K = 0
Output: 
No
Explanation: 
Binary representation of 4 is 100, in which 0th index bit from LSB is not set. So, return false.
Example 2:

Input: 
N = 4
K = 2
Output: 
Yes
Explanation: 
Binary representation of 4 is 100, in which 2nd index bit from LSB is set. So, return true.
Example 3:

Input: 
N = 500
K = 3
Output: 
No
Explanation: 
Binary representation of 500 is 111110100, in which 3rd index bit from LSB is not set. So, return false.
Your task:
You don't have to read input or print anything. Your task is to complete the function checkKthbit that takes n and k as parameters and returns either true(if kth bit is set) or false(if kth bit is not set).

Expected Time Complexity: O(1).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 109
0 ≤ K ≤ 31 */
public class CheakIfKthBitSet {
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k)
    {
        // Your code here
        //Wrong attempt
        //if(n & (1<<k) == (1<<k)) return true;
        //right attempt, don't forget parenthesis
        //if((n & (1<<k)) == (1<<k)) return true;
        //best attempt
        if((n & (1<<k)) != 0) return true;
        return false; //else
    }
    public static void main(String[] args) {
        // Test cases
        System.out.println(checkKthBit(4, 0)); // Output: false
        System.out.println(checkKthBit(4, 2)); // Output: true
        System.out.println(checkKthBit(500, 3)); // Output: false
    }
}
