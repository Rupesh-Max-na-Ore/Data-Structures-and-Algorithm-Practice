
/*Minimum Multiplications to reach End
Difficulty: MediumAccuracy: 48.94%Submissions: 146K+Points: 4Average Time: 20m
Given start, end and an array arr of n numbers. At each step, start is multiplied with any number in the array and then mod operation with 100000 is done to get the new start.

Your task is to find the minimum steps in which end can be achieved starting from start. If it is not possible to reach end, then return -1.

Example 1:

Input:
arr[] = {2, 5, 7}
start = 3, end = 30
Output:
2
Explanation:
Step 1: 3*2 = 6 % 100000 = 6 
Step 2: 6*5 = 30 % 100000 = 30
Example 2:

Input:
arr[] = {3, 4, 65}
start = 7, end = 66175
Output:
4
Explanation:
Step 1: 7*3 = 21 % 100000 = 21 
Step 2: 21*3 = 63 % 100000 = 63 
Step 3: 63*65 = 4095 % 100000 = 4095 
Step 4: 4095*65 = 266175 % 100000 = 66175
Your Task:
You don't need to print or input anything. Complete the function minimumMultiplications() which takes an integer array arr, an integer start and an integer end as the input parameters and returns an integer, denoting the minumum steps to reach in which end can be achieved starting from start.

Expected Time Complexity: O(105)
Expected Space Complexity: O(105)

Constraints:

1 <= n <= 104
1 <= arr[i] <= 104
1 <= start, end < 105
Topic Tags
ArraysGraphBFSData StructuresAlgorithms */

import java.util.LinkedList;
import java.util.Queue;

public class q39_Minimum_Multiplications_to_Reach_End {
    int minimumMultiplications(int[] canUse, int start, int end) {
        if(start==end) return 0;
        int mod = (int)1e5;
        boolean [] vis = new boolean[mod];
        Queue<int[]> q = new LinkedList<>();
        vis[start%mod]=true;
        q.add(new int[]{start%mod, 0});
        while(!q.isEmpty()){
            int [] curr = q.poll();
            int cn = curr[0];
            int cs = curr[1];
            for(int m : canUse){
                int nv = m*cn % mod;
                if(!vis[nv]){
                    vis[nv]=true;
                    if(nv==end) return cs+1;
                    q.add(new int[]{nv,cs+1});
                }
            }
        } return -1;
    }
}
