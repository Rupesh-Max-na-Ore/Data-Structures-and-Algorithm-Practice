package Arrays.Easy;
//q5 & q6
// 189. Rotate Array
// Medium
// Topics
// Companies
// Hint
// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

// Example 1:

// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
// Example 2:

// Input: nums = [-1,-100,3,99], k = 2
// Output: [3,99,-1,-100]
// Explanation: 
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]
 

// Constraints:

// 1 <= nums.length <= 105
// -231 <= nums[i] <= 231 - 1
// 0 <= k <= 105
 

// Follow up:

// Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
// Could you do it in-place with O(1) extra space?
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 2.1M
// Submissions
// 5.3M
// Acceptance Rate
// 40.6%
import java.util.Arrays;

public class rotatebyK {

    rotatebyK(int [] nums, int k){
        rotatebyKsteps(nums,k);
    }

    private void rotatebyKsteps(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        int [] b=Arrays.copyOfRange(nums,n-k,n);
        System.out.println("Copy b array: " + Arrays.toString(b));

        int i;
        System.out.println("Original array: " + Arrays.toString(nums));

        //for(i=0;i<n-k;i++)
        for(i=n-1-k;i>=0;i--)
        {
            nums[i+k]=nums[i];
        }
        for(i=0;i<k;i++){
            nums[i]=b[i];
        }
        System.out.println("Mod array: " + Arrays.toString(nums));

        
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7}; int k=3;
        rotatebyK rd = new rotatebyK(arr,k);
    }
    
}
//lc submission
        // int n=nums.length;
        // k=k%n;
        // int [] b=Arrays.copyOfRange(nums,n-k,n);

        // int i;

        // for(i=n-1-k;i>=0;i--)
        // {
        //     nums[i+k]=nums[i];
        // }
        // for(i=0;i<k;i++){
        //     nums[i]=b[i];
        // }
//lc fast soln
// class Solution {
//     public void rotate(int[] nums, int k) {
//         k = k % nums.length;   
//         // find reminder of k divided by nums.length because k is more than nums.length we don't need to iterate huge iterations.
//         reverse(nums,0,nums.length-1);  // first of all reverse entire the array.
//         reverse(nums,0,k-1);   // reverse the array from 0th index to k-1 index.
//         reverse(nums,k,nums.length-1);   // reverse the array from kth index to araay.length-1 index.
//     }
//     void reverse(int[] nums,int i,int j){   // Create a reverse function to reverse array from ith position to jth position.
//         while(i<j){
//             swap(nums,i,j);
//             i++;
//             j--;
//         }
//     }
//     void swap(int[] nums,int i,int j){   // Create a swap function to swap to array elements.
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }