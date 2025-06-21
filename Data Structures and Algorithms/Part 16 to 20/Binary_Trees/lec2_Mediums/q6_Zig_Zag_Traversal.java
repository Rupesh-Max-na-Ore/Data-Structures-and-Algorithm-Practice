package Binary_Trees.lec2_Mediums;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Binary_Trees.TreeNode;

public class q6_Zig_Zag_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zz = new ArrayList<>();
        if (root == null) return zz;
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        boolean flag = true;
        while (!Q.isEmpty()) {
            int size = Q.size();
            List<Integer> lvl = new ArrayList<>(size);
            // Process each lvl
            for (int i = 0; i < size; i++) {
                TreeNode node = Q.poll();
                // Add the node's val to the list depending on the current direction
                if (flag) {
                    lvl.add(node.data);  // Left to right order
                } else {
                    lvl.add(0, node.data);  // Right to left order (prepend)
                }
                // Add child nodes for the next lvl
                if (node.left != null) Q.add(node.left);
                if (node.right != null) Q.add(node.right);
            }
            zz.add(lvl);
            flag = !flag;
        }
        return zz;
    }
    // Correct Logic, fault in implementation details
    // 
    /*trying to manipulate the index using lvl.add(indx, x.data), 
    but this logic will not work correctly in some cases since 
    ArrayList does not allow insertion at arbitrary indices unless 
    those indices are already populated. */
    //
    // public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    //     List<List<Integer>> zz = new ArrayList<>();
    //     if(root==null) return zz;
    //     boolean flag = true;
    //     Queue<TreeNode> Q= new LinkedList<>();
    //     Q.add(root);
    //     while(!Q.isEmpty()){
    //         int size = Q.size();
    //         List<Integer> lvl = new ArrayList<>(size);
    //         for(int i=0; i<size; i++){
    //             int indx = i;
    //             if(flag==false){
    //                 indx = size - 1 - i;
    //             }
    //             TreeNode x = Q.poll();
    //             lvl.add(indx,x.data);
    //             if(x.left!=null) Q.add(x.left);
    //             if(x.right!=null) Q.add(x.right);

    //         }
    //         flag = !flag;
    //         zz.add(lvl);

    //     } return zz;
    // }
}
