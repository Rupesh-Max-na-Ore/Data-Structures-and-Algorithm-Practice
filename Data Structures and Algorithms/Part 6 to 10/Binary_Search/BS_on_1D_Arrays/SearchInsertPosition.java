package Binary_Search.BS_on_1D_Arrays;
/*
 * Q4
 * Search Insert Position

Problem Statement: You are given a sorted array arr of distinct values and a target value x. 
You need to search for the index of the target value in the array.

If the value is present in the array, then return its index. 
Otherwise, determine the index where it would be inserted in the array while maintaining the sorted order.

Pre-requisite: Lower Bound & Binary Search

Example 1:
Input Format: arr[] = {1,2,4,7}, x = 6
Result: 3
Explanation: 6 is not present in the array. 
So, if we will insert 6 in the 3rd index(0-based indexing), the array will still be sorted. {1,2,4,6,7}.

Example 2:
Input Format: arr[] = {1,2,4,7}, x = 2
Result: 1
Explanation: 2 is present in the array and so we will return its index i.e. 1.
 */
public class SearchInsertPosition {
    /* This problem is == to LUB/floor finding if there does not exist x in a[], else it is just searching */ 
    public static int searchInsertPos(int [] a, int x) {
        int n=a.length;
        int l=0; int r=n-1; int sip=-1; //Ini. Vars.
        while (l<=r) {
            int m=l+(r-l)/2;

            if(a[m]<x) l=m+1; // narrow srch space to right subspace

            else if(a[m]==x) {
                System.out.println(" Exact Match found at: "+m);
                return m;
            }

            else if(a[m]>x){
                sip=m; // might be the apt Insert pos index in a[]
                r=m-1; // try to find least greater sip, by narrowing srch space to left subspace that still satisfy a[m]>x
            }

        }
        System.out.println(" Elem must be inserted at: "+sip);
        return sip;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7};
        int x = 6;
        int ind = searchInsertPos(arr, x);
        System.out.println("The index is: " + ind);
    }
}
