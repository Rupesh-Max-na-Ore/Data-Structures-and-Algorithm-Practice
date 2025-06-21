package Trie.Lec2_Problems;
/*421. Maximum XOR of Two Numbers in an Array
Medium
Topics
Companies
Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

 

Example 1:

Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
Example 2:

Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127
 

Constraints:

1 <= nums.length <= 2 * 105
0 <= nums[i] <= 231 - 1
Seen this question in a real interview before?
1/5
Yes
No
Accepted
189.1K
Submissions
355.6K
Acceptance Rate
53.2%
Topics
Array
Hash Table
Bit Manipulation
Trie
Companies
Similar Questions
Maximum XOR With an Element From Array
Hard
Maximum XOR After Operations
Medium
Sum of Prefix Scores of Strings
Hard
Minimize XOR
Medium
Maximum Strong Pair XOR I
Easy
Maximum Strong Pair XOR II
Hard */
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
        //costruct_no = the xor maxxing complementary no. actually present in trie
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
}
public class q6_Max_XOR_2Arr {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        //
        for(int i=0;i<nums.length;i++) trie.insert(nums[i]);
        int maxXOR = 0;
        for(int num : nums){
            int numXOR  = trie.getMax(num);
            maxXOR = Math.max(maxXOR, numXOR);
        }
        return maxXOR;
    }
}
