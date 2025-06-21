package Recursion_Pattern_Wise.Lec_3_TryingOutAllCombos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*Q3 51. N-Queens
Hard
Topics
Companies
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9
Seen this question in a real interview before?
1/5
Yes
No
Accepted
738.4K
Submissions
1.1M
Acceptance Rate
68.7% */
public class N_Queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][]board=new char[n][n];
        //fill whole board all places as blank marker
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='b';//b==blank
            }
        }
        //Create Hash Tables for storing lines of attack already occupied
        int[]lft=new int[n];
        int[]lftLoDiag=new int[n+n-1];
        int[]lftHiDiag=new int[n+n-1];
        //
        recurDFS(0,board,ans, n,lft,lftLoDiag,lftHiDiag); return ans;
    }

    private void recurDFS(int col, char[][] board, List<List<String>> ans, int n, int[]lft, int[]lftLoDiag, int[]lftHiDiag) {
        //check if beyond boards length
        if(col==n){
            ans.add(construct(board));
            return;
        }
        //Search Rows
        for(int row=0;row<n;row++){
            //if Q for the curr col is placeable in in this row
            if(validate(board,n, row,col,lft,lftLoDiag,lftHiDiag)){
                //put Q of curr col in that row
                board[row][col]='Q';
                //update hash tables
                lft[row]=1;
                lftLoDiag[row+col]=1;
                lftHiDiag[(n-1-row)+col]=1;
                //search next col Q place
                recurDFS(col+1, board, ans, n, lft, lftLoDiag, lftHiDiag);
                //Backtrack to previous state to enable exploring alternate paths in recursion tree
                board[row][col]='b';
                //revert hash tables
                lft[row]=0;
                lftLoDiag[row+col]=0;
                lftHiDiag[(n-1-row)+col]=0;
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String>currSet=new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            currSet.add(s);
        }
        return currSet;
    }

    private boolean validate(char[][] board, int n, int row, int col, int[] lft, int[] lftLoDiag, int[] lftHiDiag) {
        //See if given (row,col) is in line of attack of any other Q
        //check left attacks
        if(lft[row]!=0) return false;
        //chk diag attacks
        if(lftLoDiag[row+col]!=0||lftHiDiag[(n-row)+col]!=0) return false;
        //else
        return true;
    }
    
}
/*
//lc submission
class Solution {
  public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][]board=new char[n][n];
        //fill whole board all places as blank marker
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';//b==blank
            }
        }
        //Create Hash Tables for storing lines of attack already occupied
        int[]lft=new int[n];
        int[]lftLoDiag=new int[n+n-1];
        int[]lftHiDiag=new int[n+n-1];
        //
        recurDFS(0,board,ans, n,lft,lftLoDiag,lftHiDiag); return ans;
    }

    private void recurDFS(int col, char[][] board, List<List<String>> ans, int n, int[]lft, int[]lftLoDiag, int[]lftHiDiag) {
        //check if beyond boards length
        if(col==n){
            ans.add(construct(board));
            return;
        }
        //Search Rows
        for(int row=0;row<n;row++){
            //if Q for the curr col is placeable in in this row
            if(validate(board,n, row,col,lft,lftLoDiag,lftHiDiag)){
                //put Q of curr col in that row
                board[row][col]='Q';
                //update hash tables
                lft[row]=1;
                lftLoDiag[row+col]=1;
                lftHiDiag[(n-1-row)+col]=1;
                //search next col Q place
                recurDFS(col+1, board, ans, n, lft, lftLoDiag, lftHiDiag);
                //Backtrack to previous state to enable exploring alternate paths in recursion tree
                board[row][col]='.';
                //revert hash tables
                lft[row]=0;
                lftLoDiag[row+col]=0;
                lftHiDiag[(n-1-row)+col]=0;
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String>currSet=new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            currSet.add(s);
        }
        return currSet;
    }

    private boolean validate(char[][] board, int n, int row, int col, int[] lft, int[] lftLoDiag, int[] lftHiDiag) {
        //See if given (row,col) is in line of attack of any other Q
        //check left attacks
        if(lft[row]!=0) return false;
        //chk diag attacks
        if(lftLoDiag[row+col]!=0||lftHiDiag[(n-1-row)+col]!=0) return false;
        //else
        return true;
    }
} */