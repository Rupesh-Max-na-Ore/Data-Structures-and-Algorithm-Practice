package Greedy_Algorithms.Medium_Hard;

import java.util.ArrayList;
import java.util.Arrays;

/*Q1 N meetings in one room
Difficulty: EasyAccuracy: 45.3%Submissions: 241K+Points: 2
There is one meeting room in a firm. There are n meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time? Return the maximum number of meetings that can be held in the meeting room.

 

Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.


Examples :

Input: n = 6, start[] = {1,3,0,5,8,5}, end[] =  {2,4,6,7,9,9}
Output: 4
Explanation: Maximum four meetings can be held with given start and end timings. The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
Input: n = 3, start[] = {10, 12, 20}, end[] = {20, 25, 30}
Output: 1
Explanation: Only one meetings can be held with given start and end timings.
Expected Time Complexity : O(n*Logn)
Expected Auxilliary Space : O(n)


Constraints:
1 ≤ n ≤ 105
0 ≤ start[i] < end[i] ≤ 105 */
public class N_meetings_in_one_room {
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n) {
        int[][] meetings = new int[n][3];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
            meetings[i][2] = i;//can omit if only ask count
        }

        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        int cnt = 1;//if ask no. of meets only
        int lastMeetingEndTime = meetings[0][1];
        //ArrayList<Integer> AnsSeqn = new ArrayList<>();//if ask sequence

        for (int i = 1; i < n; i++) {
            if (meetings[i][0] > lastMeetingEndTime) {
                cnt++;
                lastMeetingEndTime = meetings[i][1];
                //AnsSeqn.add(meetings[i][2]);
            }
        }

        return cnt;
        //Collections.sort(AnsSeqn);
        //return AnsSeqn;
    }
}
/*//Reference
import java.util.*;
class meeting {
    int start;
    int end;
    int pos;
     
    meeting(int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
class meetingComparator implements Comparator<meeting>
{
    @Override
    public int compare(meeting o1, meeting o2) 
    {
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if(o1.pos < o2.pos)
            return -1;
        return 1; 
    }
}
public class Meeting {
    static void maxMeetings(int start[], int end[], int n) {
        ArrayList<meeting> meet = new ArrayList<>();
        
        for(int i = 0; i < start.length; i++)
            meet.add(new meeting(start[i], end[i], i+1));
        
        meetingComparator mc = new meetingComparator(); 
        Collections.sort(meet, mc); 
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(meet.get(0).pos);
        int limit = meet.get(0).end; 
        
        for(int i = 1;i<start.length;i++) {
            if(meet.get(i).start > limit) {
                limit = meet.get(i).end; 
                answer.add(meet.get(i).pos);
            }
        }
        System.out.println("The order in which the meetings will be performed is ");
        for(int i = 0;i<answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }
    public static void main(String args[])
    {
        int n = 6;
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,5,7,9,9};
        maxMeetings(start,end,n);
        
    }
} */