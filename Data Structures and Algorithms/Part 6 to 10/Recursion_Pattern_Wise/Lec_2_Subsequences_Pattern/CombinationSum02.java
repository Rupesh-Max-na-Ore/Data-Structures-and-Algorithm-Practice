package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;
/*Q8 
40. Combination Sum II
Solved
Medium
Topics
Companies
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
Seen this question in a real interview before?
1/5
Yes
No
Accepted
990.2K
Submissions
1.8M
Acceptance Rate
54.7%
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum02 {
    public static List<List<Integer>> combinationSum2(int[] a, int k) {
        List < List < Integer >> ans = new ArrayList < > ();
        Arrays.sort(a);// to prune recursion tree
        int n = a.length;
        recurCSum2(a, n, k, 0, ans, new ArrayList <Integer> ());
        return ans;
    }

    private static void recurCSum2(int[] a, int n, int k, int i, List<List<Integer>> ans, ArrayList<Integer> set) {
        if(k==0){
            //add curr set to ans
            ans.add(new ArrayList<Integer>(set));
            return; //terminate recursion subtree there, as all elems > 0
        }

        for(int j=i; j<n; j++){
            if(j>i && a[j]==a[j-1]) continue; //skip duplis of ith elem, taking advantage of sorting
            if(a[j]>k) break;
            set.add(a[j]);//consider and add ith elem as new start
            recurCSum2(a, n, k-a[j], j+1, ans, set);// propagate down the tree
            set.remove(set.size()-1);// remove this elem to backtrack
        }
    }
    public static void main(String args[]) {
        int a[]={10,1,2,7,6,1,5};
        List < List < Integer >> ans = combinationSum2(a, 8);
        System.out.println(ans.toString());
    }   
}
/*
 * //some solns found on lc forum
 * 3 backtracking variations [Java] beats 100%

kunalsuri
100 Days Badge 2023
234
4104
May 17, 2021
Java
Backtracking
Backtracking With Visited Array (using space)

class Solution {
    public int combinationSum2(int[] arr, int tar, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (tar == 0) {
            ArrayList<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }
        boolean[] visited = new boolean[50];
        int count = 0;
        for (int i = idx; i < arr.length; ++i) {
            if (!visited[arr[i]] && tar - arr[i] >= 0) {
                
                visited[arr[i]] = true;
                
                smallAns.add(arr[i]);
                count += combinationSum2(arr, tar - arr[i], i + 1, smallAns, res);
                smallAns.remove(smallAns.size() - 1);
            }
        }
        return count;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        combinationSum2(candidates, target, 0, smallAns, res);
        return res;
    }
}
Backtracking With Prev Variable (space efficient)

class Solution {
    public int combinationSum2(int[] arr, int tar, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (tar == 0) {
            ArrayList<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }
        
        int count = 0;
        int prev = -1;
        for (int i = idx; i < arr.length; ++i) {
            if (prev != arr[i] && tar - arr[i] >= 0) {
                smallAns.add(arr[i]);
                count += combinationSum2(arr, tar - arr[i], i + 1, smallAns, res);
                smallAns.remove(smallAns.size() - 1);
            }
            
            if (tar - arr[i] < 0)
                break;
            
            prev = arr[i];
        }
        return count;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        combinationSum2(candidates, target, 0, smallAns, res);
        return res;
    }
}
BackTracking Subsequence method

class Solution {
    public int combinationSum2(int[] arr, int tar, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (tar == 0 || idx >= arr.length) {
            if (tar == 0) {
                List<Integer> base = new ArrayList<>(smallAns);
                res.add(base);
                return 1;
            }
            return 0;
        }
            
        int count = 0;

        if (tar - arr[idx] >= 0) {
            smallAns.add(arr[idx]);
            count += combinationSum2(arr, tar - arr[idx], idx + 1, smallAns, res);
            smallAns.remove(smallAns.size() - 1);
        }

        idx++;
        while (idx < arr.length && arr[idx - 1] == arr[idx])
            idx++;

        count += combinationSum2(arr, tar, idx, smallAns, res);
        return count;
    }
    public List<List<Integer>> combinationSum2(int[] arr, int tar) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        Arrays.sort(arr);
        combinationSum2(arr, tar, 0, smallAns, res);
        return res;
    }
}
If you liked it, even a little bit then pls consider giving this solution a Upvote
Thank You :)
two DP solutions in Java (with explanation)

clock330
Annual Badge 2022
1578
908
Nov 14, 2020
Dynamic Programming
Method 1: With Hash Table
Consider a 2D dp array, where dp[i][j] is all combinations using candidates[0] to candidates[i] that sum to j. Our goal is dp[n - 1][target], where n is the number of candidates.

The transition function is dp[i][j] = d[i - 1][j] + d[i - 1][j - candidates[i]].add(candidates[i]).

The first term on right hand side, d[i - 1][j], is all combinations using candidates[0] to candidates[i - 1] that sum to j. This is part of d[i][j], when we don't include candidates[i] in the combination (because the sum is already j).

The second term on right hand side, d[i - 1][j - candidates[i]] is all combinations using candidates[0] to candidates[i - 1] that sum to j - candidates[i]. This is other parts of d[i][j] when we include candidates[i] in the combination (because j - candidates[i] + candidates[i] = j.

.add(candidates[i]) means we are adding candidates[i] to each of the combination in d[i - 1][j - candidates[i]]

Since the candidates[] array has duplicates, we need to avoid adding duplicate combinations to our result. We can use hash table to accomplish this, the dp array can be defined as:

// dp array simplified to 1D, as we always use d[i][j] and d[i - 1][j] (the last two rows of the 2D dp array
Set<List<Integer>>[] dp = new Set[target + 1];
We also need to sort the candidates array to avoid duplicates. Consider candidates being [1,6,1,1], and target is 7. If we don't sort, we would have [1,6],[6,1],[6,1] as the combination. The hash table will only screen the two [6,1], but not [1,6],[6,1], because they are considered different List<Integer>. If we sort the candidate so it becomes [1,1,1,6], and the three combinations sum to 7 is [1,6],[1,6],[1,6], hash table can screen off duplicates, only one [1,6] will be present in the result.

Below is the java code:

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // we need to sort candidates, to avoid duplicate combibation
        Arrays.sort(candidates);

        // initialize dp array
        Set<List<Integer>>[] dp = new Set[target + 1];
        for (int i = 0; i <= target; i++) {
            dp[i] = new HashSet<>();
        }

        // base case when target is 0 and not picking first candidate
        dp[0].add(new ArrayList<>());

        // populate the dp array
        for (int i = 0; i < candidates.length; i++) {
            for (int j = target; j >= candidates[i]; j--) {
                for (List<Integer> comb : dp[j - candidates[i]]) {
                    List<Integer> newComb = new ArrayList<>(comb);
                    newComb.add(candidates[i]);
                    dp[j].add(newComb);
                }
            }
        }

        return new ArrayList<>(dp[target]);
    }
}
Method 2: Without Hash Table
This method has the same time and space complexity as method 1, so there is no advantage with respect to time/space. Just another way of thinking.

We keep two lists, combs to store all the temporary combinations we encountered, sums to store the sum for those combinations. When adding candidates[i] to our current collection of combinations, we check if its been encountered before. If so, we will not add it to earlier combinations (because those combinations already contain this number). For any combinations that sum to target, we add it to the final result.

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // we need to sort the array to skip duplicates
        Arrays.sort(candidates);
        
        // initialize combs and sums
        List<List<Integer>> combs = new ArrayList<>(), res = new ArrayList<>();
        List<Integer> sums = new ArrayList<>();        
        combs.add(new ArrayList<>());
        sums.add(0);

        int startIndex = 0, n = candidates.length, size = combs.size();
        for (int i = 0; i < candidates.length; i++) {
            // determine the startIndex to add candidates[i]
            startIndex = i > 0 && candidates[i] == candidates[i-1] ? size : 0;
            size = combs.size();
            // try to add candidates[i] to previous combinations
            // if sum == target, add to result list
            for (int j = startIndex; j < size; j++) {
                List<Integer> temp = new ArrayList<>(combs.get(j));
                temp.add(candidates[i]);
                int sum = sums.get(j) + candidates[i];
                if (sum == target) {
                    res.add(temp);
                } else if (sum < target) {
                    combs.add(temp);
                    sums.add(sum);
                }
            }
        }
        return res;
    }
}
 */