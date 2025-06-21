package Graphs.Lec2_ProblemsOnBfsDfs;
/*
Code
Testcase
Test Result
Test Result
130. Surrounded Regions
Medium
Topics
Companies
You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

 

Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Explanation:


In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

Example 2:

Input: board = [["X"]]

Output: [["X"]]

 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
894.2K
Submissions
2.1M
Acceptance Rate
42.1% */
public class q14_Surrounded_Regions_dfs {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][]vis=new boolean[n][m];
        // Detect boundary Os
        for(int i=0;i<m;i++){
            if(board[0][i]=='O') dfs(board,n,m,0,i,vis);
            if(board[n-1][i]=='O') dfs(board,n,m,n-1,i,vis);
        }
        for(int i=0;i<n;i++){
            if(board[i][0]=='O') dfs(board,n,m,i,0,vis);
            if(board[i][m-1]=='O') dfs(board,n,m,i,m-1,vis);
        }
        // leaving truths, all  turn to Xs
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[j][i]) board[j][i]='X';
            }
        }
    }
            
    private void dfs(char[][] board, int n, int m, int i, int i2, boolean[][] vis) {
        int[]dx={0,-1,0,+1};
        int[]dy={-1,0,+1,0};
        vis[i][i2]=true;
        for(int k=0;k<4;k++){
            int nr=i+dx[k];
            int nc=i2+dy[k];
            if(nr>=0 && nc>=0 && nr<n && nc<m && !vis[nr][nc] && board[nr][nc]=='O') dfs(board, n, m, nr, nc, vis);
        }
    }
    
}
