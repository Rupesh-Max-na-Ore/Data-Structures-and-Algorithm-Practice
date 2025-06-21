/*
 * Q2
 * 
Linked List Insertion
BasicAccuracy: 43.96%Submissions: 193K+Points: 1
Get Internship at GfG by submitting your Entries in: Data Science Blogathon

banner
Create a link list of size N according to the given input literals. Each integer input is accompanied by an indicator which can either be 0 or 1. If it is 0, insert the integer in the beginning of the link list. If it is 1, insert the integer at the end of the link list. 
Hint: When inserting at the end, make sure that you handle NULL explicitly.

Example 1:

Input:
LinkedList: 9->0->5->1->6->1->2->0->5->0
Output: 5 2 9 5 6
Explanation:
Length of Link List = N = 5
9 0 indicated that 9 should be
inserted in the beginning. Modified
Link List = 9.
5 1 indicated that 5 should be
inserted in the end. Modified Link
List = 9,5.
6 1 indicated that 6 should be
inserted in the end. Modified Link
List = 9,5,6.
2 0 indicated that 2 should be
inserted in the beginning. Modified
Link List = 2,9,5,6.
5 0 indicated that 5 should be
inserted in the beginning. Modified
Link List = 5,2,9,5,6. 
Final linked list = 5, 2, 9, 5, 6.

Example 2:

Input:
LinkedList: 5->1->6->1->9->1
Output: 5 6 9

Your Task:
You only need to complete the functions insertAtBeginning() and insertAtEnd() that takes the head of link list and integer value of the data to be inserted as inputs and returns the head of the modified link list. 

Expected Time Complexity: O(1) for insertAtBeginning() and O(N) for insertAtEnd().
Expected Auxiliary Space: O(1) for both.

Constraints:
1 <= N <= 104
 */

package Linked_Lists.Singly_Linked_List;

import Linked_Lists.Singly_Linked_List.LinkedList.Node;

public class Insert {
    //Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x)
    {
        // Make next of newly created node to same Node as pointed by Head
        Node newNode = new Node(x);
        // Make next of newly created node point to the current head
        newNode.next = head;
        // Node newHead = newNode;
        // return newHead; // works but not required to create new ptr
        // The new node itself becomes the new head of the list
        return newNode;
    }
    
    //Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x)
    {
        // Travel to End Node of SLL and make its next point to newly created node
        Node newNode = new Node(x);
         // If the list is empty, the new node becomes the head
         if (head == null) {
            return newNode;
        }
        // Travel to the end of the list
        Node travel = head;
        while(travel.next!=null){
            travel=travel.next;
        }
        // Make the last node's next point to the new node
        travel.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        Insert insert = new Insert();
        Node head = null;

        // Example 1
        int[] data = {9, 5, 6, 2, 5};
        int[] indicators = {0, 1, 1, 0, 0};
        for (int i = 0; i < data.length; i++) {
            if (indicators[i] == 0) {
                head = insert.insertAtBeginning(head, data[i]);
            } else {
                head = insert.insertAtEnd(head, data[i]);
            }
        }
        LinkedList.print(head);  // Expected Output: 5->2->9->5->6->null

        // Example 2
        head = null;  // Reset the list
        int[] data2 = {5, 6, 9};
        int[] indicators2 = {1, 1, 1};
        for (int i = 0; i < data2.length; i++) {
            if (indicators2[i] == 0) {
                head = insert.insertAtBeginning(head, data2[i]);
            } else {
                head = insert.insertAtEnd(head, data2[i]);
            }
        }
        LinkedList.print(head);  // Expected Output: 5->6->9->null
    }
}
