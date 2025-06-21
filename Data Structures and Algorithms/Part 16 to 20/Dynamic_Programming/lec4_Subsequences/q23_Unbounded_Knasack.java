package Dynamic_Programming.lec4_Subsequences;
/*Knapsack with Duplicate Items
Difficulty: MediumAccuracy: 52.13%Submissions: 162K+Points: 4
Given a set of N items, each with a weight and a value, represented by the array wt and val respectively. Also, a knapsack with weight limit W.
The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
Note: Each item can be taken any number of times.

Examples:

Input: N = 2, W = 3, val = {1, 1}, wt = {2, 1}
Output: 3
Explanation: 1.Pick the 2nd element thrice. 2.Total profit = 1 + 1 + 1 = 3. Also the total weight = 1 + 1 + 1  = 3 which is <= 3.
Input: N = 4, W = 8, val[] = {6, 1, 7, 7}, wt[] = {1, 3, 4, 5}
Output: 48
Explanation: The optimal choice is to pick the 1st element 8 times.
Your Task:
You do not need to read input or print anything. Your task is to complete the function knapSack() which takes the values N, W and the arrays val and wt as input parameters and returns the maximum possible value.

Expected Time Complexity: O(N*W)
Expected Auxiliary Space: O(W)

Constraints:
1 ≤ N, W ≤ 1000
1 ≤ val[i], wt[i] ≤ 100 */
public class q23_Unbounded_Knasack {
    static int unboundedKnapsack(int n, int W, int[] val, int[] wt) {
        int cur[] = new int[W + 1];
        for (int i = wt[0]; i <= W; i++) cur[i] = ((int) i / wt[0]) * val[0];
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {
                int excl = cur[cap];
                int incl = Integer.MIN_VALUE;
                if (wt[ind] <= cap) incl = val[ind] + cur[cap - wt[ind]];
                cur[cap] = Math.max(excl, incl);
            }
        }
        return cur[W]; 
    }
}
//https://chatgpt.com/share/67252df5-02f0-8005-aa10-1d4b2e6381e7
/*You're correct that even updating the array from **left to right** still gives the right answer in 
this specific implementation. The reason lies in the way the **unbounded knapsack problem** 
(or the **complete knapsack problem**) works compared to the **0/1 knapsack problem**:

### Key Insight:
In the **unbounded knapsack problem**, an item can be selected multiple times. 
This means that when we consider an item at index `ind` for capacity `cap`, 
we can use the updated value for `cur[cap]` within the same iteration, 
reflecting the inclusion of the item more than once.

### Detailed Explanation:
1. **State Transition**: The state transition in this problem is:
   \[
   \text{cur[cap]} = \max(\text{cur[cap]}, \text{val[ind]} + \text{cur[cap - wt[ind]]})
   \]
   Here, `cur[cap]` is updated based on whether we include the 
   current item (`val[ind] + cur[cap - wt[ind]]`) or not (`cur[cap]`).

2. **Left-to-Right Update**:
   - When updating from left to right (from `cap = 0` to `cap = W`), the inclusion `cur[cap - wt[ind]]` 
   will use values that have already been updated in the current iteration.
   - This means that when you include the current item, 
   you're effectively treating the item as available again for reuse within the same capacity.

### Example to Illustrate:
Consider an example where:
- `n = 2`, `W = 5`
- `val = [10, 15]`, `wt = [2, 3]`

**Initialization**:
- Start with `cur[] = [0, 0, 0, 0, 0, 0]`

**Processing the first item (`val[0] = 10`, `wt[0] = 2`) from left to right**:
- `cap = 2`: `cur[2] = max(0, 10 + cur[0]) = 10` → `cur[] = [0, 0, 10, 0, 0, 0]`
- `cap = 3`: `cur[3] = max(0, 10 + cur[1]) = 10` → `cur[] = [0, 0, 10, 10, 0, 0]`
- `cap = 4`: `cur[4] = max(0, 10 + cur[2]) = 20` → `cur[] = [0, 0, 10, 10, 20, 0]`
- `cap = 5`: `cur[5] = max(0, 10 + cur[3]) = 20` → `cur[] = [0, 0, 10, 10, 20, 20]`

**Processing the second item (`val[1] = 15`, `wt[1] = 3`) from left to right**:
- `cap = 3`: `cur[3] = max(10, 15 + cur[0]) = 15` → `cur[] = [0, 0, 10, 15, 20, 20]`
- `cap = 4`: `cur[4] = max(20, 15 + cur[1]) = 20` → `cur[] = [0, 0, 10, 15, 20, 20]`
- `cap = 5`: `cur[5] = max(20, 15 + cur[2]) = 25` → `cur[] = [0, 0, 10, 15, 20, 25]`

### Why This Works:
- **Multiple Use of Items**: When iterating left to right, if `cur[cap - wt[ind]]` 
has already been updated in the current iteration, it means we are considering the scenario 
where the current item has already been included one or more times. This aligns with the nature of 
the unbounded knapsack problem, where items can be reused multiple times.
- **No Overwriting Issue**: Unlike the **0/1 knapsack problem** 
(where each item can only be used once), 
the unbounded knapsack problem allows for repeated use, 
so updating left to right does not compromise the correctness of the solution.

### Conclusion:
For the **unbounded knapsack problem**, it is safe to update from left to right because 
the problem's nature allows items to be included multiple times. 
The in-place update does not affect the correctness, as each update reflects 
a valid state where items can be reused. */