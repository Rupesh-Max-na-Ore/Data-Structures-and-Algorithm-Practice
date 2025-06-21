package StackAndQueue.Lec3_MonotonicStackAndQueue;

import StackAndQueue.Lec1_Learning.Stack;

/*Q4 Number of NGEs to the right
Difficulty: MediumAccuracy: 60.69%Submissions: 10K+Points: 4
Given an array of N integers and Q queries of indices, print the number of next greater elements(NGEs) to the right of the given index element. 
Example:

Input:  arr     = [3, 4, 2, 7, 5, 8, 10, 6]
        queries = 2
        indices = [0, 5]
Output:  6, 1
Explanation:  
The next greater elements to the right of 3(index 0)
are 4,7,5,8,10,6.  
The next greater elements to the right of 8(index 5)
is only 10.

Your Task:
You don't need to read or print anything. Your task is to complete the function count_NGEs() which takes N, arr, queries and indices as the input parameter and returns a list NGEs[] where NGEs[i] stores the count of elements strictly greater than the current element (arr[indices[i]]) to the right of indices[i].


Expected Time Complexity: O(N * queries).
Expected Auxiliary Space: O(queries).


Constraints:
1 <= N <= 104
1 <= arr[i] <= 105
1 <= queries <= 100

0 <= indices[i] <= N - 1 */
import java.util.Stack;

public class NumberOfNGEsToRight {
    public static int[] count_NGEs(int n, int a[], int queries, int indices[]) {
        int [] ans = new int[queries];
        for(int i = 0 ; i< queries ; i++) ans[i] = cntNGE(n,a,indices[i]);
        return ans;
    }
    // Stack SOln.
    // private static int cntNGE(int n, int[] a, int start) {
    //     int  cnt = 0;
    //     Stack <Integer> st = new Stack<>();
    //     for(int i=n-1 ;i>=start; i-- ){
    //         int curr = a[i];
    //         if(i==start){
    //             while(!st.isEmpty()){
    //                 if(st.peek() > curr) cnt++;
    //                 st.pop();
    //             }
    //         }
    //         st.push(curr);
    //     } return cnt;
    // }
    //just iterating soln., more efficicent here actually
    private static int cntNGE(int n, int[] a, int start) {
        int  cnt = 0;
        for(int i=start+1; i<n; i++ ){
            int curr = a[i];
            if(curr > a[start]) cnt++;
        } return cnt;
    }
}
