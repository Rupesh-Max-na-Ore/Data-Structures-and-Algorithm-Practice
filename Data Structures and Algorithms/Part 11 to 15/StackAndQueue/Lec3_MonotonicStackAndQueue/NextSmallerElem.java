package StackAndQueue.Lec3_MonotonicStackAndQueue;

import java.util.ArrayList;
import java.util.Stack;

/*Q3  Nearest Smaller Element
Programming
Stacks And Queues
Easy
51.3% Success

539

16

Bookmark
Asked In:
Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

    G[i] for an element A[i] = an element A[j] such that 
    j is maximum possible AND 
    j < i AND
    A[j] < A[i]
Elements for which no smaller element exist, consider next smaller element as -1.

Input Format

The only argument given is integer array A.
Output Format

Return the integar array G such that G[i] contains nearest smaller number than A[i].If no such element occurs G[i] should be -1.
For Example

Input 1:
    A = [4, 5, 2, 10, 8]
Output 1:
    G = [-1, 4, -1, 2, 2]
Explaination 1:
    index 1: No element less than 4 in left of 4, G[1] = -1
    index 2: A[1] is only element less than A[2], G[2] = A[1]
    index 3: No element less than 2 in left of 2, G[3] = -1
    index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
    index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
    
Input 2:
    A = [3, 2, 1]
Output 2:
    [-1, -1, -1]
Explaination 2:
    index 1: No element less than 3 in left of 3, G[1] = -1
    index 2: No element less than 2 in left of 2, G[2] = -1
    index 3: No element less than 1 in left of 1, G[3] = -1
Show similar questions
MAXSPPROD
88 Minutes Medium
Asked in:
Balanced Parantheses!
15 Minutes Easy
Asked in:
Hotel Service
48 Minutes Medium
Asked in:
Note:You only need to implement the given function. Do not read input, instead use the arguments to the function. Do not print the output, instead return values as specified. Still have a question? Checkout Sample Codes for more details.
submission-count
90350
successful submissions.
See Expected Output*/
public class NextSmallerElem {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> prevSmallerElem = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int num: A){
            while(!st.isEmpty() && st.peek() >= num) st.pop();
            if(st.isEmpty()) prevSmallerElem.add(-1);
            else prevSmallerElem.add(st.peek());
            st.push(num);
        } return prevSmallerElem;
    }
}
