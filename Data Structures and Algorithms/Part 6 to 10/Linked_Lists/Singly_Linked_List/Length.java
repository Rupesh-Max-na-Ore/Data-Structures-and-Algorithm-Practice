package Linked_Lists.Singly_Linked_List;

import Linked_Lists.Singly_Linked_List.LinkedList.Node;
// Q4
public class Length {
    // Fn to find no. of nodes in a SLL
    public static int length(Node h){
        if(h==null) return 0;
        if(h.next==null) return 1;
        Node travel = h;
        int cnt=1;
        while(travel.next != null){
            travel=travel.next;
            cnt++;
        }
        return cnt;
    }
    // // Another way to write
    // public static int length(Node h) {
    //     int count = 0;
    //     Node travel = h;
    //     while (travel != null) {
    //         count++;
    //         travel = travel.next;
    //     }
    //     return count;
    // }
    public static void main(String[] args) {
        // Test the length function
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node(1);
        linkedList.head.next = new Node(2);
        linkedList.head.next.next = new Node(3);
        linkedList.head.next.next.next = new Node(4);

        System.out.println("Length of the linked list: " + Length.length(linkedList.head)); // Expected output: 4
    }
}
