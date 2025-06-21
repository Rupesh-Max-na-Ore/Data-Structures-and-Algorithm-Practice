package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;
/*Q9 
Subset Sums
MediumAccuracy: 72.55%Submissions: 107K+Points: 4
Be the comment of the day in POTD and win a GfG T-Shirt!
Solve right now

banner
Given a list arr of n integers, return sums of all subsets in it. Output sums can be printed in any order.

 

Example 1:

Input:
n = 2
arr[] = {2, 3}
Output:
0 2 3 5
Explanation:
When no elements is taken then Sum = 0.
When only 2 is taken then Sum = 2.
When only 3 is taken then Sum = 3.
When element 2 and 3 are taken then 
Sum = 2+3 = 5.
Example 2:

Input:
n = 3
arr = {5, 2, 1}
Output:
0 1 2 3 5 6 7 8
Your Task:  
You don't need to read input or print anything. Your task is to complete the function subsetSums() which takes a list/vector and an integer n as an input parameter and returns the list/vector of all the subset sums.

Expected Time Complexity: O(2n)
Expected Auxiliary Space: O(2n)

Constraints:
1 <= n <= 15
0 <= arr[i] <= 104 */
import java.util.ArrayList;

public class SubsetSum01 {
    ArrayList<Integer> subsetSums(ArrayList<Integer> a, int n) {
        ArrayList <Integer> ans = new ArrayList < > ();
        recurSubSum(a, n, 0, 0, ans);
        return ans;
    }

    private void recurSubSum(ArrayList<Integer> a, int n, int sum, int i, ArrayList<Integer> ans) {
        if(i==n) {//base
            ans.add(sum); return;
        }
        recurSubSum(a, n, (sum+a.get(i)), i+1, ans); //select
        recurSubSum(a, n, sum, i+1, ans);//reject
    }

}
