package StackAndQueue.Lec3_MonotonicStackAndQueue;

import java.util.Stack;

/*Q7 735. Asteroid Collision
Medium
Topics
Companies
Hint
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 

Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
Seen this question in a real interview before?
1/5
Yes
No
Accepted
523.6K
Submissions
1.2M
Acceptance Rate
44.5% */
public class Asteroid_Collision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        for(int i = n-1; i>=0; i--){
            int curr = asteroids[i];
            //int currIndx= i;
            //when curr +ve and top -ve
            while(!st.isEmpty() && curr > 0 && st.peek() <0){
                //collision occurs
                int sum = curr + st.peek();
                if(sum < 0) { 
                    //top dominates curr
                    curr = 0; // nullify curr
                }
                else if(sum>0) {
                    //curr dominates top
                    st.pop();// destroy top
                }
                else if(sum==0){
                    //both destroy each other
                    st.pop();
                    curr = 0;
                } 
            }
            //otherwise, stack empty || curr -ve || top +ve
            if(curr !=0) st.push(curr);
        }
        //puta all that's remaining in stack, as survivors
        int s = st.size();
        int[] survivors = new int[s];
        for (int i = 0; i < s; i++) {
            survivors[i] = st.pop();
        }

        return survivors;
    }
}
/*//LC submission, using arraylist in a stack like manner(LIFO)
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> st = new ArrayList<>();
        int n = asteroids.length;
        for(int i = n-1; i>=0; i--){
            //int curr = asteroids[i];
            //int currIndx= i;
            //when curr +ve and top -ve
            while(!st.isEmpty() && asteroids[i] > 0 && st.get(st.size() - 1) <0){
                //collision occurs
                int sum = asteroids[i] + st.get(st.size() - 1);
                if(sum < 0) { 
                    //top dominates curr
                    asteroids[i] = 0; // nullify curr
                }
                else if(sum>0) {
                    //curr dominates top
                    //st.pop();// destroy top
                    st.remove(st.size() - 1);
                }
                else if(sum==0){
                    //both destroy each other
                    //st.pop();
                    st.remove(st.size() - 1);
                    asteroids[i] = 0;
                } 
            }
            //otherwise, stack empty || curr -ve || top +ve
            if(asteroids[i] !=0) st.add(asteroids[i]);
        }
        //puta all that's remaining in stack, as survivors
        int s = st.size();
        int[] survivors = new int[s];
        for (int i = 0; i < s; i++) {
            survivors[s-1-i] = st.get(i);
        }

        return survivors;
    }
}
*/

/*//Fastest LC soln., clever
/*
++ offer into stack
-- offer into stack
-+ offer into stack
+- compare

array with index as stack(top as top of stack, inclusive):
top  = -1    : empty
top >= 0     : not empty
array[++top] : offer new guy onto top of stack
top--        : pop
array[top]   : peek
*/
// class Solution {
//     public int[] asteroidCollision(int[] a) {
//         int top = -1;
//         for (int x : a) {
//             boolean stillAlive = true; // new guys is still alive
//             while (stillAlive && x < 0 && top >= 0 && a[top] > 0) {
//                 stillAlive = a[top] + x < 0;
//                 if (a[top] + x <= 0) top--; // die young or die together
//             }
//             if (stillAlive) a[++top] = x; // if new guys is still alive, put it on top of stack
//         }
        
//         return Arrays.copyOf(a, top+1); // return whats in stack as array
//     }
// }
// */