package Recursion_Pattern_Wise.Lec_3_TryingOutAllCombos;
/*Q7 
Code
Testcase
Testcase
Test Result
37. Sudoku Solver
Hard
Topics
Companies
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 

Example 1:


Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:


 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
600.2K
Submissions
974.7K
Acceptance Rate
61.6% */
public class Solve_Sodoku {
    public void solve_Sudoku(char[][] board) {
        solveSudoku(board);
    }

    public boolean solveSudoku(char[][] board) {
        // tail recursion soln. -> recursive case before base case check
        // iterate entire board for blanks 
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
            // when blank found
                if (board[i][j] == '.') {
                    // check if any char fits
                    for (char c = '1'; c <= '9'; c++) {
                        if (possible(c,i,j,board)==true) {
                            // if char fits put it there
                            board[i][j] = c;
                            // recursively calls for next blanks, explore this possibility with curent char fixed
                            if(solveSudoku(board)==true) return true;
                            // backtrack, unfix current char 
                            //only if curr char not lead to soln. that satify all rules
                            board[i][j] = '.';
                        }
                    } return false;// no no. works to avoid breaking some rule
                }
            }
        } return true;// if no blanks found, Base case
    }

    private boolean possible(char c, int row, int col, char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)
              return false;
      
            if (board[row][i] == c)
              return false;
      
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
              return false;
          }
          return true;
    }
    
}
/*
 * //faster soln, in lc forum
 * class Solution {
    public void solveSudoku(char[][] board) {
        // We are going to need to edit our sudoku board
        solve(board, 0, 0);
    }

    public boolean solve(char[][] board, int row, int col) {
        // If the col is 9, that means you've filled out a whole row. Start the search on the next row by resetting column and incrementing the row by 1
        if (col == board[0].length) {
            col = 0;
            row += 1;
        }
        // If you've reached 9, that means you didn't run into any errors with your blocks in the previous rows, so you have a valid solution
        if (row == board.length) {
            return true; 
        }
        // If this piece already has a value, check the next square
        if (board[row][col] != '.') return solve(board, row, col+1);
        // We want to try every number for this block
        for (char num = '1'; num <= '9'; num++) {
            // Self explanatory, don't run this if the number isn't a valid answer
            if (checkIfValid(board, row, col, num)) {
                // Set the value of the current square to the valid num
                board[row][col] = num;
                // Run this algo for the next square over
                boolean solved = solve(board, row, col+1);
                // The only way we can trigger a true is if we got to the end, so if it's true that means we have a solved board so you just keep returning
                if (solved) return true;
                // If our board isn't solved, backtrack and try the next number
                else board[row][col] = '.';
            }
        }
        // You get this when every value of the board is filled, because you don't run anything on it
        // If you get to this step, that means that no values fit, which means the current iteration of the board is wrong so return false and try the previous step again with a different value
        return false;
    }

    public boolean checkIfValid(char[][] board, int row, int col, char value) {
        for (int i = 0; i < board.length; i++) {
            // Check the column for duplicates
            if (board[i][col] == value) return false; 
            // Check the row for duplicates
            if (board[row][i] == value) return false;
        }
        // This generates our "box", for [1, 1] for example, this pair will be the box bound by [0, 2] and [0,2]
        int boxRow = row / 3;
        int boxCol = col / 3;
        for (int i = boxRow * 3; i < (boxRow + 1) * 3; i++) {
            for (int j = boxCol * 3; j < (boxCol + 1) * 3; j++) {
                // Check the box for duplicates
                if (board[i][j] == value) return false;
            }
        }
		// There are no falses, therefore this is a valid number to put on the square
        return true;
    }
}
    //https://leetcode.com/problems/sudoku-solver/solutions/1100767/java-5ms-backtracking-solution-using-dfs-with-line-by-line-explanation/
 */