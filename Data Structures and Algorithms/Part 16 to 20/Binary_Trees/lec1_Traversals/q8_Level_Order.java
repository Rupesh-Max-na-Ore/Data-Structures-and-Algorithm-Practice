package Binary_Trees.lec1_Traversals;
/*Q8 102. Binary Tree Level Order Traversal
Medium
Topics
Companies
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Binary_Trees.TreeNode;

public class q8_Level_Order {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans; //prevents a NullPointerException when the tree is empty
        Queue <TreeNode> Q = new LinkedList<>();
        Q.add(root); //root might pt to null hence chk above
        while(!Q.isEmpty()){
            int size = Q.size();
            List<Integer> lvl = new ArrayList<>();
            for(int i=0; i<size;i++){
                TreeNode nod = Q.poll();
                lvl.add(nod.data);
                if(nod.left!=null) Q.add(nod.left);
                if(nod.right!=null) Q.add(nod.right);
            } ans.add(lvl);
        } return ans;
    }
}
