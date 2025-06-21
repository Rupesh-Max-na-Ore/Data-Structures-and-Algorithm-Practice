/*Q2 All divisors of a Number
Difficulty: EasyAccuracy: 46.73%Submissions: 19K+Points: 2
Given an integer N, print all the divisors of N in the ascending order.
 

Example 1:

Input : 20
Output: 1 2 4 5 10 20
Explanation: 20 is completely 
divisible by 1, 2, 4, 5, 10 and 20.

Example 2:

Input: 21191
Output: 1 21191
Explanation: As 21191 is a prime number,
it has only 2 factors(1 and the number itself).

Your Task:

Your task is to complete the function print_divisors() which takes N as input parameter and prints all the factors of N as space seperated integers in sorted order. You don't have to print any new line after printing the desired output. It will be handled in driver code.
 

Expected Time Complexity: O(sqrt(N))
Expected Space Complexity: O(sqrt(N))
 

Constraints:
1 <= N <= 105

 */

import java.util.TreeSet;

public class Divisors {
    public static void print_divisors(int n) {
        TreeSet<Integer> ans = new TreeSet<>();
        for(int i=1; i*i <=n ; i++){
            if(n%i == 0){
                System.out.println("Wow");
                System.out.print(i+" ");
                if(n/i != i){
                    System.out.println(" hmm");
                    ans.add(n/i);
                }
            }
            // if(n/i != i){
            //     System.out.println(" hmm");
            //     ans.add(n/i);
            // }
        }
        // Integer[] a = ans.toArray(new Integer[0]);
        // for(int i = 0; i< a.length; i++){
        //     if(i== a.length - 1) System.out.print(a[i]);
        //     else System.out.println(a[i]+" ");
        // }
        for(Integer i: ans){
            System.out.println(i+" ");
        }
    }
    public static void main(String[] args) {
        print_divisors(20); // Example test case 1
        System.out.println();
        //print_divisors(21191); // Example test case 2
    }
}
