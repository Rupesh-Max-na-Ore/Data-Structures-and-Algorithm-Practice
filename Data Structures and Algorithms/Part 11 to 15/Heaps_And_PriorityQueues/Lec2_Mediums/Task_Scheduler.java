package Heaps_And_PriorityQueues.Lec2_Mediums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*Q6 Task Scheduler
 * Medium
Topics
Companies
Hint
You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.

​Return the minimum number of intervals required to complete all tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2

Output: 8

Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

After completing task A, you must wait two cycles before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th cycle, you can do A again as 2 intervals have passed.

Example 2:

Input: tasks = ["A","C","A","B","D","B"], n = 1

Output: 6

Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.

With a cooling interval of 1, you can repeat a task after just one other task.

Example 3:

Input: tasks = ["A","A","A", "B","B","B"], n = 3

Output: 10

Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.

There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.

 

Constraints:

1 <= tasks.length <= 104
tasks[i] is an uppercase English letter.
0 <= n <= 100
Seen this question in a real interview before?
1/5
Yes
No
Accepted
646.8K
Submissions
1.1M
Acceptance Rate
60.1%
 */
public class Task_Scheduler {
    //1st attempt, min heap, faster
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] hash = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>();//min heap
        for (char task : tasks) hash[task-'A']--;
        for (int count : hash) {
            if (count != 0) pq.offer(count);
        }
        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 1; i <= n+1; i++) {
                if (!pq.isEmpty()) {
                    int task = pq.poll();
                    task++;
                    temp.add(task+1);
                }
            }
            for (int F : temp) {
                if(F<0) pq.offer(F);
            }
            if(!pq.isEmpty()) time+=temp.size();
            else time+=n+1;
        }
        return time;
    }
    //2nd attempt, use max heap & more compact code, x2 slower
    //   public int leastInterval(char[] tasks, int n) {
    //     if (n == 0) return tasks.length;
    //     int[] hash = new int[26];
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -(o1.compareTo(o2)));//use max heap
    //     for (char task : tasks) hash[task-'A']++;
    //     for (int count : hash) {
    //         if (count != 0) pq.offer(count);
    //     }
    //     int time = 0;
    //     while (!pq.isEmpty()) {
    //         List<Integer> temp = new ArrayList<>();
    //         for (int i = 1; i <= n+1; i++) {
    //             if (pq.isEmpty() && temp.size() == 0) break;
    //             if (!pq.isEmpty()) {
    //                 int task = pq.poll();
    //                 if (task != 1) temp.add(task-1);
    //             }
    //             time++;
    //         }
    //         for (int F : temp) {
    //             pq.offer(F);
    //         }
    //     }
    //     return time;
    // }
}
//3rd attempt, greedy way
// class Solution {
//     public int leastInterval(char[] tasks, int n) {
//         if (n == 0) return tasks.length;
//         int[] hash = new int[26];
//         for (char task : tasks) hash[task-'A']++;
//         Arrays.sort(hash);
//         int maxF=hash[25];
//         int holes = maxF-1;
//         int idleSlots=n*holes;
//         for(int i=24;i>=0;i--) idleSlots-= Math.min(hash[i],holes);
//         return  Math.max(tasks.length,tasks.length+idleSlots);
//     }
// }
/*//Greedy optimized soln
// (c[25] - 1) * (n + 1) + 25 - i  is frame size
// when inserting chars, the frame might be "burst", then tasks.length takes precedence
// when 25 - i > n, the frame is already full at construction, the following is still valid.
public class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] c = new int[26];
        for(char t : tasks){
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while(i >= 0 && c[i] == c[25]) i--;

        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
}
    //highly recommend to read
    //https://leetcode.com/problems/task-scheduler/solutions/104496/concise-java-solution-o-n-time-o-26-space/
 */