package Linked_Lists.Medium_DLL_Qs;

import Linked_Lists.Doubly_Linked_List.DoublyLinkedList.Node;
// Q3
public class DeleteDuplis {
    Node removeDuplicates(Node h){
        if(h==null||h.next==null) return h;
        Node l=h;
        while(l!=null && l.next!=null){
            Node r = l.next;
            while(r!=null && r.value==l.value) r=r.next;
            l.next=r;
            if(r!=null) r.previous=l;

            l=r;
            // or l=l.next;// any one for l to go to next unique elem
        } return h;  
    }

}
