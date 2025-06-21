package Arrays.Easy;
//q12
// 136. Single Number
// Easy
// Topics
// Companies
// Hint
// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

import java.util.HashMap;

// You must implement a solution with a linear runtime complexity and use only constant extra space.

 

// Example 1:

// Input: nums = [2,2,1]
// Output: 1
// Example 2:

// Input: nums = [4,1,2,1,2]
// Output: 4
// Example 3:

// Input: nums = [1]
// Output: 1
 

// Constraints:

// 1 <= nums.length <= 3 * 104
// -3 * 104 <= nums[i] <= 3 * 104
// Each element in the array appears twice except for one element which appears only once.
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 2.8M
// Submissions
// 3.8M
// Acceptance Rate
// 72.9%
public class singleNo {
    
    public static int singleNumber(int[] nums) {//hm soln
        // HashMap<Integer,Integer> EF= new HashMap<>();
        // int i;
        // int L=nums.length;
        // for(i=0;i<L;i++){
        //     if(EF.containsKey(nums[i])){
        //         //if elem already prsnt overwrt its freq by incremented freq
        //         EF.put(nums[i],EF.get(nums[i])+1);
        //     }else{//if elem not prsnt, add with freq=1
        //         EF.put(nums[i],1);
        //     }
        // }
        // int keyi=-1;int f;
        // for (int key : EF.keySet()) {
        //     f = EF.get(key);
        //     if(f<2) {
        //         keyi=key;
        //         return keyi;
        //     }
            
        // }return keyi;

        // XOR soln, fastr
        int n = nums.length;

        // XOR all the elements:
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {0,0,1};
        //int k = 86;
        int sn=singleNo.singleNumber(arr);
        System.out.println("single no. = "+ sn);
    
        
    }
    
}
//lc hashmap soln submission, took lot of time
// class Solution {
//     public int singleNumber(int[] nums) {
//                 HashMap<Integer,Integer> EF= new HashMap<>();
//         int i;
//         int L=nums.length;
//         for(i=0;i<L;i++){
//             if(EF.containsKey(nums[i])){
//                 EF.put(nums[i],EF.get(nums[i])+1);
//             }else{
//                 EF.put(nums[i],1);
//             }
//         }
//         int keyi=-1;int f;
//         for (int key : EF.keySet()) {
//             f = EF.get(key);
//             if(f<2) {
//                 keyi=key;
//                 return keyi;
//             }
            
//         }return keyi;

        
//     }
// }

//lc XOR submission

// class Solution {
//     public int singleNumber(int[] nums) {
//         int n = nums.length;
//         int ans = 0;
//         for (int i = 0; i < n; i++) {
//             ans = ans ^ nums[i];
//         }
//         return ans; 
        
//     }
//}