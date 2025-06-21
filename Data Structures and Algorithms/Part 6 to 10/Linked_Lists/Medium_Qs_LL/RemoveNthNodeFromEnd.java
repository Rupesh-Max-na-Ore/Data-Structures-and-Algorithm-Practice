package Linked_Lists.Medium_Qs_LL;

import Linked_Lists.Singly_Linked_List.LinkedList.Node;
/*Q8 */
public class RemoveNthNodeFromEnd {
    public Node removeNthFromEnd(Node h, int n) {
        if(h==null) return h;
        Node L=h; Node R=h;
        int i=0;
        while(i<=n){
            if(R.next==null) return h.next;

            R=R.next;
            i++;
        }
        while(R!=null && R.next!=null){
            L=L.next;
            R=R.next;
        }
        L.next=L.next.next;
        return h;

    }

}
