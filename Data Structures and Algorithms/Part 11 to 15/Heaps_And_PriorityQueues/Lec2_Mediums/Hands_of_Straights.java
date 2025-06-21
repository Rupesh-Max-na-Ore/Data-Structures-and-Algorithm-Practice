package Heaps_And_PriorityQueues.Lec2_Mediums;

import java.util.PriorityQueue;

public class Hands_of_Straights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int card : hand) minHeap.add(card);
        while(minHeap.size() != 0) {
            int MinStart = minHeap.peek();// top elem always min. in minHeap
            for(int j = 0; j < groupSize; j++){
                //remove fromm minHeap if present
                if(minHeap.remove(MinStart + j)) continue;
                else return false; //else can't form consecutive grp, so false
            }
        }
        return true;
    }
}
// //Treemap soln, lc forum
// class Solution {
//     // O(nlogn) time where n == hand.length, because in the worst case all n elements are distinct so inserting n elements into a TreeMap costs O(nlogn) time, and it costs O(nlogn) time to remove all elements again while creating the groups.
// // O(n) space because in the worst case all n elements are distinct so we have n entries in the TreeMap.
// public boolean isNStraightHand(int[] hand, int W) {
//     if (hand == null || hand.length == 0) return true;
//     if (hand.length % W != 0) return false;
//     TreeMap<Integer, Integer> map = new TreeMap<>();
//     for (int curr : hand) map.put(curr, map.getOrDefault(curr, 0) + 1);     // O(nlogn) time.
//     while (map.size() > 0) {
//         // Try creating the next group of W consecutive cards.
//         int start = map.firstKey();                 // O(logn) time.
//         for (int i = start; i < start + W; ++i) {
//             if (!map.containsKey(i)) return false;  // O(logn) time.
//             map.put(i, map.get(i) - 1);             // O(logn) time.
//             if (map.get(i) == 0) map.remove(i);     // O(logn) time.
//         }
//     }
//     return true;
// }
// }
//

// //Faster LC soln., no hashMap, skipping over elems using helper fn.
// class Solution {
//     public boolean findsucessors(int[] hand, int groupSize, int i, int n) {
//         int f = hand[i] + 1;
//         hand[i] = -1;
//         int count = 1;
//         i += 1;
//         while (i < n && count < groupSize) {
//             if (hand[i] == f) {
//                 f = hand[i] + 1;
//                 hand[i] = -1;
//                 count++;
//             }
//             i++;
//         }
//         if (count != groupSize)
//             return false;
//         else
//             return true;
//     }

//     public boolean isNStraightHand(int[] hand, int groupSize) {
//         int n = hand.length;
//         if (n % groupSize != 0)
//             return false;
//         Arrays.sort(hand);
//         int i = 0;
//         for (; i < n; i++) {
//             if (hand[i] >= 0) {
//                 if (!findsucessors(hand, groupSize, i, n))
//                     return false;
//             }
//         }
//         return true;
//     }
// }

// //Lc forum fastest soln, use buckets
//https://leetcode.com/problems/hand-of-straights/solutions/153519/copy-from-the-quickest-java-solutions-with-explanation-10-ms-beats-100/
// public boolean isNStraightHand(int[] hands, int W) {
//     if (W == 1) return true;
//     if (hands.length % W != 0) return false;

//     int H = hands.length / W;
//     int[][] buckets = new int[W][H];
//     int[] bucketSize = new int[W];

//     for (int h : hands) {
//         int indexInBucket = h % W, bucketId = bucketSize[indexInBucket]++;
//         if (bucketId >= H) return false;
//         buckets[indexInBucket][bucketId] = h;
//     }
            
//     for (int i = 0; i < W; i++) Arrays.sort(buckets[i]);
    
//     for (int i = 0; i < H; i++)
//         for (int j = 1; j < W; j++)
//             //consider case 3,1,2 and 3,4,2
//             if (buckets[j][i] != buckets[j - 1][i] + 1 && buckets[j - 1][i] - buckets[j][i] != W - 1) return false;

//     return true;
// }