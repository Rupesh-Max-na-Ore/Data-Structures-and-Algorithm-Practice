package Bit_Manipulation.Basics;
/*Q6 Set the rightmost unset bit
BasicAccuracy: 47.64%Submissions: 23K+Points: 1
Given a non-negative number N. 
The problem is to set the rightmost unset bit in the binary representation of N.

Example 1:

Input:
N = 6
Output:
7
Explanation:
The binary representation of 6 is 110.
After setting right most bit it becomes
111 which is 7.
Example 2:

Input:
N = 15
Output:
31
Explanation:
The binary representation of 15 is 01111.
After setting right most bit it becomes
11111 which is 31.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function setBit() which takes an integer N as input parameter and returns the integer after setting a rightmost unset bit.

Expected Time Complexity: O(LogN)
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 109 */
public class setRightMostUnsetBit {
    //step by step way
    static int setBit(int n){
        n = ~n; //1. flip n
        n = n & (n-1); //2. unset first set bit of curr n
        n = ~n; //3. re-flip n, unset bit becomes set (everything else reverts to normal)
        return n;

    }

    // direct way
    // static int setBit(int n){
    //     // find rightmost unset bit by flipping all bits of N then find rightmost set bit
    //     // use(~n & (~n-1)) to set the unset the set bit of ~n 
    //     // use ~ on whole to get the no. which is n with last unset bit setted
    //     return (~((~n)&((~n-1)))); 

    // }
    // First wrong attempt
    // static int setBit(int n){
    //     // find rightmost unset bit by flipping all bits of N then find rightmost set bit
    //     // use(~n & ~(n-1)) for 1 based bit 
    //     //make 0 based by 1 right shift
    //     // make this result bitwise OR with N to set that unset bit
    //     return (((~n)&(~(n-1))>>1)|(n)); 

    // }
}
