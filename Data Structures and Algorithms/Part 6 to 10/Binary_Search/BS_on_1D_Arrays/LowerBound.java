package Binary_Search.BS_on_1D_Arrays;
/*
 * Q2
 * Implement Lower Bound

Problem Statement: Given a sorted array of N integers and an integer x, 
write a program to find the lower bound of x.

Pre-requisite: Binary Search algorithm

Examples
Example 1:
Input Format:
 N = 4, arr[] = {1,2,2,3}, x = 2
Result:
 1
Explanation:
 Index 1 is the smallest index such that arr[1] >= x.

Example 2:
Input Format:
 N = 5, arr[] = {3,5,8,15,19}, x = 9
Result:
 3
Explanation:
 Index 3 is the smallest index such that arr[3] >= x.
 */
public class LowerBound {
    //== finding floor/LUB
    public static int lowerBound(int[]a, int n, int k)
    {
        int l=0; int r=n-1; int LUB=n; // Random Ini.
        while(l<=r)
        {
            int m = l+(r-l)/2;
            if(a[m]<k) l=m+1;
            else if(a[m]>=k) 
            {
                LUB=m;
                r=m-1;
            }
        }
        return LUB;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int n = 5, x = 9;
        int ind = lowerBound(arr, n, x);
        System.out.println("The lower bound is the index: " + ind);
    }
    
}
