package Binary_Search_Tree.lec2_practice_problems;

import java.util.Stack;

import Binary_Trees.lec2_Mediums.q8_Vertical_Order_Traversal.TreeNode;

public class q11_BST_2sum {
    
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BstIterator{

    Stack<TreeNode> st = new Stack<>();
    // reverse = true -> before
    // reverse = false -> next
    boolean reverse = true;

    public BstIterator(TreeNode root, boolean isReverse){
        reverse = isReverse;
        pushAll(root);
    }

    public int next() {
        TreeNode tmpNode = st.pop();
        if(reverse == false) pushAll(tmpNode.right);
        else pushAll(tmpNode.left); 
        return tmpNode.val;
    }

    public boolean hasNext(){
        return st.isEmpty();
    }

    private void pushAll(TreeNode node) {
        while(node != null) {
             st.push(node);
             if(reverse == true) {
                 node = node.right; 
             } else {
                 node = node.left; 
             }
        }
    }

}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }

        BstIterator l = new BstIterator(root,false);
        BstIterator r = new BstIterator(root,true);
        int i = l.next();
        int j = r.next();
        while(i < j){
            if(i + j == k){
                return true;
            }
            else if(i + j < k){
               i = l.next();
            }else{
               j = r.next();
           
            }
        }
        return false;
    }
}