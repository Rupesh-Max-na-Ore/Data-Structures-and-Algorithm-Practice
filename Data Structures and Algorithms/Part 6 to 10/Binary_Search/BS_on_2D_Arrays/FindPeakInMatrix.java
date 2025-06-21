package Binary_Search.BS_on_2D_Arrays;
/*
 * Q4
 * 1901. Find a Peak Element II
Medium
A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

 

Example 1:



Input: mat = [[1,4],[3,2]]
Output: [0,1]
Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
Example 2:



Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
Output: [1,1]
Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 500
1 <= mat[i][j] <= 105
No two adjacent cells are equal.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
66.8K
Submissions
130.2K
Acceptance Rate
51.3%
 */
public class FindPeakInMatrix{
    public int[] findPeakGrid(int[][] a) {
        int r0=a.length; int c=a[0].length;
        int l=0; int r=c-1;
        while(l<=r){
            int m=(l+r)/2;
            int maxRowIndex=findMaxRow(a,r0,c,m); // Find the row index with the max elem in col 'm'
            int lft=(m-1>=0)?a[maxRowIndex][m-1]:-1; // Value to the left of the mid elem
            int rit=(m+1<=c-1)?a[maxRowIndex][m+1]:-1; // Value to the right of the mid elem
            
            // Check if the mid elem is a peak
            if((a[maxRowIndex][m]>lft) && (a[maxRowIndex][m]>rit)) return new int[]{maxRowIndex,m};
            else if (a[maxRowIndex][m]<lft) r=m-1; // Search in the left half, might have peak in that col.
            else l=m+1; // Search in the right half, might have peak in that col.
        } return new int[] {-1,-1};
    }

    private int findMaxRow(int[][] a, int r, int c, int col) {
        int maxRowIndex=-1; int maxElem=-1;
        // Check if the current elem is greater than the current max
        for(int i=0; i<r; i++){
            if((a[i][col]>maxElem)){
                maxElem=a[i][col];
                maxRowIndex=i;
            }
        }        return maxRowIndex;
    }

    public static void main(String[] args) {
        // Test cases
        FindPeakInMatrix solution = new FindPeakInMatrix();
        int[][] mat1 = {{1, 4}, {3, 2}};
        int[][] mat2 = {{10, 20, 15}, {21, 30, 14}, {7, 16, 32}};

        int[] peak1 = solution.findPeakGrid(mat1);
        System.out.println("Peak in mat1: [" + peak1[0] + ", " + peak1[1] + "]");

        int[] peak2 = solution.findPeakGrid(mat2);
        System.out.println("Peak in mat2: [" + peak2[0] + ", " + peak2[1] + "]");
    }
}

// // lc submission
// class Solution {
//     public int[] findPeakGrid(int[][] a) {
//         int r0=a.length; int c=a[0].length;
//         int l=0; int r=c-1;
//         while(l<=r){
//             int m=(l+r)/2;
//             int maxRowIndex=findMaxRow(a,r0,c,m);
//             int lft=(m-1>=0)?a[maxRowIndex][m-1]:-1;
//             int rit=(m+1<=c-1)?a[maxRowIndex][m+1]:-1;

//             if((a[maxRowIndex][m]>lft) && (a[maxRowIndex][m]>rit)) return new int[]{maxRowIndex,m};
//             else if (a[maxRowIndex][m]<lft) r=m-1;
//             else l=m+1; 
//         } return new int[] {-1,-1};
//     }

//     private int findMaxRow(int[][] a, int r, int c, int col) {
//         int maxRowIndex=-1; int maxElem=-1;
//         for(int i=0; i<r; i++){
//             if((a[i][col]>maxElem)){
//                 maxElem=a[i][col];
//                 maxRowIndex=i;
//             }
//         }        return maxRowIndex;
//     }
// }