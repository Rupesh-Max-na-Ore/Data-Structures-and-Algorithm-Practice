package Heaps_And_PriorityQueues.Lec2_Mediums;
/*Q3 Merge k Sorted Arrays
Difficulty: MediumAccuracy: 67.25%Submissions: 90K+Points: 4
Given k sorted arrays arranged in the form of a matrix of size k * k. The task is to merge them into one sorted array. Return the merged sorted array ( as a pointer to the merged sorted arrays in cpp, as an ArrayList in java, and list in python).


Examples :

Input: k = 3, arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation: Above test case has 3 sorted arrays of size 3, 3, 3 arr[][] = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]. The merged list will be [1, 2, 3, 4, 5, 6, 7, 8, 9].
Input: k = 4, arr[][]={{1,2,3,4},{2,2,3,4},{5,5,6,6},{7,8,9,9}}
Output: 1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9 
Explanation: Above test case has 4 sorted arrays of size 4, 4, 4, 4 arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4], [5, 5, 6, 6], [7, 8, 9, 9 ]]. The merged list will be [1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9].
Expected Time Complexity: O(k2*Log(k))
Expected Auxiliary Space: O(k2)

Constraints:
1 <= k <= 100 */
import java.util.ArrayList;
import java.util.PriorityQueue;

/*Code above below is not written by me, pasted it here for learning implementation, as it has good comments compared to what I had written */


public class Merge_k_Sorted_Arrays {
    // Helper class to store the element along with its array index and element index
    static class Element {
        int value;
        int arrayIndex;
        int elementIndex;

        public Element(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arrays, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Define a priority queue with a custom comparator
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));

        // Initialize the heap with the first element of each array
        for (int i = 0; i < k; i++) {
            if (arrays[i].length > 0) {
                minHeap.offer(new Element(arrays[i][0], i, 0));
            }
        }

        // Process the heap and construct the merged sorted array
        while (!minHeap.isEmpty()) {
            Element current = minHeap.poll();
            result.add(current.value);

            // Move to the next element in the same array
            if (current.elementIndex + 1 < arrays[current.arrayIndex].length) {
                minHeap.offer(new Element(arrays[current.arrayIndex][current.elementIndex + 1], current.arrayIndex, current.elementIndex + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arrays1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k1 = 3;
        System.out.println(mergeKArrays(arrays1, k1)); // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]

        int[][] arrays2 = {{1, 2, 3, 4}, {2, 2, 3, 4}, {5, 5, 6, 6}, {7, 8, 9, 9}};
        int k2 = 4;
        System.out.println(mergeKArrays(arrays2, k2)); // Output: [1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9]
    }

}  

/*Code above and below is not written by me, pasted it here for learning implementation */

// import java.util.ArrayList;
// import java.util.PriorityQueue;

// public class Merge_k_Sorted_Arrays {

//     // Helper class to store the element along with its array index and element index
//     static class Element implements Comparable<Element> {
//         int value;
//         int arrayIndex;
//         int elementIndex;

//         public Element(int value, int arrayIndex, int elementIndex) {
//             this.value = value;
//             this.arrayIndex = arrayIndex;
//             this.elementIndex = elementIndex;
//         }

//         @Override
//         public int compareTo(Element other) {
//             return Integer.compare(this.value, other.value);
//         }
//     }

//     public static ArrayList<Integer> mergeKArrays(int[][] arrays, int k) {
//         ArrayList<Integer> result = new ArrayList<>();
//         PriorityQueue<Element> minHeap = new PriorityQueue<>();

//         // Initialize the heap with the first element of each array
//         for (int i = 0; i < k; i++) {
//             if (arrays[i].length > 0) {
//                 minHeap.offer(new Element(arrays[i][0], i, 0));
//             }
//         }

//         // Process the heap and construct the merged sorted array
//         while (!minHeap.isEmpty()) {
//             Element current = minHeap.poll();
//             result.add(current.value);

//             // Move to the next element in the same array
//             if (current.elementIndex + 1 < arrays[current.arrayIndex].length) {
//                 minHeap.offer(new Element(arrays[current.arrayIndex][current.elementIndex + 1], current.arrayIndex, current.elementIndex + 1));
//             }
//         }

//         return result;
//     }

//     public static void main(String[] args) {
//         int[][] arrays1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//         int k1 = 3;
//         System.out.println(mergeKArrays(arrays1, k1)); // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]

//         int[][] arrays2 = {{1, 2, 3, 4}, {2, 2, 3, 4}, {5, 5, 6, 6}, {7, 8, 9, 9}};
//         int k2 = 4;
//         System.out.println(mergeKArrays(arrays2, k2)); // Output: [1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9]
//     }
// }
