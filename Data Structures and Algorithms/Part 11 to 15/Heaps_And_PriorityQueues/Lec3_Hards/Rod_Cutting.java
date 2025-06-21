package Heaps_And_PriorityQueues.Lec3_Hards;
/*Q2 Rod Cutting
Difficulty: MediumAccuracy: 60.66%Submissions: 124K+Points: 4
Given a rod of length N inches and an array of prices, price[]. price[i] denotes the value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

Note: Consider 1-based indexing.

Example 1:

Input:
N = 8
Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
Output:
22
Explanation:
The maximum obtainable value is 22 by 
cutting in two pieces of lengths 2 and 
6, i.e., 5+17=22.
Example 2:

Input:
N=8
Price[] = {3, 5, 8, 9, 10, 17, 17, 20}
Output: 
24
Explanation: 
The maximum obtainable value is 
24 by cutting the rod into 8 pieces 
of length 1, i.e, 8*price[1]= 8*3 = 24. 
Your Task:  
You don't need to read input or print anything. Your task is to complete the function cutRod() which takes the array A[] and its size N as inputs and returns the maximum price obtainable.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 1000
1 ≤ Ai ≤ 105

Seen this question in a real interview before ?
Yes
No
Company Tags
Google */
public class Rod_Cutting {
    public int cutRod(int price[], int n) {
        
    }
}
/*Aman Gour
1 month ago

is it possible to do this question using Heaps ?? anyone who could please help 

 


3

0
Reply
( Hide Replies )
User
Mahi Verma
2 weeks ago

@user_nrupybt  No, It is not possible. It is a classical DP problem. 
If you are coming from the striver's A to Z sheet , the wrong link is pasted there. 
The correct problem link is https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1


7

0 */