package Dynamic_Programming.lec1_Intro;
/*213. House Robber II
Medium
Topics
Companies
Hint
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000
Seen this question in a real interview before?
1/5
Yes
No
Accepted
864.1K
Submissions
2M
Acceptance Rate
42.7% */
public class q6_House_Robber_2 {
    public int robs(int[] a, int n, int start) {
        //int n = a.length;
        int[]p = {0, a[start]};
        for(int i=start+1;i<n;i++){
            int e=a[i];
            int pick = e + ((i>1)?p[0]:0);
            int npick = p[1];
            int curr = Math.max(pick, npick);
            p[0]=p[1];
            p[1]=curr;
        } return p[1];
    }
    public int rob(int[] a) {
        int n = a.length;
        if (n == 1) return a[0];
        int take1st = robs(a,n-1,0); //leave last
        int takeLast = robs(a, n, 1); //leave 1st
        return Math.max(take1st, takeLast);
    }
}
