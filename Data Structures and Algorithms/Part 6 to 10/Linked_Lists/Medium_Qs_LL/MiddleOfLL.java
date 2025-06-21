package Linked_Lists.Medium_Qs_LL;
/*
 * Q1
 * 876. Middle of the Linked List
Solved
Easy
Topics
Companies
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.9M
Submissions
2.4M
Acceptance Rate
78.6%

 */
import Linked_Lists.Singly_Linked_List.LinkedList.Node;

public class MiddleOfLL {
    public Node LeftMiddleNode(Node h) {
        if(h==null||h.next==null) return h;

        Node slow = h;
        Node fast = h.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node RightMiddleNode(Node h) {
        if(h==null||h.next==null) return h;

        Node slow = h;
        Node fast = h;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
