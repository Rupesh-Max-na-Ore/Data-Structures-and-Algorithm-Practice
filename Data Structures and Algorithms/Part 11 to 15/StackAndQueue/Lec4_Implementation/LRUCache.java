package StackAndQueue.Lec4_Implementation;
/*Q4  146. LRU Cache
Solved
Medium
Topics
Companies
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 

Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.7M
Submissions
3.9M
Acceptance Rate
42.7%*/

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    // Create a DLL(doubly linked list)
    //Create 2 dummy nodes to easily track head and tail and do insert/delete from front/rear
    Node head = new Node(0, 0); 
    Node tail = new Node(0, 0);
    // Create a hmap to store (key,node address) pair
    Map<Integer, Node> hmap = new HashMap<>();

    int capacity;

    public LRUCache(int capacity) {
        // Ini. the capacity of the cache
        this.capacity = capacity;
        // Link the head and tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // Check if the key exists in the hmap
        if (hmap.containsKey(key)) {
            Node node = hmap.get(key);
            // Remove the node from its current position
            remove(node);
            // Insert the node at the head (most recently used)
            insert(node);
            return node.val;
        } else {
            return -1; // Key does not exist
        }
    }

    public void put(int key, int val) {
        // If the key already exists, remove the old node
        if (hmap.containsKey(key)) {
            remove(hmap.get(key));
        }
        // If the cache is full, remove the least recently used node
        if (hmap.size() == capacity) {
            remove(tail.prev);
        }
        // Insert the new node at the head (most recently used)
        insert(new Node(key, val));
    }

    private void remove(Node node) {
        // Remove the node from the hmap
        hmap.remove(node.key);
        // Unlink the node from the DLL by skipping over it
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        // Add the node to the hmap
        hmap.put(node.key, node);
        // Link the node right after the head
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    // Define the Node class for the DLL
    class Node {
        Node prev, next;
        int key, val;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}
// //https://leetcode.com/problems/lru-cache/solutions/45939/laziest-implementation-java-s-linkedhashmap-takes-care-of-everything/
// //another shorter soln.
// class LRUCache {
//     private LinkedHashMap<Integer, Integer> map;
//     private int SIZE;
//     public LRUCache(int capacity) {
//         map = new LinkedHashMap<>();
//         SIZE = capacity;
//     }
    
//     public int get(int key) {
//         if(map.containsKey(key)) {
//             int value = map.remove(key);
//             map.put(key, value);
//             return value;
//         }
//         return -1;
//     }
    
//     public void put(int key, int value) {
//         if(map.containsKey(key)) {
//             map.remove(key);
//         }else if(map.size() + 1 > SIZE) {
//             map.remove(map.keySet().iterator().next());
//         }
//         map.put(key, value);
//     }
//     }

//https://leetcode.com/problems/lru-cache/solutions/801375/java-o-1-solution-clean-and-detailed-explanation/
//https://android.googlesource.com/platform/frameworks/support.git/+/795b97d901e1793dac5c3e67d43c96a758fec388/v4/java/android/support/v4/util/LruCache.java
