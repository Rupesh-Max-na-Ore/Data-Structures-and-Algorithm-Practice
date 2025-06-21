package Binary_Search.BS_on_2D_Arrays;
/*
 * Q5
 * Median of Row Wise Sorted Matrix

Problem Statement: Given a row-wise sorted matrix of size MXN, where M is no. of rows and N is no. of columns, find the median in the given matrix.

Note: MXN is odd.

Examples
Example 1:
Input Format:M = 3, N = 3, matrix[][] =

                    1 4 9 
                    2 5 6
                    3 8 7
                    
Result: 5
Explanation:  If we find the linear sorted array, the array becomes 1 2 3 4 5 6 7 8 9. So, median = 5
Example 2:
Input Format:M = 3, N = 3, matrix[][] =

                    1 3 8 
                    2 3 4
                    1 2 5
                    
Result: 3
Explanation:  If we find the linear sorted array, the array becomes 1 1 2 2 3 3 4 5 7 8. So, median = 3
 */
public class MedianInRowSortedMatrix {

    public int median(int[][] a, int n, int m) {
        int l = Integer.MAX_VALUE; int r = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            l = Math.min(l, a[i][0]);
            r = Math.max(r, a[i][m - 1]);
        }

        int need = (n * m) / 2;
        while (l <= r) {
            int mid = (l + r) / 2;
            int smallEqual = countSmallEqual(a, n, m, mid);
            if (smallEqual <= need) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }

    public static int countSmallEqual(int[][] a, int n, int m, int x) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += upperBound(a[i], x, m);
        }
        return cnt;
    }

    public static int upperBound(int[] a, int x, int n) {
        // Basically, to find a the Least Strictly Greater no. in a[] than x
        int l=0; int r=n-1; int ub=n;//Var. Ini.
        while(l<=r){
            int m=l+(r-l)/2;
            if(a[m]<=x) l=m+1; // Narrow search range to left subspace
            else if(a[m]>x)
            {
                ub=m;// m might be ub
                r=m-1; // Try to find a new-ub < curr-ub, that is still >x
            }
        }
        return ub;
    }

    public static void main(String[] args) {
        // Test cases
        int[][] matrix1 = { { 1, 4, 9 }, { 2, 5, 6 }, { 3, 8, 7 } };
        int[][] matrix2 = { { 1, 3, 8 }, { 2, 3, 4 }, { 1, 2, 5 } };

        int n1 = 3, m1 = 3; // Dimensions of matrix1
        int n2 = 3, m2 = 3; // Dimensions of matrix2

        MedianInRowSortedMatrix obj = new MedianInRowSortedMatrix();

        // Test the median method
        System.out.println("Median of matrix1: " + obj.median(matrix1, n1, m1)); // Output: 5
        System.out.println("Median of matrix2: " + obj.median(matrix2, n2, m2)); // Output: 3
    }
    
}
