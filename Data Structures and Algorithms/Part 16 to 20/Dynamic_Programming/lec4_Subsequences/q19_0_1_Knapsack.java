package Dynamic_Programming.lec4_Subsequences;
/*0 - 1 Knapsack Problem
Difficulty: MediumAccuracy: 31.76%Submissions: 445K+Points: 4
You are given the weights and values of items, and you need to put these items in a 
knapsack of capacity capacity to achieve the maximum total value in the knapsack. 
Each item is available in only one quantity.

In other words, you are given two integer arrays val[] and wt[], which represent 
the values and weights associated with items, respectively. You are also given an 
integer capacity, which represents the knapsack capacity. Your task is to find the 
maximum sum of values of a subset of val[] such that the sum of the weights of the 
corresponding subset is less than or equal to capacity. You cannot break an item;
 you must either pick the entire item or leave it (0-1 property).

Examples :

Input: capacity = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1] 
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.
Input: capacity = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6] 
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).
Input: capacity = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 6, 3] 
Output: 90
Explanation: Choose the second item (value 40, weight 4) and the fourth item (value 50, weight 3) for a total weight of 7, which exceeds the capacity. Instead, pick the first item (value 10, weight 5) and the second item (value 40, weight 4) for a total value of 50.
Expected Time Complexity: O(n*capacity).
Expected Auxiliary Space: O(n*capacity)

Constraints:
2 ≤ val.size() = wt.size() ≤ 103
1 ≤ capacity ≤ 103
1 ≤ val[i] ≤ 103
1 ≤ wt[i] ≤ 103 */
public class q19_0_1_Knapsack {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        int[] prev = new int[capacity+1];
        //Both lines below do same thing logically, below one save some time
        //for(int j=1;j<=capacity;j++ )if(wt[0]<=j) prev[j]=val[0];
        if(wt[0]<=capacity) for(int j=wt[0];j<=capacity;j++) prev[j]=val[0];
        for(int i =1;i<val.length;i++){
            for(int j=capacity;j>=0;j--){
                int incl=0;
                if(wt[i]<=j) incl = val[i]+prev[j-wt[i]];
                int excl=prev[j];
                prev[j]=Math.max(incl, excl);
            }
        } return prev[capacity];
    }
}
