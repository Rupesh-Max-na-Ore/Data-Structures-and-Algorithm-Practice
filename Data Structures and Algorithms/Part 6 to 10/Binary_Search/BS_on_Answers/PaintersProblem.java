package Binary_Search.BS_on_Answers;

import java.util.ArrayList;
import java.util.List;

/*
 * Q10
 * Painter's Partition Problem
Problem Statement: Given an array/list of length ‘N’, where the array/list represents the boards and each element of the given array/list represents the length of each board. Some ‘K’ numbers of painters are available to paint these boards. Consider that each unit of a board takes 1 unit of time to paint. You are supposed to return the area of the minimum time to get this job done of painting all the ‘N’ boards under the constraint that any painter will only paint the continuous sections of boards.

Pre-requisite: BS-18. Allocate Books or Book Allocation | Hard Binary Search

Examples
Example 1:
Input Format:
 N = 4, boards[] = {5, 5, 5, 5}, k = 2
Result:
 10
Explanation:
 We can divide the boards into 2 equal-sized partitions, so each painter gets 10 units of the board and the total time taken is 10.

Example 2:
Input Format:
 N = 4, boards[] = {10, 20, 30, 40}, k = 2
Result:
 60
Explanation:
 We can divide the first 3 boards for one painter and the last board for the second painter.

We can allocate the boards to the painters in several ways but it is clearly said in the question that we have to allocate the boards in such a way that the painters can paint all the boards in the minimum possible time. The painters will work simultaneously.

Note: Upon close observation, we can understand that this problem is similar to the previous problem: BS-18. Allocate Books or Book Allocation | Hard Binary Search. There we had to allocate books to the students and here we need to allocate walls to the painters.

Assume the given array is {10, 20, 30, 40} and number of painters, k = 2. Now, we can allocate these boards in different ways. Some of them are the following:

10 | 20, 30, 40  → Minimum time required to paint all the boards  = 90
10, 20 | 30, 40  → Minimum time required to paint all the boards = 70
10, 20, 30 | 40  → Minimum time required to paint all the boards = 60
From the above allocations, we can clearly observe that in the last case, the first painter will paint the first 3 walls in 60 units of time and the second painter will take 40 units of time. So, the minimum time required to paint all the boards is 60.

Observations:

Minimum possible answer: We will get the minimum answer when we give n boards of the array to n painters(i.e. Each painter will be allocated 1 board). Now, in this case, the minimum time required to paint all the boards will be the maximum element in the array. So, the minimum possible answer is max(arr[]).
Maximum possible answer: We will get the maximum answer when we give all n boards to a single painter. The total time required is the summation of array elements i.e. sum(arr[]). So, the maximum possible answer is sum(arr[]).
From the observations, it is clear that our answer lies in the range [max(arr[]), sum(arr[])].

How to calculate the number of painters we need if we have to paint all the walls within ‘time’ units of time:

In order to calculate the number of painters we will write a function, countPainters(). This function will take the array and ‘time’ as parameters and return the number of painters to whom we can allocate the boards.

countPainters(arr[], time):

We will first declare two variables i.e. ‘painters’(stores the no. of painters), and ‘boardsPainter’(stores the unit of boards, a painter will paint). As we are starting with the first painter, ‘painters’ should be initialized with 1.
We will start traversing the given array.
If boardsPainter + arr[i] <= time: If upon adding the current board with ‘boardsPainter’ does not exceed the time limit, we can allocate this i-th board to the current painter.
Otherwise, we will move to the next painter(i.e. painters += 1 ) and allocate the i-th board.
Finally, we will return the value of ‘painters’.
 */
public class PaintersProblem {
    public static int MinTimeToPaint(ArrayList<Integer> boards, int k)
    {
        int n=boards.size();
        if (k>n) return -1;
        int max = findMax(boards);
        if(k==n) return max;
        int sum = findSum(boards);
        if(k==n) return sum;
        int l=max; int r=sum;
        while(r>=l){
            int m=l+(r-l)/2;
            
            if (PaintersNeeded(boards,m,k)<=k) r=m-1;
            else l=m+1;
        } return l;
    }
        private static int PaintersNeeded(ArrayList<Integer> boards, int maxTime, int k) {
        int PntrCnt=1;
        int BrdAlloc=0;
        for(int board:boards){
            if(board+BrdAlloc<=maxTime) BrdAlloc+=board;
            else{
                PntrCnt++;
                if(PntrCnt>k) return PntrCnt;
                BrdAlloc=board;
                
            }
        } return PntrCnt;
    }
    // Methods designed for Arraylists
    // Method to find the max value
    public static int findMax(List<Integer> list) {
        int max = list.get(0); // Assume the first elem is the max
        for (int num : list) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    

    // Method to find the sum of elems
    public static int findSum(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        // Test cases
        ArrayList<Integer> boards1 = new ArrayList<>(List.of(5, 5, 5, 5));
        int painters1 = 2;
        System.out.println("Test Case 1:");
        System.out.println("Input: boards = {5, 5, 5, 5}, painters = 2");
        System.out.println("Output: " + MinTimeToPaint(boards1, painters1)); // Expected output: 10

        ArrayList<Integer> boards2 = new ArrayList<>(List.of(10, 20, 30, 40));
        int painters2 = 2;
        System.out.println("\nTest Case 2:");
        System.out.println("Input: boards = {10, 20, 30, 40}, painters = 2");
        System.out.println("Output: " + MinTimeToPaint(boards2, painters2)); // Expected output: 60
    }
}
// CODE 360 subm
// import java.util.*;

// public class Solution 
// {
//     public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
//     {
//         int n=boards.size();
//         if (k>n) return -1;
//         int max = findMax(boards);
//         if(k==n) return max;
//         int sum = findSum(boards);
//         if(k==n) return sum;
//         int l=max; int r=sum;
//         while(r>=l){
//             int m=l+(r-l)/2;
            
//             if (PaintersNeeded(boards,m,k)<=k) r=m-1;
//             else l=m+1;
//         } return l;

//     }

//     private static int PaintersNeeded(ArrayList<Integer> boards, int maxTime, int k) {
//         int PntrCnt=1;
//         int BrdAlloc=0;
//         for(int board:boards){
//             if(board+BrdAlloc<=maxTime) BrdAlloc+=board;
//             else{
//                 PntrCnt++;
//                 if(PntrCnt>k) return PntrCnt;
//                 BrdAlloc=board;
                
//             }
//         } return PntrCnt;
//     }
//     // Methods designed for Arraylists
//     // Method to find the max value
//     public static int findMax(List<Integer> list) {
//         int max = list.get(0); // Assume the first elem is the max
//         for (int num : list) {
//             if (num > max) {
//                 max = num;
//             }
//         }
//         return max;
//     }
    

//     // Method to find the sum of elems
//     public static int findSum(List<Integer> list) {
//         int sum = 0;
//         for (int num : list) {
//             sum += num;
//         }
//         return sum;
//     }
// }