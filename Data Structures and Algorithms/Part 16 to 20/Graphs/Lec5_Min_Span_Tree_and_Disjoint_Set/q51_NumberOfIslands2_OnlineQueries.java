package Graphs.Lec5_Min_Span_Tree_and_Disjoint_Set;

import java.util.ArrayList;
import java.util.List;

/*Number of Islands - II - Online Queries - DSU: G-51


24

0
Problem Statement: You are given an n, m which means the cr and column of the 2D matrix, and an array of size k denoting the number of operations. Matrix elements are 0 if there is water or 1 if there is land. Originally, the 2D matrix is all 0 which means there is no land in the matrix. The array has k operator(s) and each operator has two integers A[i][0], A[i][1] means that you can change the cell matrix[A[i][0]][A[i][1]] from sea to island. Return how many islands are there in the matrix after each operation. You need to return an array of size k.

Note: An island means a group of 1s such that they share a common side.

Pre-requisite: Disjoint Set data structure

Example 1:

Input Format: n = 4 m = 5 k = 4 A = {{1,1},{0,1},{3,3},{3,4}} Output: 1 1 2 2 Explanation: The following illustration is the representation of the operation:

Example 2:

Input Format: n = 4 m = 5 k = 12 A = {{0,0},{0,0},{1,1},{1,0},{0,1},{0,3},{1,3},{0,4}, {3,2}, {2,2},{1,2}, {0,2}} Output: 1 1 2 1 1 2 2 2 3 3 1 1 Explanation: If we follow the process like in example 1, we will get the above result. */
public class q51_NumberOfIslands2_OnlineQueries {
    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        DisjointSet ds = new DisjointSet(n * m);
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        int len = operators.length;
        int dx[] = { -1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        //iterate thru queries/islands
        for (int i = 0; i < len ; i++) {
            int cr = operators[i][0];
            int cc = operators[i][1];
            //if already visited
            if (vis[cr][cc]) {
                ans.add(cnt);
                continue;
            }
            //else
            vis[cr][cc] = true;
            cnt++; //incr per new operation/query

            //check out 4 nbrs
            for (int ind = 0; ind < 4; ind++) {
                int nbrr = cr + dx[ind];
                int nbrc = cc + dy[ind];
                if (isValid(nbrr, nbrc, n, m)) {//if nbr w/in boundary
                    if (vis[nbrr][nbrc]) {
                        int currNodeNo = cr * m + cc;
                        int nbrNodeNo = nbrr * m + nbrc;
                        if (ds.findParent(currNodeNo) != ds.findParent(nbrNodeNo)) {
                            cnt--;
                            ds.unionBySize(currNodeNo, nbrNodeNo);
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
    private boolean isValid(int nbrr, int nbrc, int n, int m) {//just boundary check
        return nbrr >= 0 && nbrr < n && nbrc >= 0 && nbrc < m;
    }
}
