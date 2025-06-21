package Dynamic_Programming.lec1_Intro;
/*Q3 Geek Jump
Difficulty: EasyAccuracy: 49.55%Submissions: 88K+Points: 2
 Geek wants to climb from the 0th stair to the (n-1)th stair. At a time the Geek can climb either one or two steps. A height[N] array is also given. Whenever the geek jumps from stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. return the minimum energy that can be used by the Geek to jump from stair 0 to stair N-1.

Example:

 

Input: n = 4, height = {10 20 30 10}
Output: 20
Explanation:
Geek jump from 1st to 2nd stair(|20-10| = 10 energy lost). Then a jump from the 2nd to the last stair(|10-20| = 10 energy lost). So, total energy lost is 20 which is the minimum.
Your Task:
You don't need to read input or print anything. Your task is to complete the function MinimumEnergy() which takes the array height, and integer n, and returns the minimum energy that is lost.

Expected Time Complexity: O(n)
Expected Space Complexity: O(n)

Constraint:
1<=n<=100000
1<=height[i]<=1000*/
public class q3_Frong_Jump_MinEnergy {
    public int minimumEnergy(int a[],int N){
        if(N==1) return 0;
        if(N==2) return Math.abs(a[1]-a[0]);

        int p2 = 0;
        int p1 = Math.abs(a[1]-a[0]);
        int c=0;
        for(int i=2;i<N;i++){
            //u can reach curr i by jumping 1 step from i-1 
            //or 2 step from i-2
            //p1 being lowest energy consumed till i-1
            //p2 being lowest energy consumed till i-2
            int j1 = p1 + Math.abs(a[i]-a[i-1]);
            int j2 = p2 + Math.abs(a[i]-a[i-2]);
            c= Math.min(j1, j2);
            p2=p1;
            p1=c;
        } return c;
    }
}
