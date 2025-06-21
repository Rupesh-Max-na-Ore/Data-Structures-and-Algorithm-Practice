package Trie.Lec2_Problems;
/*1707. Maximum XOR With an Element From Array
Hard
Topics
Companies
Hint
You are given an array nums consisting of non-negative integers. You are also given a queries array, where queries[i] = [xi, mi].

The answer to the ith query is the maximum bitwise XOR value of xi and any element of nums that does not exceed mi. In other words, the answer is max(nums[j] XOR xi) for all j such that nums[j] <= mi. If all elements in nums are larger than mi, then the answer is -1.

Return an integer array answer where answer.length == queries.length and answer[i] is the answer to the ith query.

 

Example 1:

Input: nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
Output: [3,3,7]
Explanation:
1) 0 and 1 are the only two integers not greater than 1. 0 XOR 3 = 3 and 1 XOR 3 = 2. The larger of the two is 3.
2) 1 XOR 2 = 3.
3) 5 XOR 2 = 7.
Example 2:

Input: nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
Output: [15,-1,5]
 

Constraints:

1 <= nums.length, queries.length <= 105
queries[i].length == 2
0 <= nums[j], xi, mi <= 109
Seen this question in a real interview before?
1/5
Yes
No
Accepted
33.7K
Submissions
61.9K
Acceptance Rate
54.4%
Topics
Companies
Hint 1
In problems involving bitwise operations, we often think on the bits level. In this problem, we can think that to maximize the result of an xor operation, we need to maximize the most significant bit, then the next one, and so on.
Hint 2
If there's some number in the array that is less than m and whose the most significant bit is different than that of x, then xoring with this number maximizes the most significant bit, so I know this bit in the answer is 1.
Hint 3
To check the existence of such numbers and narrow your scope for further bits based on your choice, you can use trie.
Hint 4
You can sort the array and the queries, and maintain the trie such that in each query the trie consists exactly of the valid elements.
Similar Questions
Maximum XOR of Two Numbers in an Array
Medium
Maximum Genetic Difference Query
Hard
Minimize XOR
Medium
Maximum Strong Pair XOR I
Easy
Maximum Strong Pair XOR II
Hard
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//import Binary.BinarySearch;

class Node{
    Node links[];
    Node(){
        links = new Node[2];
    }
    Node get(int i){
        return links[i];
    }
    boolean containsKey(int i){
        return links[i]!=null;
    }
    public void put(int bit, Node node) {
        links[bit] = node;
    }

}
class Trie{
    Node root;
    Trie(){
        root = new Node();
    }
    Node getRoot(){
        return root;
    }
    void insert(int x){
        Node traverser = root;
        int n = Integer.SIZE;
        for(int i = n-1; i >= 0; i--){
            int bit = ((x>>i)&1);
            if(traverser.containsKey(bit)) traverser = traverser.get(bit);
            else {
                traverser.put(bit, new Node());
                traverser = traverser.get(bit);
            }
        } 
    }

    int getMax(int num){
        Node traverser = root;
        int n = Integer.SIZE;
        int construct_no = 0;
        int maxXOR;
        for(int i=n-1; i>=0 ; i--){
            int bit = ((num>>i)&1);
            int opp_bit = (1 - bit);
            if(traverser.containsKey(opp_bit)){
                construct_no = (construct_no<<1)|opp_bit;
                traverser = traverser.get(opp_bit);
            }  else{
                construct_no = (construct_no<<1)|bit;
                traverser = traverser.get(bit);
            }
        }
        maxXOR = num ^ construct_no;
        return maxXOR;
    }

    boolean isEmpty(){
        return ((root.links[0] == null) && (root.links[1] == null));
    }
}


public class q7_Max_XOR_Limit_Queries {
    //way 1 - trie with offline query
    public int[] maximizeXor(int[] nums, int[][] queries) {
        //Sort array
        int n = nums.length;
        Arrays.sort(nums);
        int q = queries.length;
        int[][] offlineQueries = new int[q][3];
        for(int i=0; i<q;i+=1){//xi,mi,og_idx
            offlineQueries[i][0] = queries[i][0];
            offlineQueries[i][1] = queries[i][1];
            offlineQueries[i][2] = i;
        }
        //SOrt by mi
        Arrays.sort(offlineQueries, Comparator.comparingInt(a->a[1]));

        //
        Trie trie = new Trie();
        int[] res = new int[q];
        int idx = 0;
        for(int query[]: offlineQueries){
            int xi=query[0];
            int mi=query[1];
            int qIdx = query[2];//place in og array to store
            //Insert all from nums[] till mi
            while(idx < n && nums[idx]<=mi){
                trie.insert(nums[idx++]);
            }

            //Edge case: No no. in nums[] <=mi
            if(trie.isEmpty()) res[qIdx] = -1;
            else res[qIdx] = trie.getMax(xi);
        }
        return res;
    } 
    //way 2 - Binary Search, less efficient, but smaller code, but harder to explain
    //Much better SPace complexity tho
    public int[] maximizeXor_3(int[] nums, int[][] queries) {
        int q = queries.length;
        int[] ans = new int[q];

        // Sort nums for binary search operations
        Arrays.sort(nums);

        for (int i = 0; i < q; i++) {
            int x = queries[i][0]; // Value to XOR with
            int m = queries[i][1]; // Upper limit on valid elements from nums

            // If smallest number in nums is larger than m, no valid element
            if (nums[0] > m) {
                ans[i] = -1;
                continue;
            }

            // Restrict nums to values <= m
            int end = upperBound(nums, m); // First index where nums[i] > m
            int start = 0;                 // We will slide this window over nums

            int cur = 0; // This will build up the current mask we're testing
            int k = 0;   // This will accumulate the best XOR result

            // We try to build the best number to XOR with x from most to least significant bit
            for (int bit = 31; bit >= 0; bit--) {
                int bitMask = 1 << bit;

                if ((x & bitMask) != 0) {
                    // If x has 1 at this bit, we prefer nums with 0 to make XOR 1
                    if ((nums[start] & bitMask) == 0) {
                        // Filter out elements >= cur | bitMask
                        end = lowerBound(nums, start, end, cur | bitMask);
                        k |= bitMask;
                    } else {
                        // We have no 0-bit numbers in this range; keep cur mask
                        cur |= bitMask;
                    }
                } else {
                    // If x has 0 at this bit, we prefer nums with 1 to make XOR 1
                    if (start < end && (nums[end - 1] & bitMask) != 0) {
                        cur |= bitMask;
                        start = lowerBound(nums, start, end, cur);
                        k |= bitMask;
                    }
                }
            }

            ans[i] = k;
        }

        return ans;
    }

    // Returns first index where nums[i] > target (standard upper bound)
    private int upperBound(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    // Returns first index in nums[start:end] where nums[i] >= target
    private int lowerBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    //Time Limit Exceeded 60 / 67 testcases passed
    public int[] maximizeXor_2(int[] nums, int[][] queries) {
        Arrays.sort(nums);  // sort the input nums array

        int q = queries.length;
        int[][] qWithIndex = new int[q][3];
        for (int i = 0; i < q; i++) {
            qWithIndex[i][0] = queries[i][0]; // xi
            qWithIndex[i][1] = queries[i][1]; // mi
            qWithIndex[i][2] = i;             // original index
        }

        // sort queries by mi
        Arrays.sort(qWithIndex, Comparator.comparingInt(a -> a[1]));

        int[] res = new int[q];
        int i = 0;
        List<Integer> validNums = new ArrayList<>();

        for (int[] query : qWithIndex) {
            int xi = query[0], mi = query[1], idx = query[2];

            // insert all nums <= mi
            while (i < nums.length && nums[i] <= mi) validNums.add(nums[i++]);

            if (validNums.isEmpty()) {
                res[idx] = -1;
            } else {
                int max = 0;
                //TODO: Have put Linear Search here for now, but will put binary search later 
                for (int num : validNums) max = Math.max(max, num ^ xi);
                //int max = XORBinarySearch(validNums, xi);
                res[idx] = max;
            }
        }

        return res;
    }
}
/*import java.util.*;

class Node {
    Node[] links = new Node[2];

    boolean containsKey(int bit) {
        return links[bit] != null;
    }

    Node get(int bit) {
        return links[bit];
    }

    void put(int bit, Node node) {
        links[bit] = node;
    }
}

class Trie {
    Node root = new Node();

    void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    int getMaxXor(int x) {
        Node node = root;
        int max = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (x >> i) & 1;
            int oppositeBit = 1 - bit;
            if (node.containsKey(oppositeBit)) {
                max |= (1 << i);
                node = node.get(oppositeBit);
            } else {
                node = node.get(bit);
            }
        }
        return max;
    }

    boolean isEmpty() {
        return root.links[0] == null && root.links[1] == null;
    }
}

public class q7_Max_XOR_Limit_Queries {

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums); // Sort nums for incremental Trie building

        int q = queries.length;
        int[][] offlineQueries = new int[q][3]; // {xi, mi, index}
        for (int i = 0; i < q; i++) {
            offlineQueries[i][0] = queries[i][0]; // xi
            offlineQueries[i][1] = queries[i][1]; // mi
            offlineQueries[i][2] = i;             // original index
        }

        Arrays.sort(offlineQueries, Comparator.comparingInt(a -> a[1])); // sort by mi

        Trie trie = new Trie();
        int[] result = new int[q];
        int idx = 0;

        for (int[] query : offlineQueries) {
            int xi = query[0];
            int mi = query[1];
            int qIdx = query[2];

            // Insert all nums[j] ≤ mi into Trie
            while (idx < nums.length && nums[idx] <= mi) {
                trie.insert(nums[idx]);
                idx++;
            }

            // If no number ≤ mi exists
            if (trie.isEmpty()) {
                result[qIdx] = -1;
            } else {
                result[qIdx] = trie.getMaxXor(xi);
            }
        }

        return result;
    }
}
 */