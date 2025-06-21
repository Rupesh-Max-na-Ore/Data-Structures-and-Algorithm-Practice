package Arrays.Easy;
//q7
// 283. Move Zeroes
// Solved
// Easy
// Topics
// Companies
// Hint
// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

 

// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:

// Input: nums = [0]
// Output: [0]
 

// Constraints:

// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1
 

// Follow up: Could you minimize the total number of operations done?
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 3M
// Submissions
// 4.8M
// Acceptance Rate
// 61.8%
import java.util.Arrays;

public class moveZeroes {

    moveZeroes(int nums[])
    {
        moveZeroesToEnd(nums);
    }

    private void moveZeroesToEnd(int[] nums) {
        int k=0; int n=nums.length;
        System.out.println("Original array: " + Arrays.toString(nums));
        for(int i=0;i<n;i++){
            if(nums[i]!=0) nums[k++]=nums[i];
        } 
        System.out.println("Intermediate array: " + Arrays.toString(nums));
        for(int i=k;i<n;i++) nums[i]=0;
        System.out.println("Final array: " + Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] arr = {0};//{1,0,2,3,4,0,5,6,7};
        moveZeroes rd = new moveZeroes(arr);
    }

    
}
//lc submission
// class Solution {
//     public void moveZeroes(int[] nums) {
//         int k=0; int n=nums.length;
//         for(int i=0;i<n;i++){
//             if(nums[i]!=0) nums[k++]=nums[i];
//         } 
//         for(int i=k;i<n;i++) nums[i]=0;
        
//     }
// }

//lc snowball approach
// class Solution {
//     public void moveZeroes(int[] nums) {
//        int snowBallSize = 0; 
//        for (int i=0;i<nums.length;i++){
//            if (nums[i]==0){
//                snowBallSize++; 
//            }
//            else if (snowBallSize > 0) {
            //    int t = nums[i];//
            //    nums[i]=0;//
            //    nums[i-snowBallSize]=t;//
    //         nums[i-snowBallSize]=nums[i];
    // nums[i]=0;
//            }
//        }
//    }
// }

//lc 2 ptr soln
// class Solution {
//     public void moveZeroes(int[] nums) {
//         int left = 0;

//         for (int right = 0; right < nums.length; right++) {
//             if (nums[right] != 0) {
                   //swap 
//                 int temp = nums[right];
//                 nums[right] = nums[left];
//                 nums[left] = temp;
//                 left++;
//             }
//         }        
//     }
// }