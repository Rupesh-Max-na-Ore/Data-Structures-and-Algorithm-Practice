package Two_Pointer_and_Sliding_Window.java.Lec1_MediumQ;
/*Q6 1248. Count Number of Nice Subarrays
Medium
Topics
Companies
Hint
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

 

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 

Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
Seen this question in a real interview before?
1/5
Yes
No
Accepted
252K
Submissions
354.9K
Acceptance Rate
71.0% */
public class Count_Number_of_Nice_Subarrays {
    // generic way1, 4 pass soln.
    public int numberOfSubarrays(int[] a, int k) {
        return countSubarrSumLessThanEqualToGoal(a, a.length, k) - countSubarrSumLessThanEqualToGoal(a, a.length, (k-1));
    }
    private int countSubarrSumLessThanEqualToGoal(int[] a, int n, int k) {
        if(k<0) return 0;
        int l=0,r=0,cnt=0,sum=0; 
        while(r<n){
            sum+=a[r]%2;
            while(sum>k){
                sum-=a[l]%2;
                l++; //shrink
            }
            int subArrWithSameEndR= r-l+1; 
            cnt+=subArrWithSameEndR;
            r++;//expand
        } return cnt;
    }
}
// //Lc submission 2, way 2, more specific method, 2 pass
// class Solution {
//     public int numberOfSubarrays(int[] A, int k) {
//         //cnt == preceeding Even Nos Before Block With Sum == k
//         int ans = 0, L = 0, R = 0, cnt = 0, sum =0;
//         while(R < A.length) {
//             if (A[R] % 2 == 1) {
//                 sum++;
//                 cnt = 0;
//             }
//             while (sum==k) {     
//                 if(A[L] % 2 == 1) sum--; //==sum -= A[L++] & 1; 
//                 cnt++;
//                 L++;
//             }
//             R++;
//             ans += cnt;
//         }
//         return ans;
//     }
// }