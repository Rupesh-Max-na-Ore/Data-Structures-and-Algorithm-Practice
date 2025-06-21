import java.util.ArrayList;
import java.util.List;

/*Q1 Prime Factors
Difficulty: EasyAccuracy: 30.47%Submissions: 29K+Points: 2
Given a number N. Find its unique prime factors in increasing order.
 

Example 1:

Input: N = 100
Output: 2 5
Explanation: 2 and 5 are the unique prime
factors of 100.
Example 2:

Input: N = 35
Output: 5 7
Explanation: 5 and 7 are the unique prime
factors of 35.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function AllPrimeFactors() which takes N as input parameter and returns a list of all unique prime factors of N in increasing order.

 

Expected Time Complexity: O(N)
Expected Space Complexity: O(N)
 

Constraints:
1 <= N  <= 106 */
public class PrimeFactors {
    //Optimized and explained attempt
    public int[] AllPrimeFactors(int N) {
        List<Integer> al = new ArrayList<>();
        if(N==1) return new int[]{}; //not needed, do in end anyway, but no harm as well

        // Check for the smallest prime factor 2 separately - O(1)
        if (N % 2 == 0) {
            al.add(2);
            while (N % 2 == 0) N = N/2;
        }
        
        // Check for odd prime factors from 3 onwards - O(sqrt(N)/2 * time to add to DS)
        // as checked for 2 alredy, no need to check for 4,6,8,... etc.
        for (int i = 3; i * i <= N; i += 2) {
            if (N % i == 0) {
                al.add(i);
                while (N % i == 0) {
                    N /= i;
                }
            }
        }
        
        // If N is still > 1, then it is a prime factor
        if (N > 1) al.add(N);
        
        // Convert the list to an array
        int[] ans = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            ans[i] = al.get(i);
        }
        
        return ans;
    }
    // //FIrst Attempt, debug and learn from some mistakes, works
    // public int[] AllPrimeFactors(int N)
    // {
    //     if(N==1) return new int[]{};
    //     List<Integer> al = new ArrayList<>();
    //     for(int i = 2; i*i <= N; i=i+1){
    //         //System.out.println("Loop i: "+i);
    //         if(N%i==0){
    //             //System.out.println("ENter if CUrr i: "+i);
    //             al.add(i);
    //             //if(N/i != i) al.add(N/i);
    //             while(N%i==0) N=N/i;
    //             if(N==1) {
    //                 // Convert the list to an array
    //                 int[] a = new int[al.size()];
    //                 for (int j = 0; j < al.size(); j++) {
    //                 a[j] = al.get(j);
    //                 }
        
    //                 return a;
    //             }
    //         }
    //     }
    //     if(N>1) al.add(N);
    //     if(al.isEmpty() ) return new int[]{N};
    //     //if(N==1) {
    //             // Convert the list to an array
    //             int[] a = new int[al.size()];
    //             for (int j = 0; j < al.size(); j++) {
    //             a[j] = al.get(j);
    //             }
    
    //             return a;
    //         //}
    //     //return new int[]{};
    // }
    public static void main(String[] args) {
        PrimeFactors pf = new PrimeFactors();

        // Test case 1: N = 100
        int[] result1 = pf.AllPrimeFactors(100);
        System.out.print("Prime factors of 100: ");
        for (int i : result1) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Test case 2: N = 35
        int[] result2 = pf.AllPrimeFactors(35);
        System.out.print("Prime factors of 35: ");
        for (int i : result2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Test case 3: N = 17 (a prime number)
        int[] result3 = pf.AllPrimeFactors(17);
        System.out.print("Prime factors of 17: ");
        for (int i : result3) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Test case 4: N = 1 (edge case)
        int[] result4 = pf.AllPrimeFactors(1);
        System.out.print("Prime factors of 1: ");
        for (int i : result4) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Test case 5: N = 2 (smallest prime number)
        int[] result5 = pf.AllPrimeFactors(2);
        System.out.print("Prime factors of 2: ");
        for (int i : result5) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
