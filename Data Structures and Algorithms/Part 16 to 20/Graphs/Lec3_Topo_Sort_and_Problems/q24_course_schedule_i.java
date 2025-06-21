package Graphs.Lec3_Topo_Sort_and_Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*207. Course Schedule
Medium
Topics
Companies
Hint
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
2M
Submissions
4.1M
Acceptance Rate
48.6% */
public class q24_course_schedule_i {
    public boolean canFinish(int n, int[][] t) {
        int p = t.length;
        ArrayList<Integer>[] g = new ArrayList[n];
        int[] indegree = new int[n];

        for(int i=0;i<n;i++) g[i] = new ArrayList<>();
        for(int i=0;i<p;i++) {
            indegree[t[i][1]]++;
            g[t[i][0]].add(t[i][1]);
        }
        // for(int i=0;i<n;i++){
        //     for(int nbr: g[i]) indegree[nbr]++;
        // }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++) if(indegree[i]==0) q.offer(i);
        int cnt=0;
        while(!q.isEmpty()){
            int curr = q.poll();
            cnt++;
            for(int nbr:g[curr]){
                indegree[nbr]--;
                if(indegree[nbr]==0) q.offer(nbr);
            }
        }
        return (n==cnt);
    }
}
