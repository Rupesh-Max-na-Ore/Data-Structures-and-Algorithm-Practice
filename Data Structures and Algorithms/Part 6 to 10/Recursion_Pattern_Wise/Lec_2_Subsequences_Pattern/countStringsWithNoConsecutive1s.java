package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;
/*Q1 Consecutive 1's not allowed
MediumAccuracy: 27.46%Submissions: 109K+Points: 4
Be the comment of the day in POTD and win a GfG T-Shirt!
Solve right now

banner
Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1’s. Output your answer modulo 109 + 7.

Example 1:

Input:
N = 3
Output: 5
Explanation:
5 strings are (000,
001, 010, 100, 101).
Example 2:

Input:
N = 2
Output: 3
Explanation: 
3 strings are (00,01,10).

Input:
N = 99996
Output: 855252772
Your Task:
You don't have to print answer or take inputs. Complete the function countStrings() which takes single integer n, as input parameters and returns an integer denoting the answer. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105

 */
public class countStringsWithNoConsecutive1s {
    long countStrings(int n) {
    if(n==1) return 2;
    if(n==2) return 3;

    long a[] = new long[n+1];
    a[0]=0;
    a[1]=2;
    a[2]=3;
    return recur(n,a);       
    }

    private long recur(int n, long[] a) {
        if(n==1) return 2;
        if(n==2) return 3;
    
        if(n>0 && a[n]!=0) return a[n];
        long ans=recur(n-1, a)+recur(n-2, a);
        a[n]=ans;
        return ans;
    }
    public static void main(String[] args) {
        countStringsWithNoConsecutive1s solution = new countStringsWithNoConsecutive1s();
        System.out.println(solution.countStrings(8)); // Output: 5
        System.out.println(solution.countStrings(2)); // Output: 3
        //System.out.println(solution.countStrings(99996)); // Output: 855252772
    }
}
//gfg submission, passes 1110/1115 TCs, lol, not work for N=99996 sadly
// stack overflow on gfg server
// not accepting purely recursive soln
// long countStrings(int n) {
//     if(n==1) return 2;
//     if(n==2) return 3;
//     long a[] = new long[n+1];
//     a[0]=0;
//     a[1]=2;
//     a[2]=3;
//     return recur(n,a)%1000000007;       
//     }

//     private long recur(int n, long[] a) {
//         if(n==1) return 2;
//         if(n==2) return 3;

//         if(n>0 && a[n]!=0) return a[n];
//         long ans=recur(n-1, a)%1000000007+recur(n-2, a)%1000000007;
//         a[n]=ans;
//         return ans;
//     }

/* //Iterative soln, works in gfg
 * package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;

public class CountStringsWithNoConsecutive1s {
    private static final long MOD = 1_000_000_007;

    long countStrings(int n) {
        if (n == 1) return 2;
        if (n == 2) return 3;

        long[] a = new long[n + 1];
        a[1] = 2;
        a[2] = 3;

        for (int i = 3; i <= n; i++) {
            a[i] = (a[i - 1] + a[i - 2]) % MOD;
        }

        return a[n];
    }

    public static void main(String[] args) {
        CountStringsWithNoConsecutive1s solution = new CountStringsWithNoConsecutive1s();
        System.out.println(solution.countStrings(3)); // Output: 5
        System.out.println(solution.countStrings(2)); // Output: 3
        System.out.println(solution.countStrings(99996)); // Output: 855252772
    }
}

 */