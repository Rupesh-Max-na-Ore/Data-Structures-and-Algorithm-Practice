package Linked_Lists.Medium_Qs_LL;
/*Q2
 * 206. Reverse Linked List
Solved
Easy
Topics
Companies
Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

Seen this question in a real interview before?
1/5
Yes
No
Accepted
4.2M
Submissions
5.4M
Acceptance Rate
76.7%
 */
import Linked_Lists.Singly_Linked_List.LinkedList.Node;

public class ReverseSLL {
    public Node reverseSLL(Node h){
        if(h==null||h.next==null) return h;

        Node Pt=null;
        Node t=h;
        Node Ft=h.next;

        while(t!=null){
            t.next=Pt;
            Pt=t;
            t=Ft;
            if(Ft==null) h=t;
            else Ft = Ft.next;
        }
        return Pt;
    }
}
// // lc submission
// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode reverseList(ListNode h) {
//         if(h==null||h.next==null) return h;

//         ListNode Pt=null;
//         ListNode t=h;
//         ListNode Ft=h.next;

//         while(t!=null){
//             t.next=Pt;
//             Pt=t;
//             t=Ft;
//             if(Ft==null) h=t;
//             else Ft = Ft.next;
//         }
//         return Pt;
//     }
// }