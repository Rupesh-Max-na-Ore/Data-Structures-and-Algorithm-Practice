//q11
// 485. Max Consecutive Ones
// Solved
// Easy
// Topics
// Companies
// Hint
// Given a binary array nums, return the maximum number of consecutive 1's in the array.

 

// Example 1:

// Input: nums = [1,1,0,1,1,1]
// Output: 3
// Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
// Example 2:

// Input: nums = [1,0,1,1,0,1]
// Output: 2
 

// Constraints:

// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 1.2M
// Submissions
// 2M
// Acceptance Rate
// 59.1%


package Arrays.Easy;


public class maxConsec1s {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int r=0; int cnt=0; int max=0; int n=nums.length;
        while(r<n){
            if(nums[r]==1) cnt++;
            else cnt=0;
            max=(cnt>max)?cnt:max;
            r++;
        }return max;

        
    }
    public static void main(String[] args) {
        int[] arr = {0,1,1,0,0,1,1,1,0};
        //int k = 86;
        int max1s=maxConsec1s.findMaxConsecutiveOnes(arr);
        System.out.println("max. consec. 1's = "+ max1s);
    
        
    }
}

//lc submission 1
// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {
//                 int l=0; int r=0; int cnt=0; int max=0; int n=nums.length;
//         while(r<n){
//             if(nums[l]==nums[r]){
//                 r++;
//                 if(nums[r-1]==1) cnt++;
//                 if(cnt>max) {max=cnt; }
//             }else{
//                 l=r;
               
//                 cnt=0;
//             }
//         }return max;

//     }
//}

//lc submission 2

// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {
//         int r=0; int cnt=0; int max=0; int n=nums.length;
//         while(r<n){
//             if(nums[r]==1) cnt++;
//             else cnt=0;
//              max=(cnt>max)?cnt:max;

//             r++;
//         }return max;

//     }
// }

// lc soln by sb else, little faster due to some reason
// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums)
//     {
//         // Initialize variables to track the maximum count and current count of consecutive 1s
//         int maxCount=0;
//         int curCount=0;

//         // Iterate through each element in the array
//         for(int element: nums){
//             if(element==0){
//         //reset curCount and maxCount whenever 0 is encountered.
//                 if(maxCount<curCount){
//                     maxCount=curCount;
//                 }
//                 curCount=0;                
//             }
//             else{
//                 curCount++;
//             }
//         }
//         // After the loop, compare the final current count with the maximum count and return the larger value
//         return maxCount>curCount? maxCount:curCount;
        
//     }
// }

//lc submission 3, takes little lesser memory replacing if with ?
// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums)
//     {
//         int maxCount=0;
//         int curCount=0;

//         for(int element: nums){
//             if(element==0){  
//                 maxCount=(maxCount<curCount)?curCount:maxCount;
//                 curCount=0;                
//             }
//             else{
//                 curCount++;
//             }
//         }
//         return maxCount>curCount? maxCount:curCount;
        
//     }
// }