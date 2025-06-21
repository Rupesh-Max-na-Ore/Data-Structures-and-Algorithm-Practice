package StackAndQueue.Lec3_MonotonicStackAndQueue;

import java.util.Stack;

/*Q5 42. Trapping Rain Water
Hard
Topics
Companies
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
Seen this question in a real interview before?
1/5
Yes
No
Accepted
2.2M
Submissions
3.5M
Acceptance Rate
62.3% */
public class Trapping_RainWater {
    // Optimal way 1 - 2 ptr. approach
    public int trap(int[] ht) {
        int n = ht.length;
        int L = 0; int R = n - 1;
        int Trapped = 0; //Total Trapped
        int MxL = 0, MxR = 0;
        // KEy idea is - only relative dips cause water trap
        // water trapped depends on the depth of dip(lower the more)
        // and ht. of min. relative peak on either side of dip(min(ht[L],ht[R])), the higher the more trapping
        while (L <= R) { //Can move any ptr when ht[L] == ht[R], actually
            if (ht[L] <= ht[R]) { //there exists a peak on R > curr L -> Potential for water trapping at Lth pos
                if (ht[L] >= MxL) MxL = ht[L]; //Peak not cause water trapping
                else Trapped += MxL - ht[L]; //==Trapped at curr Lth pos.
                L++;
            } 
            else { //there exists a peak on L > curr R -> Potential for water trapping at Rth pos
                if (ht[R] >= MxR) MxR = ht[R]; //Peak not cause water trapping
                else Trapped += MxR - ht[R]; //==Trapped at curr Rth pos.
                R--;
            }
        }
        return Trapped;
    }

    // //optimal way - 2 - using stack
    // public int trap(int[] ht) {
    //     Stack<Integer> st = new Stack<>();
    //     int curr = 0, rw=0;
    //     while(curr<ht.length){
    //         while(!st.isEmpty() && ht[curr]>ht[st.peek()]){
    //             int top = st.pop();
    //             if(st.isEmpty()) break; // no lft bound
    //             int d = curr - st.peek() -1;
    //             int fill = d*(Math.min(ht[curr], ht[st.peek()])-ht[top]);
    //             rw+=fill;
    //         } st.push(curr);
    //         curr++;
    //     } return rw;
    // }
}
