package Bit_Manipulation.Interview_Problems;
/*Q5 Two numbers with odd occurrences
MediumAccuracy: 49.49%Submissions: 44K+Points: 4
Be the comment of the day in POTD and win a GfG T-Shirt!
Solve right now

banner
Given an unsorted array, Arr[] of size N and that contains even number of occurrences for all numbers except two numbers. Find the two numbers in decreasing order which has odd occurrences.

Example 1:

Input:
N = 8
Arr = {4, 2, 4, 5, 2, 3, 3, 1}
Output: {5, 1} 
Explaination: 5 and 1 have odd occurrences.

Example 2:

Input:
N = 8
Arr = {1 7 5 7 5 4 7 4}
Output: {7, 1}
Explaination: 7 and 1 have odd occurrences.

Your Task:
You don't need to read input or print anything. Your task is to complete the function twoOddNum() which takes the array Arr[] and its size N as input parameters and returns the two numbers in decreasing order which have odd occurrences.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
2 ≤ N ≤ 106
1 ≤ Arri ≤ 1012

 */
public class TwoOddOccurrences {
    public int[] twoOddNum(int a[], int n)
    {
        long xor=0; 
        //1. get the xor of 2 nos.
        for(int i=0;i<n;i++) xor^=a[i];
        //2. get rightmost set bit, indicating difference, as both nos.distict
        //long rightmostSet= (xor&(xor-1))^xor;// (xor&(xor-1)) clears right most set bit, the &xor re-extracts it
        long rightmostSet= xor&(-xor);
        //3. iterate, put in different buckets based on the righmost bit set or unset
        long b0=0; long b1=0;
        for(int i=0;i<n;i++){
            if((rightmostSet & a[i]) == 0) b0^=a[i];
            else b1^=a[i];
        } 
        // Ensure the result is in decreasing order
        if (b0 > b1) return new int[]{(int)b0, (int)b1};
        else return new int[]{(int)b1, (int)b0};
        
    }
}
