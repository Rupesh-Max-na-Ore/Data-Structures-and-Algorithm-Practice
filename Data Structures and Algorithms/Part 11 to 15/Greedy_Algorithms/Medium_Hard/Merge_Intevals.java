package Greedy_Algorithms.Medium_Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*Q10 56. Merge Intervals
Solved
Medium
Topics
Companies
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
Seen this question in a real interview before?
1/5
Yes
No
Accepted
2.6M
Submissions
5.4M
Acceptance Rate
47.8% */
public class Merge_Intevals {
     public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        
        if(intervals.length == 0 || intervals == null) {
            return ans.toArray(new int[0][]);
        }
        
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int[] i : intervals) {
            if(i[0] <= end) {
                end = Math.max(end, i[1]);
            }
            else {
                ans.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[0][]);
    }
}
