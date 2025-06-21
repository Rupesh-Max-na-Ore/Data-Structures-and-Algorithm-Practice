package Linked_Lists.Hard_Qs_LL;
/*Q3 Flattening a Linked List
MediumAccuracy: 51.53%Submissions: 142K+Points: 4
Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 

Note: The flattened list will be printed using the bottom pointer instead of the next pointer.
For more clarity have a look at the printList() function in the driver code.

 

Example 1:

Input:
5 -> 10 -> 19 -> 28
|     |     |     | 
7     20    22   35
|           |     | 
8          50    40
|                 | 
30               45
Output:  5-> 7-> 8- > 10 -> 19-> 20->
22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation:
The resultant linked lists has every 
node in a single level.
(Note: | represents the bottom pointer.)
 

Example 2:

Input:
5 -> 10 -> 19 -> 28
|          |                
7          22   
|          |                 
8          50 
|                           
30              
Output: 5->7->8->10->19->22->28->30->50
Explanation:
The resultant linked lists has every
node in a single level.

(Note: | represents the bottom pointer.)
 

Your Task:
You do not need to read input or print anything. Complete the function flatten() that takes the head of the linked list as input parameter and returns the head of flattened link list.

Expected Time Complexity: O(N*N*M)
Expected Auxiliary Space: O(N)

Constraints:
0 <= N <= 50
1 <= Mi <= 20
1 <= Element of linked list <= 103 */
//Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}

/*  Function which returns the  root of 
    the flattened linked list. */
public class FlatteningLLs {
    Node flatten(Node h)
    {
        if(h==null||h.next==null) return h;
        Node mergeW= flatten(h.next);

        return VerticalMerge(h,mergeW);
    }

    private Node VerticalMerge(Node l1, Node l2) {
        Node dn = new Node(-1);
        Node ml = dn;
        while(l1!=null && l2!=null){
            if(l1.data<l2.data){
                ml.bottom=l1; //link correct node to merged list's next position 
                ml=l1; //== ml=ml.bottom // update fpr next correct placing during next iteration
                l1=l1.bottom; // same reason, for next comparision
            } else{
                ml.bottom=l2;
                ml=l2;
                l2=l2.bottom;
            }
            ml.next=null; // always, leave noting connected to next, cuz forming vertical LL
// above line is not required for most nodes, but the head, cuz each node.next except head.next is already null
        }
        if(l1!=null) ml.bottom=l1;
        if(l2!=null) ml.bottom=l2;
        return dn.bottom;
    }

}
