package Arrays.Medium;
//q4
import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumSubarr {

    //Kadane's Algo Applying
    public static int maxSubArray(int[] nums) {
        int L=0;
        int R=0;
        int max=Integer.MIN_VALUE;
        int sum=0; 
        int i=0;
        int n=nums.length;
        for(i=0;i<n;i++){
            if(sum==0) L=i;//when sum =0, we are starting to explore a fresh, non-overlapping subarray

            sum+=nums[i];

            
            if(sum>max){
                max=sum;
                R=i;
            }

            if(sum<0)sum=0;//reset sum if -ve sum for previous subarray
        }
        System.out.println("l="+L+", r="+R);
        return max;
        
    }



    
     public static void main(String[] args) {
        int[] a1 = {-1,-1,0,3,-3,4,-5,6,-7};
        int[] a2 = {-1,-2,3};
        
        System.out.println("Original array: " + Arrays.toString(a1));
        int max=MaxSumSubarr.maxSubArray(a1);
        System.out.println("Sum of max subarr: "+max);
        }
}

//lc submission
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int max=Integer.MIN_VALUE;
//         int sum=0; 
//         int n=nums.length;
//         for(int i=0;i<n;i++){
//             sum+=nums[i];

            
//             max=(sum>max)?sum:max;

//             sum=(sum<0)?0:sum;
//         }
//         return max;

//     }
// }

// gfg submission


// DP solution & some thoughts

// FujiwaranoSai
// 2728
// 395440
// Dec 27, 2014
// Analysis of this problem:
// Apparently, this is a optimization problem, which can be usually solved by DP. So when it comes to DP, the first thing for us to figure out is the format of the sub problem(or the state of each sub problem). The format of the sub problem can be helpful when we are trying to come up with the recursive relation.

// At first, I think the sub problem should look like: maxSubArray(int A[], int i, int j), which means the maxSubArray for A[i: j]. In this way, our goal is to figure out what maxSubArray(A, 0, A.length - 1) is. However, if we define the format of the sub problem in this way, it's hard to find the connection from the sub problem to the original problem(at least for me). In other words, I can't find a way to divided the original problem into the sub problems and use the solutions of the sub problems to somehow create the solution of the original one.

// So I change the format of the sub problem into something like: maxSubArray(int A[], int i), which means the maxSubArray for A[0:i ] which must has A[i] as the end element. Note that now the sub problem's format is less flexible and less powerful than the previous one because there's a limitation that A[i] should be contained in that sequence and we have to keep track of each solution of the sub problem to update the global optimal value. However, now the connect between the sub problem & the original one becomes clearer:

// maxSubArray(A, i) = maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 + A[i]; 
// And here's the code

// public int maxSubArray(int[] A) {
//         int n = A.length;
//         int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
//         dp[0] = A[0];
//         int max = dp[0];
        
//         for(int i = 1; i < n; i++){
//             dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
//             max = Math.max(max, dp[i]);
//         }
        
//         return max;
// }
// Previous
// [C++] Easy O(n) with 5 lines of code | Use Greedy | Easy solution
// Next
// Easiest Solution with Dynamic Solution ||


// hidro
// Feb 16, 2016
// My DP reasoning is as follows:

// To calculate sum(0,i), you have 2 choices: either adding sum(0,i-1) to a[i], or not. If sum(0,i-1) is negative, adding it to a[i] will only make a smaller sum, so we add only if it's non-negative.

// sum(0,i) = a[i] + (sum(0,i-1) < 0 ? 0 : sum(0,i-1))
// We can then use O(1) space to keep track of the max sum(0, i) so far.

// public int maxSubArray(int[] nums) {
// 	if (nums == null || nums.length == 0) { return 0; }
// 	int max = nums[0], sum = nums[0];
// 	for (int i = 1; i < nums.length; i++) {
// 		if (sum < 0) { sum = nums[i]; }
// 		else {sum += nums[i]; }
// 		max = Math.max(max, sum);
// 	}
// 	return max;
// }
// 399
// Show 15 Replies
// Reply
// Share

// using divide and conquer in o(nlogn), copy and learnt from gfg
// A Divide and Conquer based Java 
// program for maximum subarray sum 
// problem 
// import java.util.*; 

// class GFG { 

// 	// Find the maximum possible sum in arr[] 
// 	// such that arr[m] is part of it 
// 	static int maxCrossingSum(int arr[], int l, int m, 
// 							int h) 
// 	{ 
// 		// Include elements on left of mid. 
// 		int sum = 0; 
// 		int left_sum = Integer.MIN_VALUE; 
// 		for (int i = m; i >= l; i--) { 
// 			sum = sum + arr[i]; 
// 			if (sum > left_sum) 
// 				left_sum = sum; 
// 		} 

// 		// Include elements on right of mid 
// 		sum = 0; 
// 		int right_sum = Integer.MIN_VALUE; 
// 		for (int i = m; i <= h; i++) { 
// 			sum = sum + arr[i]; 
// 			if (sum > right_sum) 
// 				right_sum = sum; 
// 		} 

// 		// Return sum of elements on left 
// 		// and right of mid 
// 		// returning only left_sum + right_sum will fail for 
// 		// [-2, 1] 
// 		return Math.max(left_sum + right_sum - arr[m], 
// 						Math.max(left_sum, right_sum)); 
// 	} 

// 	// Returns sum of maximum sum subarray 
// 	// in aa[l..h] 
// 	static int maxSubArraySum(int arr[], int l, int h) 
// 	{ 
// 		//Invalid Range: low is greater than high 
// 		if (l > h) 
// 			return Integer.MIN_VALUE; 
// 		// Base Case: Only one element 
// 		if (l == h) 
// 			return arr[l]; 

// 		// Find middle point 
// 		int m = (l + h) / 2; 

// 		/* Return maximum of following three 
// 		possible cases: 
// 		a) Maximum subarray sum in left half 
// 		b) Maximum subarray sum in right half 
// 		c) Maximum subarray sum such that the 
// 		subarray crosses the midpoint */
// 		return Math.max( 
// 			Math.max(maxSubArraySum(arr, l, m-1), 
// 					maxSubArraySum(arr, m + 1, h)), 
// 			maxCrossingSum(arr, l, m, h)); 
// 	} 

// 	/* Driver program to test maxSubArraySum */
// 	public static void main(String[] args) 
// 	{ 
// 		int arr[] = { 2, 3, 4, 5, 7 }; 
// 		int n = arr.length; 
// 		int max_sum = maxSubArraySum(arr, 0, n - 1); 

// 		System.out.println("Maximum contiguous sum is "
// 						+ max_sum); 
// 	} 
// } 
// 

/*From gfg
 * The following approach solves it using Divide and Conquer approach which takes the same time complexity of O(n).
Divide and conquer algorithms generally involves dividing the problem into sub-problems and conquering them separately. 
For this problem we maintain a structure (in cpp) or class(in java or python) which stores the following values: 
 

Total sum for a sub-array.
Maximum prefix sum for a sub-array.
Maximum suffix sum for a sub-array.
Overall maximum sum for a sub-array.(This contains the max sum for a sub-array).


During the recursion(Divide part) the array is divided into 2 parts from the middle. 
The left node structure contains all the above values for the left part of array and the right node structure contains all the above values. 
Having both the nodes, now we can merge the two nodes by computing all the values for resulting node. 
The max prefix sum for the resulting node will be maximum value 
among the maximum prefix sum of left node or left node sum + max prefix sum of right node or total sum of both the nodes 
(which is possible for an array with all positive values). 
Similarly the max suffix sum for the resulting node will be maximum value 
among the maximum suffix sum of right node or right node sum + max suffix sum of left node or total sum of both the nodes 
(which is again possible for an array with all positive values). 
The total sum for the resulting node is the sum of both left node and right node sum. 
Now, the max subarray sum for the resulting node will be maximum among prefix sum of resulting node, 
suffix sum of resulting node, total sum of resulting node, maximum sum of left node, maximum sum of right node, 
sum of maximum suffix sum of left node and maximum prefix sum of right node. 
Here the conquer part can be done in O(1) time by combining the result from the left and right node structures.
Below is the implementation of the above approach:
 


// Java implementation of the approach
import java.util.*;
class GFG
{
static class Node
{
     
    // To store the maximum sum 
    // for a sub-array
    int _max;
     
    // To store the maximum prefix 
    // sum for a sub-array
    int _pre;
     
    // To store the maximum suffix 
    // sum for a sub-array
    int _suf;
     
    // To store the total sum 
    // for a sub-array 
    int _sum;
 
};
 
 
// Function to create a node
static Node getNode(int x)
{
    Node a = new Node();
    a._max = x;
    a._pre = x;
    a._suf = x;
    a._sum = x;
    return a;
}
 
// Function to merge the 2 nodes left and right
static Node merg(Node l, Node r)
{
     
    // Creating node ans
    Node ans = new Node();
 
    // Initializing all the variables:
    ans._max = ans._pre = ans._suf = ans._sum = 0;
     
    // The max prefix sum of ans Node is maximum of
    // a) max prefix sum of left Node
    // b) sum of left Node + max prefix sum of right Node
    // c) sum of left Node + sum of right Node
    ans._pre = Arrays.stream(new int[]{l._pre, l._sum+r._pre,
                                       l._sum+r._sum}).max().getAsInt();
 
    // The max suffix sum of ans Node is maximum of
    // a) max suffix sum of right Node
    // b) sum of right Node + max suffix sum of left Node
    // c) sum of left Node + sum of right Node
    ans._suf = Arrays.stream(new int[]{r._suf, r._sum+l._suf,
                                       l._sum+r._sum}).max().getAsInt();
     
    // Total sum of ans Node = total sum of 
  // left Node + total sum of right Node 
    ans._sum = l._sum + r._sum;
     
    // The max sum of ans Node stores 
    // the answer which is the maximum value among:
    // prefix sum of ans Node
    // suffix sum of ans Node
    // maximum value of left Node
    // maximum value of right Node
    // prefix value of right Node + suffix value of left Node
    ans._max = Arrays.stream(new int[]{ans._pre, 
                                       ans._suf,
                                       ans._sum,
                                       l._max, r._max, 
                                       l._suf+r._pre}).max().getAsInt();
 
    // Return the ans Node
    return ans;
}
 
// Function for calculating the 
// max_sum_subArray using divide and conquer
static Node getMaxSumSubArray(int l, int r, int []ar)
{
 
    if (l == r) return getNode(ar[l]);
    int mid = (l + r) >> 1;
     
    // Call method to return left Node:
    Node left = getMaxSumSubArray(l, mid, ar);
     
    // Call method to return right Node:
    Node right = getMaxSumSubArray(mid + 1, r, ar);
     
    // Return the merged Node:
    return merg(left, right);
 
}
 
// Driver code
public static void main(String[] args)
{
    int []ar = {-2, -5, 6, -2, -3, 1, 5, -6};
    int n = ar.length;
    Node ans = getMaxSumSubArray(0, n - 1, ar);
    System.out.print("Answer is " +  ans._max + "\n");
}
}
 
// This code is contributed by shikhasingrajput
Output: 

Answer is 7
Time Complexity: The getMaxSumSubArray() recursive function generates the following recurrence relation. 
T(n) = 2 * T(n / 2) + O(1) note that conquer part takes only O(1) time. 
So on solving this recurrence using Master’s Theorem we get the time complexity of O(n).
 */