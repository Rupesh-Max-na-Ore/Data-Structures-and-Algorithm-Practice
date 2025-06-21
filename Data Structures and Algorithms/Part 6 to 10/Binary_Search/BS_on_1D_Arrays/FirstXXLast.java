package Binary_Search.BS_on_1D_Arrays;
/*
 * Q6
 * 34. Find First and Last Position of Element in Sorted Array
Solved
Medium

Given an array of integers nums sorted in non-decreasing order, 
find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

Accepted
2M
Submissions
4.6M
Acceptance Rate
44.4%
 */
public class FirstXXLast {

    public int[] searchRange(int[] a, int k) {
        int fst= FirstOcc(a,a.length,k);
        int lst= LastOcc(a,a.length,k);
        return new int[]{fst,lst};
    }

    private int LastOcc(int[] a, int n, int k) {
        int l=0; int r=n-1; int lst=-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(a[m]<k) l=m+1;
            else if(a[m]>k) r=m-1;
            else if(a[m]==k){
                lst=(m>lst)? m:lst; // this check is not needed
                l=m+1;//try to find a elem = k, righter still
            }
        }
        return lst;
    }

    private int FirstOcc(int[] a, int n, int k) {
        int l=0; int r=n-1; int fst=n;
        while(l<=r){
            int m=l+(r-l)/2;
            if(a[m]<k) l=m+1;
            else if(a[m]>k) r=m-1;
            else if(a[m]==k){
                fst=(m<fst)? m:fst; //this check is not needed
                r=m-1;//try to find a elem = k, lefter still
            }
        }if(fst==n) return -1;
        return fst;
    }
    public static void main(String[] args) {
        FirstXXLast solution = new FirstXXLast();
        int[] arr = {5, 7, 7, 8, 8, 10};
        int k = 8;
        int[] result = solution.searchRange(arr, k);
        System.out.println("First and last occurrence of " + k + " are at indices: " + result[0] + " and " + result[1]);
    }
}

// //lc submission, bettered the code
// class Solution {
//     public int[] searchRange(int[] a, int k) {
//         // int fst= FirstOcc(a,a.length,k);
//         // int lst= LastOcc(a,a.length,k);
//         return new int[]{FirstOcc(a,a.length,k),LastOcc(a,a.length,k)};
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