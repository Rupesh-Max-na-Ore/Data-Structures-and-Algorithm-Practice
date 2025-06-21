/*Q1 25. Reverse Nodes in k-Group
Solved
Hard
Topics
Companies
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 

Follow-up: Can you solve the problem in O(1) extra memory space?

Seen this question in a real interview before?
1/5
Yes
No
Accepted
937.9K
Submissions
1.6M
Acceptance Rate
59.0% */
package Linked_Lists.Hard_Qs_LL;

import Linked_Lists.Singly_Linked_List.LinkedList.Node;

public class ReverseKsizeGrps {
    public Node reverseKGroup(Node h, int k) {
        if(h==null||h.next==null||k==1) return h;

        Node t=h; Node kNode=null; Node ptNode=null; Node akN=h;
        while(t!=null){
            // find kth node, put in kNode
            int cnt=k; kNode=t;
            while(kNode!=null && cnt>1){
                kNode=kNode.next;
                cnt--;
            }
            if(kNode==null){
                if(ptNode!=null) ptNode.next=t;
                break;
            }
            // store in akn next of that, for next t
            akN=kNode.next;
            System.out.println("akn now: ");
            printList(akN);
            kNode.next=null;
            System.out.println("t start: ");
            printList(t);

            reverseSLL(t);
            System.out.println("t rev now: ");

            printList(t);
            if(t==h){
                System.out.println("kNode h: ");

                printList(kNode);
                h=kNode;
            } else{
                System.out.println("kNode pt: ");
                printList(kNode);
                ptNode.next=kNode;
            }
            ptNode=t;
            //akN=t; //by mistake
            t=akN;
        } return h;
    }
    public Node reverseSLL(Node h){
        if(h==null||h.next==null) return h;

        Node Pt=null;
        Node t=h;
        Node Ft=h.next;

        while(t!=null){
            t.next=Pt;
            Pt=t;
            t=Ft;
            if(Ft==null) h=t;
            else Ft = Ft.next;
        }
        System.out.println("new h in rev fn: ");

        printList(Pt);
        return Pt;
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
    // first attempt, some wrongs
    // public Node reverseKGroup(Node h, int k) {
    //     if(h==null||h.next==null||k==1) return h;

    //     Node t=h; Node kNode=null; Node ptNode=null; Node akN=h;
    //     while(kNode!=null){
    //         // find kth node, put in kNode
    //         int cnt=k; kNode=t;
    //         while(kNode!=null && cnt>1){
    //             kNode=kNode.next;
    //             cnt--;
    //         }
    //         if(kNode==null){
    //             if(ptNode!=null) ptNode.next=t;
    //         }
    //         // store in akn next of that, for next t
    //         akN=kNode.next;
    //         if(t==h){
    //             //h=kNode;
    //             kNode.next=null;
    //             ptNode=t;
    //             t=reverseSLL(t);
    //             h=t;
    //         } else{
    //             kNode.next=null;
    //             //ptNode
    //             ptNode=t;
    //             t=reverseSLL(t);
    //         }
    //         //akN=t;
    //         t=akN;
    //     } return h;
    // }
    // public Node reverseSLL(Node h){
    //     if(h==null||h.next==null) return h;

    //     Node Pt=null;
    //     Node t=h;
    //     Node Ft=h.next;

    //     while(t!=null){
    //         t.next=Pt;
    //         Pt=t;
    //         t=Ft;
    //         if(Ft==null) h=t;
    //         else Ft = Ft.next;
    //     }
    //     return Pt;
    // }
}
/*
 * package Linked_Lists.Hard_Qs_LL;

import Linked_Lists.Singly_Linked_List.LinkedList.Node;
// Another way to write, more readable, use of dummy node
public class ReverseKsizeGrps {
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
}

 */

 