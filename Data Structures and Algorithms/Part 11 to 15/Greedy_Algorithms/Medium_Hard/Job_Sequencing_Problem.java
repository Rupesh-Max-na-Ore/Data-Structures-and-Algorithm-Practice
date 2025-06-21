package Greedy_Algorithms.Medium_Hard;

import java.util.Arrays;

/*Q5 Job Sequencing Problem
Difficulty: MediumAccuracy: 34.51%Submissions: 217K+Points: 4
Given a set of N jobs where each jobi has a deadline and profit associated with it.

Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with job if and only if the job is completed by its deadline.

Find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job. Deadline of the job is the time before which job needs to be completed to earn the profit.


Example 1:

Input:
N = 4
Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
Output:
2 60
Explanation:
Job1 and Job3 can be done with
maximum profit of 60 (20+40).
Example 2:

Input:
N = 5
Jobs = {(1,2,100),(2,1,19),(3,2,27),
        (4,1,25),(5,1,15)}
Output:
2 127
Explanation:
2 jobs can be done with
maximum profit of 127 (100+27).

Your Task :
You don't need to read input or print anything. Your task is to complete the function JobScheduling() which takes an integer N and an array of Jobs(Job id, Deadline, Profit) as input and returns the count of jobs and maximum profit as a list or vector of 2 elements.


Expected Time Complexity: O(NlogN)
Expected Auxilliary Space: O(N)


Constraints:
1 <= N <= 105
1 <= Deadline <= N
1 <= Profit <= 500 */
//given
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

public class Job_Sequencing_Problem {
    int[] JobScheduling(Job arr[], int n) {
      Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

      int maxDeadline = 0;

      for (int i = 0; i < n; i++) {
         if (arr[i].deadline > maxDeadline) maxDeadline = arr[i].deadline;
      }

      int JobSchedulingSlots[] = new int[maxDeadline + 1];

      for (int i = 1; i <= maxDeadline; i++) JobSchedulingSlots[i] = -1;

      int jobsScheduledYet = 0, estimatedProfitYet = 0;

      for (int i = 0; i < n; i++) {

         for (int j = arr[i].deadline; j > 0; j--) {

            // job slot unoccupied, so we can fix schedule of next most profitable among remaining jobs in that slot 
            if (JobSchedulingSlots[j] == -1) {
               JobSchedulingSlots[j] = i;
               jobsScheduledYet++;
               estimatedProfitYet += arr[i].profit;
               break;
            }
         }
      }

      return new int[] {jobsScheduledYet,estimatedProfitYet};

   }
}
