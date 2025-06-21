package Linked_Lists.Medium_Qs_LL;
//Q3
import Linked_Lists.Singly_Linked_List.LinkedList.Node;

public class RecursiveReverseSLL {
    public static Node reverseSLL(Node h){
        if(h==null||h.next==null) return h; // true for only last node, pass to recursive calls, make newHead in First call

        Node newHead = reverseSLL(h.next);
        
        h.next.next = h; // change link
        h.next=null; // changes for all nodes except first node, as we want first node next to be null, make it end node for reverse 
        return newHead;
    }
}

// // LC submit
// class Solution {
//     public ListNode reverseList(ListNode h) {
//         if(h==null||h.next==null) return h;

//         ListNode newHead = reverseList(h.next);
        
//         h.next.next = h;
//         h.next=null;

//         return newHead;
//     }
// }