package Graphs.Lec5_Min_Span_Tree_and_Disjoint_Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Code
Testcase
Test Result
Test Result
947. Most Stones Removed with Same Row or Column
Medium
Topics
Companies
On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.

A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.

Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.

 

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Explanation: One way to remove 5 stones is as follows:
1. Remove stone [2,2] because it shares the same row as [2,1].
2. Remove stone [2,1] because it shares the same column as [0,1].
3. Remove stone [1,2] because it shares the same row as [1,0].
4. Remove stone [1,0] because it shares the same column as [0,0].
5. Remove stone [0,1] because it shares the same row as [0,0].
Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Explanation: One way to make 3 moves is as follows:
1. Remove stone [2,2] because it shares the same row as [2,0].
2. Remove stone [2,0] because it shares the same column as [0,0].
3. Remove stone [0,2] because it shares the same row as [0,0].
Stones [0,0] and [1,1] cannot be removed since they do not share a row/column with another stone still on the plane.
Example 3:

Input: stones = [[0,0]]
Output: 0
Explanation: [0,0] is the only stone on the plane, so you cannot remove it.
 

Constraints:

1 <= stones.length <= 1000
0 <= xi, yi <= 104
No two stones are at the same coordinate point.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
332.6K
Submissions
535.6K
Acceptance Rate
62.1%
Topics
Hash Table
Depth-First Search
Union Find
Graph */
public class q53_Most_Stones_Removed_with_Same_Row_or_Column {

    //wrong attempt
    // public int removeStones(int[][] stones) {
    //     int n = stones.length;
    //     int mr = 0,mc=0;
    //     //find max #rows and cols from list of stones
    //     for(int i=0;i<n;i++){
    //         mr = Math.max(mr, stones[i][0]);
    //         mc = Math.max(mc, stones[i][1]);
    //     }
    //     //create DSU
    //     DisjointSet dsu = new DisjointSet(mr + mc + 1);
    //     //store stone's nodes
    //     ArrayList<Integer> stoneNodes = new ArrayList<>();
    //     for(int i=0;i<n;i++){
    //         int cr = stones[i][0];
    //         int cc = mr + 1 + stones[i][1];
    //         dsu.unionBySize(cr, cc);
    //         stoneNodes.add(cr);
    //         stoneNodes.add(cc);
    //     }
    //     //itr thru AL to find comps
    //     int comps=0;
    //     for(int a : stoneNodes){
    //         if(dsu.findParent(a) == a) comps++;
    //     }
    //     return n-comps;
    // }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int mr = 0, mc = 0;

        // Find max row index and max column index from the list of stones
        for (int i = 0; i < n; i++) {
            mr = Math.max(mr, stones[i][0]);
            mc = Math.max(mc, stones[i][1]);
        }

        // Create DSU with enough space for all row and column indices
        DisjointSet dsu = new DisjointSet(mr + mc + 2);

        // Use a HashSet to store unique stone nodes
        Set<Integer> uniqueNodes = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int cr = stones[i][0];          // Row index
            int cc = mr + 1 + stones[i][1]; // Column index (Shifted to avoid overlap)
            dsu.unionBySize(cr, cc);
            uniqueNodes.add(cr);
            uniqueNodes.add(cc);
        }

        // Count the number of connected components
        int comps = 0;
        for (int a : uniqueNodes) {
            if (dsu.findParent(a) == a) comps++;
        }

        // Maximum removable stones = Total stones - Number of connected components
        return n - comps;
    }

}

