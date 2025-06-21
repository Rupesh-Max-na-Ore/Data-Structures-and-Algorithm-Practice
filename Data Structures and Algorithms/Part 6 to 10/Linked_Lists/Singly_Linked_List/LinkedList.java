package Linked_Lists.Singly_Linked_List;

public class LinkedList {
    Node head;

    public static class Node {
        public int value;
        public Node next;

        public Node(int d) {
            value = d;
            next = null;
        }

        Node(){
            value=0;
            next = null;
        }
    }

    static void print(Node t) {
        while (t != null) {
            System.out.print(t.value + "->");
            t = t.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        linkedList.head.next = second;
        second.next = third;

        System.out.print("LinkedList: ");
        print(linkedList.head);
    }
}
