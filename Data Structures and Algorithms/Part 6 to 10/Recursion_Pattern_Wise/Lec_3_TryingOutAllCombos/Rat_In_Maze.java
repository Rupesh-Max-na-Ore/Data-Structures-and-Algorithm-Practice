package Recursion_Pattern_Wise.Lec_3_TryingOutAllCombos;

import java.util.ArrayList;
import java.util.List;

/*Q4 Rat in a Maze Problem - I
MediumAccuracy: 35.75%Submissions: 249K+Points: 4
Be the comment of the day in POTD and win a GfG T-Shirt!
Solve right now

banner
Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.

Example 1:

Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - DRDDRR 
and DDRDRR, when printed in sorted order 
we get DDRDRR DRDDRR.
Example 2:
Input:
N = 2
m[][] = {{1, 0},
         {1, 0}}
Output:
-1
Explanation:
No path exists and destination cell is 
blocked.
Your Task:  
You don't need to read input or print anything. Complete the function printPath() which takes N and 2D array m[ ][ ] as input parameters and returns the list of paths in lexicographically increasing order. 
Note: In case of no path, return an empty list. The driver will output "-1" automatically.

Expected Time Complexity: O((3N^2)).
Expected Auxiliary Space: O(L * X), L = length of the path, X = number of paths.

Constraints:
2 ≤ N ≤ 5
0 ≤ m[i][j] ≤ 1

 */
public class Rat_In_Maze {
    //2nd attempt, minor improvements
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        if(m[n-1][n-1] != 1) return ans;
        if (m[0][0] != 1) return ans;
        int vis[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }
        int di[] = {+1, 0, 0, -1};
        int dj[] = {0, -1, +1, 0};
        //if (m[0][0] == 1) 
        recurChk(0, 0, m, n, ans, "", vis, di, dj);
        return ans;
    }

    // i=row, j=col
    private static void recurChk(int i, int j, int[][] m, int n, List<String> ans, String movesSB, int[][] vis, int[] di, int[] dj) {
        if (i == n - 1 && j == n - 1) {
            ans.add(movesSB);
            return;
        }

        char[] dirs = {'D', 'L', 'R', 'U'};
        for (int ind = 0; ind < 4; ind++) {
            int nextrow = i + di[ind];
            int nextcol = j + dj[ind];
            if (nextrow >= 0 && nextrow < n && nextcol >= 0 && nextcol < n && vis[nextrow][nextcol] == 0 && m[nextrow][nextcol] == 1) {
                vis[i][j] = 1;
                recurChk(nextrow, nextcol, m, n, ans, movesSB + dirs[ind], vis, di, dj);
                vis[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int[][] maze1 = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };
        System.out.println(findPath(maze1, 4)); // Expected output: [DDRDRR, DRDDRR]

        // Test Case 2
        int[][] maze2 = {
            {1, 0},
            {1, 0}
        };
        System.out.println(findPath(maze2, 2)); // Expected output: []
    }
//first attempt, some mistakes
//     public static ArrayList<String> findPath(int[][] m, int n) {
//         ArrayList<String> ans = new ArrayList<>();
//         //keepa visted matrix;
//         int vis[][]=new int[n][n];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 vis[i][j]=0;
//             }
//         }
//         //to store direction offsets
//         int di[]={+1,0,0,-1};
//         int dj[]={0,-1,+1,0};
//         if(m[0][0]==1) recurChk(0,0,m,n,ans,"",vis,di,dj);
//         return ans;
//     }
//     //i=row,j=col
//     private static void recurChk(int i, int j, int[][] m, int n, List<String> ans, String movesSB, int[][] vis,
//             int[] di, int[] dj) {
//                 //if reach destination, return
//                 if(i==n-1 && j==n-1){
//                     ans.add(new String(movesSB));
//                     return;
//                 }
//                 char[] dirs={'D','L','R','U'};
//                 for(int ind=0; ind<4; ind++){
//                     int nextcol=i+di[ind];
//                     int nextrow=j+dj[ind];
//                     if(nextcol>=0 && nextcol<n && nextrow>=0 && nextcol<n && vis[nextrow][nextcol]==0 && m[nextrow][nextcol]==1){
//                         //mark curr place as visted
//                         vis[i][j]=1;
//                         //explore further after fixing curr place
//                         recurChk(nextrow, nextcol, m, nextrow, ans, (movesSB + dirs[ind]), vis, di, dj);
//                         //Backtracking, umark and unfix curr place
//                         vis[i][j]=0;
//                     }
//                 } 
//     }

//Corrected 1st attempt, refer for comments here
// //i=row,j=col
// private static void recurChk(int i, int j, int[][] m, int n, List<String> ans, String movesSB, int[][] vis,
// int[] di, int[] dj) {
//     //if reach destination, return
//     if(i==n-1 && j==n-1){
//         ans.add(movesSB);
//         return;
//     }
//     char[] dirs={'D','L','R','U'};
//     for(int ind=0; ind<4; ind++){
//         int nextrow=i+di[ind];
//         int nextcol=j+dj[ind];
//         // if(nextcol>=0 && nextcol<n && nextrow>=0 && nextcol<n && vis[nextrow][nextcol]==0 && m[nextrow][nextcol]==1){
//         if (nextrow >= 0 && nextrow < n && nextcol >= 0 && nextcol < n && vis[nextrow][nextcol] == 0 && m[nextrow][nextcol] == 1) {

//             //mark curr place as visted
//             vis[i][j]=1;
//             //explore further after fixing curr place
//             recurChk(nextrow, nextcol, m, n, ans, (movesSB + dirs[ind]), vis, di, dj);
//             //Backtracking, umark and unfix curr place
//             vis[i][j]=0;
//         }
//     } 
// }
}
