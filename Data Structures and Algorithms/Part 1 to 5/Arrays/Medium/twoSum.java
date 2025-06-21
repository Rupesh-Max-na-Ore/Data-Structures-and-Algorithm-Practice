package Arrays.Medium;
//import  Arrays.Easy;
//q1
// 1. Two Sum
// Easy
// Topics
// Companies
// Hint
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

 

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]
 

// Constraints:

// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.
 

// Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 13.1M
// Submissions
// 25M
// Acceptance Rate
// 52.6%
import Arrays.Easy.Search;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSum {

    public static int[] twoSumI(int[] nums, int target) {
        //way 3
        // //correct soln. but works for positive nos. array only
        // int n=nums.length;
        // int c[]=Arrays.copyOf(nums,n);//arrayCopy = Arrays.copyOf(A, A.length);
        // System.out.println("unsorted in method input array: "+Arrays.toString(c));

        // Arrays.sort(nums);
        // System.out.println("SOrted array: "+Arrays.toString(nums));
        // int l=0;
        // int r=n-1; int sum=0;
        // int []b=new int[2];
        // b[0]=Integer.MIN_VALUE;b[1]=Integer.MIN_VALUE;
        // //b={0,0};
        // while(l<r){
        //     sum=nums[l]+nums[r];
        //     if (sum>target)r--;
        //     else if(sum<target)l--;
        //     else {
        //         int i;
        //         for(i=0;i<n;i++){
        //             if(b[0]==Integer.MIN_VALUE||b[1]==Integer.MIN_VALUE){
        //             if(c[i]==nums[l] && b[0]==Integer.MIN_VALUE) b[0]=i;
        //             else if(c[i]==nums[r] && b[1]==Integer.MIN_VALUE) b[1]=i;
        //             }else return b;
        //         }
        //     }
            
        // }return b; //never execute

        //way 2 using HYM, works for all cases
        Map<Integer,Integer> HM=new HashMap<>();
        int []b=new int[2];
        int i=0;
        int n=nums.length; int num=0; int moreNeed=0;
        while(i<n){
            num=nums[i];
            moreNeed=target-num;
            if(HM.containsKey(moreNeed)){
                int ii=HM.get(moreNeed);
                b[0]=(i>ii)?ii:i;
                b[1]=(i<ii)?ii:i;
                return b;
            }
            HM.put(nums[i],i);
            i++;
        }return b;//never executes


    }

        public static void main(String[] args) {
        int[] arr = {-440,10,22,35,47,58,69,73,86,420,42069};
        int k = 96;
    
        System.out.println("unsorted input array: "+Arrays.toString(arr));
        int []srchI=twoSum.twoSumI(arr, k);
        System.out.println("indices with sum "+k+" = "+ Arrays.toString(srchI));
        System.out.println();
    }
    

    
}

//lc submission 1
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//                 Map<Integer,Integer> HM=new HashMap<>();
//         int []b=new int[2];
//         int i=0;
//         int n=nums.length; int num=0; int moreNeed=0;
//         while(i<n){
//             num=nums[i];
//             moreNeed=target-num;
//             if(HM.containsKey(moreNeed)){
//                 int ii=HM.get(moreNeed);
//                 b[0]=(i>ii)?ii:i;
//                 b[1]=(i<ii)?ii:i;
//                 return b;
//             }
//             HM.put(nums[i],i);
//             i++;
//         }return b;//never executes

//     }
// }

//lc submission 2
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//                 Map<Integer,Integer> HM=new HashMap<>();
//         int []b=new int[2];
//         int i=0;
//         int n=nums.length;  
//         while(i<n){
//             if(HM.containsKey(target-nums[i])){
//                 b[0]=i;
//                 b[1]=HM.get(target-nums[i]);
//                 return b;
//             }
//             HM.put(nums[i],i);
//             i++;
//         }return b;

//     }
// }

//lc clever way to reduce avg no. of comparisons
//turns out to be faster than using HM std methods on java in posterior analysis
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//     int n = nums.length-1;
//     for (int i = 0; i <= n; i++) {
//         for (int j = i+1; j <= n; j++) {
//             if (nums[i] + nums[j] == target) {
//                 return new int[]{i, j};
//             }

//             if(nums[n-i]+nums[j]==target){
//                 return new int[]{n-i,j};
//             }
//         }
//     }
//     return new int[]{-1, -1};
// }
// }