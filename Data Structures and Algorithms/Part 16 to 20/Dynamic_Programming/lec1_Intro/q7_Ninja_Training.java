package Dynamic_Programming.lec1_Intro;
/*Q7 Geek's Training
Difficulty: MediumAccuracy: 49.98%Submissions: 80K+Points: 4
Geek is going for a training program. He can perform any of these activities: 
Running, Fighting, and Learning Practice. Each activity has some point on each day. 
As Geek wants to improve all his skills, he can't do the same activity on two consecutive days. 
Help Geek to maximize his merit points as you are given a 2D array of points arr, 
corresponding to each day and activity.

Example:
Input: n=3 and arr[]= [[1,2,5],[3,1,1],[3,3,3]]
Output:11
Explanation:Geek will learn a new move and earn 5 point then on second 
day he will do running and earn 3 point and on third day 
he will do fighting and earn 3 points so, maximum point is 11.
Expected Time Complexity: O(3*n)
Expected Space Complexity: O(3*n)

Constraint:
1 <=  arr.size <= 105
1 <=  arr[i][j] <= 100 */
public class q7_Ninja_Training {
    public int maximumPoints(int pts[][], int n) {
        // code here
        // Ini. an arr 'prev' to store the max. pts for the previous day
        int prev[] = new int[4];

        // Ini. the 1st day's max. pts based on the available choices
        prev[0] = Math.max(pts[0][1], pts[0][2]);
        prev[1] = Math.max(pts[0][0], pts[0][2]);
        prev[2] = Math.max(pts[0][0], pts[0][1]);
        prev[3] = Math.max(pts[0][0], Math.max(pts[0][1], pts[0][2]));

        // Iterate through each day starting from the 2nd day onwards
        for (int day = 1; day < n; day++) {
            // Ini. an arr 'tmp' to store the max. pts for the current day
            int tmp[] = new int[4];
            for (int last = 0; last < 4; last++) {//for last
                // Ini. the max. pts for the current day and last activity
                tmp[last] = 0; 
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { 
                        // Ensure that the current task is different from the last
                        // Calc. the pts for the current activity and 
                        // add it to the max. pts from the previous day
                        tmp[last] = Math.max(tmp[last], pts[day][task] + prev[task]);
                    }
                }
            }
            // Update 'prev' to store the max. pts for the current day
            prev = tmp;
        }

        // Return the max. pts achievable after all days, last activity being 3
        return prev[3];
    }
}
