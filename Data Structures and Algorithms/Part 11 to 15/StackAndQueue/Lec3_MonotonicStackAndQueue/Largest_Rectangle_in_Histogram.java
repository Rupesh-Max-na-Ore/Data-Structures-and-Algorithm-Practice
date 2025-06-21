package StackAndQueue.Lec3_MonotonicStackAndQueue;
/*Q10 84. Largest Rectangle in Histogram
Solved
Hard
Topics
Companies
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
Seen this question in a real interview before?
1/5
Yes
No
Accepted
919.1K
Submissions
2.1M
Acceptance Rate
44.8% */
import java.util.Stack;

public class Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] h) {
        int n = h.length, j, k;
        int Area = 0;
        int MaxArea = 0;
        
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && h[st.peek()] > (i == n ? Integer.MIN_VALUE : h[i])) {
                j = st.pop();
                k = st.isEmpty() ? -1 : st.peek();
                Area = h[j] * ((i - k - 1)); //== (i - j ) - (j - k) - 1 == width from right + width from left - exclude itself cuz include itself twice
                MaxArea = (Area>MaxArea)? Area : MaxArea;
            }
            st.push(i);
        }
        return MaxArea;
    }
}
// Striver Soln, does very similar
// import java.util.*;
// public class TUF {
//     static int largestRectangleArea(int histo[]) {
//         Stack < Integer > st = new Stack < > ();
//         int maxA = 0;
//         int n = histo.length;
//         for (int i = 0; i <= n; i++) {
//             while (!st.empty() && (i == n || histo[st.peek()] >= histo[i])) {
//                 int height = histo[st.peek()];
//                 st.pop();
//                 int width;
//                 if (st.empty())
//                     width = i;
//                 else
//                     width = i - st.peek() - 1;
//                 maxA = Math.max(maxA, width * height);
//             }
//             st.push(i);
//         }
//         return maxA;
//     }

//     public static void main(String args[]) {
//         int histo[] = {3, 1, 5, 6, 2, 3};
//         System.out.println("The largest area in the histogram is " + largestRectangleArea(histo));
//     }
// }
// Output: The largest area in the histogram is 10

// Time Complexity: O( N ) + O (N)

// Space Complexity: O(N)


// //Recommended soln, as above soln is hard to explain in limited time in an interview
// public int largestRectangleArea(int[] heights) {
//     int n = heights.length;
//     Stack < Integer > st = new Stack < > ();
//     int leftSmall[] = new int[n];
//     int rightSmall[] = new int[n];
//     for (int i = 0; i < n; i++) {
//         while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
//             st.pop();
//         }

//         if (st.isEmpty()) leftSmall[i] = 0;
//         else leftSmall[i] = st.peek() + 1;
//         st.push(i);
//     }

//     // clear the stack to be re-used
//     while (!st.isEmpty()) st.pop();

//     for (int i = n - 1; i >= 0; i--) {
//         while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
//             st.pop();
//         }

//         if (st.isEmpty()) rightSmall[i] = n - 1;
//         else rightSmall[i] = st.peek() - 1;

//         st.push(i);
//     }

//     int maxA = 0;
//     for (int i = 0; i < n; i++) {
//         maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
//     }
//     return maxA;

// }


// //Array used as a stack soln, faster(est) as the using collections is slow in java
// public class Solution {
//     public int largestRectangleArea(int[] h) {
//         int n = h.length;
//         int max = 0;
//         int[] stack = new int[n + 1];
//         int is = -1;
//         for (int i = 0; i <= n; i++) {
//             int height = (i == n) ? 0 : h[i];
//             while (is != -1 && height < h[stack[is]]) {
//                 int hh = h[stack[is--]];
//                 int width = (is == -1) ? i : i - 1 - stack[is];
//                 max = Math.max(max, hh * width);
//             }
//             stack[++is] = i;
//         }
//         return max;
//     }
// }

// //a DP soln., pretty fast
// https://leetcode.com/problems/largest-rectangle-in-histogram/solutions/28902/5ms-o-n-java-solution-explained-beats-96/
// public class Solution {
//     public static int largestRectangleArea(int[] height) {
//     if (height == null || height.length == 0) {
//         return 0;
//     }
//     int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
//     int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
//     lessFromRight[height.length - 1] = height.length;
//     lessFromLeft[0] = -1;

//     for (int i = 1; i < height.length; i++) {
//         int p = i - 1;

//         while (p >= 0 && height[p] >= height[i]) {
//             p = lessFromLeft[p];
//         }
//         lessFromLeft[i] = p;
//     }

//     for (int i = height.length - 2; i >= 0; i--) {
//         int p = i + 1;

//         while (p < height.length && height[p] >= height[i]) {
//             p = lessFromRight[p];
//         }
//         lessFromRight[i] = p;
//     }

//     int maxArea = 0;
//     for (int i = 0; i < height.length; i++) {
//         maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
//     }

//     return maxArea;
// }
// }
/*The main trick is how to effectively calculate lessFromRight and lessFromLeft arrays. 
The trivial solution is to use O(n^2) solution and for each i element first find his left/right heighbour 
in the second inner loop just iterating back or forward:

for (int i = 1; i < height.length; i++) {              
    int p = i - 1;
    while (p >= 0 && height[p] >= height[i]) {
        p--;
    }
    lessFromLeft[i] = p;              
}
The only line change shifts this algorithm from O(n^2) to O(n) complexity: 
we don't need to rescan each item to the left - 
we can reuse results of previous calculations and "jump" through indices in quick manner:

while (p >= 0 && height[p] >= height[i]) {
      p = lessFromLeft[p];
} 
*/