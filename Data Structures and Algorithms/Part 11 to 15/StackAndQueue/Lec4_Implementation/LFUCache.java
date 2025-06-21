package StackAndQueue.Lec4_Implementation;
/*Q5 


Code
Accepted
Accepted
Code Sample
Code Sample
Testcase
Testcase
Test Result
460. LFU Cache
Solved
Hard
Topics
Companies
Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

Explanation
// cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
LFUCache lfu = new LFUCache(2);
lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lfu.get(1);      // return 1
                 // cache=[1,2], cnt(2)=1, cnt(1)=2
lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
lfu.get(2);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
lfu.get(1);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,4], cnt(4)=1, cnt(3)=3
lfu.get(4);      // return 4
                 // cache=[4,3], cnt(4)=2, cnt(3)=3
 

Constraints:

1 <= capacity <= 104
0 <= key <= 105
0 <= value <= 109
At most 2 * 105 calls will be made to get and put.
 

Seen this question in a real interview before?
1/5
Yes
No
Accepted
254.6K
Submissions
573K
Acceptance Rate
44.4%
 */
import java.util.HashMap;
import java.util.Map;

class LFUCache {
    // Refer to Notes for comments or the code at end
    int cap;
    int currSize;
    int minFreq;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> freqHmap;

    public LFUCache(int cap) {
        this.cap = cap;
        this.currSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqHmap = new HashMap<>();
    }

    public int get(int key) {
        DLLNode currNode = cache.get(key);
        if (currNode == null) {
            return -1;
        }
        updateNode(currNode);
        return currNode.val;
    }

    public void put(int key, int value) {
        if (cap == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            DLLNode currNode = cache.get(key);
            currNode.val = value;
            updateNode(currNode);
        }
        else {
            currSize++;
            if (currSize > cap) {
                DoubleLinkedList minFreqList = freqHmap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currSize--;
            }
            minFreq = 1;
            DLLNode newNode = new DLLNode(key, value);

            DoubleLinkedList currList = freqHmap.getOrDefault(1, new DoubleLinkedList());
            currList.addNode(newNode);
            freqHmap.put(1, currList);
            cache.put(key, newNode);
        }
    }

    public void updateNode(DLLNode currNode) {
        int currFreq = currNode.freq;
        DoubleLinkedList currList = freqHmap.get(currFreq);
        currList.removeNode(currNode);

        if (currFreq == minFreq && currList.listSize == 0) {
            minFreq++;
        }

        currNode.freq++;
        DoubleLinkedList newList = freqHmap.getOrDefault(currNode.freq, new DoubleLinkedList());
        newList.addNode(currNode);
        freqHmap.put(currNode.freq, newList);
    }

    class DLLNode {
        int key;
        int val;
        int freq;
        DLLNode prev;
        DLLNode next;

        public DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class DoubleLinkedList {
        int listSize;
        DLLNode head;
        DLLNode tail;
        public DoubleLinkedList() {
            this.listSize = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(DLLNode currNode) {
            DLLNode nextNode = head.next;
            currNode.next = nextNode;
            currNode.prev = head;
            head.next = currNode;
            nextNode.prev = currNode;
            listSize++;
        }

        public void removeNode(DLLNode currNode) {
            DLLNode prevNode = currNode.prev;
            DLLNode nextNode = currNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//nice posts below for different ways and visualization- 
//https://leetcode.com/problems/lfu-cache/solutions/94657/java-solutions-of-three-different-ways-priorityqueue-o-capacity-treemap-o-log-capacity-doublelinkedlist-o-1
//https://leetcode.com/problems/lfu-cache/solutions/443113/visualization-for-2-hashmap-1-doublelinkedlist-approach/

// //Reference code by Striver's YT
// class LFUCache {

//     final int capacity;
//     int curSize;
//     int minFrequency;
//     Map<Integer, DLLNode> cache;
//     Map<Integer, DoubleLinkedList> frequencyMap;

//     /*.*/
//     /*
//     * @param capacity: total capacity of LFU Cache
//     * @param curSize: current size of LFU cache
//     * @param minFrequency: frequency of the last linked list (the minimum frequency of entire LFU cache)
//     * @param cache: a hash map that has key to Node mapping, which used for storing all nodes by their keys
//     * @param frequencyMap: a hash map that has key to linked list mapping, which used for storing all
//     * double linked list by their frequencies
//     * */
//     public LFUCache(int capacity) {
//         this.capacity = capacity;
//         this.curSize = 0;
//         this.minFrequency = 0;

//         this.cache = new HashMap<>();
//         this.frequencyMap = new HashMap<>();
//     }

//     /** get node value by key, and then update node frequency as well as relocate that node **/
//     public int get(int key) {
//         DLLNode curNode = cache.get(key);
//         if (curNode == null) {
//             return -1;
//         }
//         updateNode(curNode);
//         return curNode.val;
//     }

//     /**
//      * add new node into LFU cache, as well as double linked list
//      * condition 1: if LFU cache has input key, update node value and node position in list
//      * condition 2: if LFU cache does NOT have input key
//      *  - sub condition 1: if LFU cache does NOT have enough space, remove the Least Recent Used node
//      *  in minimum frequency list, then add new node
//      *  - sub condition 2: if LFU cache has enough space, add new node directly
//      * **/
//     public void put(int key, int value) {
//         // corner case: check cache capacity initialization
//         if (capacity == 0) {
//             return;
//         }

//         if (cache.containsKey(key)) {
//             DLLNode curNode = cache.get(key);
//             curNode.val = value;
//             updateNode(curNode);
//         }
//         else {
//             curSize++;
//             if (curSize > capacity) {
//                 // get minimum frequency list
//                 DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
//                 cache.remove(minFreqList.tail.prev.key);
//                 minFreqList.removeNode(minFreqList.tail.prev);
//                 curSize--;
//             }
//             // reset min frequency to 1 because of adding new node
//             minFrequency = 1;
//             DLLNode newNode = new DLLNode(key, value);

//             // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
//             DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
//             curList.addNode(newNode);
//             frequencyMap.put(1, curList);
//             cache.put(key, newNode);
//         }
//     }

//     public void updateNode(DLLNode curNode) {
//         int curFreq = curNode.frequency;
//         DoubleLinkedList curList = frequencyMap.get(curFreq);
//         curList.removeNode(curNode);

//         // if current list the the last list which has lowest frequency and current node is the only node in that list
//         // we need to remove the entire list and then increase min frequency value by 1
//         if (curFreq == minFrequency && curList.listSize == 0) {
//             minFrequency++;
//         }

//         curNode.frequency++;
//         // add current node to another list has current frequency + 1,
//         // if we do not have the list with this frequency, initialize it
//         DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
//         newList.addNode(curNode);
//         frequencyMap.put(curNode.frequency, newList);
//     }

//     /*
//     * @param key: node key
//     * @param val: node value
//     * @param frequency: frequency count of current node
//     * (all nodes connected in same double linked list has same frequency)
//     * @param prev: previous pointer of current node
//     * @param next: next pointer of current node
//     * */
//     class DLLNode {
//         int key;
//         int val;
//         int frequency;
//         DLLNode prev;
//         DLLNode next;

//         public DLLNode(int key, int val) {
//             this.key = key;
//             this.val = val;
//             this.frequency = 1;
//         }
//     }

//     /*
//     * @param listSize: current size of double linked list
//     * @param head: head node of double linked list
//     * @param tail: tail node of double linked list
//     * */
//     class DoubleLinkedList {
//         int listSize;
//         DLLNode head;
//         DLLNode tail;
//         public DoubleLinkedList() {
//             this.listSize = 0;
//             this.head = new DLLNode(0, 0);
//             this.tail = new DLLNode(0, 0);
//             head.next = tail;
//             tail.prev = head;
//         }

//         /** add new node into head of list and increase list size by 1 **/
//         public void addNode(DLLNode curNode) {
//             DLLNode nextNode = head.next;
//             curNode.next = nextNode;
//             curNode.prev = head;
//             head.next = curNode;
//             nextNode.prev = curNode;
//             listSize++;
//         }

//         /** remove input node and decrease list size by 1**/
//         public void removeNode(DLLNode curNode) {
//             DLLNode prevNode = curNode.prev;
//             DLLNode nextNode = curNode.next;
//             prevNode.next = nextNode;
//             nextNode.prev = prevNode;
//             listSize--;
//         }

//     }
// }

// /**
//  * Your LFUCache object will be instantiated and called as such:
//  * LFUCache obj = new LFUCache(capacity);
//  * int param_1 = obj.get(key);
//  * obj.put(key,value);
//  */