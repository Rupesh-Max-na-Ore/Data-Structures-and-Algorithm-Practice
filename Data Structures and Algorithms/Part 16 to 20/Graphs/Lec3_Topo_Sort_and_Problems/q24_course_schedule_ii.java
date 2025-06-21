package Graphs.Lec3_Topo_Sort_and_Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Code
Testcase
Testcase
Test Result
210. Course Schedule II
Medium
Topics
Companies
Hint
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.3M
Submissions
2.5M
Acceptance Rate
52.7% */
public class q24_course_schedule_ii {
    public int[] findOrder(int n, int[][] t) {
        int p = t.length;
        ArrayList<Integer>[] g = new ArrayList[n];
        int[] indegree = new int[n];

        for(int i=0;i<n;i++) g[i] = new ArrayList<>();
        for(int i=0;i<p;i++) {
            indegree[t[i][0]]++;
            g[t[i][1]].add(t[i][0]);
        }
        // for(int i=0;i<n;i++){
        //     for(int nbr: g[i]) indegree[nbr]++;
        // }
        Queue<Integer> q=new LinkedList<>();
        int []ans=new int[n];
        for(int i=0;i<n;i++) if(indegree[i]==0) q.offer(i);
        int cnt=0;
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[cnt]=curr;
            cnt++;
            for(int nbr:g[curr]){
                indegree[nbr]--;
                if(indegree[nbr]==0) q.offer(nbr);
            }
        }
        return (cnt==n)?ans:new int[0];

    }

}
