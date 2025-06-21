package Linked_Lists.Medium_DLL_Qs;

import Linked_Lists.Doubly_Linked_List.DoublyLinkedList.Node;
//Q1
public class DeleteAllOccursOfK {
    static Node deleteAllOccurOfX(Node h, int x) {
        if(h==null) return h;
        Node t=h;
        while(t!=null){
            if(t.value==x){
                if(t==h) h=h.next;
                Node pt=t.previous;
                Node ft=t.next;
                if(pt!=null) pt.next=ft;
                if(ft!=null) ft.previous=pt;

                t=ft;
            } else t=t.next;

        } return h;
    }
}
