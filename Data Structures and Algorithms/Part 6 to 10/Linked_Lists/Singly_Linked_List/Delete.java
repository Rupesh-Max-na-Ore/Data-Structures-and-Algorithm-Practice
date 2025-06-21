/*
 * Q3
 * 237. Delete Node in a Linked List
Medium
Topics
Companies
There is a singly-linked list head and we want to delete a node node in it.

You are given the node to be deleted node. You will not be given access to the first node of head.

All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.

Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:

The value of the given node should not exist in the linked list.
The number of nodes in the linked list should decrease by one.
All the values before node should be in the same order.
All the values after node should be in the same order.
Custom testing:

For the input, you should provide the entire linked list head and the node to be given node. node should not be the last node of the list and should be an actual node in the list.
We will build the linked list and pass the node to your function.
The output will be the entire list after calling your function.
 

Example 1:


Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
Example 2:


Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 

Constraints:

The number of the nodes in the given list is in the range [2, 1000].
-1000 <= Node.val <= 1000
The value of each node in the list is unique.
The node to be deleted is in the list and is not a tail node.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.4M
Submissions
1.8M
Acceptance Rate
79.9%

 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

package Linked_Lists.Singly_Linked_List;

import Linked_Lists.Singly_Linked_List.LinkedList.Node;

public class Delete {
    // Fn to Delete non-tail Node w/o head ptr, given only access to that node
    // First attempt, O(n)
    public void deleteNode(Node node) {
        if (node == null || node.next == null) 
            return; // If node is null or node is last node, do nothing

        // Create Ptr to keep track of Previous Node while traversing
        Node prevNode = null;
        // Traverse SLL by ++ing node till we hit null
        while (node != null && node.next != null) {
            // Copy(Overwrite) the val of next node to curr node
            node.value = node.next.value;
            prevNode = node; // Update previous node ptr to pt to curr node
            node = node.next; // Move to the next node
        }

        // If prev node exists (probable), set its next ptr to null to remove the last node
        if (prevNode != null) {
            prevNode.next = null;
        }
    }

    public void deleteTail(Node h){
        // if SLL is vacant or has 1 node, just loose the head by returning null
        if (h == null || h.next == null) return;
        Node travel = h;
        // Traverse till 2nd last node
        while (travel.next.next!=null) travel=travel.next;

        travel.next=null; // remove link of 2nd last node from last node, deleting it        

    }

    public static void main(String[] args) {
        // Creating a test linked list: 4 -> 5 -> 1 -> 9
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node(4);
        linkedList.head.next = new Node(5);
        linkedList.head.next.next = new Node(1);
        linkedList.head.next.next.next = new Node(9);

        // Node to be deleted
        Node nodeToDelete = linkedList.head.next; // Node with value 5

        // Deleting the node
        Delete delete = new Delete();
        delete.deleteNode(nodeToDelete);

        // Printing the modified linked list
        LinkedList.print(linkedList.head); // Expected output: 4 -> 1 -> 9 -> null

        delete.deleteTail(linkedList.head);
        // Printing the modified linked list
        LinkedList.print(linkedList.head); // Expected output: 4 -> 1 -> null


    }
}

// // LC submission, better actually O(1)
// // Soln. is applicable only because it is mentioned in the question that it is not the last node(tail)
// public void deleteNode(ListNode node) {
//     // Copy the value of the next node to the current node.
//     node.val = node.next.val;
//     // Adjust the next pointer to skip the next node.
//     node.next = node.next.next;
// }