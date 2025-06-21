package Greedy_Algorithms.Medium_Hard;
import java.util.Arrays;

/*Q11 435. Non-overlapping Intervals
Medium
Topics
Companies
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 

Constraints:

1 <= intervals.length <= 105
intervals[i].length == 2
-5 * 104 <= starti < endi <= 5 * 104
Seen this question in a real interview before?
1/5
Yes
No
Accepted
621.3K
Submissions
1.2M
Acceptance Rate
53.9% */
public class Non_overlapping_Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        //Sort by asc order of end time
        Arrays.sort(intervals, (a,b)-> a[1] - b[1]);
        int cnt=1;//1st interval/meeting always includes
        int lastEndTime=intervals[0][1];
        for(int i=0; i<n;i++){
            if(intervals[i][0]>= lastEndTime){
                //include
                cnt++;
                lastEndTime =intervals[i][1]; //increasing order of end time, no need to take max
                //lastEndTime = Math.max(lastEndTime, intervals[i][1]);
            }
        }
        return n-cnt;
    }
}
