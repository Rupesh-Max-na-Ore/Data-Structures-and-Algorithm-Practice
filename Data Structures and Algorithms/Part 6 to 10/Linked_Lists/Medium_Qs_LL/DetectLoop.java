package Linked_Lists.Medium_Qs_LL;

import Linked_Lists.Singly_Linked_List.LinkedList.Node;

/*Q4 141. Linked List Cycle
Solved
Easy
Topics
Companies
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:


Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:


Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 

Follow up: Can you solve it using O(1) (i.e. constant) memory?

Seen this question in a real interview before?
1/5
Yes
No
Accepted
3M
Submissions
5.9M
Acceptance Rate
50.5%
*/
public class DetectLoop {
    // fifth attempt, just curious
    // public boolean hasCycle(Node h) {
    //     if(h==null||h.next==null) return false;
    //     Node fast=h.next;
    //     Node slow=h;
    //     //if(fast==fast.next) return true;
    //     while(fast!=null && fast.next!=null){
    //         if(fast==slow) return true;
    //         fast=fast.next.next;
            
    //         if(fast==slow) return true;
    //         slow=slow.next;
    //     }
    //     return false;

    // }
    // second attempt, shorter code due to updating slow ptr first, no worries dealing with null ptr exception
    public boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
    
        while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
          if (slow == fast)
            return true;
        }
    
        return false;
      }
    // first Attempt, correct, but code could be shorter, long due to updating fast ptr before slow
    // to avoid null ptr exception
    // @SuppressWarnings("null")
    // public boolean hasCycle(Node h) {
    //     if(h==null||h.next==null) return false;
    //     Node fast=h.next;
    //     Node slow=h;
    //     while(fast!=null||fast.next!=null){
    //         if(fast==slow) return true;
    //         if(fast.next!=null){
    //         fast=fast.next;
    //         } else break;
    //         if(fast==slow) return true;
    //          if(fast.next!=null){
    //         fast=fast.next;
    //         } else break;
            
    //         slow=slow.next;
    //     }
    //     return false;
    // }


      // third attempt just to experiment, got to know && is very imp in condn
    /**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// public class Solution {
//     public boolean hasCycle(ListNode h) {
//         if(h==null||h.next==null) return false;
//        ListNode fast=h.next;
//        ListNode slow=h;
//        //if(fast==fast.next) return true;
//         while(fast!=null && fast.next!=null){
//             if(fast==slow) return true;
//             fast=fast.next;
//             if(fast==slow) return true;
//             fast=fast.next;
//             if(fast==slow) return true;
//             slow=slow.next;
//         }
//         return false;

//     }
}
