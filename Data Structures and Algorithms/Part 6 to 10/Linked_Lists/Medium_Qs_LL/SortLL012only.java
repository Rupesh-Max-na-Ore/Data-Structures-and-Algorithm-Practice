package Linked_Lists.Medium_Qs_LL;

import Linked_Lists.Singly_Linked_List.LinkedList.Node;
/*Q12 
Given a linked list of 0s, 1s and 2s, sort it.
EasyAccuracy: 60.75%Submissions: 169K+Points: 2

Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

Example 1:

Input:
N = 8
value[] = {1,2,2,1,2,0,2,2}
Output: 0 1 1 2 2 2 2 2
Explanation: All the 0s are segregated
to the left end of the linked list,
2s to the right end of the list, and
1s in between.
Example 2:

Input:
N = 4
value[] = {2,2,0,1}
Output: 0 1 2 2
Explanation: After arranging all the
0s,1s and 2s in the given format,
the output will be 0 1 2 2.
Your Task:
The task is to complete the function segregate() which segregates the nodes in the linked list as asked in the problem statement and returns the head of the modified linked list. The printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 106 */
public class SortLL012only {
    static Node segregate(Node h) {
        if(h==null||h.next==null) return h;
        // Dummy Nodes
        Node zH = new Node(-1);
        Node oH = new Node(-1);
        Node tH = new Node(-1);
        // Ptr to Dummy Nodes for Linking next of LL in sorted waY
        Node z = zH;
        Node o = oH;
        Node t = tH;
        Node travel=h;
        while(travel!=null){
            int elem=travel.value;
            // Linkup as per curr node value
            switch (elem) {
                case 0:
                    z.next=travel;
                    z=travel;
                    break;
                case 1:
                    o.next=travel;
                    o=travel;
                    break;
                case 2:
                    t.next=travel;
                    t=travel;
                    break;
                default:
                    break;
            } 
            travel=travel.next; // keep travesing
        }
        // COnnect up all 3 list parts
        t.next=null;
        o.next=tH.next;
        z.next=oH.next;

        // return the new head, zero Dummy's next
        return zH.next;

    }
}
