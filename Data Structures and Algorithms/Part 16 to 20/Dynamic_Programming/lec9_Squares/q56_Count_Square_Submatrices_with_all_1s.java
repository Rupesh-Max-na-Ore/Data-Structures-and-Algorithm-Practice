package Dynamic_Programming.lec9_Squares;
/*1277. Count Square Submatrices with All Ones
Medium
Topics
Companies
Hint
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 

Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1
Seen this question in a real interview before?
1/5
Yes
No
Accepted
340.8K
Submissions
433.6K
Acceptance Rate
78.6%
Topics
Array
Dynamic Programming
Matrix
Companies
Hint 1
Create an additive table that counts the sum of elements of submatrix with the superior corner at (0,0).
Hint 2
Loop over all subsquares in O(n^3) and check if the sum make the whole array to be ones, if it checks then add 1 to the answer. */
public class q56_Count_Square_Submatrices_with_all_1s {
    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int sum = 0;
        int [][] cnt = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (i == 0 || j == 0) {
                    if (matrix[i][j]==1)
                        sum++;
                    cnt[i][j] = matrix[i][j];
                    continue;
                }
                if(matrix[i][j] == 0) continue;

                int current = matrix[i][j];
                int up = cnt[i-1][j];
                int left = cnt[i][j-1];
                int diag = cnt[i-1][j-1];
                
                int mini = Math.min(up,Math.min(left,diag));
                cnt[i][j] = mini + 1;


                sum += (mini +1); 
            }
        }

        for(int i = 0; i<m;i++){
            for(int j=0 ; j<n;j++){
                System.out.print(cnt[i][j] + " ");
            }
            System.out.println();
        }

        return sum;
    }

    public static void main(String args[]){
        int[][] test = {
            {1,1,1,1},
            {1,1,1,1},
            {1,1,1,0}
        };

        countSquares(test);


    }

    public static int countSquares_(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int sum = 0;
        int [][] cnt = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (i == 0 || j == 0) {
                    if (matrix[i][j]==1)
                        sum++;
                    cnt[i][j] = matrix[i][j];
                    continue;
                }
                if(matrix[i][j] == 0) continue;

                int up = cnt[i-1][j];
                int left = cnt[i][j-1];
                int diag = cnt[i-1][j-1];
                
                int mini = Math.min(up,Math.min(left,diag));
                cnt[i][j] = mini + 1;


                sum += (mini +1); 
            }
        }

        return sum;
    }
}

// class Solution {
//     public int countSquares(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int sum = 0;

//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 if (i == 0 || j == 0) {
//                     if (matrix[i][j]==1)
//                         sum++;
//                     continue;
//                 }
//                 if(matrix[i][j] == 0) continue;

//                 int current = matrix[i][j];
//                 int up = matrix[i-1][j];
//                 int left = matrix[i][j-1];
//                 int diag = matrix[i-1][j-1];
                
//                 int mini = Math.min(up,Math.min(left,diag));

//                 sum += (mini +1); 
//             }
//         }

//         return sum;
//     }
// }
