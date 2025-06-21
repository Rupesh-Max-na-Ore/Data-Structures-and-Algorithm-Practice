package Linked_Lists.Singly_Linked_List;
//Q5
import Linked_Lists.Singly_Linked_List.LinkedList.Node;

public class Search {
    //Fn that tells if a no. is present in SLL
    static boolean searchKey(Node head, int key) {
        if(head==null) return false;
        Node travel = head;
        while(travel != null) {
            if(travel.value==key) return true;
            travel=travel.next;
        }
        return false;
    }

    //Fn that returns ptr to node if the int is present in SLL
    public static Node search(Node h, int x){
        if(h==null) return null;
        Node travel = h;
        while(travel != null) {
            if(travel.value==x) return travel;
            travel=travel.next;
        }
        return null;
    }

    public static void main(String[] args) {
        // Test the search functions
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node(1);
        linkedList.head.next = new Node(2);
        linkedList.head.next.next = new Node(3);
        linkedList.head.next.next.next = new Node(4);

        System.out.println("Is 3 present? " + searchKey(linkedList.head, 3)); // Expected output: true
        System.out.println("Is 5 present? " + searchKey(linkedList.head, 5)); // Expected output: false

        Node resultNode = search(linkedList.head, 3);
        if (resultNode != null) {
            System.out.println("Node with value 3 found: " + resultNode.value); // Expected output: 3
        } else {
            System.out.println("Node with value 3 not found");
        }

        resultNode = search(linkedList.head, 5);
        if (resultNode != null) {
            System.out.println("Node with value 5 found: " + resultNode.value);
        } else {
            System.out.println("Node with value 5 not found"); // Expected output: Node with value 5 not found
        }
    }
}
