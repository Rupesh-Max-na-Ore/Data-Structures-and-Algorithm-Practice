package StackAndQueue.Lec3_MonotonicStackAndQueue;

import java.util.Stack;

/*Q5 907. Sum of Subarray Minimums
Medium
Topics
Companies
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
 

Constraints:

1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104
Seen this question in a real interview before?
1/5
Yes
No
Accepted
260K
Submissions
696.6K
Acceptance Rate
37.3% */
public class SumOfSubArrayMinimums {
    //Optimal way - o(n)
    public int sumSubarrayMins(int[] A) {
        int n = A.length;

        int[] NSL = getNSL(A, n);
        int[] NSR = getNSR(A, n);

        //Use long to avoid overflow due to multiplication

        long sum = 0;
        int M = 1000000007;

        for (int i = 0; i < n; i++) {
            long L = i - NSL[i];
            long R = NSR[i] - i;
            
            long SubArraysWhereIisMin = L * R;
            long contributionToSum = A[i] * SubArraysWhereIisMin;

            sum = (sum + contributionToSum) % M;
        }

        return (int) sum;
    }

    public int[] getNSL(int[] A, int n) {
        int[] NSL = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && A[st.peek()] > A[i]) st.pop();

            NSL[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return NSL;
    }

    public int[] getNSR(int[] A, int n) {
        int[] NSR = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) st.pop();

            NSR[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return NSR;
    }
    // Brute FOrce, 1st attempt
    // // Time Limit Exceeded 79 / 88 testcases passed
    // public int sumSubarrayMins(int[] a) {
    //     int sum=0; 
    //     for(int i= 0; i< a.length; i++){
    //         int min = a[i]%1000000007;
    //         sum+=a[i]%1000000007;
    //         for(int j=i+1; j<a.length; j++){
    //             if(a[j]<min) min = a[j]%1000000007;
    //             sum+=min%1000000007;
    //         }
    //     } return sum%1000000007;
    // }
}
