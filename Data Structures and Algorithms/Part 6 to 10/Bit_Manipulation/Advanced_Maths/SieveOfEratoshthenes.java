/*Q4 Prime Factorization using Sieve
Difficulty: MediumAccuracy: 41.03%Submissions: 9K+Points: 4
You are given a positive number N. Using the concept of Sieve, compute its prime factorisation.

Example:

Input: 
N = 12246
Output: 
2 3 13 157
Explanation: 
2*3*13*157 = 12246 = N.
Your Task:

Comple the function findPrimeFactors(), which takes a positive number N as input and returns a vector consisting of prime factors. You should implement Sieve algorithm to solve this problem.

 

Expected Time Complexity: O(Nlog(log(N)).

Expected Auxiliary Space: O(N).

Constraints:

1<=N<=2*105 */

import java.util.ArrayList;
import java.util.List;

public class SieveOfEratoshthenes {
        // You must implement this function
    static void sieve() {}

    static List<Integer> findPrimeFactors(int N) {
        List<Integer> ans = new ArrayList<>();
        int[] prime = new int[N + 1];
        mySieveOfErathosthenes(prime, N);

        while (N != 1) {
            ans.add(prime[N]);
            N = N / prime[N];
        }
        return ans;        
    }

    private static void mySieveOfErathosthenes(int[] prime, int n) {
        for (int i = 1; i <= n; i++) prime[i] = i;
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (prime[j] == j)
                        prime[j] = i;
                }
            }
        }
    }
}
