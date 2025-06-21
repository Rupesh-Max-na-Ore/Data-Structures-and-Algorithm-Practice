//q4
// 26. Remove Duplicates from Sorted Array
// Easy
// Topics
// Companies
// Hint
// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

// Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

// Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
// Return k.
// Custom Judge:

// The judge will test your solution with the following code:

// int[] nums = [...]; // Input array
// int[] expectedNums = [...]; // The expected answer with correct length

// int k = removeDuplicates(nums); // Calls your implementation

// assert k == expectedNums.length;
// for (int i = 0; i < k; i++) {
//     assert nums[i] == expectedNums[i];
// }
// If all assertions pass, then your solution will be accepted.

 

// Example 1:

// Input: nums = [1,1,2]
// Output: 2, nums = [1,2,_]
// Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).
// Example 2:

// Input: nums = [0,0,1,1,1,2,2,3,3,4]
// Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
// Explanation: Your function should return k = 5, 
// with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).
 

// Constraints:

// 1 <= nums.length <= 3 * 104
// -100 <= nums[i] <= 100
// nums is sorted in non-decreasing order.
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 4.3M
// Submissions
// 7.7M
// Acceptance Rate
// 55.8%

package Arrays.Easy;

import java.util.Arrays;

public class removeDuplicates {
    removeDuplicates(int[]A){
        slidingRemoval(A);
    }

    private void slidingRemoval(int[] a) {
        int k=0;
        int l=0;
        int r=1;
        int i;
        int n= a.length;
        int []b=new int[n];
        //if((n>1)){

        for(i=1;i<=n;i++){
            if(a[l]!=a[r%n]){
                b[k]=a[l]; k++;
                l=r;
                r++;

            }else{
                r++;
            }
            if(r==l) {
            //     b[k]=a[l];
            //     k++;
                break;}
        }//}else{k=1;}
        if(n>0 && k==0){ 
            b[k]=a[l];
            k=1;
        }
        System.out.println("Original array: " + Arrays.toString(a));
        for(int j=0;j<n;j++){
            a[j]=b[j];
        }
        // if(n>0 && k==0){ k=1;}
        System.out.println("Mod array: " + Arrays.toString(b));
        System.out.println("Copy back array: " + Arrays.toString(a));
        System.out.println("No.of unique elems.= "+k);
    }

    public static void main(String[] args) {
        int[] arr = {1};
        removeDuplicates rd = new removeDuplicates(arr);
    }
}
//LC submission
// class Solution {
//     public int removeDuplicates(int[] nums) {
//         int k=0;
//         int l=0;
//         int r=1;
//         int i;
//         int n= nums.length;
//         int []b=new int[n];
//         for(i=1;i<=n;i++){
//             if(nums[l]!=nums[r%n]){
//                 b[k]=nums[l];k++;
//                 l=r;
//                 r++;
//             }else{
//                 r++;
//             }
//         }
        
//         for(int j=0;j<n;j++){
//             nums[j]=b[j];
//         }
//         return k;
        
//     }
// }

//Optimized LC soln
// public class Solution {
//     public int removeDuplicates(int[] nums) {
//         if (nums.length == 0) {
//             return 0;
//         }

//         int k = 1; // Initialize the count of unique elements to 1
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] != nums[k - 1]) {
//                 nums[k] = nums[i]; // Overwrite the next unique element
//                 k++;
//             }
//         }
        
//         return k;
//     }
// }