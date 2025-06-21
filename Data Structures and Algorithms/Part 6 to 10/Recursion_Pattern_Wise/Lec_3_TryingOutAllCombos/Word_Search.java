package Recursion_Pattern_Wise.Lec_3_TryingOutAllCombos;
/*Q2 79. Word Search
Medium
Topics
Companies
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?

Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.7M
Submissions
4M
Acceptance Rate
43.0% */
public class Word_Search {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        int drow[]={-1,+1,0,0};//top,bot,rit,lft offsets
        int dcol[]={0,0,+1,-1};
        //FInd 1st letter of s in board
        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==word.charAt(0)){
                    int indx=0;
                    if(searchNextLetter(board, m, n, word, i, j, indx, drow, dcol)) return true;
                }
            }
        } return false;
    }

    private boolean searchNextLetter(char[][] board, int m, int n, String word, int row, int col, int indx, int[] drow, int[] dcol) {
        if(indx==word.length()) return true;//Base-found all letters
        // all edge/corner cases and not found/already used cases
        if(row<0||col<0||row==m||col==n||board[row][col]!=word.charAt(indx)||board[row][col]=='!') return false;
        // to avoid reuse of same char that's alredy been used
        char c = board[row][col];
        board[row][col]='!';
        //Adjacent checks - top, bot, rit, lft here
        boolean [] adj=new boolean[4];
        boolean cumul = false;// var. to tell if match for indx th pos. at any adjacent found at all
        for(int k=0;k<4;k++){
            adj[k] = searchNextLetter(board, m, n, word, (row + drow[k]), (col + dcol[k]), indx+1, drow, dcol);
            cumul = cumul||adj[k];
        }
        board[row][col]=c;//backtrack, restore prev. state of board
        return cumul;
    }
}
// // fastest soln. found on LC, for later learning
//https://leetcode.com/problems/word-search/solutions/4965080/100-beats-fully-explained-code-with-comments-2-approaches/
// class Solution {
//     // Main function to check if the word exists on the board
//     public boolean exist(char[][] board, String word) {
//         int n = board.length; // Number of rows in the board
//         int m = board[0].length; // Number of columns in the board
        
//         boolean[][] visited = new boolean[n][m]; // Array to keep track of visited cells
        
//         char[] wordChar = word.toCharArray(); // Convert the word into a character array
        
//         // Quick check: If the length of the word exceeds the total number of cells on the board, it can't exist
//         if (wordChar.length > n * m)
//             return false;
        
//         int counts[] = new int[256]; // Array to store counts of each character
        
//         // Count the occurrence of each character on the board
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 counts[board[i][j]]++;
//             }
//         }
        
//         // Adjust the order of characters in the wordChar array based on their frequency counts to optimize search
//         int len = wordChar.length;
//         for(int i=0; i<len/2; i++) {
//             if(counts[wordChar[i]] > counts[wordChar[len - 1 - i]]) {
//                 for(int j=0; j<len/2; j++) {
//                     char temp = wordChar[j];
//                     wordChar[j] = wordChar[len - 1 - j];
//                     wordChar[len - 1 - j] = temp;
//                 }
//                 break;
//             }
//         }
        
//         // Decrease counts of characters in the word from the board
//         for (char c : wordChar) {
//             if (--counts[c] < 0)
//                 return false; // If there are more occurrences of a character in the word than on the board, return false
//         }
        
//         // Iterate through each cell in the board and start searching for the word
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (visit(board, wordChar, 0, i, j, n, m, visited))
//                     return true; // If the word is found starting from this cell, return true
//             }
//         }
//         return false; // If the loop completes without finding the word, return false
//     }

//     // Helper function to recursively search for the word starting from a given cell
//     private boolean visit(char[][] board, char[] word, int start, int x, int y,
//             int n, int m, boolean[][] visited) {
//         // Base case: If all characters in the word are found, return true
//         if (start == word.length)
//             return true;
        
//         // Check for out-of-bounds, already visited cells, and character mismatch
//         if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y])
//             return false;
        
//         // If the current character in the word does not match the character on the board, return false
//         if (word[start] != board[x][y])
//             return false;
        
//         visited[x][y] = true; // Mark the current cell as visited
        
//         // Recursively search in all four directions from the current cell
//         boolean found = visit(board, word, start + 1, x + 1, y, n, m, visited)
//                 || visit(board, word, start + 1, x - 1, y, n, m, visited)
//                 || visit(board, word, start + 1, x, y + 1, n, m, visited)
//                 || visit(board, word, start + 1, x, y - 1, n, m, visited);
        
//         visited[x][y] = false; // Backtrack: Unmark the current cell as visited
        
//         return found; // Return whether the word was found starting from the current cell
//     }
// }
//another nice explanation
// https://leetcode.com/problems/word-search/solutions/1908561/c-how-to-prune-the-dfs-to-0ms/
