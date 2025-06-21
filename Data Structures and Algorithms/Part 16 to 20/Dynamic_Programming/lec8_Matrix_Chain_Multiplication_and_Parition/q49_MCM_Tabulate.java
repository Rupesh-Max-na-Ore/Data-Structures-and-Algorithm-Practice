package Dynamic_Programming.lec8_Matrix_Chain_Multiplication_and_Parition;

import java.util.Arrays;

public class q49_MCM_Tabulate {
    // Function to recursively calculate the minimum number of operations for matrix multiplication
    static int f(int[] arr, int i, int j, int[][] dp) {
        // Base condition
        if (i == j) {
            return 0;
        }

        // Check if the result is already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int minOperations = Integer.MAX_VALUE;

        // Partitioning loop to find the optimal split point
        for (int k = i; k <= j - 1; k++) {
            int operations = f(arr, i, k, dp) + f(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];
            minOperations = Math.min(minOperations, operations);
        }

        dp[i][j] = minOperations;
        return minOperations;
    }

    // Function to find the minimum number of operations for matrix multiplication
    static int matrixMultiplication(int[] arr, int N) {
        int[][] dp = new int[N][N];

        // Initialize the dp array with -1
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        // Initialize the diagonal with 0
        for (int i = 1; i < N; i++) {
            dp[i][i] = 0;
        }

        // Fill in the dp array using bottom-up approach
        for (int i = N - 1; i >= 1; i--) {
            for (int j = i + 1; j < N; j++) {
                int minOperations = Integer.MAX_VALUE;

                // Partitioning loop to find the optimal split point
                for (int k = i; k <= j - 1; k++) {
                    int operations = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    minOperations = Math.min(minOperations, operations);
                }

                dp[i][j] = minOperations;
            }
        }
        System.out.println("The minimum number of operations are " + dp[2][4]);
        // The result is stored in dp[1][N-1]
        return dp[1][N - 1];
    }

    public static void main(String[] args) {
        // int[] arr = {10, 20, 30, 40, 50};
        int[] arr = {2, 3, 4, 6, 5};

        int n = arr.length;

        System.out.println("The minimum number of operations are " + matrixMultiplication(arr, n));
    }
}
