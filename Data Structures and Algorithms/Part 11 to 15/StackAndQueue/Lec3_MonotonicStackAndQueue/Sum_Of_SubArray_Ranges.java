package StackAndQueue.Lec3_MonotonicStackAndQueue;

import java.util.Stack;

/*Q8 2104. Sum of Subarray Ranges
Medium
Topics
Companies
Hint
You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

Return the sum of all subarray ranges of nums.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0 
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
Example 2:

Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
Example 3:

Input: nums = [4,-2,-3,4,1]
Output: 59
Explanation: The sum of all subarray ranges of nums is 59.
 

Constraints:

1 <= nums.length <= 1000
-109 <= nums[i] <= 109
 

Follow-up: Could you find a solution with O(n) time complexity?

Seen this question in a real interview before?
1/5
Yes
No
Accepted
97.4K
Submissions
159.2K
Acceptance Rate
61.2% */
public class Sum_Of_SubArray_Ranges {
    public long subArrayRanges(int[] A) {
        int n = A.length, j, k;
        long R = 0;
        
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && A[st.peek()] > (i == n ? Integer.MIN_VALUE : A[i])) {
                j = st.pop();
                k = st.isEmpty() ? -1 : st.peek();
                R -= (long)A[j] * (i - j) * (j - k);

            }
            st.push(i);
        }
        
        st.pop();// or st.clear()

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && A[st.peek()] < (i == n ? Integer.MAX_VALUE : A[i])) {
                j = st.pop();
                k = st.isEmpty() ? -1 : st.peek();
                R += (long)A[j] * (i - j) * (j - k);

            }
            st.push(i);
        }
        return R;
    }
}
//Reference soln & discussion - https://leetcode.com/problems/sum-of-subarray-ranges/solutions/1624222/java-c-python-o-n-solution-detailed-explanation/
/*//A recursive soln. found on LC forum, fastest
class Solution {
    public long subArrayRanges(int[] arr) {
        return calculateMaxSum(arr,0,arr.length-1) - calculateMinSum(arr,0,arr.length-1);
    }
    public long calculateMinSum(int[] arr, int i, int j) {
        int n = j-i+1;
        if(n == 1) return arr[i];
        int minIndex = i;
        for(int k=i+1;k<=j;k++) {
            if(arr[k]<arr[minIndex]) {
                minIndex = k;
            }
        }
        long sum = 1l*(n-(minIndex-i))*(minIndex-i+1)*arr[minIndex];
        if (minIndex == i) {
            return sum+calculateMinSum(arr, minIndex+1, j);
        } else if(minIndex == j) {
            return sum + calculateMinSum(arr, i, minIndex-1);
        }
        return sum + calculateMinSum(arr, i, minIndex-1) + calculateMinSum(arr, minIndex+1,j);
    }
    public long calculateMaxSum(int[] arr, int i, int j) {
        int n = j-i+1;
        if(n == 1) return arr[i];
        int maxIndex = i;
        for(int k=i+1;k<=j;k++) {
            if(arr[k]>arr[maxIndex]) {
                maxIndex = k;
            }
        }
        long sum = 1l*(n-(maxIndex-i))*(maxIndex-i+1)*arr[maxIndex];
        if (maxIndex == i) {
            return sum+calculateMaxSum(arr, maxIndex+1, j);
        } else if(maxIndex == j) {
            return sum + calculateMaxSum(arr, i, maxIndex-1);
        }
        return sum + calculateMaxSum(arr, i, maxIndex-1) + calculateMaxSum(arr, maxIndex+1,j);
    }
        public long subArrayRanges1(int[] A) {
        int n = A.length, j, k;
        long res = 0;
        
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] > (i == n ? Integer.MIN_VALUE : A[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res -= (long)A[j] * (i - j) * (j - k);

            }
            s.push(i);
        }
        
        s.pop();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] < (i == n ? Integer.MAX_VALUE : A[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res += (long)A[j] * (i - j) * (j - k);

            }
            s.push(i);
        }
        return res;
    }
}
*/
/*
class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long answer = 0;
        Stack<Integer> stack = new Stack<>();    

        // Find the sum of all the minimum.
        for (int right = 0; right <= n; ++right) {
            while (!stack.isEmpty() && (right == n || nums[stack.peek()] >= nums[right])) {
                int mid = stack.peek();
                stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                answer -= (long)nums[mid] * (right - mid) * (mid - left);   
            }
            stack.add(right);
        }
        
        // Find the sum of all the maximum.
        stack.clear();
        for (int right = 0; right <= n; ++right) {
            while (!stack.isEmpty() && (right == n || nums[stack.peek()] <= nums[right])) {
                int mid = stack.peek();
                stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                answer += (long)nums[mid] * (right - mid) * (mid - left);   
            }
            stack.add(right);
        }
        return answer;
    }
}
 */
/* LC editorial
Solution
Overview
Define the range of a subarray as the difference between the largest and smallest element in the subarray:

img

The task is to find the sum of all subarray ranges of the given array nums.

Approach 1: Two Loops
Intuition
Let's start with a brute force solution, that is, to find and iterate over all subarrays of nums, and get the sum of their ranges.

Set answer = 0.
Iterate over every left index of subarrays left.
With every fixed left, iterate over every right index right of subarrays.
For each subarray [left, right], iterate over it to find its minimum value minVal and maximum value maxVal.
Increment answer by maxVal - minVal.
This approach contains three nested loops which make the time complexity quite high, so it may not pass all test cases. But we can consider this as a prompt for better approaches!

Note that for a fixed left index, two adjacent arrays only differ by one element. Suppose the previous array is [left, right] and the new array is [left, right + 1], we can get the minVal, maxVal for the new subarray, by updating minVal, maxVal of the previous array using nums[right + 1].

minVal = min(minVal, nums[right + 1])
maxVal = max(maxVal, nums[right + 1])
Therefore, the average time for finding the range of one subarray is reduced to O(1)O(1)O(1). Please refer to the following picture.

img


Algorithm
Set answer = 0.
Iterate over every left index of subarrays left.
With every fixed left, initialize minVal = maxVal = nums[left], iterate over every right index right of subarrays.
For each right index right, update minVal and maxVal by nums[right]. Then update answer += maxVal - minVal.
Implementation

Complexity Analysis
Let nnn be the size of the input array nums.

Time complexity: O(n2)O(n^2)O(n 
2
 )

We have two nested iterations over nums.
In each step, we update minVal, maxVal and answer, it takes constant time.
To sum up, the overall time complexity is O(n2)O(n^2)O(n 
2
 ).
Space complexity: O(1)O(1)O(1)

We only need to update three variables minVal, maxVal and answer.

Approach 2: Monotonic Stack
Intuition
From the definition of the sum of all subarray ranges:

∑krangek=∑k(maxValk−minValk)=∑kmaxValk−∑kminValk\sum\limits_{k} range_{k} = \sum\limits_{k} (maxVal_{k} - minVal_{k}) = \sum\limits_{k} maxVal_{k} - \sum\limits_{k} minVal_{k} 
k
∑
​
 range 
k
​
 = 
k
∑
​
 (maxVal 
k
​
 −minVal 
k
​
 )= 
k
∑
​
 maxVal 
k
​
 − 
k
∑
​
 minVal 
k
​
 

It implies that we can calculate these two partial sums separately.

Let's think of this problem differently, instead of finding each subarray and getting its minVal and maxVal, we focus on each number. If we can find that, for each number nums[i], the number of subarrays having nums[i] as its minimum value is minTime[i]. Then the sum of minVal can be rewritten as:

∑kminValk=∑i=1nminTime[i] ⋅ nums[i]\sum\limits_{k} minVal_{k} = \sum\limits_{i = 1}^{n} minTime[i]\ \cdot\ nums[i] 
k
∑
​
 minVal 
k
​
 = 
i=1
∑
n
​
 minTime[i] ⋅ nums[i]

For example, we have found minTime = [1, 4, 1] for the array [X, Y, Z] by some means (which will be explained in detail soon), then the sum of minVal is 1 * X + 4 * Y + 1 * Z. We don't need to know exactly which array holds which value as the minimum, but only the number of times each number is taken as the minimum!

Now the task becomes finding minTime[i] for each index i.

Notice that minTime[i] depends on:

How many consecutive elements are larger than or equal to nums[i] on its left side, in other word, to find the index left which value is less than nums[i].

How many consecutive elements are smaller than nums[i] on its right side, in other word, to find the index right which value is larger than or equal to nums[i].

Now we have (i - left) positions to put the starting position of the subarray, and (right - i) positions to put the ending position of the subarray. Therefore, we have (i - left) * (right - i) valid subarrays in total, so we can calculate minTime[i] as follows:

minTime[i]=(right−i)⋅(i−left)minTime[i] = (right - i) \cdot (i - left)minTime[i]=(right−i)⋅(i−left)
rangei=minTime[i]⋅nums[i]range_i = minTime[i] \cdot nums[i]range 
i
​
 =minTime[i]⋅nums[i]

In the array shown below, nums[3] = 4 has left = 0 and right = 6, thus the number of subarrays having nums[3] as the minimum is minTime[3] = (6 - 3) * (3 - 0) = 9, meaning that there are 9 subarays having nums[3] as the minimum.

img

To calculate minTime[i] for every index, we can use a stack to maintain a monotonically increasing sequence during the iteration over nums:

What is the left index left? The element on nums[i]'s left in the stack.

What is the right index right? The element we are using to pop nums[i] from the stack.

In other words, minTime[i] is not calculated when we add nums[i] to the stack, but when we pop nums[i] from the stack, because only then are the left and right indexes clear to us. Then we can calculate minTime[i] using: minTime[i]=(right−i)⋅(i−left)minTime[i] = (right - i) \cdot (i - left)minTime[i]=(right−i)⋅(i−left). As shown in the picture below, when we encounter nums[6] = 1, we should pop nums[3] = 4 from the stack, which is the time to calculate minTime[3].

img

How to handle the edge cases?

If the stack is empty after we pop nums[i] from it, we can't find the any index as the left boundary, so we set the left index as -1, which means that all the numbers on nums[i]'s left are within the range [left, i].

In order to pop the remaining elements from the stack after the iteration over nums stops, we set the right boundaries of all the remaining elements as n, which means that all the numbers on nums[i]'s right are within the range [i, right]. That's why we iterate from i = 0 to i = n: to use i = n as the right boundary index to pop all the remaining elements from the stack.

Will there by any duplicated calculation?

One might think, what if there are identical values that are close or adjacent, do we double count any subarray? The answer is NO! Although several identical values A may be adjacent to each other, the subarrays of the previous A will never take the following A as their minimum. As shown in the picture below, subarrays using the first 4 as the minimum don't cross the second 4, thus we won't double count any subarray!

img

With each subproblem solved, we can move on to the results!

Please take the following slides as an example of getting the total sum of minVal.

Current

Note that this iteration is to get the sum of minVal. We also need to find the sum of maxVal in a similar way, by reversing the comparison condition, then get the sum of ranges using the first equation in this chapter. The job is done!

If you are not much familiar with stack, we suggest you read our Leetcode Explore Card and have some knowledge of it beforehand.


Algorithm
Initialize an empty stack stack, get the size of nums as n.

Iterate over every index from 0 to n (inclusive). For each index right, if either of the following two condition is met:

index = n
stack is not empty and nums[mid] >= nums[right], where mid is its top value:
go to step 3.
Otherwise, repeat step 2.

Calculate the number of subarrays with nums[mid] as its minimum value:

Pop mid from stack.
If stack is empty, set left = -1, otherwise, left equals the top element from stack.
Increment answer by (right - mid) * (mid - left).
Repeat step 2.
Implementation

Complexity Analysis
Let nnn be the size of the input array nums.

Time complexity: O(n)O(n)O(n)

To find the total sum of minVal, we only need one iteration over nums, and each number will be added to and popped from stack once, these also apply for finding maxVal.
Therefore the overall time complexity is O(n)O(n)O(n).
Space complexity: O(n)O(n)O(n)

We use a (monotonic) stack to keep the increasing (decreasing) sequence, in the worst-case scenario, there may be O(n)O(n)O(n) numbers in the stack, which takes O(n)O(n)O(n) space.
 */