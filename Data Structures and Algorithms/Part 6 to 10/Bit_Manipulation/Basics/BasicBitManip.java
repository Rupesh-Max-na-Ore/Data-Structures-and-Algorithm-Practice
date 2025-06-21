package Bit_Manipulation.Basics;
/*Q1 Bit Manipulation
EasyAccuracy: 49.84%Submissions: 17K+Points: 2
Be the comment of the day in POTD and win a GfG T-Shirt!
Solve right now

banner
Given a 32 bit unsigned integer num and an integer i. Perform following operations on the number - 

1. Get ith bit

2. Set ith bit

3. Clear ith bit

Note : For better understanding, we are starting bits from 1 instead 0. (1-based)

Example 1:

Input: 70 3
Output: 1 70 66
Explanation: Bit at the 3rd position from LSB is 1. (1 0 0 0 1 1 0)
The value of the given number after setting the 3rd bit is 70. 
The value of the given number after clearing 3rd bit is 66. (1 0 0 0 0 1 0)
Example 2:

Input: 8 1
Output: 0 9 8
Explanation: Bit at the first position from LSB is 0. (1 0 0 0)
The value of the given number after setting the 1st bit is 9. (1 0 0 1)
The value of the given number after clearing 1st bit is 8. (1 0 0 0)
 

Your Task:

Complete the function bitManipulation() which takes two integers num and i as input and prints the results after each operation separted by a space in the same line. You don't have to print any new lines after printing the output, that will be handled by driver code.

 

Constraints:

0<=num<=109

1<=i<=32

  */
public class BasicBitManip {
    static void bitManipulation(int num, int i) {
        // code here
        // 1. get ith bit
        int ithbit;
        if((num & (1<<(i-1)))!=0) ithbit=1;
        else ithbit = 0; 
        System.out.print(ithbit+" ");
        //2. set ith bit
        num=num|(1<<(i-1));
        System.out.print(num+" ");
        //3. clear ith bit
        num=num&(~(1<<(i-1)));
        System.out.print(num);

    }
}
