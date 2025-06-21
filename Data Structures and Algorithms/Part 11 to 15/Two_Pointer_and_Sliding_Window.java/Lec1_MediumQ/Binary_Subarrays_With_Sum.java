package Two_Pointer_and_Sliding_Window.java.Lec1_MediumQ;
/*Q5 930. Binary Subarrays With Sum
Medium
Topics
Companies
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 

Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length
Seen this question in a real interview before?
1/5
Yes
No
Accepted
249.3K
Submissions
395.3K
Acceptance Rate
63.1% */
public class Binary_Subarrays_With_Sum {
    //way 1, very general
    public int numSubarraysWithSum(int[] a, int goal) {
        return countSubarrSumLessThanEqualToGoal(a, a.length, goal) - countSubarrSumLessThanEqualToGoal(a, a.length, (goal-1));
    }

    private int countSubarrSumLessThanEqualToGoal(int[] a, int n, int goal) {
        if(goal<0) return 0;
        int l=0,r=0,cnt=0,sum=0;
        while(r<n){
            sum+=a[r];
            while(sum>goal){
                sum-=a[l];
                l++; //shrink
            }
            int subArrWithSameEndR= r-l+1; 
            cnt+=subArrWithSameEndR;
            r++;//expand
        } return cnt;
    }
}
// // LC submission way 2, more specific way due to binary nature of a[]
// class Solution {
//     public int numSubarraysWithSum(int[] a, int goal) {
//         int prefix_zeros = 0;
//         int window_sum = 0;
//         int cnt = 0;
        
//         int L = 0, R = 0;
        
//         while(R < a.length) {
//             window_sum += a[R];
            
//             // main modification from normal sliding winodw
//             while (L < R && (a[L] == 0 || window_sum > goal)) {
//                 if (a[L] == 1) {
//                     prefix_zeros = 0;
//                 } else {
//                     prefix_zeros += 1;
//                 }
                
//                 window_sum -= a[L];
//                 L++;
//             }
            
//             if (window_sum == goal) {
//                 cnt += 1 + prefix_zeros;
//             }
//             R++;
//         }
        
//         return cnt;
//     }
// }