package StackAndQueue.Lec4_Implementation;

import java.util.ArrayDeque;
import java.util.Deque;

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
public class Sliding_WIndow_Max {
    //optimal way 1 - monotonic increasing deque, lto r traversal
    // public int[] maxSlidingWindow(int[] a, int k) {
    //     int n = a.length;
    //     if(k==1) return  a;
    //     int [] windowMaxs = new int[n-k+1];
    //     //int maxIndex=0; //realized no need for maxIndex, (i- k +1) does it
    //     Deque<Integer> dq=new ArrayDeque<>();
    //     for(int i = 0; i< n; i++){
    //         while(!dq.isEmpty() && dq.peek()<=(i-k)) dq.pollFirst(); //or dq.poll()
    //         while(!dq.isEmpty() && a[dq.peekLast()] < a[i]) dq.pollLast();
    //         dq.add(i);// or dq.offer(i)
    //         if(i<(k-1)) continue;
    //         windowMaxs[i-k+1]=a[dq.peekFirst()]; //or dq.peek() would do too
    //     }
    //     return windowMaxs;
    // }

    //Optimal way 2 - Precomputation
        public static int[] maxSlidingWindow(int[] a, int k) {
            if (a == null || a.length == 0) return new int[0];

            int n = a.length;
            int[] l = new int[n];
            int[] r = new int[n];
    
            // Compute l[] and r[] in a single iter
            for (int i = 0; i < n; i++) {
                // Compute l[i]
                if (i % k == 0) {
                    l[i] = a[i]; //left boundary start
                } else {
                    l[i] = Math.max(l[i - 1], a[i]);
                }
    
                // Compute r[n - i - 1]
                int j = n - i - 1;
                if (j % k == k - 1 || j == n - 1) {
                    r[j] = a[j]; //right boundary start
                } else {
                    r[j] = Math.max(r[j + 1], a[j]);
                }
            }
    
            // Build the result w[]
            int[] w = new int[n - k + 1];//n - k + 1 == # k-sized windows
            for (int i = 0; i < (n - k + 1); i++) {
                w[i] = Math.max(r[i], l[i + k - 1]);
            }
    
            return w;
    
        }

    // //Reference code - found discussion at - https://leetcode.com/problems/sliding-window-maximum/solutions/65881/o-n-solution-in-java-with-two-simple-pass-in-the-array/
    // // very short and fun to type, great for interview situation
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


    // //Brute force - Time Limit Exceeded - 40 / 51 testcases passed
    // public int[] maxSlidingWindow(int[] a, int k) {
    //     int n = a.length;
    //     if(k==1) return  a;
    //     int [] windowMaxs = new int[n-k+1];
    //     int max = a[0]; int maxIndex=0;
    //     for(int i =0; i<=(n-k); i++){
    //         max = a[i]; maxIndex = i;
    //         for(int j = i; j<=(i+k-1); j++){
    //             if(a[j]> max) {
    //                 max = a[j];
    //                 maxIndex = j;
    //             }
    //         }
    //         windowMaxs[i]=max;
    //     }
    //     return windowMaxs;
    // }


    // first attempt, some mistakes due to a oversight
        // public static int[] maxSlidingWindow(int[] a, int k) {
        //     int n = a.length;
        // //if(n==k) return a;
        // if(k==1) return  a;
        // //if(n-k < 1) return new int[]{}; 
        // int [] windowMaxs = new int[n-k+1];
        // int max = a[0]; int maxIndex=0;
        // //first sliding window max
        // for(int i =1; i<k ; i++){
        //     if(max < a[i]){
        //         max = a[i];
        //         maxIndex = i;
        //     }
        // }
        // windowMaxs[0] = max;
        // if(n==k) return windowMaxs;
        // //for next sliding windows
        // //i = fix left, j = sliding right
        // for(int i=1; i<(n-k) ; i++){
        //     if(i > maxIndex) {
        //         max = Integer.MIN_VALUE;
        //         maxIndex = -1;
        //     }
        //     for(int j=i; j<(i+k) ; j++){
        //         if(a[j] >= max) {
        //             max = a[j];
        //             maxIndex = j;
        //         }
        //     } windowMaxs[i] = max;

        // }
        // if(a[n-1]> max) windowMaxs[n-k] = a[n-1];
        // else windowMaxs[n-k] = max;
        // return windowMaxs;
        // }

        
        public static void main(String args[]) {
            int i, j, n, k = 3, x;
            int arr[]={4,0,-1,3,5,3,6,8};
            int ans[] = maxSlidingWindow(arr, k);
            System.out.println("Maximum element in every " + k + " window ");
            for (i = 0; i < ans.length; i++)
                System.out.print(ans[i] + "  ");
    
        }
}
