package Binary_Search.BS_on_Answers;
/*
 * Q2
 * Nth Root of a Number using Binary Search

Problem Statement: Given two numbers N and M, find the Nth root of M. The nth root of a number M is defined as a number X when raised to the power N equals M. If the 'nth root is not an integer, return -1.

Examples
Example 1:
Input Format:
 N = 3, M = 27
Result:
 3
Explanation:
 The cube root of 27 is equal to 3.

Example 2:
Input Format:
 N = 4, M = 69
Result:
 -1
Explanation:
 The 4th root of 69 does not exist. So, the answer is -1.
 */
public class NthRoot {
    public double nthRoot(double x, int n) {
        // Special case for 0 and 1
        if (x == 0) return 0;
        if (x == 1 || n == 1) return x;

        // Ini. the range for binary search
        double low = 0;
        double high = x;
        double epsilon = 1e-7; // Precision level 
        double root = 0;

        while ((high - low) > epsilon) {
            double mid = low + (high - low) / 2.0;
            double midPow = Math.pow(mid, n);

            if (midPow == x) {
                return mid; // Exact Nth root found
            } else if (midPow < x) {
                root = mid; // Possible answer, move to the right half
                low = mid;
            } else {
                high = mid; // Move to the left half
            }
        }

        return root;
    }

    public static void main(String[] args) {
        NthRoot nthRootCalculator = new NthRoot();

        // Test cases
        double[] numbers = {0, 1, 8, 27, 16, 32, 81, 100, 2147483647};
        int[] roots = {2, 3, 3, 3, 4, 5, 4, 2, 10};

        for (int i = 0; i < numbers.length; i++) {
            double x = numbers[i];
            int n = roots[i];
            double result = nthRootCalculator.nthRoot(x, n);
            System.out.println("The " + n + "th root of " + x + " is approximately: " + result);
        }
    }
}

// gfg submission
/*
 * class Solution
{
    public int NthRoot(int n, int m)
    {
        if(m==1||m==0) return m;
        int l=1; int r=m;
        while(l<=r)
        {
            int mid= l+(r-l)/2;
            int v= (int)Math.pow(mid,n);
            if(v==m) return mid;
            else if(v<m) l=mid+1;
            else if(v>m) r=mid-1;
        }
        return -1;
    }
}
 */