package Linked_Lists.Medium_Qs_LL;

import Linked_Lists.Singly_Linked_List.LinkedList.Node;
// Q13
public class Yintersection {
    public Node getIntersectionNode(Node h1, Node h2) {
        if(h1==null||h2==null) return null;
        Node t1=h1;
        Node t2=h2;
        while(t2!=t1){
            t2=t2.next;
            t1=t1.next;
            if(t1==t2) return t1;// ort t2
            else if(t1==null) t1=h2;
            else if(t2==null) t2=h1;
        } return t1;
    }
}
