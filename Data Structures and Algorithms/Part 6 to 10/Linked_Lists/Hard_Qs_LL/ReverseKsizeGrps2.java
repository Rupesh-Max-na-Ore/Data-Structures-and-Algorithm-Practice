package Linked_Lists.Hard_Qs_LL;

import Linked_Lists.Singly_Linked_List.LinkedList.Node;

public class ReverseKsizeGrps2 {
    public Node reverseKGroup(Node h, int k) {
        if (h == null || h.next == null || k == 1) return h;

        Node dummy = new Node(0);
        dummy.next = h;
        Node prevGroupEnd = dummy;

        while (true) {
            Node groupStart = prevGroupEnd.next;
            Node kthNode = groupStart;

            // Find the k-th node
            for (int i = 1; i < k && kthNode != null; i++) {
                kthNode = kthNode.next;
            }

            if (kthNode == null) break; // Not enough nodes to reverse

            Node nextGroupStart = kthNode.next;
            kthNode.next = null;

            // Reverse the group
            Node newGroupStart = reverseSLL(groupStart);

            // Connect the previous group to the newly reversed group
            prevGroupEnd.next = newGroupStart;
            groupStart.next = nextGroupStart;

            // Move prevGroupEnd to the end of the reversed group
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    public Node reverseSLL(Node h) {
        Node prev = null;
        Node curr = h;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Helper function to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        printList(head);

        ReverseKsizeGrps solution = new ReverseKsizeGrps();
        int k = 2; // Set the value of k

        Node newHead = solution.reverseKGroup(head, k);

        System.out.println("Reversed List in k-groups:");
        printList(newHead);
    }
}
