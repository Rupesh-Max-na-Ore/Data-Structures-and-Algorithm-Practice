package Dynamic_Programming.lec1_Intro;
/*198. House Robber
Medium
Topics
Companies
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
Seen this question in a real interview before?
1/5
Yes
No
Accepted
2.5M
Submissions
4.9M
Acceptance Rate
51.6% */
public class q5_Max_sum_non_adjacents {
    public int rob(int[] a) {
        int n = a.length;
        int[]p = {0, a[0]};
        for(int i=0;i<n;i++){
            int e=a[i];
            int pick = e + ((i>1)?p[0]:0);
            int npick = p[1];
            int curr = Math.max(pick, npick);
            p[0]=p[1];
            p[1]=curr;
        } return p[1];
    }
}
