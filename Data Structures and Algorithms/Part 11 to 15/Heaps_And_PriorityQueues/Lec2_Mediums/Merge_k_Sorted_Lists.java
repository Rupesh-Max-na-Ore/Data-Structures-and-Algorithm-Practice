package Heaps_And_PriorityQueues.Lec2_Mediums;

import java.util.PriorityQueue;

/*Q4 23. Merge k Sorted Lists
Hard
Topics
Companies
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
2.1M
Submissions
3.8M
Acceptance Rate
53.4% */
public class Merge_k_Sorted_Lists {
    // this is PQ min-heap way, check SLL mediums for Divide and conquer approach
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // Below is not my code, this one had nice comments, so pasted it for learning and revision
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case: If the input array is empty, return null.
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Create a priority queue (min-heap) that orders ListNodes by their value.
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Add the head node of each linked list to the min-heap.
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        // Create a dummy head for the result linked list.
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        // While the heap is not empty, extract the smallest node and add it to the result list.
        while (!minHeap.isEmpty()) {
            ListNode smallestNode = minHeap.poll(); // Extract the smallest node.
            current.next = smallestNode; // Append it to the result list.
            current = current.next; // Move to the next position in the result list.

            // If the extracted node has a next node, add it to the heap.
            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }

        // Return the merged sorted linked list, which starts from dummyHead.next.
        return dummyHead.next;
    }
}
/*//A divide and conquer soln found on LCF
public static ListNode mergeKLists(ListNode[] lists){
    return partion(lists,0,lists.length-1);
}

public static ListNode partion(ListNode[] lists,int s,int e){
    if(s==e)  return lists[s];
    if(s<e){
        int q=(s+e)/2;
        ListNode l1=partion(lists,s,q);
        ListNode l2=partion(lists,q+1,e);
        return merge(l1,l2);
    }else
        return null;
}

//This function is from Merge Two Sorted Lists.
public static ListNode merge(ListNode l1,ListNode l2){
    if(l1==null) return l2;
    if(l2==null) return l1;
    if(l1.val<l2.val){
        l1.next=merge(l1.next,l2);
        return l1;
    }else{
        l2.next=merge(l1,l2.next);
        return l2;
    }
}
 */