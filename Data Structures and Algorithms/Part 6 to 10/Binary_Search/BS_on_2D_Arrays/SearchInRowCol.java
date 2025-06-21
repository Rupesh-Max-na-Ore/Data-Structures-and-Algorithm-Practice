package Binary_Search.BS_on_2D_Arrays;
/*
 * Q3
 * Search in a row and column-wise sorted matrix

Problem Statement: You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively. The elements of each row and each column are sorted in non-decreasing order.
But, the first element of a row is not necessarily greater than the last element of the previous row (if it exists).
You are given an integer ‘target’, and your task is to find if it exists in the given 'mat' or not.

Pre-requisite: Search in a 2D sorted matrix

Examples
Example 1:
Input Format:
 N = 5, M = 5, target = 14
mat[] = 

Result:
 true
Explanation:
 Target 14 is present in the cell (3, 2)(0-based indexing) of the matrix. So, the answer is true.

Example 2:
Input Format:
 N = 3, M = 3, target = 12,
mat[] = 

Result:
 false
Explanation:
 As target 12 is not present in the matrix, the answer is false.
 */
public class SearchInRowCol {
    public int[] searchMatrix(int[][] a, int k) {
        int n=a.length; int m=a[0].length;
        // using top right to bottom left direction
        int r=0; int c=m-1;
        while((r<=(n-1))&&(c>=0)){
            if(a[r][c]==k) return new int[] {r,c};
            else if(a[r][c]<k) r++; // too low, search successive row
            else c--; // too high, search preceeding column
        } return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        SearchInRowCol solution = new SearchInRowCol();
        int[][] mat1 = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        // Search for the number 5 in the matrix
        int[] result1 = solution.searchMatrix(mat1, 5);
        System.out.println("Result 1: [" + result1[0] + ", " + result1[1] + "]"); // Expected: [1, 1]

        // Search for the number 20 in the matrix
        int[] result2 = solution.searchMatrix(mat1, 20);
        System.out.println("Result 2: [" + result2[0] + ", " + result2[1] + "]"); // Expected: [-1, -1]
    }
}
// LC submission
/*
 * class Solution {
    public boolean searchMatrix(int[][] a, int k) {
                int n=a.length; int m=a[0].length;
        // using top right to bottom left direction
        int r=0; int c=m-1;
        while((r<=(n-1))&&(c>=0)){
            if(a[r][c]==k) return true;
            else if(a[r][c]<k) r++; // too low, search successive row
            else c--; // too high, search preceeding column
        } return false;

    }
}
 */

 // another code I found in LC forum, slightly faster
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
// 		// Start from the top-right corner
//         int i=0;
//         int j=matrix[0].length-1;
//         while(j>=0 && i<matrix.length){
//             if(matrix[i][j]==target)return true;
//             if(j-1>=0 && matrix[i][j-1]<target){
//                 i++;
//             }
//             else{
//                 if(j-1<0)i++;
//                 else j--;
//             }
//         }
//         return false;
//     }
// }