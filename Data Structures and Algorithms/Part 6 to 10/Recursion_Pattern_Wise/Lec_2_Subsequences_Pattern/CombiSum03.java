package Recursion_Pattern_Wise.Lec_2_Subsequences_Pattern;

import java.util.ArrayList;
import java.util.List;

/*Q11 216. Combination Sum III
Medium
Topics
Companies
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 

Constraints:

2 <= k <= 9
1 <= n <= 60
Seen this question in a real interview before?
1/5
Yes
No
Accepted
519.4K
Submissions
743.4K
Acceptance Rate
69.9% */
public class CombiSum03 {
    //Attemopt 2, optimized
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        recurCsum3(1, n, k, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void recurCsum3(int i, int n, int k, List<Integer> set, List<List<Integer>> ans) {
        if((n==0)&&(k==0)){
            ans.add(new ArrayList<>(set));
            return;
        }
        //below 2 lines optional
        if((n<=0)&&(k>0)) return;
        if((k==0)&&(n!=0)) return;
        for(int j=i;j<=9;j++){//j=i+1 is wrong, i not considered yet
            if(j<=n && k>=1){
                set.add(j);
                recurCsum3(j+1, n-j, k-1, set, ans);//only j is wrong, causes repetiions in considering i, j+1 mandatory
                set.remove(set.size()-1);
            }
        }
        // Some mistakes below, figure why again for revision
        // for(int j=i;j<=9;j++){
        //     if(j<=n && k>=1){
        //         set.add(j);
        //         recurCsum3(j, n-j, k-1, set, ans);
        //         set.remove(set.size()-1);
        //     }
        
    }

    public static void main(String[] args) {
        CombiSum03 obj = new CombiSum03();

        // Test Case 1
        System.out.println("Test Case 1: " + obj.combinationSum3(3, 7));

        // Test Case 2
        System.out.println("Test Case 2: " + obj.combinationSum3(3, 9));

        // Test Case 3
        System.out.println("Test Case 3: " + obj.combinationSum3(4, 1));

        // Test Case 4
        System.out.println("Test Case 4: " + obj.combinationSum3(2, 18));
    }
}

// Attempt 1, works, is simpler, but higher time due to some unnecessay recursive calls, same TC tho
// public class CombiSum03 {
//     public List<List<Integer>> combinationSum3(int k, int n) {
//         List<List<Integer>> ans = new ArrayList<>();
//         recurCsum3(1,n,k,new ArrayList<Integer>(),ans);
//         return ans;
//     }

//     private void recurCsum3(int i, int n, int k, ArrayList<Integer> set, List<List<Integer>> ans) {
//         if((n==0)&&(k==0)){
//             ans.add(new ArrayList<Integer>(set));
//             return;
//         } 
//         if(i>9) return;
//         //select i
//         if(i<=n){
//             set.add(i);
//             recurCsum3(i+1, n-i, k-1, set, ans);
//             set.remove(set.size()-1);
//         }
//         //reject i
//         recurCsum3(i+1, n, k, set, ans);
//     }
// }
// //Attempt 3, also optimal
// class Solution {
//     //Attemopt 2
//         public List<List<Integer>> combinationSum3(int k, int n) {
//             List<List<Integer>> ans = new ArrayList<>();
//             recurCsum3(0, n, k, new ArrayList<Integer>(), ans);
//              // if start w/ i=0, instead of 1, modify recurCSum3 a little
//             return ans;
//         }
    
//         private void recurCsum3(int i, int n, int k, List<Integer> set, List<List<Integer>> ans) {
//             if((n==0)&&(k==0)){
//                 ans.add(new ArrayList<>(set));
//                 return;
//             }
//             if((n<=0)&&(k>0)) return;
//             if((k==0)&&(n!=0)) return;
//             for(int j=i+1;j<=9;j++){//j=i+1 is right here, i starts at 0, which we wanna skip
//                 if(j<=n && k>=1){
//                     set.add(j);
//                     recurCsum3(j, n-j, k-1, set, ans);
//                      //only j is right, cuz here consider ith no. in next fn. call, j+1 is wrong
//                     set.remove(set.size()-1);
//                 }
//             }
//         }
//     }

/*//ANother soln, found on LC, backward iteration
public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        combinations(k, n, 9, 0, new ArrayList<>(), list);
        return list;
    }
    private void combinations(int k, int n, int end, int sum, ArrayList<Integer> curr_list,    List<List<Integer>> list){
        if(sum == n && curr_list.size() == k){
            list.add(new ArrayList(curr_list));
            return;
        }
        for(int i=end; i >= 1; i--){
            if(sum > n || curr_list.size() > k) break;
            curr_list.add(0, i);
            combinations(k, n, i-1, sum+i, curr_list, list);
            curr_list.remove(0);
        }
    }
         */