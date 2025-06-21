package Binary_Search.BS_on_1D_Arrays;
/*
 * Q3
 * Implement Upper Bound

Problem Statement: Given a sorted array of N integers and an integer x, 
write a program to find the upper bound of x.

Pre-requisite: Binary Search algorithm

Examples
Example 1:
Input Format:
 N = 4, arr[] = {1,2,2,3}, x = 2
Result:
 3
Explanation:
 Index 3 is the smallest index such that arr[3] > x.

Example 2:
Input Format:
 N = 6, arr[] = {3,5,8,9,15,19}, x = 9
Result:
 4
Explanation:
 Index 4 is the smallest index such that arr[4] > x.
 */
public class UpperBound {

    public static int upperBound(int[] a, int x, int n) {
        // Basically, to find a the Least Strictly Greater no. in a[] than x
        int l=0; int r=n-1; int ub=-1;//Var. Ini.
        while(l<=r){
            int m=l+(r-l)/2;
            if(a[m]<=x) l=m+1; // Narrow search range to left subspace
            else if(a[m]>x)
            {
                ub=m;// m might be ub
                r=m-1; // Try to find a new-ub < curr-ub, that is still >x
            }
        }
        return ub;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 15, 19}; 
        int n = 6, x = 9;
        int ind = upperBound(arr, x, n);
        System.out.println("The upper bound is the index: " + ind);
    }
    
}
