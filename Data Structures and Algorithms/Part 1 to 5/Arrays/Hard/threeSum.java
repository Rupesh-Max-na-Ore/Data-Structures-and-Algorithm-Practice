package Arrays.Hard;
/*
 * q3
 * 15. 3Sum
Solved
Medium
Topics
Companies
Hint
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
Seen this question in a real interview before?
1/5
Yes
No
Accepted
3.5M
Submissions
10.2M
Acceptance Rate
34.6%
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class threeSum{

    public static List<List<Integer>> threeSumI(int a[]){
        int n=a.length;
        if(a==null||n<3) return new ArrayList<>();
        //sort for 2 ptr tech. to work
        Arrays.sort(a);
        Set<List<Integer>> rslt=new HashSet<>();
        Map<Integer,Integer> HM=new HashMap<>(); // to check if -sum exists
        Map<Integer,Integer> RevHM=new HashMap<>(); // to check if L<M<R, M is index of -sum
        //Itr. to set up HMs
        for(int i=0;i<n;i++){
            HM.put(i,a[i]);
            RevHM.put(a[i],i);
        }
        //Apply 2 ptr. tech.
        int L=0;
        int R=n-1;
        //random ini. for below 2, update in loop anyway
        int M=0;
        int sum=0;

        while(L<R){
            sum=a[L]+a[R];
            
            if(HM.containsValue(0-sum)){
                 M = RevHM.get(0-sum);
                if(M>L && M <R) {
                    rslt.add(Arrays.asList(a[L],0-sum,a[R]));
                    L++;
                    R--;
                }
            }else if(sum<0) L++;
            else if(sum>0) R--;
        }
        return new ArrayList<>(rslt);
    }
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4};
        int n = arr.length;
        List<List<Integer>> ans = threeSumI(arr);
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
 }

//  //lc submission 1, directly done there, works
//  class Solution {
//     public List<List<Integer>> threeSum(int[] a) {
//         int n=a.length;
//         List<List<Integer>> B = new ArrayList<>();
//         Arrays.sort(a);
//         int L=0,M=1,R=n-1;
//         // always do ptr checking before value checking to avoid L==-1 error
//         for (L = 0; L < n; L++) {
//             if (L>0 && a[L] == a[L - 1]) continue;
//             M = L + 1;
//             R = n - 1;
//             while (M < R) {
//                 int sum = a[L] + a[M] + a[R];
//                 if (sum < 0) {
//                     M++;
//                 } else if (sum > 0) {
//                     R--;
//                 } else {
//                     List<Integer> temp = Arrays.asList(a[L], a[M], a[R]);
//                     B.add(temp);
//                     M++;
//                     R--;
//                     while (M<R && a[M] == a[M - 1]) M++;
//                     while (R>M && a[R] == a[R + 1]) R--;
//                 }
//             }
//         }

//         return B;
//     }
// }