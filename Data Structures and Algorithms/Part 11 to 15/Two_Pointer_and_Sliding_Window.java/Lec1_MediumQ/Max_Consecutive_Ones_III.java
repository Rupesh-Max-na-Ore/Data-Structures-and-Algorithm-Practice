package Two_Pointer_and_Sliding_Window.java.Lec1_MediumQ;
/*Q2 1004. Max Consecutive Ones III
Medium
Topics
Companies
Hint
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
Seen this question in a real interview before?
1/5
Yes
No
Accepted
580.6K
Submissions
914.9K
Acceptance Rate
63.5% */
public class Max_Consecutive_Ones_III {
    public int longestOnes(int[] a, int k) {
        int maxL=0;
        int r=0,l=0,z=0;
        while(r<a.length){
            if(a[r]==0) z++;
            if(z>k){
                if(a[l]==0) z--;
                l++;
            }
            if(z<=k){
                int currL=r-l+1;
                maxL = Math.max(maxL, currL); //==// maxL = (maxL > currL) ? maxL : currL;
            }
            r++;
        } return maxL;
    }
}
/*//similar soln. on LC forum
Explanation
For each A[j], try to find the longest subarray.
If A[i] ~ A[j] has zeros <= K, we continue to increment j.
If A[i] ~ A[j] has zeros > K, we increment i (as well as j).


Java:

    public int longestOnes(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
        }
        return j - i;
    }
 */