package StackAndQueue.Lec3_MonotonicStackAndQueue;

import java.util.Stack;

/*Q2 503. Next Greater Element II
Medium
Topics
Companies
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

 

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
 

Constraints:

1 <= nums.length <= 104
-109 <= nums[i] <= 109
Seen this question in a real interview before?
1/5
Yes
No
Accepted
408.7K
Submissions
638.2K
Acceptance Rate
64.0% */
public class NextGreaterElem2 {
    public int[] nextGreaterElements(int[] a) {
        int n = a.length;
        int [] nextGreaterElements = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<(2*n); i++){
            // use % to cycle back to a[n-1] at end and onwards
            // curr elem. from back
            int ind = (n-1-i%n);//)%n;
            int curr = a[ind];
            // pop till get nearest(to right) greater elem., all righter to it already in stack
            while(!st.isEmpty() && st.peek()<=curr) st.pop();
            if(st.isEmpty()) nextGreaterElements[ind] = -1; //is greatest elem. or when i=0
            else nextGreaterElements[ind] = st.peek();
            st.push(curr);
        } return nextGreaterElements;
    }
    //1st attempt, mistake in for loop end pt.
    // public int[] nextGreaterElements(int[] a) {
    //     int n = a.length;
    //     int [] nextGreaterElements = new int[n];
    //     Stack<Integer> st = new Stack<>();
    //     for(int i = 0; i<(n+1); i++){
    //         // use % to cycle back to i=0 at end
    //         // curr elem. from back
    //         int ind = (n-1-i)%n;
    //         int curr = a[ind];
    //         // pop till get nearest(to right) greater elem., all righter to it already in stack
    //         while(!st.isEmpty() && st.peek()<=curr) st.pop();
    //         if(st.isEmpty()) nextGreaterElements[ind] = -1; //is greatest elem. or when i=0
    //         else nextGreaterElements[ind] = st.peek();
    //         st.push(curr);
    //     } return nextGreaterElements;
    // }
}
/*//SLightly faster code on LC forum
public class Solution {
    public int[] nextGreaterElements(int[] A) {
        int n = A.length;
        int[] res = new int[n]; 
        Arrays.fill(res, -1); // Initialize result array with -1    
        Stack<Integer> stack = new Stack<>(); // Stack to store indices

        // Iterate through the array twice to handle circular nature
        for (int i = 0; i < n * 2; i++) {       
            // Use modulo to wrap around the array
            while (!stack.isEmpty() && A[stack.peek()] < A[i % n]) {     
                
                res[stack.pop()] = A[i % n];
            }
            stack.push(i % n); // Push current index (mod n) onto the stack
        }
        return res; // Return the result array
    }
}
    //https://leetcode.com/problems/next-greater-element-ii/solutions/5201809/brute-intuitive-solution-beats-98-monotonic-pattern/ 
*/