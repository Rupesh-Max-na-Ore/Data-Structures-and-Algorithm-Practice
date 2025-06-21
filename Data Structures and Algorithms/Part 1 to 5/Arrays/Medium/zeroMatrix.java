package Arrays.Medium;
// //q11
// 73. Set Matrix Zeroes
// Medium
// Topics
// Companies
// Hint
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

import java.util.Arrays;

// You must do it in place.

 

// Example 1:


// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Example 2:


// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

// Constraints:

// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
 

// Follow up:

// A straightforward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 1.4M
// Submissions
// 2.5M
// Acceptance Rate
// 55.7%
public class zeroMatrix {
    public static void setZeroes(int[][] A) {
        int n=A.length; int m=A[0].length;
        int c0=1;
        int i,j;
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                if(A[i][j]==0){
                    A[i][0]=0;
                    if(j==0) c0=0;
                    else A[0][j]=0;
                }
            }
        }
        for(i=1;i<n;i++){
            for(j=1;j<m;j++){
                if(A[i][0]==0||A[0][j]==0){
                    A[i][j]=0;
                }
            }
        }
        if(A[0][0]==0){
            for(j=0;j<m;j++){A[0][j]=0;}
        }
        if(c0==0){
            for(i=0;i<n;i++){A[i][0]=0;}
        }
        //return A;
    }
    
    public static void main(String[] args) {
        int [][] A={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        // Print the 2D array using Arrays.deepToString
        System.out.println(Arrays.deepToString(A));
        // System.out.println(Arrays.toString(A));
         zeroMatrix.setZeroes(A);
        // System.out.println(Arrays.toString(A));
        // abpve not woprks
        // Print the 2D array using Arrays.deepToString
        System.out.println(Arrays.deepToString(A));
    }
}
// //lc submission
// class Solution {
//     public void setZeroes(int[][] A) {
//                 int n=A.length; int m=A[0].length;
//         int c0=1;
//         int i,j;
//         for(i=0;i<n;i++){
//             for(j=0;j<m;j++){
//                 if(A[i][j]==0){
//                     A[i][0]=0;
//                     if(j==0) c0=0;
//                     else A[0][j]=0;
//                 }
//             }
//         }
//         for(i=1;i<n;i++){
//             for(j=1;j<m;j++){
//                 if(A[i][0]==0||A[0][j]==0){
//                     A[i][j]=0;
//                 }
//             }
//         }
//         if(A[0][0]==0){
//             for(j=0;j<m;j++){A[0][j]=0;}
//         }
//         if(c0==0){
//             for(i=0;i<n;i++){A[i][0]=0;}
//         }

//     }
// }