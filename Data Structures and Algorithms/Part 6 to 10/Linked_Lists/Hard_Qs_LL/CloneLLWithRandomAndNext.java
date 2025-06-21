package Linked_Lists.Hard_Qs_LL;
/*Q4 Clone Linked List with Random and Next Pointer

Problem Statement: Given a linked list where every node in the linked list contains two pointers:

‘next’ which points to the next node in the list.
‘random’ which points to a random node in the list or ‘null’.
Create a ‘deep copy’ of the given linked list and return it.

138. Copy List with Random Pointer
Medium
Topics
Companies
Hint
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

 

Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
 

Constraints:

0 <= n <= 1000
-104 <= Node.val <= 104
Node.random is null or is pointing to some node in the linked list.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.3M
Submissions
2.2M
Acceptance Rate
56.5%
Explanation:  A deep copy of the linked list has to be created while maintaining all ‘next’ and ‘random’ pointers to the appropriate new nodes. Additional memory allocation is done while creating a duplicate set of nodes and managing their pointer relationships. */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CloneLLWithRandomAndNext {
    public Node copyRandomList(Node h) {
        if(h==null) return null;
        insertCopyNodes(h);
        connectRandoms(h);
        return DeepCopier(h);
    }

    private Node DeepCopier(Node h) {
        //to separate copy LL and OG LL
        Node dmyNode=new Node(-1);//note LL of copy nodes
        Node z=dmyNode;//ptr to collect all copy nodes
        Node t=h;
        while(t!=null){
            Node copy=t.next;
            z.next=copy;//collect copy node to dummy
            z=z.next;//increment z for next collection
            t.next=t.next.next;//connect curent og node to nest og node

            //keep traversing og nodes
            t=t.next;
        } return dmyNode.next;
    }

    private void connectRandoms(Node h) {
        Node t=h;
        while(t!=null){
            //retreieve copy
            Node copy=t.next;
            //copy random point to the node's copy that og node's random is pointing to
            if(t.random!= null) copy.random=t.random.next; 
            //t.random.next== the node's copy that og node's random is pointing to
            else copy.random=null;
            //keep traversing to og nodes
            t=t.next.next;//==copy.next;
        }
    }

    private void insertCopyNodes(Node h) {
        Node t=h;
        while(t!=null){
            //create new node
            Node newCopy=new Node(t.val);
            //connect copy's next to OG's next
            newCopy.next=t.next;
            //connect og's next to copy
            t.next=newCopy;
            //keep traversing
            t=t.next.next; //== newCopy.next;
        }
    }
    
}
