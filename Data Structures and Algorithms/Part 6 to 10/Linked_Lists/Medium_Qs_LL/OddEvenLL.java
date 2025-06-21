package Linked_Lists.Medium_Qs_LL;

import Linked_Lists.Singly_Linked_List.LinkedList.Node;

/*q7
 * 
328. Odd Even Linked List
Medium
Topics
Companies
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 

Constraints:

The number of nodes in the linked list is in the range [0, 104].
-106 <= Node.val <= 106
Seen this question in a real interview before?
1/5
Yes
No
Accepted
932.5K
Submissions
1.5M
Acceptance Rate
61.4%
Topics
Companies
Similar Questions
Discussion (115)
 */
public class OddEvenLL {
    public Node oddEvenList(Node h) {
        if(h==null||h.next==null) return h;
        Node ev=h.next;
        Node od=h;
        Node evStart=ev;
        while(ev!=null&&ev.next!=null){
            od.next=od.next.next;
            ev.next=ev.next.next;

            od=od.next;
            ev=ev.next;
        } od.next=evStart;

        return h;

    }
}
