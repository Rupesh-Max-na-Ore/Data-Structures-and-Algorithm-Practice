package Two_Pointer_and_Sliding_Window.java.Lec2_HardQ;

import java.util.HashMap;

/*Q2 992. Subarrays with K Different Integers
Hard
Topics
Companies
Hint
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length
Seen this question in a real interview before?
1/5
Yes
No
Accepted
222K
Submissions
349.1K
Acceptance Rate
63.6% */
public class Subarrays_with_K_Different_Integers {
    public int subarraysWithKDistinct(int[] a, int k) {
        return countSubarrSumLessThanEqualToK(a, a.length, k) - countSubarrSumLessThanEqualToK(a, a.length, (k-1));
    }
    private int countSubarrSumLessThanEqualToK(int[] a, int n, int k) {
        if(k<0) return 0;
        //if(k==1) return n;//fails [2,1,1,1,2], k=1, 5 wrong, 8 correct
        HashMap<Integer,Integer> hFreq = new HashMap<>();
        int l=0,r=0,cnt=0,sum=0;
        while(r<n){
            hFreq.put(a[r], hFreq.getOrDefault(a[r], 0)+1);
            while(hFreq.size()>k){
                hFreq.put(a[l], hFreq.get(a[l])-1);
                if(hFreq.get(a[l])==0) hFreq.remove(a[l]);
                l++; //shrink
            }
            int subArrWithSameEndR= r-l+1; 
            cnt+=subArrWithSameEndR;
            r++;//expand
        } return cnt;
    }
}
