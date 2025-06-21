package Binary_Search.BS_on_1D_Arrays;
/*
 * Q8
 * Search Element in a Rotated Sorted Array with distinct values
    Q9
    Same but with duplicates

Problem Statement: Given an integer array arr of size N, 
sorted in ascending order (with distinct values) and a target value k. 
Now the array is rotated at some pivot point unknown to you. 
Find the index at which k is present and if k is not present return -1.

Examples
Example 1:
Input Format: arr = [4,5,6,7,0,1,2,3], k = 0
Result: 4
Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.

Example 2:
Input Format: arr = [4,5,6,7,0,1,2], k = 3
Result: -1
Explanation: Here, the target is 3. Since 3 is not present in the given rotated sorted array. Thus, we get the output as -1.
 */
public class SearchRotatedArray {
    public int search(int[] a, int k) {
    int l=0; int r=a.length-1;
    while(l<=r){
        int m=l+(r-l)/2;
        if(a[m]==k) return m;

        //if duplicates exist
        if (a[l]==a[r] && a[r]==a[m]){
            //shift ptrs inward
            l++;
            r--;
            continue; //(keep doing this) skip this itr L-R checking, recalc M, start again
        }

        //if L subarr sorted
        if(a[l]<=a[m]){
            if(a[l]<=k && k<=a[m]){
                r=m-1; // eliminate R subarr
            }
            else{
                l=m+1; // eliminate L subarr
            }
        }

        //if R subarr sorted
        if(a[m]<=a[r]){
            if(a[m]<=k && k<=a[r]){
                l=m+1; // eliminate L subarr
            }
            else{
                r=m-1; // eliminate R subarr
            }
        }
    }
    return -1;    
    }
    
}
// exact same code is LC submission for (i)
// LC submission for (ii)
// class Solution {
//     public boolean search(int[] a, int k) {
//         int l=0; int r=a.length-1;
//     while(l<=r){
//         int m=l+(r-l)/2;
//         if(a[m]==k) return true;

//         //if duplicates exist
//         if (a[l]==a[r] && a[r]==a[m]){
//             //shift ptrs inward
//             l++;
//             r--;
//             continue; //(keep doing this) skip this itr L-R checking, recalc M, start again
//         }

//         //if L subarr sorted
//         if(a[l]<=a[m]){
//             if(a[l]<=k && k<=a[m]){
//                 r=m-1; // eliminate R subarr
//             }
//             else{
//                 l=m+1; // eliminate L subarr
//             }
//         }

//         //if R subarr sorted
//         if(a[m]<=a[r]){
//             if(a[m]<=k && k<=a[r]){
//                 l=m+1; // eliminate L subarr
//             }
//             else{
//                 r=m-1; // eliminate R subarr
//             }
//         }
//     }
//     return false; 
//     }
// }