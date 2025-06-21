package Linked_Lists.Singly_Linked_List;

import Linked_Lists.Singly_Linked_List.LinkedList.Node;

/*
 * Q1
 * Introduction to Linked List
EasyAccuracy: 66.76%Submissions: 17K+Points: 2
Get Internship at GfG by submitting your Entries in: Data Science Blogathon

banner
Geek loves linked list data structure. Given an array of integer arr of size n, Geek wants to construct the linked list from arr.

Construct the linked list from arr and return the head of the linked list.

Example 1:

Input:
n = 5
arr = [1,2,3,4,5]
Output:
1 2 3 4 5
Explanation: Linked list for the given array will be 1->2->3->4->5.
Example 2:

Input:
n = 2
arr = [2,4]
Output:
2 4
Explanation: Linked list for the given array will be 2->4.
Constraints:
1 <= n <= 105
1 <= arr[i] <= 100

Your Task:
You don't need to read input or print anything. Your task is to complete the function constructLL() which takes arr[] as input parameters and returns the head of the Linked List.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)
 */
/*
class Node { 
    int data; 
    Node next; 

    Node() { data = 0; }
    Node(int d) { data = d; }  //constructor to create a new node
} 
*/
public class ArrayToLL {
    static Node constructLL(int a[]) {
        int n = a.length;
        if(n==0) return null;
        // LinkedList SLL = new LinkedList();
        // SLL.head = new Node(a[0]);
        // Node travel = SLL.head;
        // for(int i=1; i<n; i++){
        //     travel.next= new Node(a[i]);
        // }
        // return SLL.head;
        //---------------------------------
        // Create the head of the linked list
        Node head = new Node(a[0]);
        Node travel = head;
        // Loop to add the rest of the nodes
        for (int i = 1; i < a.length; i++) {
            travel.next = new Node(a[i]);
            travel = travel.next; // Move the travel pointer to the next node
        }
        return head;
    }

    public static void main(String[] args) {
        int a[]={1,2,3,4};
        Node head = ArrayToLL.constructLL(a);
        LinkedList.print(head);
    }

}

// // gfg submission
// /*
// class Node { 
//     int data; 
//     Node next; 

//     Node() { data = 0; }
//     Node(int d) { data = d; }  //constructor to create a new node
// } 
// */
// class Solution {
//     static Node constructLL(int a[]) {
//         int n = a.length;
//         if(n==0) return null;
//         // Create the head of the linked list
//         Node head = new Node(a[0]);
//         Node travel = head;
//         // Loop to add the rest of the nodes
//         for (int i = 1; i < a.length; i++) {
//             travel.next = new Node(a[i]);
//             travel = travel.next; // Move the travel pointer to the next node
//         }
//         return head;
//     }
// }
