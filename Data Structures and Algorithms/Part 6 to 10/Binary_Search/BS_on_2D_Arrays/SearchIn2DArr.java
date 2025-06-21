package Binary_Search.BS_on_2D_Arrays;
/*
 * Q2 
 * Search in 2D Matrix
 */
public class SearchIn2DArr {
    /*This approach treats the 2D matrix as a flattened 1D array for the purpose of binary search, 
    ensuring a time complexity of O(log(m*n)), which is efficient for large matrices. */
    public int[] searchMatrix(int[][] a, int k) {
        int n=a.length; int m=a[0].length;
        int l=0; int r=m*n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int ro=mid/m;
            int c=mid%m;
            if(a[ro][c]==k) return new int[] {ro,c};
            else if(a[ro][c]<k) l=mid+1;
            else r=mid-1; 
        } return new int[] {-1,-1};
    }
    public static void main(String[] args) {
        SearchIn2DArr solution = new SearchIn2DArr();
        int[][] mat1 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        // Search for the number 3 in the matrix
        int[] result1 = solution.searchMatrix(mat1, 3);
        System.out.println("Result 1: [" + result1[0] + ", " + result1[1] + "]"); // Expected: [0, 1]

        // Search for the number 13 in the matrix
        int[] result2 = solution.searchMatrix(mat1, 13);
        System.out.println("Result 2: [" + result2[0] + ", " + result2[1] + "]"); // Expected: [-1, -1]
    }
}
/*
 * LC submission
 * class Solution {
    public boolean searchMatrix(int[][] a, int k) {
        int n=a.length; int m=a[0].length;
        int l=0; int r=m*n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int ro=mid/m;
            int c=mid%m;
            if(a[ro][c]==k) return true;
            else if(a[ro][c]<k) l=mid+1;
            else r=mid-1; 
        } return false;
    }
}


 */