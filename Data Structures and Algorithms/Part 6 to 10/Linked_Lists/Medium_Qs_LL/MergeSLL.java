package Linked_Lists.Medium_Qs_LL;

import Linked_Lists.Singly_Linked_List.LinkedList.Node;
//q10 Recursive
public class MergeSLL {
    // Fn to merge 2 sorted LLs
    public Node merge2LLs(Node h1, Node h2) {
        // Dummy node to help with the merge process
        Node dummy = new Node(0);
        Node curr = dummy;

        // While both LLs are not empty, compare the values
        while (h1 != null && h2 != null) {
            if (h1.value <= h2.value) {
                curr.next = h1;
                h1 = h1.next;
            } else {
                curr.next = h2;
                h2 = h2.next;
            }
            curr = curr.next;
        }

        // If one of the LLs is not empty, append it to the result
        if (h1 != null) {
            curr.next = h1;
        } else {
            curr.next = h2;
        }

        return dummy.next; // The merged LL starts from dummy.next
    }
}
