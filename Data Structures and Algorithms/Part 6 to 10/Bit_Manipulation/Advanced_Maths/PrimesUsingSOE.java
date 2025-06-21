/*Q3 204. Count Primes
Medium
Topics
Companies
Hint
Given an integer n, return the number of prime numbers that are strictly less than n.

 

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
 

Constraints:

0 <= n <= 5 * 106
Seen this question in a real interview before?
1/5
Yes
No
Accepted
878.6K
Submissions
2.6M
Acceptance Rate
33.7% */
public class PrimesUsingSOE {
    public static int countPrimes(int n) {
        // calcs. #primes till n-1 ie under n 
        if(n==0||n==1) return 0; //edge case
        int cnt=n-2;//-1 for i=1 and 0 and for n
        // assume all prime at first
        int preComp[] = new int[n+1]; //to store if i is prime or not
        for(int i=0; i<=n-1; i++) preComp[i]=1;

        for(int i=2;i*i<=n-1;i++){
            if(preComp[i]==1){//if i is prime, all multiples of i not prime
                //System.out.println("Prime counted = "+i);
                for(int j=(i*i); j<=n-1;j=j+i){
                    // start from i*i cuz all below are this are taken by primes multiples below i
                    if(preComp[j]==1) // cut only if not already cut
                    {
                        preComp[j]=0;
                        cnt--; // decrement no. of primes
                        //System.out.println(" So, cutting now = "+j);
                    }
                    //System.out.println(" So, cutting = "+j);
                }
            }
        } return cnt;
    }
    public static void main(String[] args) {
        int primes = countPrimes(10); // Example test case 1
        System.out.println(primes);
        System.out.println(countPrimes(30));
    }
}
/*//optimal soln from lc forum
public int countPrimes(int n) {
        if(n <= 2) return 0;
        int ans = 1;// don't forget to record 2. :-)
        boolean[] isCompositeArr = new boolean[n];
        int upper = (int) Math.sqrt(n);
        for(int i = 3;i < n;i=i+2){//1.scan only odd number
            if(isCompositeArr[i]) continue;
            ans++;
            if(i > upper) continue;//2. avoid i^2 overflow.
            for(int j = i*i; j < n;j = j + 2*i){//3. initialize j to i^2
                                                //4. increase 2i to keep j as an odd number
                
                isCompositeArr[j] = true;
            }
        }
        return ans;
    } */ //Explanation- https://leetcode.com/problems/count-primes/solutions/3524353/explanation-of-why-sqrt-n-i-i-and-2-i/

    /*// implement optimal way myself
    class Solution {
    public int countPrimes(int n) {
        boolean a[]=new boolean[n];
       if(n<3) return 0;
        int cnt=n/2;
        for(int i=3;i*i<=n;i+=2)
        {
            if(a[i]==false)
            {
                for(int j=i*i;j<n;j+=2*i)
                {
                    if(!a[j]){
                    cnt--;
                    a[j]=true;
                    }
                }
            }
        }
        return cnt;
    }
} */