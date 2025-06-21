package Dynamic_Programming.lec1_Intro;
/*120. Triangle
Medium
Topics
Companies
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
 

Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
Accepted
861.1K
Submissions
1.5M
Acceptance Rate
57.9% */
import java.util.List;

public class q11_Triangle {
    //Space Optimized
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] below= new int[triangle.get(n-1).size()];
        for(int i=triangle.size()-1; i>=0; i--){
            int[] curr= new int[triangle.get(n-1).size()];
            for(int j=triangle.get(i).size()-1; j>=0; j--){
                //Base Case
                if(i == n-1) curr[j]= triangle.get(i).get(j);
                //Reccuring Case
                else{
                    int down= triangle.get(i).get(j) + below[j];
                    int diag= triangle.get(i).get(j) + below[j+1];
                    curr[j]= Math.min(down, diag);
                }
            }
            below = curr; //For next, curr is below
        }
        return below[0];
    }
}
/*
//Recursion
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return f(triangle, 0,0);
    }
    public int f(List<List<Integer>> triangle, int i, int j){
        if(i== triangle.size()-1) return triangle.get(i).get(j);
        if(i>triangle.size()-1 || j>triangle.get(i).size()-1) return 1000000;
        int down= triangle.get(i).get(j) + f(triangle, i+1, j);
        int dia= triangle.get(i).get(j) + f(triangle, i+1, j+1);
        return Math.min(down, dia);
    }
} 
//Memoization
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp= new int[triangle.get(triangle.size()-1).size()][triangle.get(triangle.size()-1).size()];
        for(int[] ar: dp){
            Arrays.fill(ar, -1);
        }
        return f(triangle, 0,0, dp);
    }
    public int f(List<List<Integer>> triangle, int i, int j, int[][] dp){
        if(i== triangle.size()-1) return triangle.get(i).get(j);
        if(i>triangle.size()-1 || j>triangle.get(i).size()-1) return 1000000;
        if(dp[i][j] != -1) return dp[i][j];
        int down= triangle.get(i).get(j) + f(triangle, i+1, j, dp);
        int dia= triangle.get(i).get(j) + f(triangle, i+1, j+1, dp);
        return dp[i][j]= Math.min(down, dia);
    }
}
//Tabulation
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp= new int[triangle.get(triangle.size()-1).size()][triangle.get(triangle.size()-1).size()];
        for(int i=triangle.size()-1; i>=0; i--){
            for(int j=triangle.get(i).size()-1; j>=0; j--){
                if(i== triangle.size()-1) dp[i][j]= triangle.get(i).get(j);
                else{
                    int down= triangle.get(i).get(j) + dp[i+1][j];
                    int dia= triangle.get(i).get(j) + dp[i+1][j+1];
                    dp[i][j]= Math.min(down, dia);
                }
            }
        }
        return dp[0][0];
}
*/