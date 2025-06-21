package StackAndQueue.Lec3_MonotonicStackAndQueue;

import java.util.Stack;

/*Q11 85. Maximal Rectangle
Solved
Hard
Topics
Companies
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [["0"]]
Output: 0
Example 3:

Input: matrix = [["1"]]
Output: 1
 

Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= row, cols <= 200
matrix[i][j] is '0' or '1'.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
495.7K
Submissions
975.1K
Acceptance Rate
50.8%*/
public class Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)  return 0;
        int maxArea = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] ht = new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                ht[j] = matrix[i][j] == '1' ? ht[j]+1 : 0;
            }
            //ht[j] is containing hts. of histogram(till i-th row), finding area of max rectagle there
            int currLargestRectangleArea = largestRectangleArea(ht);
            //update maxArea if curr Area bigger
            maxArea = (maxArea > currLargestRectangleArea)? maxArea : currLargestRectangleArea;
        }
        return maxArea;
    }
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
                MaxArea = (Area > MaxArea)? Area : MaxArea;
            }
            st.push(i);
        }
        return MaxArea;
    }
}
// // Faster LC submission, by using array as stack instead of collections framework
// class Solution {
//     public int maximalRectangle(char[][] matrix) {
//         if(matrix.length == 0)  return 0;
//         int maxArea = 0;
//         int row = matrix.length;
//         int col = matrix[0].length;
//         int[] ht = new int[col];
//         for(int i=0;i<row;i++){
//             for(int j=0;j<col;j++){
//                 ht[j] = matrix[i][j] == '1' ? ht[j]+1 : 0;
//             }
//             //ht[j] is containing hts. of histogram(till i-th row), finding area of max rectagle there
//             int currLargestRectangleArea = largestRectangleArea(ht);
//             //update maxArea if curr Area bigger
//             maxArea = (maxArea > currLargestRectangleArea)? maxArea : currLargestRectangleArea;
//         }
//         return maxArea;
//     }
//     public int largestRectangleArea(int[] h) {
//         int n = h.length;
//         int max = 0;
//         int[] stack = new int[n + 1];
//         int sind = -1; //sind keeps track of top indx of stack
//         for (int i = 0; i <= n; i++) {
//             int height = (i == n) ? 0 : h[i];
//             //when stack is not empty == sind != -1
//             while (sind != -1 && height < h[stack[sind]]) {
//                 int ht = h[stack[sind--]]; //assign top indx elem as ht, and pop the top
//                 int width = (sind == -1) ? i : i - stack[sind] - 1 ; //== rb - lb - 1
//                 int area = ht * width;
//                 max = (max > area)? max : area;
//             }
//             stack[++sind] = i; // push curr indx i
//         }
//         return max;
//     }
// }
/*Intuition :
1) Pick one row
2) Do summation of each index till that row
		i) if any index value is 0 then put 0 else previous summation + 1 
3) Pass this array to get max area (84. Largest Rectangle in Historgram)
4) Update max area

84. Largest Rectangle in Histogram
Intuition :
1) Max area will always have atleast one full bar height on any index
2) Find largest rectangle including each bar one by one.
	a) For each bar, We have to find it's left limit & right limit (to know the maximum width)
	b) Find it's left limit (where we find any index's value is smaller than current index in left side array of curr index)
	c) Find it's right limit (where we find any index's value is smaller than current index in right side array of curr index
3) Take the maximum of all the max area found by each bar.
4) calculate area
		width * height
where width = right limit - left limit + 1
height = curr index's value
5) Update max area & return it 
// found on - https://leetcode.com/problems/maximal-rectangle/solutions/1603593/java-detailed-explanation-easy-approach-o-row-col/
*/