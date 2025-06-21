package Arrays.Medium;
//q9
// Leaders in an array
// EasyAccuracy: 29.94%Submissions: 629K+Points: 2
// Find better job opportunities this summer via Job-A-Thon Hiring Challenge!

// banner
// Given an array A of positive integers. Your task is to find the leaders in the array. An element of array is a leader if it is greater than or equal to all the elements to its right side. The rightmost element is always a leader. 

// Example 1:

// Input:
// n = 6
// A[] = {16,17,4,3,5,2}
// Output: 17 5 2
// Explanation: The first leader is 17 
// as it is greater than all the elements
// to its right.  Similarly, the next 
// leader is 5. The right most element 
// is always a leader so it is also 
// included.
// Example 2:

// Input:
// n = 5
// A[] = {1,2,3,4,0}
// Output: 4 0
// Explanation: 0 is the rightmost element
// and 4 is the only element which is greater
// than all the elements to its right.
// Your Task:
// You don't need to read input or print anything. The task is to complete the function leader() which takes array A and n as input parameters and returns an array of leaders in order of their appearance.

// Expected Time Complexity: O(n)
// Expected Auxiliary Space: O(n)

// Constraints:
// 1 <= n <= 107
// 0 <= Ai <= 107
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Leaders {
        static ArrayList<Integer> leaders(int a[], int n){
        // Your code here
        ArrayList<Integer> B= new ArrayList<>();
  
        // Last element of an array is always a leader,
        // push into ans array.
        int max = a[n - 1];
     
         B.add(a[n-1]);
         
         // Start checking from the end whether a number is greater
         // than max no. from right, hence leader.
         for (int i = n - 2; i >= 0; i--)
           if (a[i] > max) {
             B.add(a[i]);
             max = a[i];
           }
           
           Collections.reverse(B);
       return B;


    }

    public static void main(String[] args) {
        int[] a1 = {5,1,4,2,3,4,3,2};//{-1,-1,0,3,-3,4,-5,6,-7};
        
        System.out.println("Original array: " + Arrays.toString(a1));
        Object []max=(Leaders.leaders(a1,a1.length)).toArray();
        System.out.println("leaders: "+Arrays.toString(max));
        }
}
