package Binary_Search_Tree.lec2_practice_problems;

import Binary_Trees.lec2_Mediums.q8_Vertical_Order_Traversal.TreeNode;

public class q3_insert_node {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root == null) return node;
        TreeNode t = root;
        TreeNode prev = null;
        while(root!=null){
            prev = root;
            if(root.val<=val) {
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        //Corrected logic below
        // Insert the new node as a left or right child based on value comparison
        if (val < prev.val) {
            prev.left = node;
        } else {
            prev.right = node;
        }
        /*
        //ANother wrong logic, to be careful about
        if(root == prev.left) prev.left = node; 
        else prev.right = node; // what if root == null && L and R also null? Can't differentiate here!
         */
        return t;
    }

    public TreeNode insertIntoBST2(TreeNode root, int val){
        //Implement w/o prev ptr
        TreeNode node = new TreeNode(val);
        if(root == null) return node;
        TreeNode t = root;
        while(true){
            if(t.val <= val) {
                if(t.right!=null){
                    t = t.right;
                }
                else //R not exist
                {
                    t.right = node;
                    break;
                }
            }
            else //t.val > val
            {
                if(t.left!=null){
                    t = t.left;
                }
                else //if left not exist
                {
                    t.left = node;
                    break; 
                }
            }
        } return root;
    }

    //1st attempt, wrong
    // public TreeNode insertIntoBST(TreeNode root, int val) {
    //     TreeNode node = new TreeNode(val);
    //     if(root == null) return node;
    //     TreeNode t = root;
    //     TreeNode prev = null;
    //     while(root!=null){
    //         if(root.val<=val) {
    //             prev = root;
    //             root = root.right;
    //         }
    //         else {
    //             prev = root;
    //             root = root.left;
    //         }
    //     }
    //     //Wrong logic below
    //     if(prev.left==null) prev.left = node;
    //     else prev.right = node;
    //     return t;
    // }
}
