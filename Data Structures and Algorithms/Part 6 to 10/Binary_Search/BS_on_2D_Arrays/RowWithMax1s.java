package Binary_Search.BS_on_2D_Arrays;
/*
 * Q1
 * Find the row with maximum number of 1's

Problem Statement: You have been given a non-empty grid ‘mat’ with 'n' rows and 'm' columns consisting of only 0s and 1s. All the rows are sorted in ascending order.
Your task is to find the index of the row with the maximum number of ones.
Note: If two rows have the same number of ones, consider the one with a smaller index. If there's no row with at least 1 zero, return -1.

Pre-requisite: Lower Bound implementation, Upper Bound implementation, & Find the first occurrence of a number.

Examples
Example 1:
Input Format:
 n = 3, m = 3, 
mat[] = 
1 1 1
0 0 1
0 0 0
Result:
 0
Explanation:
 The row with the maximum number of ones is 0 (0 - indexed).

Example 2:
Input Format:
 n = 2, m = 2 , 
mat[] = 
0 0
0 0
Result:
 -1
Explanation:
  The matrix does not contain any 1. So, -1 is the answer.
 */
public class RowWithMax1s {
    int rowWithMax1s(int a[][], int n, int m) {
        int max=0;
        int max_index=-1;
        for(int i=0;i<n;i++){
            int cut1s=m-lowerBound(a[i], m, 1); // #1s in ith row = #cols - col. index of encountering 1st '1'
            if(cut1s>max){
                max=cut1s;
                max_index=i;
            }
            if(max==m) return max_index; // early return, if any row has #1s = #cols, just return that row, no need to check further
        } return max_index;
    }
    public static int lowerBound(int[]a, int n, int k)
    {
        int l=0; int r=n-1; int LUB=n; // Random Ini.
        while(l<=r)
        {
            int m = l+(r-l)/2;
            if(a[m]<k) l=m+1;
            else if(a[m]>=k) 
            {
                LUB=m;
                r=m-1;
            }
        }
        return LUB;
    }
    public static void main(String[] args) {
        RowWithMax1s solution = new RowWithMax1s();
        int[][] mat1 = {
            {1, 1, 1},
            {0, 0, 1},
            {0, 0, 0}
        };
        int result1 = solution.rowWithMax1s(mat1, 3, 3);
        System.out.println("Result 1: " + result1); // Expected: 0

        int[][] mat2 = {
            {0, 0},
            {0, 0}
        };
        int result2 = solution.rowWithMax1s(mat2, 2, 2);
        System.out.println("Result 2: " + result2); // Expected: -1
    }
}
