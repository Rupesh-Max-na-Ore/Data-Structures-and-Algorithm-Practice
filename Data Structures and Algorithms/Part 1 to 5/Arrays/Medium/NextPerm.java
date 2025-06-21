package Arrays.Medium;
//q8
// 31. Next Permutation
// Medium
// Topics
// Companies
// A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

import java.util.Arrays;

// For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
// The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

// For example, the next permutation of arr = [1,2,3] is [1,3,2].
// Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
// While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
// Given an array of integers nums, find the next permutation of nums.

// The replacement must be in place and use only constant extra memory.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [1,3,2]
// Example 2:

// Input: nums = [3,2,1]
// Output: [1,2,3]
// Example 3:

// Input: nums = [1,1,5]
// Output: [1,5,1]
 

// Constraints:

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 1.3M
// Submissions
// 3.4M
// Acceptance Rate
// 40.0%
public class NextPerm {

    public static void nextPermutation(int[] A) {
        int n=A.length;
        int i;
        //Find the breakpt.
        int brkpt=-1;
        //Traverse from R to L
        for(i=n-2;i>=0;i--){
            //CHeck if able to find a A[i]<A[i+1] --> the breakpt.
            if(A[i]<A[i+1]){
                brkpt=i;
                break;
            }
        }
        //if brkpt ain't changed, means it is at non decreasing order like 5,4,3,2,1,0,0
        // in that case next perm is just reverse
        if(brkpt==-1){
        // Reverse the array in-place(here) OR just asc sort the array using Arrays.sort(A)
        for (i = 0; i < n / 2; i++) {
            int temp = A[i];
            A[i] = A[n - 1 - i];
            A[n - 1 - i] = temp;
        }
        return;
        }

        // else we find the no. A[smallestBig] that least greater than A[brkpt]
        int smallestBig=i+1;
        for(i=brkpt+1;i<n;i++){
            // check 1st if no. > brkpt. elem. or not 1st
            if(A[i]>A[brkpt]){
                // uypdate smallestBig if ith elem smaller than smallestBig current val.
                smallestBig=(A[smallestBig]>A[i])?i:smallestBig;
            }
        }
        //it's impossible for smallestBig to not change
        //Swap smallestBig and brkpt elem.
        int temp = A[brkpt];
        A[brkpt] = A[smallestBig];
        A[smallestBig] = temp;

        //sort brkpt+1 to end subarray
        int start =brkpt+1; int end =n; // don't forget end is exclusive, start is inclusive
        Arrays.sort(A, start, end);
        
    }
    
    public static void main(String[] args) {
        int []a={4,3,2,1};
        ////{3,4,1,2}; // ans is 3421
        System.out.println("OG array: "+Arrays.toString(a));
        NextPerm.nextPermutation(a);
        System.out.println("Modified array: "+Arrays.toString(a));
    }
}

//lc submission, as lesser runtime
// class Solution {
//     public static void nextPermutation(int[] A) {
//     int n=A.length;
//     int i;
//     int brkpt=-1;
//     for(i=n-2;i>=0;i--){
//         if(A[i]<A[i+1]){
//             brkpt=i;
//             break;
//         }
//     }
//     if(brkpt==-1){
//     for (i = 0; i < n / 2; i++) {
//         int temp = A[i];
//         A[i] = A[n - 1 - i];
//         A[n - 1 - i] = temp;
//     }
//     return;
//     }

//     int smallestBig=i+1;
//     for(i=brkpt+1;i<n;i++){
//         if(A[i]>A[brkpt]){
//             smallestBig=(A[smallestBig]>=A[i])?i:smallestBig;
//         }
//     }
//     int temp = A[brkpt];
//     A[brkpt] = A[smallestBig];
//     A[smallestBig] = temp;
//     //Just reverse, O(n) instead of O(nlogn) to sort
//     for (i = brkpt+1; i <= n / 2 + brkpt/2; i++) {
//         temp = A[i];
//         A[i] = A[n - i + brkpt];
//         A[n - i +brkpt] = temp;
//     }
    
// }

// }


//slightly more modular soln I found a lc forum
// class Solution {
//     public void nextPermutation(int[] nums) {
//         int ind1=-1;
//         int ind2=-1;
//         // step 1 find breaking point 
//         for(int i=nums.length-2;i>=0;i--){
//             if(nums[i]<nums[i+1]){
//                 ind1=i;
//                 break;
//             }
//         }
//         // if there is no breaking  point 
//         if(ind1==-1){
//             reverse(nums,0);
//         }
        
//         else{
//             // step 2 find next greater element and swap with ind2
//             for(int i=nums.length-1;i>=0;i--){
//                 if(nums[i]>nums[ind1]){
//                     ind2=i;
//                     break;
//                 }
//             }

//             swap(nums,ind1,ind2);
//             // step 3 reverse the rest right half
//             reverse(nums,ind1+1);
//         }
//     }
//     void swap(int[] nums,int i,int j){
//         int temp=nums[i];
//         nums[i]=nums[j];
//         nums[j]=temp;
//     }
//     void reverse(int[] nums,int start){
//         int i=start;
//         int j=nums.length-1;
//         while(i<j){
//             swap(nums,i,j);
//             i++;
//             j--;
//         }
//     }
// }