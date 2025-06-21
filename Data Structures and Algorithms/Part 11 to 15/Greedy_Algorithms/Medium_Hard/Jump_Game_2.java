package Greedy_Algorithms.Medium_Hard;
/*Q3 45. Jump Game II
Medium
Topics
Companies
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.3M
Submissions
3.3M
Acceptance Rate
40.6% */
public class Jump_Game_2 {
    public int jump(int[] a) {
        int n =a.length;
        int l=0,r=0;
        int jmps=0;
        while(r<n-1){
            int farthest=0;
            for(int i=l;i<=r;i++){
                farthest = Math.max(farthest, i+a[i]);
            }
            jmps++;
            l=r+1;
            r=farthest;
        }
        return jmps;
    }
}
