package Dynamic_Programming.lec9_Squares;

import java.util.Stack;

/*
 * 85. Maximal Rectangle
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
584.7K
Submissions
1.1M
Acceptance Rate
53.3%
Topics
Array
Dynamic Programming
Stack
Matrix
Monotonic Stack
Companies
Similar Questions
Largest Rectangle in Histogram
Hard
Maximal Square
Medium
Find Sorted Submatrices With Maximum Element at Most K
Hard
 */
public class q55_Max_Rectangle_Area_with_all_1s {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int curr[] = new int[m];
        int maxA = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='0') curr[j] = 0;
                else curr[j] += 1; //or +=matrix[i][j] 
            }
            int a = largestRectangleArea(curr);
            maxA = (maxA>a)? maxA : a ;
        }
        return maxA;
    }

    public int largestRectangleArea_(int[] ht) {
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        int n = ht.length;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty()){
                int rb = i;
                if(!(n==i || ht[st.peek()]> ht[i])) break; 
                int curr = st.pop();
                int lb;
                if(st.isEmpty()) lb = -1;
                else lb = st.peek();
                int area = (rb - lb - 1) * ht[curr];
                maxArea = (area>maxArea)? area:maxArea;
            }
            st.push(i);
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] ht) {
        int maxArea = 0;
        //Stack<Integer> st = new Stack<>();
        int n = ht.length;
        int[] st = new int[n];
        int stht = -1;
        for(int i=0;i<=n;i++){
            //while(!st.isEmpty()){
            while(!(stht==-1)){
                int rb = i;
                //if(!(n==i || ht[st.peek()]> ht[i])) break; 
                if(!(n==i || ht[st[stht]] > ht[i])) break;
                int curr = st[stht--];
                //int curr = st.pop();
                int lb;
                if(stht==-1) lb = -1;
                else lb = st[stht];
                //if(st.isEmpty()) lb = -1;
                //else lb = st.peek();
                int area = (rb - lb - 1) * ht[curr];
                maxArea = (area>maxArea)? area:maxArea;
            }
            st[++stht] = i;
            //st.push(i);
        }
        return maxArea;
    }
}
