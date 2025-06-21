package Greedy_Algorithms.Medium_Hard;

import java.util.ArrayList;
import java.util.List;

/*Q9 57. Insert Interval
Medium
Topics
Companies
Hint
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.2M
Submissions
2.8M
Acceptance Rate
42.0% */
public class Insert_Intervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i=0; int n= intervals.length;

        //Left - all intervals that end before start of NI
        while(i<n && intervals[i][1]<newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }
        //Overlaps - all intervals that end after start of NI only(as exit from prev loop)
        // loop runs till we keep finding intervals whose start before end of NI
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0], newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ans.add(newInterval);
        //exit from loop when start of intervals after end of NI only
        // Right
        while(i<n){
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}

// //Reference code using for loop
// public int[][] insert(int[][] intervals, int[] newInterval) {
//     List<int[]> ans = new ArrayList<>();
//     int[] toAdd = newInterval;
    
//     for (int i = 0; i < intervals.length; i ++) {
//         /*1. No overlap and toAdd appears before current interval, add toAdd to result.*/
//         if (intervals[i][0] > toAdd[1]) {
//             ans.add(toAdd);
//             toAdd = intervals[i];
//         }
//         /*2. Has overlap, update the toAdd to the merged interval.*/
//         else if (intervals[i][1] >= toAdd[0])  
//             toAdd = new int[] {Math.min(intervals[i][0], toAdd[0]),
//                                Math.max(intervals[i][1], toAdd[1]) };
//         /*3. No overlap and toAdd appears after current interval, add current interval to result.*/
//         else ans.add(intervals[i]); 
//     }
//     ans.add(toAdd);
//     return ans.toArray(new int[ans.size()][2]);
// }
// https://leetcode.com/problems/insert-interval/solutions/477856/beat-99-consice-java-solution/