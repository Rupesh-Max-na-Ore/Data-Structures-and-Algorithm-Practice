package Greedy_Algorithms.Medium_Hard;
/*Q2 55. Jump Game
Medium
Topics
Companies
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
Seen this question in a real interview before?
1/5
Yes
No
Accepted
2M
Submissions
5.2M
Acceptance Rate
38.6% */
public class Jump_Game {
    public boolean canJump(int[] a) {
        int maxReach = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + a[i]);

            if(maxReach>=n) return true;
        }

        return true;
    }
}
