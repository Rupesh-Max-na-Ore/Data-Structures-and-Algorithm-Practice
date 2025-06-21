package Arrays.Medium;
//q12
// 48. Rotate Image
// Medium
// Topics
// Companies
// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

import java.util.Arrays;

// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

// Example 1:


// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]
// Example 2:


// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

// Constraints:

// n == matrix.length == matrix[i].length
// 1 <= n <= 20
// -1000 <= matrix[i][j] <= 1000
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 1.7M
// Submissions
// 2.3M
// Acceptance Rate
// 74.4%

public class rotateMatrix {
    public static void rotate(int[][] A) {
        int n=A.length; //int m=A[0].length;
        int i,j;
        //Transpose
        for(i=0;i<n;i++){
            for(j=i;j<n;j++){
                int temp = 0;
                temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        //Reverse each row
        for(i=0;i<n;i++){
            for(j=0;j<n/2;j++){
                int temp = 0;
                temp = A[i][j];
                A[i][j] = A[i][n-1-j];
                A[i][n-1-j] = temp;
            }
        }
        
    }

    public static void main(String[] args) {
        int [][] A={{0,1,2},{4,5,6},{8,9,-99}};
        // Print the 2D array using Arrays.deepToString
        System.out.println(Arrays.deepToString(A));
        // System.out.println(Arrays.toString(A));
         rotateMatrix.rotate(A);
        // System.out.println(Arrays.toString(A));
        // abpve not work
        // Print the 2D array using Arrays.deepToString
        System.out.println(Arrays.deepToString(A));
    }
}

// //lc submit,exactly same
// class Solution {
//     public void rotate(int[][] A) {
//                 int n=A.length; //int m=A[0].length;
//         int i,j;
//         //Transpose
//         for(i=0;i<n;i++){
//             for(j=i;j<n;j++){
//                 int temp = 0;
//                 temp = A[i][j];
//                 A[i][j] = A[j][i];
//                 A[j][i] = temp;
//             }
//         }
//         //Reverse each row
//         for(i=0;i<n;i++){
//             for(j=0;j<n/2;j++){
//                 int temp = 0;
//                 temp = A[i][j];
//                 A[i][j] = A[i][n-1-j];
//                 A[i][n-1-j] = temp;
//             }
//         }
        

//     }
// }