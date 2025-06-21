package StackAndQueue.Lec3_MonotonicStackAndQueue;

import java.util.HashMap;
import java.util.Stack;

/*Q1 496. Next Greater Element I
Easy
Topics
Companies
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
 

Constraints:

1 <= nums1.length <= nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 104
All integers in nums1 and nums2 are unique.
All the integers of nums1 also appear in nums2.
 

Follow up: Could you find an O(nums1.length + nums2.length) solution?
Seen this question in a real interview before?
1/5
Yes
No
Accepted
738.8K
Submissions
1M
Acceptance Rate
72.4% */
public class NextGreaterElem1 {
    // O(a.len + b. len) TC, O(2*b. len) SC
    public int[] nextGreaterElement(int[] a, int[] b) {
	int[] nextGreaterElement = new int[a.length];

	Stack<Integer> stack = new Stack<>();
	HashMap<Integer, Integer> hm = new HashMap<>();

	//1. find out all the next greater elems. in b[]
	for(int num: b) {
		//2. if num > top elem in stack then it is the next greater element in b[]
		while(!stack.isEmpty() && num > stack.peek()) hm.put(stack.pop(), num);
		//3. then add num to stack
		stack.add(num);
	}
    //4. for each elem. in a[], get it's next greater from b[], as stored in HM
    // if not present in HM, means has no next greater in b[], so, mark as -1
	for(int i=0; i < a.length; i++) nextGreaterElement[i] = hm.getOrDefault(a[i], -1);

	return nextGreaterElement;
}
}
/*
 //backward (R to L) traversal soln. found on LC
 public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length-1; i>=0; i--){
            while(!stack.empty() && nums[i]>stack.peek()) stack.pop();
            map.put(nums[i], (stack.empty())? -1 : stack.peek());
            stack.push(nums[i]);
        }
        for(int i = 0; i<findNums.length; i++){
            findNums[i] = map.get(findNums[i]);
        }
        return findNums;        
    }
}
 */
