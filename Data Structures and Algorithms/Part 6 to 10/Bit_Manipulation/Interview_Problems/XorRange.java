package Bit_Manipulation.Interview_Problems;
/*Q4 Find XOR of numbers from L to R.
EasyAccuracy: 50.0%Submissions: 15K+Points: 2
Be the comment of the day in POTD and win a GfG T-Shirt!
Solve right now

banner
You are given two integers L and R, your task is to find the XOR of elements of the range [L, R].

Example:

Input: 
L = 4, R = 8 
Output:
8 
Explanation:
4 ^ 5 ^ 6 ^ 7 ^ 8 = 8
Your Task:

Your task is to complete the function findXOR() which takes two integers l and r and returns the XOR of numbers from l to r.

Expected Time Complexity: O(1).

Expected Auxiliary Space: O(1).

Constraints:

1<=l<=r<=109 */
public class XorRange {
    public static int findXORfromLtoR(int l, int r) {
        return findXORfrom0toN(l-1) ^ findXORfrom0toN(r);
    }

    private static int findXORfrom0toN(int n) {
        if(n%4 == 0) return n;
        else if(n%4 == 1) return 1;
        else if(n%4 == 2) return n+1;
        //else if(n%4 == 3) return 0;
        return 0;
    }
}
