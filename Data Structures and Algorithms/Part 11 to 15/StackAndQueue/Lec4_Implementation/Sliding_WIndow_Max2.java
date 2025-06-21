package StackAndQueue.Lec4_Implementation;

/*Q1 239. Sliding Window Maximum
Hard
Topics
Companies
Hint
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.1M
Submissions
2.3M
Acceptance Rate
46.7% */
public class Sliding_WIndow_Max2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
    
        int[] l=new int[nums.length];
        int[] r=new int[nums.length];
        r[nums.length-1]=nums[nums.length-1];
        
        for(int i=1;i<nums.length;i++)
            l[i]=(i%k==0)?nums[i]:Math.max(l[i-1],nums[i]);
        
        for(int j=nums.length-2;j>=0;j--)
            r[j]=(j%k==0)?nums[j]:Math.max(r[j+1],nums[j]);
        
        for (int i = 0; i < result.length; i++) 
            result[i] = Math.max(l[i + k -1], r[i]);

        return result;    
    }
        public static void main(String args[]) {
            int i, j, n, k = 3, x;
            int arr[]={4,0,-1,3,5,3,6,8};
            int ans[] = maxSlidingWindow(arr, k);
            System.out.println("Maximum element in every " + k + " window ");
            for (i = 0; i < ans.length; i++)
                System.out.print(ans[i] + "  ");
    
        }
}
// //Reference code, very short and nice to type
// public int[] maxSlidingWindow(int[] nums, int k) {
//     int[] result = new int[nums.length - k + 1];

//     int[] l=new int[nums.length];
//     int[] r=new int[nums.length];
//     r[nums.length-1]=nums[nums.length-1];
    
//     for(int i=1;i<nums.length;i++)
//         l[i]=(i%k==0)?nums[i]:Math.max(l[i-1],nums[i]);
    
//     for(int j=nums.length-2;j>=0;j--)
//         r[j]=(j%k==0)?nums[j]:Math.max(r[j+1],nums[j]);
    
//     for (int i = 0; i < result.length; i++) 
//         result[i] = Math.max(l[i + k -1], r[i]);

//     return result;    
// }
//https://chatgpt.com/share/aa8a0b69-2fa6-415c-836e-864b2a60465d