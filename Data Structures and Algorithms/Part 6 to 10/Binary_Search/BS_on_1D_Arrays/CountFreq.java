package Binary_Search.BS_on_1D_Arrays;
/*
 * Q7
 * Count Occurrences in Sorted Array
Problem Statement: You are given a sorted array containing N integers and a number X, 
you have to find the occurrences of X in the given array.

Examples
Example 1:
Input:
 N = 7,  X = 3 , array[] = {2, 2 , 3 , 3 , 3 , 3 , 4}
Output
: 4
Explanation:
 3 is occurring 4 times in 
the given array so it is our answer.

Example 2:
Input:
 N = 8,  X = 2 , array[] = {1, 1, 2, 2, 2, 2, 2, 3}
Output
: 5
Explanation:
 2 is occurring 5 times in the given array so it is our answer.
 */

public class CountFreq {

    public int count(int[] a, int n, int k) {
        int fst= FirstOcc(a,a.length,k);
        int lst= LastOcc(a,a.length,k);
        int freq=(lst==-1||fst==-1)? 0:(lst-fst+1);
        return freq;
    }
    
    private int LastOcc(int[] a, int n, int k) {
        int l=0; int r=n-1; int lst=-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(a[m]<k) l=m+1;
            else if(a[m]>k) r=m-1;
            else if(a[m]==k){
                lst=m;
                l=m+1;//try to find a elem = k, righter still
            }
        }
        return lst;
    }

    private int FirstOcc(int[] a, int n, int k) {
        int l=0; int r=n-1; int fst=-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(a[m]<k) l=m+1;
            else if(a[m]>k) r=m-1;
            else if(a[m]==k){
                fst=m;
                r=m-1;//try to find a elem = k, lefter still
            }
        }
        return fst;
    }

    public static void main(String[] args) {
        CountFreq countFreq = new CountFreq();
        int[] arr = {2, 4, 4, 4, 6, 6, 7, 8, 8, 10};
        int k = 4;
        int count = countFreq.count(arr, arr.length, k);
        System.out.println("Number of occurrences of " + k + " is: " + count);
    }
}

// //gfg submission
// class Solution {
//     int count(int[] a, int n, int k) {
//         int fst= FirstOcc(a,a.length,k);
//         int lst= LastOcc(a,a.length,k);
//         int freq=(lst==-1||fst==-1)? 0:(lst-fst+1);
//         return freq;
//     }
//     private int LastOcc(int[] a, int n, int k) {
//         int l=0; int r=n-1; int lst=-1;
//         while(l<=r){
//             int m=l+(r-l)/2;
//             if(a[m]<k) l=m+1;
//             else if(a[m]>k) r=m-1;
//             else if(a[m]==k){
//                 lst=m;
//                 l=m+1;//try to find a elem = k, righter still
//             }
//         }
//         return lst;
//     }

//     private int FirstOcc(int[] a, int n, int k) {
//         int l=0; int r=n-1; int fst=-1;
//         while(l<=r){
//             int m=l+(r-l)/2;
//             if(a[m]<k) l=m+1;
//             else if(a[m]>k) r=m-1;
//             else if(a[m]==k){
//                 fst=m;
//                 r=m-1;//try to find a elem = k, lefter still
//             }
//         }
//         return fst;
//     }
// }