package Linked_Lists.Hard_Qs_LL;

import Linked_Lists.Singly_Linked_List.LinkedList.Node;
/*Q2 Rotate a Linked List
In this article, we will solve the problem: "Rotate a Linked List"

Problem Statement: Given the head of a linked list, rotate the list to the right by k places.

Examples:

Example 1:
Input:
	head = [1,2,3,4,5] 
	k = 2
Output:
 head = [4,5,1,2,3]
Explanation:
 We have to rotate the list to the right twice.


Example 2:
Input:
	head = [1,2,3]
	k = 4
Output:
head = [3,1,2]
Explanation:

 */
public class RotateRightSLL {
    //@SuppressWarnings("null")
    public Node rotateRight(Node h, int k) {
        if(h==null||h.next==null||k==0) return h;
        //Calc len of LL, find tail too while at it
        int n=1;
        Node endOfLL=h;
        while(endOfLL.next!=null) {
            n++;
            endOfLL=endOfLL.next;
        }
        k=k%n;
        if(k==0) return h;
        // Find kth node from end, for new head
        int goTill=n-k;
        int gone=1; Node t=h;
        while (gone<goTill){
            gone++;
            t=t.next;
        }
        Node newHead= t.next; //n-k+1 th node is new head
        t.next=null; //disconnect k-1th node from end
        endOfLL.next=h; //coneect  to head
        return newHead;

    }

}
