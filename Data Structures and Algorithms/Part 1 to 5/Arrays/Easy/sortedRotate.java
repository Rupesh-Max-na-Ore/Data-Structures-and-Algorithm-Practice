package Arrays.Easy; //q3
// LC
// 1752. Check if Array Is Sorted and Rotated
// Easy
// Topics
// Companies
// Hint
// Given an array nums, return true if the array was originally sorted in non-decreasing order, 
// then rotated some number of positions (including zero). Otherwise, return false.

import java.util.Arrays;

// There may be duplicates in the original array.

// Note: An array A rotated by x positions results in an array B of the same length 
// such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

 

// Example 1:

// Input: nums = [3,4,5,1,2]
// Output: true
// Explanation: [1,2,3,4,5] is the original sorted array.
// You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
// Example 2:

// Input: nums = [2,1,3,4]
// Output: false
// Explanation: There is no sorted array once rotated that can make nums.
// Example 3:

// Input: nums = [1,2,3]
// Output: true
// Explanation: [1,2,3] is the original sorted array.
// You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 

// Constraints:

// 1 <= nums.length <= 100
// 1 <= nums[i] <= 100
public class sortedRotate {

    sortedRotate(int[] a){
        rotateCheck(a);
    }

    public boolean rotateCheck(int[] A){
        
            int count = 0, n = A.length;
            for (int i = 1; i < n; ++i) {
                if (A[i-1] > A[i]) {
                    count++;
                }
                if (count > 1) { //exit if count already exceed 1
                    System.out.println("Not Sorted/Roatated");
                    return false;
                }
            }
            if (A[0]<A[n-1]) count++;
            if (count > 1) {
                System.out.println("Not Sorted/Roatated");
                return false;
            }
            if (count==0) System.out.println("Sorted");
            if (count==1) System.out.println("Rotated");
            return true;
        
        

    }

    public static void main(String[] args) {
        int[] a1 = {1, 8, 7, 56, 90};
        int[] a2 = {3, 4, 5, 1, 2};
        
        System.out.println("Original array: " + Arrays.toString(a1));

        sortedRotate r1=new sortedRotate(a1);

        System.out.println("Original array: " + Arrays.toString(a2));
        sortedRotate r2=new sortedRotate(a2);
        
    }
    
}


//LC submission
// class Solution {
//     public boolean check(int[] nums) {

            
//         int count = 0, n = nums.length;
//         for (int i = 0; i < n; ++i) {
//             if (nums[i] > nums[(i + 1) % n]) {//elegant way to compare A[0]<A[n-1] within loop itself
//                 count++;
//             }
//             if (count > 1) {
//                 return false;
//             }
//         }
//         return true;
//     }
        
    
// }