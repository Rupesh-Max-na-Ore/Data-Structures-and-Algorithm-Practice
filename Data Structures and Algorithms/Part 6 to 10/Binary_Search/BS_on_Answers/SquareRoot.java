package Binary_Search.BS_on_Answers;
/*
 * Q1
 * Finding Sqrt of a number using Binary Search

Problem Statement: You are given a positive integer n. 
Your task is to find and return its square root. 
If ‘n’ is not a perfect square, then return the floor value of 'sqrt(n)'.

Note: The question explicitly states that if the given number, n, is not a perfect square, 
our objective is to find the maximum number, x, such that x squared is less than or equal to n (x*x <= n). 
In other words, we need to determine the floor value of the square root of n.
 */
public class SquareRoot {
    public long floorSqrt(long x)
	 {  
        // Special case for 0 and 1, just to optimize edge case
        if (x == 0 || x == 1) {
            return x;
        }
		// root lies b/w (for x=1)1 to x, given x is +ve
        long l=1; long r=x;
        long sqrt=x;
        while(l<=r){
            long m = l + (r - l) / 2;
            long v = m*m;
            if(v==x) return m; // happens when x is perfect square
            else if(v<x){
                sqrt=m;// possible answer
                l=m+1; // eliminate left, narrow search space to right part, try to get v closer(righter) to x
            }
            else if(v>x) r=m-1; // eliminate right, narrow search space to left part, try to get v closer(lefter) to x
        }
        return sqrt;

	 }
     public static void main(String[] args) {
        SquareRoot sqrtCalculator = new SquareRoot();

        // Test cases
        long[] testCases = {0, 1, 2,3, 4,5,6,7, 8, 9, 16, 25,50, 100, 2147395600};

        for (long x : testCases) {
            long result = sqrtCalculator.floorSqrt(x);
            System.out.println("The floor square root of " + x + " is: " + result);
        }
     }
}

// gfg submisiion, slightly better
/*
 * 

// Function to find square root
// x: element to find square root
class Solution
{
     long floorSqrt(long x)
	 {
            // Special case for 0 and 1, just to optimize edge case
            if (x == 0 || x == 1) {
                return x;
            }
            // root lies b/w (for x=1)1 to x, given x is +ve
            long l=1; long r=x;
            
            while(l<=r){
                long m = l + (r - l) / 2;
                long v = m*m;
                if(v==x) return m; // happens when x is perfect square
                else if(v<x){
                    l=m+1; // eliminate left, narrow search space to right part, try to get v closer(righter) to x
                }
                else if(v>x) r=m-1; // eliminate right, narrow search space to left part, try to get v closer(lefter) to x
            }
            return r; // at end, r ends up converging to closest left space answer to actual root
	 }
}
 */