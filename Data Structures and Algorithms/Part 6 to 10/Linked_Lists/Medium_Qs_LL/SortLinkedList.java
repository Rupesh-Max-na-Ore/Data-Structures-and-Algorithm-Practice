package Linked_Lists.Medium_Qs_LL;
// Q12
import Linked_Lists.Singly_Linked_List.LinkedList.Node;

public class SortLinkedList {
    // Fn to sort a LL using merge sort
    public Node sortLL(Node h) {
        if (h == null || h.next == null) return h;

        Node middle = getMiddle(h);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node l = sortLL(h);
        Node r = sortLL(nextOfMiddle);

        return merge2LLs(l, r);
    }

    // Fn to find the middle of the LL
    public Node getMiddle(Node h) {
        if (h == null) return h;
        
        Node S = h, F = h.next; //note the change
        while (F != null && F.next != null) {
            S = S.next;
            F = F.next.next;
        }
        return S;
    }

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

    // Fn to print the LL
    public void printLL(Node h) {
        Node curr = h;
        while (curr != null) {
            System.out.print(curr.value + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        SortLinkedList sortAndMergeLLs = new SortLinkedList();

        // Create first unsorted LL: 7 -> 3 -> 1 -> 5 -> null
        Node h1 = new Node(7);
        h1.next = new Node(3);
        h1.next.next = new Node(1);
        h1.next.next.next = new Node(5);

        // Create second unsorted LL: 8 -> 2 -> 6 -> 4 -> null
        Node h2 = new Node(8);
        h2.next = new Node(2);
        h2.next.next = new Node(6);
        h2.next.next.next = new Node(4);

        // Sort the LLs
        h1 = sortAndMergeLLs.sortLL(h1);
        h2 = sortAndMergeLLs.sortLL(h2);

        // Print the sorted LLs
        System.out.println("First sorted  LL:");
        sortAndMergeLLs.printLL(h1); // Expected output: 1 -> 3 -> 5 -> 7 -> null

        System.out.println("Second sorted  LL:");
        sortAndMergeLLs.printLL(h2); // Expected output: 2 -> 4 -> 6 -> 8 -> null

        // Merge the 2 sorted LLs
        Node mergedHead = sortAndMergeLLs.merge2LLs(h1, h2);

        // Print the merged LL
        System.out.println("Merged  LL:");
        sortAndMergeLLs.printLL(mergedHead); // Expected output: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null
    }
}


// // /*
// //  * Faster Soln In LC forum
// //  * 
// //  */
// Runtime: 2ms


// Java
// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode sortList(ListNode head) {
//         return sortList(head, null);
//     }

//     private ListNode sortList(ListNode start, ListNode end){
//         if(start == null || start.next == null || start == end)return start;
//         ListNode left = start, right = start, cur = start.next;
//         boolean sorted = true;
//         while(cur != null && cur != end){
//             ListNode tmp = cur.next;
//             if(cur.val < start.val){
//                 cur.next = left;
//                 left = cur;
//                 right.next = tmp;
//                 sorted = false;
//             }else{
//                 if(cur.val < right.val)sorted = false;
//                 right = cur;
//             }
//             cur = tmp;
//         }
//         if(sorted)return left;
//         left = sortList(left, start);
//         start.next = sortList(start.next, end);
//         return left;
//     }
// }

// //O(1) space soln in LC forum, using bottom up merge sort
// public class Solution {
//     public ListNode SortList(ListNode head) {
//         if (head == null) return null;
//         var n = 0;
//         for (var current = head; current != null; current = current.next) n += 1;
//         var dummy1 = new ListNode(-1);
//         dummy1.next = head;
//         var dummy2 = new ListNode(-1);
//         for (var m = 1; m < n; m *= 2) {
//             var prev1 = dummy1;
//             while (prev1.next != null) {

//                 // Grab up to the next m items into list1.
//                 var list1 = prev1.next;
//                 var prev2 = list1;
//                 for (var i = 0; i < m - 1 && prev2 != null; i++) prev2 = prev2.next;

//                 if (prev2 == null) break;

//                 // Grab up to the next m items into list2.
//                 var list2 = prev2.next;
//                 var prev3 = list2;
//                 for (var i = 0; i < m - 1 && prev3 != null; i++) prev3 = prev3.next;

//                 // Save the remaining items, if any.
//                 var list3 = prev3 != null ? prev3.next : null;

//                 // Terminate list1 and list2.
//                 prev2.next = null;
//                 if (prev3 != null) prev3.next = null;

//                 // Merge the two lists, terminating with remaining items.
//                 (prev1.next, prev1) = Merge(dummy2, list1, list2, list3);
//             }
//         }
//         return dummy1.next;
//     }
//     private (ListNode, ListNode) Merge(ListNode dummy, ListNode list1, ListNode list2, ListNode list3) {
//         var prev = dummy;
//         while (list1 != null || list2 != null) {
//             var first = false;
//             if (list1 == null) first = false;
//             else if (list2 == null) first = true;
//             else first = list1.val <= list2.val;
//             if (first) {
//                 prev.next = list1;
//                 list1 = list1.next;
//             }
//             else {
//                 prev.next = list2;
//                 list2 = list2.next;
//             }
//             prev = prev.next;
//         }
//         prev.next = list3;
//         return (dummy.next, prev);
//     }
// }
/*
 * Meeting the O(1) requirement

sladkey
26
288
Apr 04, 2019
Because of the O(1) requirement, you cannot use recursion or any collections. So supplementary arrays are out, priority queues are out, quicksort is out, heapsort is out, and even recursive merge sort is out.

So the trick to solving the problem is to realize that with log n passes over the list, you can do a bottom up merge sort with no supplementary storage such as a stack or recursion.

This particular algorithm is much easier to understand conceptually than it is to program because the linked-list structure means you need to keep the whole list connected for each of the passes. As a result, tracking previous nodes that need to be updated is messy and error-prone, but still just a simple matter of programming. But as far as understanding how the sort works, you can just imagine that you are sorting an array in-place and keep in mind that you must proceed from left to right in order to avoid costly random access.

How does bottom-up merge sort work? In the first pass we take adjacent pairs of items and "merge" them into a sequence of sorted pairs. In the next pass we take adjacent pairs of pairs (which are already sorted) and merge them into a sequence of sorted subsquences of length four. By doubling the length each iteration, we gradually go from sorted by twos, to sorted by fours, to sorted by eights, etc. until completely sorted. Since we are doubling with each pass, we do a total of log n passes.

The final complexity is coping with lists whose length are not a power of two. This creates two situations where either the first subsequence is too short or the first subsequence is full length but the second sequence is short. In the former case, nothing needs to be done because it was sorted in the prior iteration. In the latter case, we just merge two linked lists of unequal length.
 */

//  Insertion Sort
// Runtime: 467 ms
// Space: O(1)

// class Solution {
//     public ListNode sortList(ListNode head) {
//         ListNode cur = head;
//         ListNode temp = new ListNode(0);
//         ListNode prev = temp;
//         while(cur != null){
//             ListNode nxt = cur.next;
//             if(prev.val >= cur.val)
//                prev = temp;
//             while(prev.next != null && prev.next.val < cur.val)
//                 prev = prev.next;
//             cur.next = prev.next;
//             prev.next = cur;
//             cur = nxt;
//         }
//         return temp.next;
//     }
// }
// Sharing bottom-up true O(1) space

// al7bashkatov
// 12
// 131
// May 07, 2019
// class Solution {
//     public ListNode sortList(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
        
//         int len = getLength(head);
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
        
//         for (int step = 1; step < len; step <<= 1) {
//             ListNode l1Start = dummy.next;
//             ListNode tail = dummy;
//             ListNode right = null;
            
//             while (l1Start != null) {
//                 ListNode l1End = l1Start;
//                 int count = step;
                
//                 while (--count > 0 && l1End.next != null) {
//                     l1End = l1End.next;
//                 }
                
//                 ListNode l2Start = l1End.next;
//                 l1End.next = null;
                
//                 if (l2Start == null) {
//                     break;
//                 }
                
//                 ListNode l2End = l2Start;
//                 count = step;
                
//                 while (--count > 0 && l2End.next != null) {
//                     l2End = l2End.next;
//                 }
                
//                 right = l2End.next;
//                 l2End.next = null;
                
//                 ListNode sorted = merge(l1Start, l2Start, tail);
//                 tail = sorted;
//                 sorted.next = right;
//                 l1Start = right;
//             }
//         }
        
//         return dummy.next;
//     }
    
//     private ListNode merge(ListNode l1, ListNode l2, ListNode head) {
//         ListNode cur = head;
        
//         while (l1 != null && l2 != null) {
//             if (l1.val > l2.val) {
//                 cur.next = l2;
//                 cur = l2;
                
//                 l2 = l2.next;
//             } else {
//                 cur.next = l1;
//                 cur = l1;
//                 l1 = l1.next;
//             }
//         }
        
//         cur.next = l1 != null ? l1 : l2;
        
//         while (cur.next != null) {
//             cur = cur.next;
//         }
        
//         return cur;
//     }
    
//     private int getLength(ListNode list) {
//         int count = 0;
//         ListNode curr = list;
        
//         while (curr != null) {
//             count++;
//             curr = curr.next;
//         }
        
//         return count;
//     }
// }